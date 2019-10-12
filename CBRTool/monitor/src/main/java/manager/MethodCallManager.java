package manager;

import org.apache.log4j.Logger;

import model.MonitoringEvent;

public class MethodCallManager extends Manager {

	final static Logger logger = Logger.getLogger(MethodCallManager.class);

	public MethodCallManager(Class<?> cls) {
		super(cls);
	}

	public void evaluateApplicationState() {
		applicationState = evaluate();
	}

	public void writeSingleEvent(MonitoringEvent event) {
		runtimeDataWriter.writeMethodDetail(event);
	}

}