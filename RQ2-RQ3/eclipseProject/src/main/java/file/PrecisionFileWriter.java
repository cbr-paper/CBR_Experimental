package file;

import utils.FileWriterUtil;
import utils.SettingsUtil;

public class PrecisionFileWriter extends AbstractFileWriter<Precision> {

	private static final String PATH_FILE = SettingsUtil.getPropertyValue("precision_path");
	
	public PrecisionFileWriter() {
		super(PATH_FILE);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void write(Precision accuracy) {
		if (accuracy != null) {
			FileWriterUtil.write(fileChannel, accuracy.toString());
		}
	}
}
