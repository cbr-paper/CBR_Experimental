package utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

import org.apache.log4j.Logger;

import com.ibm.wala.classLoader.IClass;
import com.ibm.wala.ipa.callgraph.AnalysisScope;
import com.ibm.wala.ipa.cha.IClassHierarchy;

import pathconditions.PrintStreamOutLICSRules;

public class LICSRulesGenerator {

	final static Logger logger = Logger.getLogger(LICSRulesGenerator.class);

	private HashSet<LICSResolver> subclassesOfInterfaces = new HashSet<LICSResolver>();

	private PrintStreamOutLICSRules printStreamOut = new PrintStreamOutLICSRules();

	private List<String> avoidClasses = new ArrayList<String>(Arrays.asList(
			"Ljava/lang/Object",
			"Ljava/io/Serializable", "Ljava/util/stream", 
			"Ljava/util/zip", "Ljava/util/regex", "Ljava/util/jar", 
			"Ljava/nio", "Ljava/util/concurrent", 
			"Ljava/io/BufferedReader", "Ljava/util/WeakHashMap",
			"Ljava/util/ArrayList$SubList",
			"Ljava/util/LinkedHashMap$LinkedKeySet",
			"Ljava/util/LinkedHashMap$LinkedEntrySet",
			"Ljava/util/Comparators$NullComparator",
			"Ljava/util/Comparators$NaturalOrderComparator",
			"Ljava/util/HashMap$TreeNode",
			"Ljava/util/Arrays$NaturalOrder",
			"Ljava/util/Locale$FilteringMode",
			"Ljava/util/Locale$Category",
			"Ljava/sql/PseudoColumnUsage",
			"Ljava/sql/JDBCType",
			"Ljava/net/StandardProtocolFamily",
			"Ljava/lang/invoke",
			"Ljava/lang/UNIXProcess$Platform",
			"Ljava/util/LinkedHashMap$LinkedValues",
			"Ljava/io/UnixFileSystem",
			"Ljava/util/logging/LogManager$LoggerWeakRef",
			"Ljava/util/IllformedLocaleException",
			"Ljava/lang/reflect",
			"Ljava/lang/invoke/WrongMethodTypeException",
			"Ljava/util/Base64$EncOutputStream",
			"Ljava/io/Console$3",
			"Ljava/util/prefs/MacOSXPreferencesFile"));

	public HashSet<LICSResolver> getSubclassesOfInterfaces() {
		return subclassesOfInterfaces;
	}

	public void produceLICSRules(IClassHierarchy cha, AnalysisScope scope) {

		// for each class in ClassHierarchy
		for (IClass klass : cha) {
			if (isNotAvoid(klass)) {
				String fullKlassName = StaticAnalysisUtilities.getFullClassNameJVM(klass.getName());
				if (klass.isInterface()) {
					Collection<IClass> implementors = klass.getClassHierarchy().getImplementors(klass.getReference());
					for (IClass implementor : implementors)
						if (isNotAvoid(implementor))
							addRule(implementor, fullKlassName, scope);

				} else if (klass.getClassHierarchy().getNumberOfImmediateSubclasses(klass) > 0) {
					Collection<IClass> subclasses = klass.getClassHierarchy().computeSubClasses(klass.getReference());
					for (IClass subclass : subclasses)
						if (isNotAvoid(subclass))
							addRule(subclass, fullKlassName, scope);
				}
			}
		}
		printStreamOut.printOutLICSRules(subclassesOfInterfaces);
		printStreamOut.printOutLICSRulesStandard(subclassesOfInterfaces);
	}

	private boolean isNotAvoid(IClass iClass) {
		for (String klass : avoidClasses) {
			if (iClass.getName().toString().contains(klass))
				return false;
		}
		return true;
	}

	/**
	 * add a new lics rule
	 * 
	 * @param iClassCollection
	 * @param fullKlassName
	 * @param scope
	 */
	private void addRule(IClass iClass, String fullKlassName, AnalysisScope scope) {
		String fullIClassName = StaticAnalysisUtilities.getFullClassNameJVM(iClass.getName());
		logger.trace("subclasses: " + fullKlassName + " -> " + fullIClassName);

		try {
			subclassesOfInterfaces.add(new LICSResolver(fullKlassName, fullIClassName));
		} catch (SameImplementorException e) {
			logger.trace(e.getMessage());
		}

	}
}