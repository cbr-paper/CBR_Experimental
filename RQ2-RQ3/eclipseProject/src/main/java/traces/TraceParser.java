package traces;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.apache.log4j.Logger;

public class TraceParser {

	final static Logger logger = Logger.getLogger(TraceParser.class);
	private Trace trace;
	private String directory;
	private String logFileName;

	public TraceParser(File trace, String directory) throws FileNotFoundException {
		this.directory = directory;
		this.trace = readTrace(trace);
	}
	
	public TraceParser(File fileInDirectory, int logCounter, String directory) throws FileNotFoundException {
		this.logFileName = Integer.toString(logCounter);
		this.directory = directory;
		this.trace = readTrace(fileInDirectory);
	}

	public Trace getTrace() {
		return trace;
	}
	
	private Trace readTrace(File traceFile) throws FileNotFoundException {
		Trace trace = new Trace(directory);
		try (BufferedReader br = new BufferedReader(new FileReader(traceFile))) {
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

	private void parseLine(Trace trace, String[] line) {

		switch (line[0]) {
		case "M":
			trace.addMethodCall(line[1]);
			break;
		case "P":
			trace.addParameter(line[1]);
			break;
		default:
			break;
		}
		return;
	}

}
