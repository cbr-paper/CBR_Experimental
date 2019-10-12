package manager;

import java.util.Collection;
import java.util.HashMap;
import java.util.Set;

import org.apache.log4j.Logger;

import model.MonitoringEvent;
import writer.file.DataWriter;

public class RuntimeDataWriter {

	final static Logger logger = Logger.getLogger(RuntimeDataWriter.class);

	private DataWriter dataWriter = new DataWriter(true);

	private String getLogFilePath(int logCounter) {
		return dataWriter.getDir() + "/" + logCounter + ".log";
	}

	public void writeActionName(String actionName, int logCounter) {
		dataWriter.writeActionName(actionName, getLogFilePath(logCounter));
	}

	public void writeLastEventTotalTime(Long totalTime) {
		dataWriter.writeLastEventTotalTime(totalTime);
	}

	public void writeMethodDetail(MonitoringEvent event) {
		dataWriter.writeMethodDetail(event);
	}

	public void writeMethodDetail(MonitoringEvent event, int logCounter) {
		dataWriter.writeMethodDetail(event, getLogFilePath(logCounter));
	}

	public void writeSignatureData(HashMap<String, ?> values) {
		dataWriter.writeSignatureData(values);
	}
	public void writeSignatureData(Set<String> setExpressions, Collection<?> state1, int logCounter) {
		dataWriter.writeSignatureData(setExpressions, state1, getLogFilePath(logCounter));
	}
	public void writeSignatureData(Set<String> setExpressions, Collection<?> state1, Collection<?> state2,
			int logCounter) {
		dataWriter.writeSignatureData(setExpressions, state1, state2, getLogFilePath(logCounter));
	}
}
