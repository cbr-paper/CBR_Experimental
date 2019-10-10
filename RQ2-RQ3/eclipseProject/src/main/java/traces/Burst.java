package traces;

import java.util.ArrayList;
import java.util.List;

public class Burst {

	private List<MethodCall> methodCalls = new ArrayList<>();
	private String actionName;
	private String initialState;
	private String finalState;

	public List<MethodCall> getMethodCalls() {
		return methodCalls;
	}

	public int getSize() {
		return methodCalls.size();
	}

	public String getActionName() {
		return actionName;
	}

	public void setActionName(String actionName) {
		this.actionName = actionName;
	}

	public void addState(String state) {
		if (initialState == null) {
			this.initialState = state;
		} else {
			this.finalState = state;
		}
	}

	public void setInitialState(String initialState) {
		this.initialState = initialState;
	}

	public String getInitialState() {
		return initialState;
	}

	public void setFinalState(String finalState) {
		this.finalState = finalState;
	}

	public String getFinalState() {
		return finalState;
	}

	public void addMethodCall(String signature) {
		MethodCall methodCall = new MethodCall(signature);

		methodCalls.add(methodCall);
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
		Burst other = (Burst) obj;
		if (methodCalls == null) {
			if (other.methodCalls != null)
				return false;
		} else if (!methodCalls.equals(other.methodCalls))
			return false;
		return true;
	}
}
