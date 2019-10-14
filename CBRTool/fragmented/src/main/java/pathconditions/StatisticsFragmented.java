package pathconditions;

import jbse.apps.run.fragmented.RunFragmented;

/**
 * Statistics about the filtering process
 *
 */
public class StatisticsFragmented {
	
	/** Counter for the number of analyzed traces that are safe (do not violate assertions). */
	private long tracesSafe;
	
	/** Counter for the number of analyzed traces that are unsafe (violate some assertion). */
	private long tracesUnsafe;

	private long totalTraces;

	private long totalPCFragmented;

	public StatisticsFragmented(RunFragmented runM) {
		tracesSafe = runM.getTracesSafe();
		tracesUnsafe = runM.getTracesUnsafe();
	}

	public long getTracesSafe() {
		return tracesSafe;
	}

	public long getTracesUnsafe() {
		return tracesUnsafe;
	}

	public void setTotalTraces(long pathConditionCounter) {
		this.totalTraces = pathConditionCounter;
	}
	
	public long getTotalTraces(){
		return totalTraces;
	}

	public void setTotalPCFragmented(long size) {
		this.totalPCFragmented = size;
	}
	
	public long getTotalPCFragmented(){
		return totalPCFragmented;
	}
	
}
