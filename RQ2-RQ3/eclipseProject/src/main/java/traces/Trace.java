package traces;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.log4j.Logger;

public class Trace {

	final static Logger logger = Logger.getLogger(Trace.class);

	private List<MethodCall> methodCalls;

	private String directory;

	public Trace(String directory) {
		this.directory = directory;
	}

	public Trace(List<Burst> bursts) {

		methodCalls = new ArrayList<MethodCall>();
		
		for(Burst b: bursts) {
			if(b.getSize()>0) {
				methodCalls.addAll(b.getMethodCalls());
			}
		}
	}

	@Override
	public String toString() {
		String toString = "";

		for (MethodCall m : methodCalls) {
			toString = toString + m + "\n";
		}

		return toString;
	}

	public boolean contains(Trace trace) {

		if (Collections.indexOfSubList(methodCalls, trace.methodCalls) != -1) {
			return true;
		}
		return false;

	}

	public List<MethodCall> getMethodCalls() {
		return methodCalls;
	}

	public int getSize() {
		return methodCalls.size();
	}

	public boolean isEmpty() {
		return methodCalls.size() == 0 ? true : false;
	}

	public void addMethodCall(String signature) {
		MethodCall methodCall = new MethodCall(signature);

		if (methodCalls == null) {
			methodCalls = new ArrayList<>();
			methodCalls.add(methodCall);
		} else {
			methodCalls.add(methodCall);
		}
	}

	public void addParameter(String parameterName) {
		int position = methodCalls.size() - 1;
		MethodCall methodTrace = methodCalls.get(position);

		Parameter parameter = new Parameter(parameterName);

		methodTrace.addParameter(parameter);

		methodCalls.set(position, methodTrace);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((methodCalls == null) ? 0 : methodCalls.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Trace other = (Trace) obj;
		if (methodCalls == null) {
			if (other.methodCalls != null)
				return false;
		} else if (!methodCalls.equals(other.methodCalls))
			return false;
		return true;
	}

	public String getDirectory() {
		return directory;
	}
}
