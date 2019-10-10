package fsa;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;

import traces.ProcessLogFiles;
import traces.Trace;
import traces.TraceParser;
import utils.SettingsUtil;

public class SamplingBaseAnalysis {
	
	final static Logger logger = Logger.getLogger(SamplingBaseAnalysis.class);
	
	private static final String NAIVE_PATH_TRACES = SettingsUtil.getPropertyValue("naive_path_traces");
	
	public List<Trace> repositoryOfAllTraces;
	public Set<List<Trace>> repositoryOfAllSamples;
	
	public String samplingPath;
	
	public SamplingBaseAnalysis(String samplingPathTraces) {
		this.samplingPath = samplingPathTraces;
		
		retrieveSamples();
		retrieveOriginalTraces();
	}
	public void retrieveSamples() {
		repositoryOfAllSamples = new HashSet<>();
		
		for (String directory : ProcessLogFiles.returnDirectoriesInFolder(this.samplingPath)) {

			boolean iterate = true;
			int logCounter = 0;
			List<Trace> samples = new ArrayList<>();
			while (iterate) {
				try {
					File fileInDirectory = new File(this.samplingPath + "/" + directory + "/" + logCounter + ".log");

					TraceParser traceParser = new TraceParser(fileInDirectory, logCounter++, directory);

					samples.add(traceParser.getTrace());

				} catch (FileNotFoundException e) {
					iterate = false;
				}

			}
			repositoryOfAllSamples.add(samples);
		}
	}
	
	public void retrieveOriginalTraces() {
		repositoryOfAllTraces = new ArrayList<>();
		
		for (String directory : ProcessLogFiles.returnDirectoriesInFolder(NAIVE_PATH_TRACES)) {
			logger.trace(directory);

			try {
				File fileInDirectory = new File(NAIVE_PATH_TRACES + "/" + directory + "/results.log");

				TraceParser traceParser = new TraceParser(fileInDirectory, directory);

				repositoryOfAllTraces.add(traceParser.getTrace());

			} catch (FileNotFoundException e) {
				logger.error("Error");
			}
		}
	}
}
