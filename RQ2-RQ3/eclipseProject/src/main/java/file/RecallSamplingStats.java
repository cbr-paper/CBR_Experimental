package file;

import utils.SettingsUtil;

public class RecallSamplingStats {
	
	protected String separator = SettingsUtil.getPropertyValue("file_data_separator");
	
	public RecallSamplingStats(String technique, double percentageEvents) {
		this.percentageEvents = percentageEvents;
		this.technique = technique;
	}
	
	String technique;
	double percentageEvents;
	
	@Override
	public String toString() {
		return technique + separator + percentageEvents;
	}
}
