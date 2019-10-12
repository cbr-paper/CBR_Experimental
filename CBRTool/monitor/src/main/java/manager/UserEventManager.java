package manager;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;

import buffer.SystemResponseTimeBuffer;
import model.MonitoringEvent;
import util.AspectUtil;

public final class UserEventManager extends Manager {

	final static Logger logger = Logger.getLogger(CBRManager.class);

	private int logCounter = -1;

	public UserEventManager(Class<?> cls) {
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

	public void monitorAction(String actionName, SystemResponseTimeBuffer buffer) {
		logger.info("monitorAction");
		List<?> applicationStateNow = getApplicationState();

		runtimeDataWriter.writeSignatureData(getExpressions(), applicationStateNow, ++logCounter);

		runtimeDataWriter.writeActionName(actionName, logCounter);

		runtimeDataWriter.writeLastEventTotalTime(AspectUtil.getActionTotalTime(buffer));

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

	public void monitorLastAction(SystemResponseTimeBuffer buffer) {
		logger.info("monitorLastAction");

		runtimeDataWriter.writeLastEventTotalTime(AspectUtil.getActionTotalTime(buffer));

		runtimeDataWriter.writeSignatureData(applicationState);
	}
	
	
}