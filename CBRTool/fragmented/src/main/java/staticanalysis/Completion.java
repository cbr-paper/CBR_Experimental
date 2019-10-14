package staticanalysis;

public 	class Completion {
	boolean condition;
	int numberOfTraces;

	public Completion(boolean condition, int numberOfTraces) {
		this.condition = condition;
		this.numberOfTraces = numberOfTraces;
	}
	
	public boolean getCondition() {
		return condition;
	}
	
	public int getNumberOfTraces() {
		return numberOfTraces;
	}
}
