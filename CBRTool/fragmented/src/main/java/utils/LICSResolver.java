package utils;

public class LICSResolver {

	private final String klass;
	private final String subklass;

	public LICSResolver(String klass, String subklass) throws SameImplementorException {
		if (klass.equals(subklass))
			throw new SameImplementorException(klass + " and " + subklass + " are the same");
		this.klass = klass;
		this.subklass = subklass;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LICSResolver other = (LICSResolver) obj;
		if (klass == null) {
			if (other.klass != null)
				return false;
		} else if (!klass.equals(other.klass))
			return false;
		if (subklass == null) {
			if (other.subklass != null)
				return false;
		} else if (!subklass.equals(other.subklass))
			return false;
		return true;
	}

	public String getKlass() {
		return klass;
	}

	public String getSubklass() {
		return subklass;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((klass == null) ? 0 : klass.hashCode());
		result = prime * result + ((subklass == null) ? 0 : subklass.hashCode());
		return result;
	}

}