package fsa;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import java.util.Random;
import java.util.Set;

import org.apache.log4j.Logger;

import traces.Burst;
import traces.BurstParser;
import traces.ProcessLogFiles;
import traces.Trace;
import traces.TraceParser;
import utils.SettingsUtil;

public class CBRBaseAnalysis {
	final static Logger logger = Logger.getLogger(CBRBaseAnalysis.class);

	public Digraph<String> graph;
	public List<Trace> repositoryOfAllTraces;
	public Set<List<Burst>> repositoryOfAllTracesAsBursts;
	public List<Burst> repositoryOfAllBursts;

	private static final String CBR_PATH_TRACES = SettingsUtil.getPropertyValue("cbr_path_traces");
	private static final String NAIVE_PATH_TRACES = SettingsUtil.getPropertyValue("naive_path_traces");
	private static final int ITERATIONS = Integer.parseInt(SettingsUtil.getPropertyValue("iterations"));

	public CBRBaseAnalysis(double cbr_probability) {

		createGraph(cbr_probability);

		retrieveOriginalTraces();
		createTracesFromBursts();
	}

	public void createGraph(double burstProbability) {
		int count = 0;
		graph = new Digraph<String>();
		repositoryOfAllBursts = new ArrayList<>();

		for (String directory : ProcessLogFiles.returnDirectoriesInFolder(CBR_PATH_TRACES)) {
			count++;

			if (true) {
				for (int i = 0; i < ITERATIONS; i++) {
					logger.debug(directory);

					boolean iterate = true;
					int logCounter = 0;

					while (iterate) {

						try {
							File fileInDirectory = new File(
									CBR_PATH_TRACES + "/" + directory + "/" + logCounter + ".log");

							BurstParser burstParser = new BurstParser(fileInDirectory, logCounter++, directory);

							if (burstProbability(burstProbability)) {
								Burst b = burstParser.getBurst();
								PostDeploymentUtils.addToGraph(b, graph);
								repositoryOfAllBursts.add(b);
							}

						} catch (FileNotFoundException e) {
							iterate = false;
						}
					}
				}
			}
		}
	}

	private void createTracesFromBursts() {
		repositoryOfAllTracesAsBursts = new HashSet<>();
		for (String directory : ProcessLogFiles.returnDirectoriesInFolder(CBR_PATH_TRACES)) {

			boolean iterate = true;
			int logCounter = 0;
			List<Burst> bursts = new ArrayList<>();
			while (iterate) {
				try {
					File fileInDirectory = new File(CBR_PATH_TRACES + "/" + directory + "/" + logCounter + ".log");

					BurstParser burstParser = new BurstParser(fileInDirectory, logCounter++, directory);

					bursts.add(burstParser.getBurst());

				} catch (FileNotFoundException e) {
					iterate = false;
				}

			}
			repositoryOfAllTracesAsBursts.add(bursts);
		}
	}

	public void retrieveOriginalTraces() {
		repositoryOfAllTraces = new ArrayList<>();

		for (String directory : ProcessLogFiles.returnDirectoriesInFolder(CBR_PATH_TRACES)) {

			boolean iterate = true;
			int logCounter = 0;
			List<Burst> bursts = new ArrayList<>();
			while (iterate) {
				try {
					File fileInDirectory = new File(CBR_PATH_TRACES + "/" + directory + "/" + logCounter + ".log");

					BurstParser burstParser = new BurstParser(fileInDirectory, logCounter++, directory);

					bursts.add(burstParser.getBurst());

				} catch (FileNotFoundException e) {
					iterate = false;
				}

			}
			repositoryOfAllTraces.add(new Trace(bursts));
		}

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

	/**
	 * Returns the probability of being executed
	 * 
	 * @param probability
	 * @return
	 */
	private boolean burstProbability(double probability) {
		double max = 1;
		double min = 0;
		Random r = new Random();
		double random = min + r.nextDouble() * (max - min);

		if (random < probability)
			return true;
		else
			return false;
	}

}
