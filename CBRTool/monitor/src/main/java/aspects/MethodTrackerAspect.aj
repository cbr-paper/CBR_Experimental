package aspects;

import org.apache.log4j.Logger;

import manager.MethodCallManager;
import runtime.evaluators.AtLeastOneConditionEvaluator;

public aspect MethodTrackerAspect {
	private MethodCallManager manager = new MethodCallManager(AtLeastOneConditionEvaluator.class);
	
	final static Logger logger = Logger.getLogger(MethodTrackerAspect.class);
	
	pointcut constructors(Object createdObject):
		execution(org.argouml.uml.diagram.activity..new(..)) &&
		target(createdObject) && 
		!within(MethodTrackerAspect);
	
	pointcut methodCalls(): 
		execution(* org.argouml.uml.diagram.activity..*.*.*(..)) && 
		!execution(org.argouml.uml.diagram.activity..new(..)) &&
		!within(MethodTrackerAspect);
	
	Object around(Object createdObject): constructors(createdObject) {
		logger.debug("pointcut constructor...");
		manager.addNewObject(createdObject);
		return proceed(createdObject);
	}
	
	Object around(): methodCalls() {
		manager.evaluateApplicationState();
		manager.writeApplicationState();
		return proceed();
	}
	
}
