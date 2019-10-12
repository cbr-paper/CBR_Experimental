package writer.buffer;

import buffer.SystemResponseTimeBuffer;
import model.SystemResponseTimeEvent;

/**
 * It allows to write events to the buffer that contains
 * SystemResponseTimeEvent items.
 */
public class SystemResponseTimeBufferWriter implements EventBufferWriter<SystemResponseTimeEvent> {

	protected SystemResponseTimeBuffer systemResponseCpuTimeBuffer;
	
	/**
	 * It creates a new instance of SystemResponseTimeBufferWriter.
	 * 
	 * @param systemResponseTimeBuffer The buffer in which to add the items.
	 */
	public SystemResponseTimeBufferWriter(SystemResponseTimeBuffer systemResponseCpuTimeBuffer) {
		this.systemResponseCpuTimeBuffer = systemResponseCpuTimeBuffer;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void addEventToBuffer(SystemResponseTimeEvent event) {
		systemResponseCpuTimeBuffer.addItem(event);
	}
	
	public boolean isEmpty() {
		return systemResponseCpuTimeBuffer.isEmpty();
	}
}