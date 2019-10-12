package model;

import java.util.ArrayList;
import java.util.List;

import util.ExceptionsCounterUtil;

/**
 * It represent an event that occurs when the monitored application is running.
 * An event is a method called during the execution of the monitored application.
 */
public class MonitoringEvent extends Event {

	private List<Object> methodArgs;

	/**
	 * It created a new instance of DelayedMonitoringMethodDetailsEvent.
	 * 
	 * @param methodSignature The signature of the called method.
	 */
	public MonitoringEvent(String methodSignature) {
		super(methodSignature);
		this.methodArgs = new ArrayList<Object>();
	}
	
	public List<Object> getMethodArgs() {
		return this.methodArgs;
	}
	
	public boolean hasMethodArgs() {
		return methodArgs != null ? true : false;
	}
	
	public void addMethodArgs(Object object) {
		if (object != null) {
			methodArgs.add(object);
		}
	}
	
	/**
	 * It allows to get details about the state of the objects
	 * whose references were saved when the event occurred.
	 */
	@Override
	public String toString() {
		
		String s = "";
		
		try {
			for (Object arg : methodArgs) {
				s += arg.toString() + "\n";
			}
		} catch (Exception e) {
			ExceptionsCounterUtil.increase();
		}
		
		return methodSignature + "\n" + s;
	}
}