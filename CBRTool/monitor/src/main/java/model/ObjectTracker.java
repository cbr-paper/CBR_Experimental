package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.log4j.Logger;

import util.Config;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

public class ObjectTracker {

	final static Logger logger = Logger.getLogger(ObjectTracker.class);

	private static ObjectTracker INSTANCE = null;
	
	/** Map of WeakReferences*/
	private static ConcurrentHashMap<String, List<WeakReference<Object>>> map = new ConcurrentHashMap<String, List<WeakReference<Object>>>();
	
	/** ReferenceQueue that stores objects not longer references by the JVM */
	private static ReferenceQueue<Object> queue = new ReferenceQueue<Object>();

	private ObjectTracker() {}

	static {
		logger.debug("Creating Objects Reference instance...");
		INSTANCE = new ObjectTracker();
	}

	public static ObjectTracker getInstance() {
		return INSTANCE;
	}
	
	/**
	 * @return  {@code ConcurrentHashMap} with the map of objects
	 */
	public ConcurrentHashMap<String, List<WeakReference<Object>>> getMap() {
		return map;
	}

	public void addNewObject(Object object) {
		String cls = object.getClass().getName();
		logger.info("Adding object of class: " + cls + " to ConcurrentHashMap...");

		WeakReference<Object> weakObject = new WeakReference<Object>(object, queue);
		synchronized (Config.lock) {
			List<WeakReference<Object>> objectsList = map.get(cls);
	
			if (objectsList == null) {
				objectsList = new ArrayList<WeakReference<Object>>();
				objectsList.add(weakObject);
				map.put(cls, objectsList);
			} else if (!objectsList.contains(weakObject)) {
				objectsList.add(weakObject);
			}
		}
	}

	public int getMapSize() {
		int size = 0;
		for (List<WeakReference<Object>> value : map.values())
			size += value.size();
		return size;
	}

	public void cleanQueuedObjects(HashMap<String, Set<WeakReference<Object>>> queuedObjects) {
		logger.info("Cleaning objects from ConcurrentHashMap...");
		for (Entry<String, Set<WeakReference<Object>>> entry : queuedObjects.entrySet()) {
			String cls = entry.getKey();
			Set<WeakReference<Object>> set = entry.getValue();
			List<WeakReference<Object>> objectsList = map.get(cls);

			for (WeakReference<Object> wr : set)
				objectsList.remove(wr);
		}
	}

}
