package model;

/**
 * It represents a System Response Time detection. 
 * Every detection is characterized by the cock time (SRT) 
 * to execute a method and the signature of the called method.
 * 
 * To be used only for experiment.
 */
public class SystemResponseTimeEvent extends Event {
	
	protected long clockTime;
	
	/**
	 * It creates a new instance of SystemResponseTimeEvent.
	 * 
	 * @param methodSignature The signature of the called method.
	 * @param clockTime The clock time to execute the method.
	 */
	public SystemResponseTimeEvent(String methodSignature, long clockTime) {
		super(methodSignature);
		this.clockTime = clockTime;
	}

	/**
	 * It returns the clock time to execute a method.
	 * 
	 * @return The clock time to execute a method.
	 */
	public long getClockTime() {
		return clockTime;
	}
	

	/**
	 * It sets the clock time used to execute a method.
	 * 
	 * @param cockTime The clock time used to execute a method.
	 */
	public void setClockTimeEvent(long clockTime) {
		this.clockTime = clockTime;
	}

	/**
	 * It returns the signature and the System Response Time
	 * of the called method.
	 */
	@Override
	public String toString() {
		return super.toString() + separator + clockTime;
	}
}