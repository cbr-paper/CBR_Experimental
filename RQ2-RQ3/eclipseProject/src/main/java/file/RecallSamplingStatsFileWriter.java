package file;

import utils.FileWriterUtil;
import utils.SettingsUtil;

public class RecallSamplingStatsFileWriter extends AbstractFileWriter<RecallSamplingStats> {

	private static final String PATH_FILE = SettingsUtil.getPropertyValue("recall_sampling_path");

	public RecallSamplingStatsFileWriter() {
		super(PATH_FILE);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void write(RecallSamplingStats completenessStats) {
		if (completenessStats != null) {
			FileWriterUtil.write(fileChannel, completenessStats.toString());
		}
	}
}