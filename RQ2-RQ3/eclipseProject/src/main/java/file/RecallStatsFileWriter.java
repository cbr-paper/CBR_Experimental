package file;

import utils.FileWriterUtil;
import utils.SettingsUtil;

public class RecallStatsFileWriter extends AbstractFileWriter<RecallStats> {

	private static final String PATH_FILE = SettingsUtil.getPropertyValue("recall_path");
	
	public RecallStatsFileWriter() {
		super(PATH_FILE);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void write(RecallStats completenessStats) {
		if (completenessStats != null) {
			FileWriterUtil.write(fileChannel, completenessStats.toString());
		}
	}
}