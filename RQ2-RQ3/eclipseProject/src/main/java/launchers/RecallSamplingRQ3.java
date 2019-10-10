package launchers;

import java.util.List;

import org.apache.log4j.Logger;

import file.RecallSamplingStats;
import file.RecallSamplingStatsFileWriter;
import fsa.SamplingBaseAnalysis;
import traces.Trace;
import utils.SettingsUtil;

public class RecallSamplingRQ3 {

	private static final String SAMPLING1_PATH_TRACES = SettingsUtil.getPropertyValue("sampling1_path_traces");
	private static final String SAMPLING2_PATH_TRACES = SettingsUtil.getPropertyValue("sampling2_path_traces");
	
	RecallSamplingStatsFileWriter fileWriterData = new RecallSamplingStatsFileWriter();
	
	final static Logger logger = Logger.getLogger(RecallSamplingRQ3.class);

	public RecallSamplingRQ3() {
				
		SamplingBaseAnalysis baseAnalysis1 = new SamplingBaseAnalysis(SAMPLING1_PATH_TRACES);
		SamplingBaseAnalysis baseAnalysis2 = new SamplingBaseAnalysis(SAMPLING2_PATH_TRACES);
		analyzeSamples(baseAnalysis1);
		analyzeSamples(baseAnalysis2);
		
		fileWriterData.closeFile();
	}

	private void analyzeSamples(SamplingBaseAnalysis baseAnalysis) {
		for (List<Trace> listSampleTraces : baseAnalysis.repositoryOfAllSamples) {

			for (Trace sampleTrace : listSampleTraces) {
				double recall = estimateCompleteness(baseAnalysis, sampleTrace);
				logger.info("recall: " + recall);
				fileWriterData.write(new RecallSamplingStats(baseAnalysis.samplingPath, recall));
			}
		}
	}

	private double estimateCompleteness(SamplingBaseAnalysis baseAnalysis, Trace sampleTrace) {
		double bestCompleteness = 0;

		for (Trace trace : baseAnalysis.repositoryOfAllTraces) {
			if (trace.contains(sampleTrace)) {
				logger.trace("founded in trace " + trace.getDirectory());
				double completeness = (double) sampleTrace.getSize() / (double) trace.getSize();
				if (completeness > bestCompleteness) {
					bestCompleteness = completeness;
				}
			}
		}
		return bestCompleteness;
	}

	public static void main(String[] args) {
		new RecallSamplingRQ3();
	}
}
