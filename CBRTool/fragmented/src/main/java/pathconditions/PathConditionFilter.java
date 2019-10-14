package pathconditions;

import java.util.Collection;
import java.util.HashSet;

import jbse.mem.State;
import jbse.mem.fragmented.ClauseFilter;
import jbse.mem.fragmented.PathConditionFragmented;

public class PathConditionFilter {

	public enum SimplificationMode {
		NEGATION
	}

	private final static int MAX = 10000;

	/** HashSet containing the filtered path conditions */
	private HashSet<PathConditionFragmented> pathConditionsFragmented = new HashSet<PathConditionFragmented>();

	private Collection<State> finalStates;

	private int pathConditionCounter = 0;

	private SimplificationMode type = SimplificationMode.NEGATION;

	private Simplifier simplifier = null;

	private String method;

	private int hashCode;

	public PathConditionFilter(Collection<State> finalStates, String method, int hashCode) {
		this.finalStates = finalStates;
		this.method = method;
		this.hashCode = hashCode;
	}

	/**
	 * Adds a new path condition to the method's path conditions
	 * 
	 * @param pcf
	 */
	private void addNewPathCondition(PathConditionFragmented pcf) {
		pathConditionsFragmented.add(pcf);
	}

	public void filterClausesFromPathCondition() {

		for (State state : finalStates) {
			ClauseFilter clauseFilter = new ClauseFilter(state);
			PathConditionFragmented pathConditionFragmented = clauseFilter.filterClausesfromState();
			
			if (pathConditionFragmented == null) {
				continue;
			}

			if (!pathConditionsFragmented.contains(pathConditionFragmented) 
					&& pathConditionsFragmented.size() < MAX) {
				pathConditionFragmented.setMethod(method);
				pathConditionFragmented.setHashCode(hashCode);
				pathConditionFragmented.setCount(pathConditionCounter++);
				addNewPathCondition(pathConditionFragmented);
			}
		}
	}

	public int getPathConditionCounter() {
		return this.pathConditionCounter;
	}

	public HashSet<PathConditionFragmented> getPathConditionsFragmented() {
		return this.pathConditionsFragmented;
	}

	public void simplifyPathConditions() {
		if (type == SimplificationMode.NEGATION)
			this.simplifier = new NegationSimplifier(pathConditionsFragmented);
	}
}
