package model;

/**
 * It represents a System Response Time detection. Every detection is
 * characterized by the clock time to execute a method, the signature of the
 * called method, the time when the method has been called and the time when the
 * method ended its execution.
 * 
 * To be used only for experiment.
 */
public class SystemResponseTimeEventForExperiment extends SystemResponseTimeEvent {

	private long startDetectionTime;
	private long endDetectionTime;

	/**
	 * It creates a new instance of SystemResponseTimeEventForExperiment.
	 * 
	 * @param methodSignature
	 *            The signature of the called method.
	 * @param clockTime
	 *            The clock time to execute the method.
	 * @param startDetectionTime
	 *            The time when the method has been called.
	 * @param endDetectionTime
	 *            The time when the method ended its execution.
	 */
	public SystemResponseTimeEventForExperiment(String methodSignature, long clockTime, long startDetectionTime,
			long endDetectionTime) {
		super(methodSignature, clockTime);
		this.startDetectionTime = startDetectionTime;
		this.endDetectionTime = endDetectionTime;
	}

	/**
	 * It returns the time when the method has been called.
	 * 
	 * @return The time when the method has been called.
	 */
	public long getStartDetectionTime() {
		return startDetectionTime;
	}

	/**
	 * It sets the time when the method has been called.
	 * 
	 * @param startDetectionTime
	 *            The time when the method has been called.
	 */
	public void setStartDetectionTime(long startDetectionTime) {
		this.startDetectionTime = startDetectionTime;
	}

	/**
	 * It returns the time when the method ended its execution.
	 * 
	 * @return The time when the method ended its execution.
	 */
	public long getEndDetectionTime() {
		return endDetectionTime;
	}

	/**
	 * It sets the time when the method ended its execution.
	 * 
	 * @param endDetectionTime
	 *            The time when the method ended its execution.
	 */
	public void setEndDetectionTime(long endDetectionTime) {
		this.endDetectionTime = endDetectionTime;
	}

	/**
	 * It returns the signature of the called method, the clock time to execute the
	 * method, the time when the method has been called and the time when the method
	 * ended its execution.
	 */
	@Override
	public String toString() {
		return super.toString() + separator + startDetectionTime + separator + endDetectionTime;
	}
}