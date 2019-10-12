package writer.buffer;

/**
 * Interface to write the events to the buffer.
 * 
 * @param <T> The type of the event.
 */
public interface EventBufferWriter<T> {
	
	/**
	 * It allows to add the specified event to the buffer.
	 * 
	 * @param event The event that must be added to the buffer.
	 */
	public void addEventToBuffer(T event);
}