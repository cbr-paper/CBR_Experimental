package util;

/**
 * Utility class that allows to count the exceptions that occur
 * during the execution of the monitored application.
 * 
 * To be used only for experiment.
 */
public final class ExceptionsCounterUtil {
	
	private static int counter = 0;
	
	// Private constructor to prevent the direct instantiation
	private ExceptionsCounterUtil() {}
	
	/**
	 * It increases the counter when an exception occurs.
	 */
	public static void increase() {
		++counter;
	}
	
	/**
	 * It returns the numbers of the exceptions occurred during the execution
	 * of the monitored application.
	 * 
	 * @return The number of the exceptions occurred during the execution of the
	 * monitored application.
	 */
	public static int getExceptionsCounter() {
		return counter;
	}
	
	/**
	 * It allows to reset the counter of the number of the exceptions.
	 */
	public static void resetExceptionsCounter() {
		counter = 0;
	}
}