package aspects;

import manager.MethodCallSamplerManager;

import model.MonitoringEvent;
import util.AspectUtil;
import util.SettingsUtil;
import runtime.evaluators.AtLeastOneConditionEvaluator;

public aspect SamplerTrackerAspect {

	private boolean isMonitorEnabled = false;
	private static final double SAMPLING_PROBABILITY = Double
			.valueOf(SettingsUtil.getPropertyValue("sampler_probability"));
	private static final int SAMPLE_LENGTH = Integer.parseInt(SettingsUtil.getPropertyValue("sample_length"));

	private int tempSampleLength = 0;

	private static MethodCallSamplerManager manager = new MethodCallSamplerManager(AtLeastOneConditionEvaluator.class);

	/**
	 * Catch every method call that belongs to package
	 */
	pointcut methodCalls(): 
			execution(* org.argouml.uml.diagram.activity..*.*.*(..))  && 
			!execution(org.argouml.uml.diagram.activity..new(..)) &&
			!within(SamplerTrackerAspect);

	Object around(): methodCalls() {
		Object obj = null;
		
		if (ActionAspect.activeLogging()) {
			isMonitorEnabled = enableMonitor();

			if (isMonitorEnabled) {
				MonitoringEvent event = new MonitoringEvent(thisJoinPoint.getSignature().toString());

				for (Object o : thisJoinPoint.getArgs()) {
					event.addMethodArgs(o);
				}
				manager.writeSingleEvent(event);

				obj = proceed();

				tempSampleLength += 1;
				return obj;
			} else {
				obj = proceed();
			}
		} else {
			obj = proceed();
		}

		return obj;
	}

	private boolean enableMonitor() {
		boolean value = false;

		if (isMonitorEnabled && (tempSampleLength < SAMPLE_LENGTH)) {
			value = true;
		} else if (isMonitorEnabled && (tempSampleLength == SAMPLE_LENGTH)) {
			value = AspectUtil.setMonitoring(SAMPLING_PROBABILITY);

			tempSampleLength = 0;
			manager.increaseLogCounter();
		} else if (!isMonitorEnabled) {
			value = AspectUtil.setMonitoring(SAMPLING_PROBABILITY);
		}
		// System.out.println("value: " + value + " tempSampleLength: " +
		// tempSampleLength);
		return value;
	}

}
