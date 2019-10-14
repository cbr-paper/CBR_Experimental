package pathconditions;

import java.util.HashSet;

import jbse.mem.fragmented.PathConditionFragmented;

public class NegationSimplifier implements Simplifier {

	private HashSet<PathConditionFragmented> pathConditionsFragmented;

	public NegationSimplifier(HashSet<PathConditionFragmented> pathConditionsFragmented) {
		this.pathConditionsFragmented = pathConditionsFragmented;
	}

}
