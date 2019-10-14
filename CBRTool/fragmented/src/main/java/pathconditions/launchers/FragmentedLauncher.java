package pathconditions.launchers;

import static defs.Defs.serializedObjects;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;

import com.ibm.wala.classLoader.IMethod;

import pathconditions.MetadataMethod;
import pathconditions.SymbolicExecutionAnalysis;
import utils.StaticAnalysisUtilities;

public interface FragmentedLauncher {

	final static Logger logger = Logger.getLogger(FragmentedLauncher.class);

	public void staticAnalysis();

	default Collection<MetadataMethod> makeSymbolicExecution(List<String> classPath, Set<IMethod> analyzedMethods,
			List<String> include, List<String> avoid) {

		Collection<MetadataMethod> results = new ArrayList<MetadataMethod>();
		// for object serializing
		StaticAnalysisUtilities.createDirectory(serializedObjects);
		int counter = 0;

		if (include != null) {
			for (IMethod method : analyzedMethods) {
				try {
					if (isInMethodsToBeAnalyzed(method.getName().toString(), include)
							&& !isInMethodsToBeAvoid(method.getName().toString(), avoid)) {

						MetadataMethod metaDataMethod = new MetadataMethod(method);
						logger.debug("Iteration: " + counter++);
						logger.debug("Method " + metaDataMethod.getName() + " belong to class "
								+ metaDataMethod.getClassName());

						// Make symbolic execution
						SymbolicExecutionAnalysis symbolicExecutionAnalysis = new SymbolicExecutionAnalysis(classPath,
								metaDataMethod);
						symbolicExecutionAnalysis.runSymbolicExecution();
						// filter path conditions according to fragmented monitoring
						symbolicExecutionAnalysis.filterPathConditions();
						// print out path conditions
						symbolicExecutionAnalysis.printOutPathCondition();
						// serialize metadatamethod
						metaDataMethod.serializeObject(serializedObjects);

						results.add(metaDataMethod);
					}
				} catch (Exception e) {
					logger.error("JBSE exception: " + e.getMessage());
				}
			}
		} else {
			for (IMethod method : analyzedMethods) {
				try {
					if (!isInMethodsToBeAvoid(method.getName().toString(), avoid)) {

						MetadataMethod metaDataMethod = new MetadataMethod(method);
						logger.debug("Iteration: " + counter++);
						logger.debug("Method " + metaDataMethod.getName() + " belong to class "
								+ metaDataMethod.getClassName());

						// Make symbolic execution
						SymbolicExecutionAnalysis symbolicExecutionAnalysis = new SymbolicExecutionAnalysis(classPath,
								metaDataMethod);
						symbolicExecutionAnalysis.runSymbolicExecution();
						// filter path conditions according to fragmented monitoring
						symbolicExecutionAnalysis.filterPathConditions();
						// print out path conditions
						symbolicExecutionAnalysis.printOutPathCondition();
						// serialize metadatamethod
						metaDataMethod.serializeObject(serializedObjects);

						results.add(metaDataMethod);

					}
				} catch (Exception e) {
					logger.error("JBSE exception: " + e.getMessage());
				}
			}
		}

		int totalFragmentedPC = 0;

		for (MetadataMethod mdm : results) {
			if (mdm.getPathConditions().isEmpty())
				continue;
			logger.debug(mdm.getName() + ": " + mdm.getPathConditions().size());
			totalFragmentedPC += mdm.getPathConditions().size();
		}

		logger.debug("Total Path Conditions: " + totalFragmentedPC);

		return results;
	}

	public void launch();

	public void compilateConditions();

	default boolean isInMethodsToBeAnalyzed(String methodName, List<String> include) {
		if (include == null)
			return false;
		return include.contains(methodName);
	}

	default boolean isInMethodsToBeAvoid(String methodName, List<String> avoid) {
		if (avoid == null)
			return false;
		return avoid.contains(methodName);
	}
}
