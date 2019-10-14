package launchers;

import filter.ConditionFilter;

public class ConsistencyChecker {

	public ConsistencyChecker() {
		launch();
	}
	public static void main(String[] args) {
		new ConsistencyChecker();
	}
	
	private void launch() {
		filterResultsFromTestResults();
	}
	
	private void filterResultsFromTestResults() {
		ConditionFilter conditionFilter = new ConditionFilter(true);
		String[][] results = conditionFilter.getResults();
		String[] expressions = conditionFilter.getExpressions();
			

		conditionFilter.printResults("f_results.log", results);
		conditionFilter.printExpressions("f_expressions.log", expressions);
		
	}
}
