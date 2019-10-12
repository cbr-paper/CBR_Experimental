package aspects;

import java.awt.event.MouseEvent;

import manager.CBRManager;
import model.MonitoringEvent;
import runtime.evaluators.AtLeastOneConditionEvaluator;
import util.AspectUtil;
import util.SettingsUtil;

public aspect ControlledBurstRecording {

	private boolean firstIteration = true;
	private static boolean isMonitorEnabled = false;
	public static boolean cbrEnabled = false;

	private static final double SAMPLING_PROBABILITY = Double.valueOf(SettingsUtil.getPropertyValue("cbr_probability"));

	private static boolean wasLastActionMonitored = false;

	private static CBRManager manager ;

	/**
	 * Catch every method call that belongs to package
	 */
	pointcut methodCalls(): 
			execution(* org.argouml.uml.diagram.activity..*.*.*(..))  && 
			!execution(org.argouml.uml.diagram.activity..new(..)) &&
			!within(ControlledBurstRecording);

	/**
	 * Catch every new object that belongs to package. The new object is stored in
	 * {@code newObject} param.
	 * 
	 * @param newObject
	 */
	pointcut constructors(Object newObject):
			execution(org.argouml.uml.diagram.activity..new(..)) &&
			target(newObject) && 
			!within(ControlledBurstRecording);

	Object around(): methodCalls() {
		Object obj = null;
		
		if (firstIteration) {
			manager = new CBRManager(AtLeastOneConditionEvaluator.class);
			cbrEnabled = true;
			registerLastAction();
			firstIteration = false;
		}

		if (ActionAspect.activeLogging()) {

			if (isMonitorEnabled) {
				MonitoringEvent event = new MonitoringEvent(thisJoinPoint.getSignature().toString());

				for (Object o : thisJoinPoint.getArgs()) {
					event.addMethodArgs(o);
				}
				manager.writeSingleEvent(event);

				obj = proceed();

				return obj;
			} else {
				obj = proceed();
			}
		} else {
			obj = proceed();
		}
		return obj;
	}

	public static void cbrBefore(MouseEvent mouseEvent) {
		if (ActionAspect.activeLogging()) {

			manager.evaluateApplicationState();

			if (wasLastActionMonitored) {
				manager.updateLastActionState();
			}

			isMonitorEnabled = AspectUtil.setMonitoring(SAMPLING_PROBABILITY);
			
			if (isMonitorEnabled) {
				String actionName = AspectUtil.getActionNameFromMouseEvent(mouseEvent);

				manager.monitorAction(actionName);

			} else {
				wasLastActionMonitored = false;
			}
		}
	}

	public static void cbrAfter() {
		if (ActionAspect.activeLogging()) {
			if (isMonitorEnabled) {
				wasLastActionMonitored = true;
			}
		}
	}

	Object around(Object createdObject): constructors(createdObject) {
		if (ActionAspect.activeLogging()) {
			manager.addNewObject(createdObject);
		}
		return proceed(createdObject);
	}

	private void registerLastAction() {
		Runtime.getRuntime().addShutdownHook(new Thread() {
			public void run() {
				if (wasLastActionMonitored) {
					manager.updateLastActionState();
				}
			}
		});
	}
}
