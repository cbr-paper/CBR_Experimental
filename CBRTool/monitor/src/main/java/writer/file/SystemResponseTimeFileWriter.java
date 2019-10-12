package writer.file;

import model.SystemResponseTimeEvent;
import util.FileWriterUtil;
import util.SettingsUtil;

/**
 * It allows to write to file the data about the System Response Time
 * of the methods called during the execution of the monitored application.
 * 
 * To be used only for experiment.
 */
public class SystemResponseTimeFileWriter extends AbstractFileWriter<SystemResponseTimeEvent> {
	
	private static final String PATH_FILE = SettingsUtil.getPropertyValue("system_response_time_path_file");
	
	/**
	 *  It creates a new instance of SystemResponseCpuTimeFileWriter.
	 */
	public SystemResponseTimeFileWriter() {
		super(PATH_FILE);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void write(SystemResponseTimeEvent event) {
		if (event != null) {
			FileWriterUtil.write(fileChannel, event.toString());
		}
	}
}