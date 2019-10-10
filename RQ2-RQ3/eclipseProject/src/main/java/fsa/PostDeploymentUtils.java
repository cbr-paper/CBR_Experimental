package fsa;

import java.util.List;

import traces.Burst;
import traces.Trace;

public class PostDeploymentUtils {
	public static void addToGraph(Burst burst, Digraph<String> graph) {
		graph.add(burst.getInitialState());
		graph.add(burst.getFinalState());
		graph.add(burst.getInitialState(), burst.getFinalState(), burst.getActionName());
	}

	public static int estimateTotalEventsInTraceOfBursts(List<Burst> listBursts) {
		int total = 0;
		for (Burst b : listBursts) {
			total += b.getSize();
		}
		return total;
	}
	
	public static int estimateTotalEventsInTraces(List<Trace> list) {
		int total = 0;
		for (Trace t : list) {
			total += t.getSize();
		}
		return total;
	}
}
