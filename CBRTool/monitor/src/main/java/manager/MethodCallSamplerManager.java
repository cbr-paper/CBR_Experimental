package manager;

import org.apache.log4j.Logger;

import model.MonitoringEvent;

public class MethodCallSamplerManager extends Manager {

	final static Logger logger = Logger.getLogger(MethodCallSamplerManager.class);

	private int logCounter = 0;
	
	public MethodCallSamplerManager(Class<?> cls) {
		super(cls);
	}

	public void evaluateApplicationState() {
		applicationState = evaluate();
	}

	public void writeSingleEvent(MonitoringEvent event) {
		runtimeDataWriter.writeMethodDetail(event, logCounter);
	}
	
	public void increaseLogCounter() {
		logCounter += 1;
	}
	
}
