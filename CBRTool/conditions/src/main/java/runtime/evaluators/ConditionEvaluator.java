package runtime.evaluators;

import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public interface ConditionEvaluator {

	public HashMap<String, ?> monitorValues(ConcurrentHashMap<String,List<WeakReference<Object>>> map);

	int sizeQueuedObjects();

	HashMap<String, Set<WeakReference<Object>>> getQueuedObjects();

	void clearQueue();


}
