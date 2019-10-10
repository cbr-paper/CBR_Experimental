package file;

import utils.SettingsUtil;

public class Permutation {
	
	private String permutation;
	private Boolean possible;
	
	protected String separator = SettingsUtil.getPropertyValue("file_data_separator");
	
	public Permutation(String permutation, Boolean possible) {
		this.permutation = permutation;
		this.possible = possible;
	}

	public String toString() {
		return permutation + separator + possible;
	}
}
