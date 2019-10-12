package aspects;

import manager.MethodCallManager;

import model.MonitoringEvent;
import runtime.evaluators.AtLeastOneConditionEvaluator;

public aspect NaiveMonitor {

	private static MethodCallManager manager = new MethodCallManager(AtLeastOneConditionEvaluator.class);

	pointcut methodCalls(): 
			execution(* org.argouml.uml.diagram.activity..*.*.*(..))  && 
			!execution(org.argouml.uml.diagram.activity..new(..)) &&
			!within(NaiveMonitor);

	Object around(): methodCalls() {

		if (ActionAspect.activeLogging()) {
			MonitoringEvent event = new MonitoringEvent(thisJoinPoint.getSignature().toString());

			for (Object o : thisJoinPoint.getArgs()) {
				event.addMethodArgs(o);
			}

			manager.writeSingleEvent(event);
		}
		return proceed();
	}

}
