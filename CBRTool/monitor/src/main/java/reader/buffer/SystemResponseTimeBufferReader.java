package reader.buffer;

import buffer.SystemResponseTimeBuffer;
import model.SystemResponseTimeEvent;
import writer.file.DataFileWriter;
import writer.file.SystemResponseTimeFileWriter;

/**
 * Thread that reads items from the buffer that contains the System Response Time
 * of the method called during the execution of the monitored application.
 * 
 * To be used only for experiment.
 */
public class SystemResponseTimeBufferReader {
	
	private SystemResponseTimeBuffer buffer;
	private DataFileWriter<SystemResponseTimeEvent> fileWriterData;
	
	/**
	 * It creates a new instance of SystemResponseTimeBufferReader.
	 * 
	 * @param buffer The buffer that contains the System Response Time
	 * of the methods called during the execution of the monitored application.
	 */
	public SystemResponseTimeBufferReader(SystemResponseTimeBuffer buffer) {
		this.buffer = buffer;
	}
	
	/**
	 * It allows to empty the buffer and to write the data associated
	 * to the items that had been saved in the buffer.
	 */
	public void readFromBuffer() {
		
		fileWriterData = new SystemResponseTimeFileWriter();
		
		boolean iterate = true;
		
		while (iterate) {
			SystemResponseTimeEvent event = buffer.readItem();
			
			if (event != null) {
				fileWriterData.write(event);
			} else {
				iterate = false;
			}
		}
		
		fileWriterData.closeFile();
		buffer.clear();
	}
}