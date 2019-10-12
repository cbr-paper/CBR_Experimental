package util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Utility class that allows to get the configuration parameters
 * of the monitoring tool.
 * 
 * The values are saved in the config.properties file.
 */
public final class SettingsUtil {
	
	private static Properties prop;
	
	static {
		InputStream inputStream = SettingsUtil.class.getResourceAsStream("/config.properties");
		prop = new Properties();
		
		try {
			prop.load(inputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// Private constructor to prevent the direct instantiation
	private SettingsUtil() {}
	
	/**
	 * It returns the value associated to the property passed as parameter.
	 * 
	 * @param property The property of which you want to know its associated value.
	 * @return The value associated to the specified property.
	 */
	public static String getPropertyValue(String property) {
		return prop.getProperty(property, null);
	}
}