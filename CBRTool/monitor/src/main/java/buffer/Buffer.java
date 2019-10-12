package buffer;

/**
 * Interface that represents a buffer in which to put the events that
 * occur while the monitored application is running.
 *
 * @param <T> The type of the events that the buffer contains.
 */
public interface Buffer<T> {
	
	/**
	 * It adds the specified item to the end of the buffer.
	 * 
	 * @param item The item that must be added to the buffer.
	 */
	void addItem(T item);
	
	/**
	 * It retrieves and removes the item that is in the head of the buffer.
	 * 
	 * @return The item in the head of the buffer.
	 */
	T readItem();
	
	/**
	 * It removes the whole elements in the buffer.
	 */
	void clear();
}