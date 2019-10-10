package file;

import utils.SettingsUtil;

public class RecallStats {
	
	protected String separator = SettingsUtil.getPropertyValue("file_data_separator");
	
	public RecallStats(String probability, double percentageBursts, double percentageEvents) {
		this.percentageBursts = percentageBursts;
		this.percentageEvents = percentageEvents;
		this.probability = probability;
	}
	
	String probability;
	double percentageBursts;
	double percentageEvents;
	
	@Override
	public String toString() {
		return probability + separator + percentageBursts + separator + percentageEvents;
	}
}
