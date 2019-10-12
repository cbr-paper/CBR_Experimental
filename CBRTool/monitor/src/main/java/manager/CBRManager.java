package manager;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;

import model.MonitoringEvent;

public final class CBRManager extends Manager {

	final static Logger logger = Logger.getLogger(CBRManager.class);

	private int logCounter = -1;

	public CBRManager(Class<?> cls) {
		super(cls);
	}

	public void evaluateApplicationState() {
		applicationState = evaluate();
	}

	private List<?> getApplicationState() {
		return new ArrayList<>(applicationState.values());
	}

	private Set<String> getExpressions() {
		return applicationState.keySet();
	}

	public void monitorAction(String actionName) {
		logger.info("monitorAction");
		List<?> applicationStateNow = getApplicationState();

		runtimeDataWriter.writeSignatureData(getExpressions(), applicationStateNow, ++logCounter);

		runtimeDataWriter.writeActionName(actionName, logCounter);

		runtimeDataWriter.writeSignatureData(applicationState);

	}

	public void writeSingleEvent(MonitoringEvent event) {
		runtimeDataWriter.writeMethodDetail(event, logCounter);
	}

	public void updateLastActionState() {
		logger.info("updateLastActionState");
		List<?> applicationStateNow = getApplicationState();
		runtimeDataWriter.writeSignatureData(getExpressions(), applicationStateNow, logCounter);
	}
	
	
}