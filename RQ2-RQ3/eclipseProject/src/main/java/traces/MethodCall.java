package traces;

import java.util.ArrayList;
import java.util.List;

public class MethodCall {
	private List<Parameter> parameters;
	private String signature;
	
	public MethodCall(String signature) {
		this.signature = signature;
	}
	
	public String getSignature() {
		return signature;
	}

	public void addParameter(Parameter parameter) {
		if (parameters == null) {
			parameters = new ArrayList<>();
			parameters.add(parameter);
		} else
			parameters.add(parameter);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((signature == null) ? 0 : signature.hashCode());
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
		MethodCall other = (MethodCall) obj;
		if (signature == null) {
			if (other.signature != null)
				return false;
		} else if (!signature.equals(other.signature))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return signature;
	}

}
