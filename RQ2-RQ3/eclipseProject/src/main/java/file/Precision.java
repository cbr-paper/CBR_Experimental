package file;

import utils.SettingsUtil;

public class Precision {
	private String probability;
	private double precision;
	
	protected String separator = SettingsUtil.getPropertyValue("file_data_separator");
	
	public Precision(String probability, double precision) {
		this.probability = probability;
		this.precision = precision;
	}

	public String toString() {
		return probability + separator + precision;
	}
}
