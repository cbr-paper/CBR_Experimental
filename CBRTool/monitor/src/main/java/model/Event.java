package model;

import util.SettingsUtil;

/**
 * The base class that represents an event that occurs when the monitored
 * application is running. An event is a method called during the execution 
 * of the monitored application.
 */
public class Event {
	
	protected String methodSignature;
	protected String separator = SettingsUtil.getPropertyValue("file_data_separator");
	
	/**
	 * It created a new instance of Event.
	 * 
	 * @param methodSignature The signature of the called method.
	 */
	public Event(String methodSignature) {
		this.methodSignature = methodSignature;
	}
	
	/**
	 * It returns the signature of the called method.
	 * 
	 * @return The signature of the called method.
	 */
	public String getMethodSignature() {
		return methodSignature;
	}
	
	/**
	 * It sets the signature of the called method.
	 * 
	 * @param methodSignature The signature of the called method.
	 */
	public void setMethodSignature(String methodSignature) {
		this.methodSignature = methodSignature;
	}

	/**
	 * It returns the signature of the called method.
	 * This method is used when the objects state is written
	 * to the file.
	 */
	@Override
	public String toString() {
		return methodSignature;
	}
}