package writer.file;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;

/**
 * It allows to write the specified type of the data to the file
 * in the specified path.
 *
 * @param <T> The type of the data to write to the file.
 */
public abstract class AbstractFileWriter<T> implements DataFileWriter<T> {
	
	protected FileChannel fileChannel;
	private FileOutputStream fileOutputStream;
	
	/**
	 * It creates a new instance of AbstractFileWriter.
	 * 
	 * @param path The path of the file where to write the data.
	 */
	public AbstractFileWriter(String path) {
		try {
			fileOutputStream = new FileOutputStream(path);
			fileChannel = fileOutputStream.getChannel();
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}
	
	/**
	 * {@inheritDoc}
	 */
	public void closeFile() {
		try {
			fileChannel.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}