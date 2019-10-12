package manager;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

import org.apache.log4j.Logger;


import model.ObjectTracker;
import runtime.evaluators.AllConditionEvaluator;
import runtime.evaluators.AtLeastOneConditionEvaluator;
import runtime.evaluators.ConditionEvaluator;
import runtime.evaluators.NumberOfConditionEvaluator;
import util.Config;

public abstract class Manager {

	final static Logger logger = Logger.getLogger(Manager.class);

	protected ConditionEvaluator evaluator;

	protected ObjectTracker objectsReference = ObjectTracker.getInstance();

	/* state of the application */
	protected HashMap<String, ?> applicationState;

	protected RuntimeDataWriter runtimeDataWriter = new RuntimeDataWriter();

	public Manager(Class<?> cls) {

		if (cls.equals(AllConditionEvaluator.class)) {
			evaluator = new AllConditionEvaluator();
		} else if (cls.equals(AtLeastOneConditionEvaluator.class)) {
			evaluator = new AtLeastOneConditionEvaluator();
		} else
			evaluator = new NumberOfConditionEvaluator();
	}

	public void addNewObject(Object createdObject) {
		objectsReference.addNewObject(createdObject);
	}

	private void cleanQueuedObjects() {
		if (evaluator.sizeQueuedObjects() > 0) {
			objectsReference.cleanQueuedObjects(evaluator.getQueuedObjects());
			evaluator.clearQueue();
		}
	}

	/**
	 * Evaluate path conditions at runtime
	 * 
	 * @param tabular
	 */
	public HashMap<String, ?> evaluate() {
		synchronized (Config.lock) {
			logger.info("Map with " + objectsReference.getMapSize() + " objects");

			// obtain the state of the application
			HashMap<String, ?> applicationState = evaluator.monitorValues(objectsReference.getMap());

			printStatistics(applicationState);

			cleanQueuedObjects();

			return applicationState;
		}
	}

	public void writeApplicationState() {
		runtimeDataWriter.writeSignatureData(applicationState);
	}

	private void printStatistics(HashMap<String, ?> values) {
		int trueValues = Collections.frequency(new ArrayList<>(values.values()), 'T');
		int falseValues = Collections.frequency(new ArrayList<>(values.values()), 'F');
		int undefinedValues = Collections.frequency(new ArrayList<>(values.values()), 'U');

		logger.info(trueValues + " T; " + falseValues + " F; " + undefinedValues + " U");
	}

}