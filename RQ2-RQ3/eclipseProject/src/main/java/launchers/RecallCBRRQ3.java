package launchers;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import file.RecallStats;
import file.RecallStatsFileWriter;
import fsa.CBRBaseAnalysis;
import fsa.PostDeploymentUtils;
import traces.Burst;
import utils.SettingsUtil;

public class RecallCBRRQ3 {

	final static Logger logger = Logger.getLogger(RecallCBRRQ3.class);
	
	private static final String CBR_PROBABILITY = SettingsUtil.getPropertyValue("cbr_probability");
	
	private List<RecallStats> tracesStats = new ArrayList<>();

	public RecallCBRRQ3() {
		String[] probabilities = CBR_PROBABILITY.split(";");
		
		for (String probability: probabilities) {
			CBRBaseAnalysis baseAnalysis = new CBRBaseAnalysis(Double.parseDouble(probability));
			
			analyzeGraph(probability,baseAnalysis);
		}
		writeResults();
	}

	private void analyzeGraph(String probability, CBRBaseAnalysis baseAnalysis) {
		for (List<Burst> listBursts : baseAnalysis.repositoryOfAllTracesAsBursts) {
			
			int totalBursts = listBursts.size();
			int totalEvents = PostDeploymentUtils.estimateTotalEventsInTraceOfBursts(listBursts);

			int countBursts = 0;
			int countEvents = 0;
			int bestCountBursts = 0;
			int bestCountEvents = 0;

			for (int i = 0; i < listBursts.size(); i++) {
				Burst b = listBursts.get(i);

				List<String> edgeLabel = baseAnalysis.graph.getLabel(b.getInitialState(), b.getFinalState());
				
				if (edgeLabel.isEmpty()) {
					if (countBursts > bestCountBursts) {
						bestCountBursts = countBursts;
						bestCountEvents = countEvents;
					}
					countBursts = countEvents = 0;
					logger.debug("Not edges founded");
					continue;
				}
				
				logger.debug(b.getInitialState().hashCode() + " -> " + b.getFinalState().hashCode());

				if (edgeLabel.contains(b.getActionName())) {
					if (i == 0) {
						logger.debug("founded");
						countBursts++;
						countEvents += b.getSize();
						continue;
					}
					Burst previousBurst = listBursts.get(i - 1);
					logger.info("previousNode " + previousBurst.getActionName());
					if (i > 0 && b.getInitialState().equals(previousBurst.getFinalState())) {
						logger.debug("founded");
						
						countBursts++;
						countEvents += b.getSize();
					} else {
						if (countBursts > bestCountBursts) {
							bestCountBursts = countBursts;
							bestCountEvents = countEvents;
						}
						countBursts = countEvents = 0;
						logger.debug("burst not founded in model");
					}
				} else {
					if (countBursts > bestCountBursts) {
						bestCountBursts = countBursts;
						bestCountEvents = countEvents;
					}
					countBursts = countEvents = 0;
					logger.info("not found: " + b.getActionName());
				}

			}
			double percentageBursts;
			double percentageEvents;
			
			if (bestCountBursts == 0) {
				percentageBursts = (double) countBursts / (double) totalBursts;
				percentageEvents = (double) countEvents / (double) totalEvents;
			} else {
				percentageBursts = (double) bestCountBursts / (double) totalBursts;
				percentageEvents = (double) bestCountEvents / (double) totalEvents;
			}

			tracesStats.add(new RecallStats(probability, percentageBursts, percentageEvents));
		}
	}

	
	private void writeResults() {

		RecallStatsFileWriter fileWriterData = new RecallStatsFileWriter();

		for (RecallStats value : tracesStats) {
			fileWriterData.write(value);
		}

		fileWriterData.closeFile();
	}

	public static void main(String[] args) {
		new RecallCBRRQ3();
	}
}
