package aspects;

import java.awt.event.MouseEvent;

import manager.UserEventManager;
import buffer.SystemResponseTimeBuffer;
import model.MonitoringEvent;
import model.SystemResponseTimeEventForExperiment;
import util.AspectUtil;
import writer.buffer.SystemResponseTimeBufferWriter;
import runtime.evaluators.AtLeastOneConditionEvaluator;

public aspect EventTrackerAspect {

	private boolean firstIteration = true;
	private boolean isMonitorEnabled = false;
	private double probability = 1;

	private boolean wasLastActionMonitored = false;

	private static UserEventManager userEventManager = new UserEventManager(AtLeastOneConditionEvaluator.class);

	// Buffer that contains the System Response CPU Time of the called methods
	private SystemResponseTimeBuffer buffer = new SystemResponseTimeBuffer();

	// Writer of the buffer that contains System Response CPU Time of UI actions
	private SystemResponseTimeBufferWriter bufferWriterSystemResponseCpuTime = new SystemResponseTimeBufferWriter(
			buffer);

	/**
	 * Capture click {@code mouseEvent} from GUI.
	 * 
	 * @param mouseEvent
	 */
	pointcut action(MouseEvent mouseEvent):
			(		execution(* org.argouml.uml.diagram.ui.FigEdgeModelElement.mouseReleased(*)) ||
					execution(* org.tigris.gef.base.Editor.mousePressed(*)) ||
					execution(* org.tigris.toolbar..*.*.mousePressed(*))
			) && 
			args(mouseEvent) && !within(EventSamplerTrackerAspect);

	/**
	 * Catch every method call that belongs to package
	 */
	pointcut methodCalls(): 
			execution(* org.argouml.uml.diagram.activity..*.*.*(..))  && 
			!execution(org.argouml.uml.diagram.activity..new(..)) &&
			!within(EventSamplerTrackerAspect);

	/**
	 * Catch every new object that belongs to package. The new object is stored in
	 * {@code newObject} param.
	 * 
	 * @param newObject
	 */
	pointcut constructors(Object newObject):
			execution(org.argouml.uml.diagram.activity..new(..)) &&
			target(newObject) && 
			!within(EventSamplerTrackerAspect);

	Object around(MouseEvent mouseEvent): action(mouseEvent){
		userEventManager.evaluateApplicationState();

		if (wasLastActionMonitored) {
			userEventManager.updateLastActionState();
		}

		isMonitorEnabled = AspectUtil.setMonitoring(probability);

		if (isMonitorEnabled) {
			String actionName = AspectUtil.getActionNameFromMouseEvent(mouseEvent);

			userEventManager.monitorAction(actionName, buffer);

			Object obj = proceed(mouseEvent);

			wasLastActionMonitored = true;

			return obj;
		} else {
			wasLastActionMonitored = false;

			return proceed(mouseEvent);
		}
	}

	Object around(): methodCalls() {

		if (firstIteration) {
			registerLastAction();
			firstIteration = false;
		}

		if (isMonitorEnabled) {

			long start = System.nanoTime();
			long startClockTime = System.currentTimeMillis();
			
			MonitoringEvent event = new MonitoringEvent(thisJoinPoint.getSignature().toString());
			
			for (Object o: thisJoinPoint.getArgs()) {
				event.addMethodArgs(o);
			}

			userEventManager.writeSingleEvent(event);

			Object obj = proceed();

			long end = System.nanoTime();
			long endClockTime = System.currentTimeMillis();

			bufferWriterSystemResponseCpuTime.addEventToBuffer(new SystemResponseTimeEventForExperiment(
					thisJoinPoint.getSignature().toString(), end - start, startClockTime, endClockTime));

			return obj;
		} else {
			return proceed();
		}
	}

	Object around(Object createdObject): constructors(createdObject) {
		userEventManager.addNewObject(createdObject);
		return proceed(createdObject);
	}

	private void registerLastAction() {
		Runtime.getRuntime().addShutdownHook(new Thread() {
			public void run() {
				if (wasLastActionMonitored) {
					userEventManager.updateLastActionState();
					userEventManager.monitorLastAction(buffer);
				}
			}
		});
	}
}
