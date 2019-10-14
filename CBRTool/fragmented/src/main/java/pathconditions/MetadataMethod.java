package pathconditions;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

import org.apache.log4j.Logger;

import com.ibm.wala.classLoader.IMethod;

import jbse.apps.fragmented.SymbolInformation;
import jbse.apps.fragmented.SymbolsMapGenerator;
import jbse.mem.fragmented.PathConditionFragmented;
import utils.StaticAnalysisUtilities;

public class MetadataMethod implements Serializable {

	private static class OrderComparator implements Comparator<String>, Serializable {
		private static final long serialVersionUID = 1L;

		@Override
		public int compare(String s1, String s2) {
			if (s1.length() > s2.length()) {
				return -1;
			} else if (s1.length() < s2.length()) {
				return 1;
			} else {
				return s1.compareTo(s2);
			}
		}
	}

	private static final long serialVersionUID = 1L;

	final static Logger logger = Logger.getLogger(MetadataMethod.class);

	/** Symbols of the symbolic execution */
	private Map<String, SymbolInformation> symbols;

	/** Number of method parameters */
	private int numberOfParameters;

	/** Fully qualified name of class (JVM format) */
	private String classFullyQualifiedNameJVM;

	/** Fully qualified name of class */
	private String classFullyQualifiedName;

	/** Just the class name */
	private String className;

	/** Java descriptor of the method */
	private String descriptor;

	/** Name of the method */
	private String methodName;

	/** Filtered path conditions */
	private Collection<PathConditionFragmented> pathConditions;

	public MetadataMethod(IMethod method) {
		logger.debug("Building MetaDataMethod for " + method.getName().toString());

		this.className = method.getDeclaringClass().getName().getClassName().toString();
		this.classFullyQualifiedNameJVM = StaticAnalysisUtilities.getFullClassNameJVM(method);
		this.classFullyQualifiedName = StaticAnalysisUtilities.getFullClassName(method);
		this.descriptor = method.getDescriptor().toString();
		this.methodName = method.getName().toString();
		this.numberOfParameters = method.getNumberOfParameters();
	}

	public void filterPathConditionsByExpressions(ArrayList<String> expressions) {
		logger.debug("Filtering Path Conditions By Expressions ...");

		List<PathConditionFragmented> removedList = new ArrayList<PathConditionFragmented>();

		for (PathConditionFragmented pcf : pathConditions) {
			String methodCount = methodName + className + "_" + hashCode() +  "_" + pcf.getCount();
			if (!expressions.contains(methodCount)) {
				removedList.add(pcf);
			}
		}

		pathConditions.removeAll(removedList);
		setSymbols();

		for (Entry<String, SymbolInformation> entry : symbols.entrySet()) {
			String key = entry.getKey().toString();
			String value = entry.getValue().toString();
			logger.debug(key + " " + value);
		}
	}

	public String getClassFullyQualifiedName() {
		return classFullyQualifiedName;
	}

	public String getClassFullyQualifiedNameJVM() {
		return classFullyQualifiedNameJVM;
	}

	public String getClassName() {
		return className;
	}

	public String getDescriptor() {
		return descriptor;
	}

	public String getName() {
		return methodName;
	}

	public int getNumberOfParameters() {
		return numberOfParameters;
	}

	public Collection<PathConditionFragmented> getPathConditions() {
		return this.pathConditions;
	}

	public Map<String, SymbolInformation> getSymbols() {
		return symbols;
	}

	public void serializeObject(String path) {
		// save the object to file
		FileOutputStream fos = null;
		ObjectOutputStream out = null;

		try {
			fos = new FileOutputStream(path + methodName + "_" + className + ".ser");
			out = new ObjectOutputStream(fos);
			out.writeObject(this);
			out.close();
		} catch (IOException e) {
e.printStackTrace();
			//			logger.error(e.getMessage());
		}
	}

	public void setPathConditions(Collection<PathConditionFragmented> calculatedPathConditions) {
		this.pathConditions = calculatedPathConditions;
	}

	public void setSymbols() {
		logger.debug("Setting symbols..........");

		SymbolsMapGenerator smg = new SymbolsMapGenerator();
		Map<String, SymbolInformation> unsortedSymbolsMap = null;

		try {
			unsortedSymbolsMap = smg.getSymbolsMap(this.pathConditions);
		} catch (Exception e) {
			e.printStackTrace();
		}

		symbols = new TreeMap<String, SymbolInformation>(new OrderComparator());
		symbols.putAll(unsortedSymbolsMap);

		for (Entry<String, SymbolInformation> entry : symbols.entrySet()) {
			String value = entry.getKey().toString();
			logger.debug(value);
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((className == null) ? 0 : className.hashCode());
		result = prime * result + ((descriptor == null) ? 0 : descriptor.hashCode());
		result = prime * result + ((methodName == null) ? 0 : methodName.hashCode());
		return Math.abs(result);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MetadataMethod other = (MetadataMethod) obj;
		if (className == null) {
			if (other.className != null)
				return false;
		} else if (!className.equals(other.className))
			return false;
		if (descriptor == null) {
			if (other.descriptor != null)
				return false;
		} else if (!descriptor.equals(other.descriptor))
			return false;
		if (methodName == null) {
			if (other.methodName != null)
				return false;
		} else if (!methodName.equals(other.methodName))
			return false;
		return true;
	}
	
	
}
