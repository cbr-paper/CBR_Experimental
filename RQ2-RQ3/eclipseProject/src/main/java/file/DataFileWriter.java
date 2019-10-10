package file;

/**
 * Interface to write the data to file.
 *
 * @param <T> The type of the data to write to file.
 */
public interface DataFileWriter<T> {
	
	/**
	 * It allows to write the specified data to file.
	 * 
	 * @param data The data to write to file.
	 */
	public void write(T data);
	
	/**
	 * It allows to close the file.
	 */
	public void closeFile();
}