package traces;

import java.io.File;
import java.io.FilenameFilter;

import org.apache.log4j.Logger;

public class ProcessLogFiles {
	
	final static Logger logger = Logger.getLogger(ProcessLogFiles.class);

	public static String[] returnDirectoriesInFolder(String path) {

		File file = new File(path);

		String[] directories = file.list(new FilenameFilter() {
			@Override
			public boolean accept(File current, String name) {
				return new File(current, name).isDirectory();
			}
		});
		return directories;
	}
}
