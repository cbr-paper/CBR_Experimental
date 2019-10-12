package util;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Utility class to write to the file.
 */
public final class FileWriterUtil {
	
	// Private constructor to prevent the direct instantiation
	private FileWriterUtil() {}
	
	/**
	 * It allows to write the string passed as parameter to the file.
	 * 
	 * @param fileWriter The file channel to write to the file.
	 * @param s The string that must be written to the file.
	 */
	public static void write(FileChannel fileWriter, String s) {
		
		final byte[] bytes = (s + System.lineSeparator()).getBytes();
		
		ByteBuffer buffer = ByteBuffer.allocate(bytes.length);
		buffer.put(bytes);
		buffer.flip();
		
		try {
			fileWriter.write(buffer);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}