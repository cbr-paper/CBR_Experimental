package launchers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.Map.Entry;

import org.apache.log4j.Logger;

import file.Precision;
import file.PrecisionFileWriter;
import fsa.CBRBaseAnalysis;
import traces.Burst;
import traces.Trace;
import utils.SettingsUtil;

public class PrecisionRQ2 {

	final static Logger logger = Logger.getLogger(PrecisionRQ2.class);

	protected Map<String, BurstsPair> permutations;
	protected Map<String, Boolean> permutationsOutcome;

	private CBRBaseAnalysis baseAnalysis;
	
	private static final String CBR_PROBABILITY = SettingsUtil.getPropertyValue("cbr_probability");
	private static final String separator = SettingsUtil.getPropertyValue("file_data_separator");

	public static void main(String[] args) {
		new PrecisionRQ2();
	}

	public PrecisionRQ2() {

		String[] probabilities = CBR_PROBABILITY.split(";");
		
		PrecisionFileWriter fileWriterData = new PrecisionFileWriter();

		for (String probability : probabilities) {
			permutations = new HashMap<>();
			permutationsOutcome = new HashMap<>();

			baseAnalysis = new CBRBaseAnalysis(Double.parseDouble(probability));

			analyzeGraph();
			iterateOverNodes();

			double accuracy = countOcurrences();
			
			fileWriterData.write(new Precision(probability, accuracy));
			
			logger.info("Precision for p: " + probability + " = " + accuracy);
			
		}
		fileWriterData.closeFile();
	}



	private void analyzeGraph() {
		logger.trace("Graph has " + baseAnalysis.graph.getNeighbors().size() + " nodes");

		Set<String> S = new LinkedHashSet<String>();
		Queue<String> Q = new LinkedList<String>();

		String initialState = baseAnalysis.graph.getInitialVertex();

		S.add(initialState);
		Q.add(initialState);
		int count = 0;
		do {
			String current = Q.remove();
			List<String> it = baseAnalysis.graph.outboundNeighbors(current);

			for (String state : it) {
				if (!S.contains(state)) {
					S.add(state);
					Q.add(state);

					analyzeNode(state, ++count);
				}
			}
		} while (!Q.isEmpty());
		logger.trace("I visited " + S.size() + " nodes");
	}

	private void analyzeNode(String state, int count) {

		int hash = state.hashCode();

		List<String> inboundVertex = baseAnalysis.graph.inboundNeighbors(state);
		List<String> outboundVertex = baseAnalysis.graph.outboundNeighbors(state);

		for (String inboundNode : inboundVertex) {
			for (String outboundNode : outboundVertex) {
				List<String> inboundEdges = baseAnalysis.graph.getLabel(inboundNode, state);
				List<String> outboundEdges = baseAnalysis.graph.getLabel(state, outboundNode);

				for (String inboundEdge : inboundEdges) {
					for (String outboundEdge : outboundEdges) {
						if (inboundEdge.equals(outboundEdge)) {
							continue;
						}

						String permutation = inboundEdge + separator + outboundEdge + separator + hash;

						List<Burst> listBursts1 = retrieveBursts(inboundNode, state, inboundEdge);
						List<Burst> listBursts2 = retrieveBursts(state, outboundNode, outboundEdge);

						permutations.put(permutation, new BurstsPair(listBursts1, listBursts2));
					}
				}
			}
		}
	}

	private List<Burst> retrieveBursts(String inboundNode, String state, String inboundEdge) {
		List<Burst> founded = new ArrayList<>();

		for (Burst b : baseAnalysis.repositoryOfAllBursts) {
			if (b.getActionName().equals(inboundEdge) && b.getInitialState().equals(inboundNode)
					&& b.getFinalState().equals(state)) {
				founded.add(b);
			}
		}
		return founded;
	}

	private boolean evaluateExistence(Burst b1, Burst b2) {
		Trace createdTrace = null;

		createdTrace = new Trace(Arrays.asList(b1, b2));

		if (createdTrace.isEmpty()) {
			return true;
		}

		for (Trace trace : baseAnalysis.repositoryOfAllTraces) {
			if (trace.contains(createdTrace)) {
				logger.trace("founded in trace " + trace.getDirectory());
				return true;
			}
		}
		return false;
	}

	private void iterateOverNodes() {
		logger.trace("Total traces: " + baseAnalysis.repositoryOfAllTraces.size());
		logger.info("Total permutations: " + permutations.size());

		for (Entry<String, BurstsPair> entry : permutations.entrySet()) {
			BurstsPair bp = entry.getValue();
			boolean founded = false;
			for (Burst burst1 : bp.listBursts1) {
				for (Burst burst2 : bp.listBursts2) {
					if (evaluateExistence(burst1, burst2)) {
						founded = true;
					}
				}
			}
			permutationsOutcome.put(entry.getKey(), founded);
		}
	}

	
	private double countOcurrences() {
		int correct = 0;

		for (Boolean value : permutationsOutcome.values()) {
			if (value)
				correct += 1;
		}
		return (double) correct / (double) permutations.size();
	}

	class BurstsPair {
		public BurstsPair(List<Burst> listBursts12, List<Burst> listBursts22) {
			this.listBursts1 = listBursts12;
			this.listBursts2 = listBursts22;
		}

		List<Burst> listBursts1;
		List<Burst> listBursts2;
	}
}
