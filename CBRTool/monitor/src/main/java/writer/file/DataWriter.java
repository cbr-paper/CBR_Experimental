package writer.file;

import java.io.FileWriter;
import java.io.IOException;

import static defs.Defs.logs;

import java.io.BufferedWriter;
import java.io.File;

import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

import org.apache.log4j.Logger;

import model.MonitoringEvent;

public class DataWriter {

	final static Logger logger = Logger.getLogger(DataWriter.class);

	protected static String dir;

	protected static String results;
	protected static String expressions;

	/**
	 * If resultsFile is true will generate a log file with the results
	 * 
	 * @param resultsFile
	 */
	public DataWriter(boolean resultsFile) {
		Date currentDate = new Date();

		// definition of the directory of logs
		dir = logs + currentDate.getTime();

		results = dir + "/results" + ".log";

		expressions = dir + "/expressions" + ".log";

		try {
			new File(dir).mkdirs();
			new File(expressions).createNewFile();
			if (resultsFile)
				new File(results).createNewFile();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public String getDir() {
		return dir;
	}

	/**
	 * Receives a set of expressions to be printed out in a log file
	 * 
	 * @param expressionsSet
	 */
	private void writeExpressions(Collection<String> expressionsSet) {
		logger.debug("Writing expressions to file...");

		FileWriter fileWriter;
		try {
			fileWriter = new FileWriter(expressions);
			BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

			for (String expression : expressionsSet) {
				bufferedWriter.write(expression + "\n");
			}
			bufferedWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	/**
	 * Write the results of signature data to a log file
	 * 
	 * @param values
	 */
	public void writeSignatureData(HashMap<String, ?> values) {
		logger.debug("Writing to file...");

		if (new File(results).length() == 0)
			writeExpressions(values.keySet());

		writeValues(values.values(), results);

	}

	/**
	 * 
	 * @param values
	 * @param logFile
	 * @param logCounter
	 */
	public void writeSignatureData(Set<String> setExpressions, Collection<?> state1, Collection<?> state2,
			String logFile) {
		logger.debug("Writing to file...");

		// **!!!
		if (new File(expressions).length() == 0)
			writeExpressions(setExpressions);

		writeValues(state1, logFile);
		writeValues(state2, logFile);
	}

	public void writeSignatureData(Set<String> setExpressions, Collection<?> state1, String logFile) {
		logger.debug("Writing to file...");

		// **!!!
		if (new File(expressions).length() == 0)
			writeExpressions(setExpressions);

		writeValues(state1, logFile);
	}

	/**
	 * Write the events
	 * 
	 * @param monitoringMethodDetailsEvent
	 * @param logFile
	 */
	public void writeMethodDetail(MonitoringEvent monitoringEvent, String logFile) {
		logger.debug("Writing method details to file...");

		BufferedWriter output;
		try {
			output = new BufferedWriter(new FileWriter(logFile, true));

			output.append("M:" + monitoringEvent.getMethodSignature());
			output.append("\n");


				for (Object param : monitoringEvent.getMethodArgs()) {
					output.append("P:" + param.toString());
					output.append("\n");
				}

			output.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Write the events
	 * 
	 * @param monitoringEvent
	 */
	public void writeMethodDetail(MonitoringEvent monitoringEvent) {
		writeMethodDetail(monitoringEvent, results);
	}

	public void writeLastEventTotalTime(Long totalTime) {
		writeLastEventTotalTime(totalTime, results);
	}

	public void writeLastEventTotalTime(Long totalTime, String logFile) {
		BufferedWriter output;

		try {
			output = new BufferedWriter(new FileWriter(logFile, true));

			output.append("T:" + totalTime);

			output.append("\n");
			output.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Write the values of a signature data structure to the logFile
	 * 
	 * @param values
	 * @param logFile
	 */
	private void writeValues(Collection<?> values, String logFile) {
		BufferedWriter output;
		String preText = "S:";

		try {
			output = new BufferedWriter(new FileWriter(logFile, true));
			output.append(preText);
			Iterator<?> it = values.iterator();
			while (it.hasNext()) {
				output.append(it.next().toString());
				if (it.hasNext()) {
					output.append(";");
				}
			}
			output.append("\n");
			output.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void writeActionName(String actionName, String logFile) {
		BufferedWriter output;

		try {
			output = new BufferedWriter(new FileWriter(logFile, true));

			output.append("A:" + actionName);

			output.append("\n");
			output.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
