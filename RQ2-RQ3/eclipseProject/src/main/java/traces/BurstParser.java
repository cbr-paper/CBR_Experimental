package traces;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.apache.log4j.Logger;

import utils.SettingsUtil;

public class BurstParser {

	final static Logger logger = Logger.getLogger(BurstParser.class);
	private Burst burst;
	private String logFileName;
	private String directoryName;
	
	private static final String CBR_PATH_TRACES = SettingsUtil.getPropertyValue("cbr_path_traces");
	
	/**
	 * logCounter is for identifying the log file, same for directory
	 * @param burst
	 * @param logCounter
	 * @param directory
	 * @throws FileNotFoundException
	 */
	public BurstParser(File burstFile, int logCounter, String directory) throws FileNotFoundException {
		this.logFileName = Integer.toString(logCounter);
		this.directoryName = directory;
		this.burst = readBurst(burstFile);
	}

	public BurstParser(String string) throws FileNotFoundException {
		String[] meta = string.split("#");
		
		this.directoryName = meta[2];
		this.logFileName = meta[1];
		File burstFile = new File(CBR_PATH_TRACES + "/" + directoryName + "/" + logFileName + ".log");
		
		this.burst = readBurst(burstFile);
		
	}

	public Burst getBurst() {
		return burst;
	}

	private Burst readBurst(File burst) throws FileNotFoundException {
		Burst trace = new Burst();
		try (BufferedReader br = new BufferedReader(new FileReader(burst))) {

			String line;

			while ((line = br.readLine()) != null) {
				String[] splittedLine = line.split(":");

				if (splittedLine.length == 2) {
					parseLine(trace, splittedLine);
				}
			}

		} catch (FileNotFoundException e) {
			throw new FileNotFoundException();
		} catch (IOException e) {
			logger.error(e);
		}
		return trace;
	}

	private void parseLine(Burst burst, String[] line) {

		switch (line[0]) {
		case "A":
//			burst.setActionName(line[1]+ "#" + logFileName + "#" + directoryName);
			burst.setActionName(line[1]);
			break;
		case "M":
			burst.addMethodCall(line[1]);
			break;
		case "P":
			burst.addParameter(line[1]);
			break;
		case "S":
			burst.addState(line[1]);
			break;
		default:
			break;
		}
		return;
	}
}
