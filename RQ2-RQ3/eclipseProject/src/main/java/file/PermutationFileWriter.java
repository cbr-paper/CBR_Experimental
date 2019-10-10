package file;

import file.Permutation;
import utils.FileWriterUtil;
import utils.SettingsUtil;

public class PermutationFileWriter extends AbstractFileWriter<Permutation> {
	
	private static final String PATH_FILE = SettingsUtil.getPropertyValue("permutation_path");
	
	public PermutationFileWriter() {
		super(PATH_FILE);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void write(Permutation permutation) {
		if (permutation != null) {
			FileWriterUtil.write(fileChannel, permutation.toString());
		}
	}
}