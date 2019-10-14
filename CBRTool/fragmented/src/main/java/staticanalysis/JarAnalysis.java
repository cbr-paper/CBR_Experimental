package staticanalysis;

import static defs.Defs.*;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;

import com.ibm.wala.classLoader.IClass;
import com.ibm.wala.classLoader.IMethod;
import com.ibm.wala.ipa.callgraph.AnalysisScope;
import com.ibm.wala.ipa.cha.ClassHierarchy;
import com.ibm.wala.ipa.cha.ClassHierarchyException;
import com.ibm.wala.ipa.cha.ClassHierarchyFactory;
import com.ibm.wala.types.ClassLoaderReference;
import com.ibm.wala.util.io.FileProvider;

import utils.LICSRulesGenerator;
import utils.StaticAnalysisUtilities;

public class JarAnalysis {

	final static Logger logger = Logger.getLogger(JarAnalysis.class);

	/** Set of entry points from the interface jar or plugin */
	private Collection<?> entryPointsInterface;

	/** Path of the interface */
	private String appJar;

	/** Classpath */
	private List<String> classPath;

	/** Set of methods to be analyzed */
	private Set<IMethod> analyzedMethods = new LinkedHashSet<IMethod>();

	/** Classes Hierarchy of the problem */
	private ClassHierarchy cha;

	/** Analysis Scope of the problem */
	private AnalysisScope scope;

	/** LICS rules generator */
	private LICSRulesGenerator licsRulesGenerator = new LICSRulesGenerator();

	private JarDependencies jarDependencies = null;
	
	private CallGraphAnalysis cga;

	/**
	 * 
	 * @param appJar
	 * @param entryPointsInterface
	 * @param librariesPath
	 */
	public JarAnalysis(String appJar, String librariesPath) {
		logger.debug("Starting JarAnalysis for interface: " + appJar);

		this.appJar = appJar;

		if (!librariesPath.isEmpty())
			jarDependencies = new JarDependencies(librariesPath, false);

		
		collectRequiredBundles();
		generateClassPath();
		prepareStaticAnalysis();
	}

	public void collectRequiredBundles() {
		if (jarDependencies == null)
			return;

		jarDependencies.collectNamesRequiredJars(this.appJar);
		
		return;
	}

	public List<String> discoverClassesInPackage(List<String> monitoringScope)
			throws IOException, ClassHierarchyException {

		/** Set of classes to be analyzed */
		Set<String> analyzedClasses = new LinkedHashSet<String>();

		ClassLoaderReference clr = this.scope.getApplicationLoader();

		for (IClass klass : JarAnalysis.this.cha) {
			if (klass.getClassLoader().getReference().equals(clr)
					&& StaticAnalysisUtilities.isClassContainedInScope(klass, monitoringScope)) {
				logger.debug(StaticAnalysisUtilities.getFullClassName(klass.getName()));
				analyzedClasses.add(StaticAnalysisUtilities.getFullClassName(klass.getName()));
			}
		}
		return new ArrayList<>(analyzedClasses);
	}

	private void generateClassPath() {
		if (jarDependencies == null) {
			classPath = new ArrayList<String>();
			classPath.add(appJar);
		} else {
			classPath = jarDependencies.getRequiredJars(false);
			classPath.add(appJar);
		}
	}

	public Set<IMethod> getAnalyzedMethods() {
		return analyzedMethods;
	}

	public List<String> getClassPath() {
		return classPath;
	}

	public Set<IMethod> makePackageAnalysis(List<String> monitoringScope) {
		ClassLoaderReference clr = this.scope.getApplicationLoader();

		for (IClass klass : this.cha) {
			if (klass.getClassLoader().getReference().equals(clr)
					&& StaticAnalysisUtilities.isClassInScope(klass, monitoringScope)) {
				for (IMethod m : klass.getAllMethods()) {
					if (StaticAnalysisUtilities.isClassInScope(m.getDeclaringClass(), monitoringScope)) {
						analyzedMethods.add(m);
					}
				}
			}
		}
		return analyzedMethods;
	}

	/**
	 * Setup the WALA Static Analysis process (sets scope and cha)
	 * 
	 */
	public void prepareStaticAnalysis() {
		File exclusionFile;
		try {
			exclusionFile = (new FileProvider()).getFile(EXCLUSIONS);
			this.scope = AnalysisScopeReader.makeJavaBinaryAnalysisScope(this.appJar,
					exclusionFile != null ? exclusionFile : new File(EXCLUSIONS));

			this.cha = ClassHierarchyFactory.make(this.scope);

		} catch (IOException | ClassHierarchyException e) {
			logger.error(e);
		}
	}

	public void createCallGraph() {
		try {
			this.entryPointsInterface = discoverClassesInPackage(Arrays.asList("org.argouml.uml"));

			cga = new CallGraphAnalysis(this.cha, this.scope, entryPointsInterface);

			cga.buildCallGraph();

		} catch (ClassHierarchyException | IOException e) {
			logger.error(e);
		}
	}

	public void produceLICSRules() {
		licsRulesGenerator.produceLICSRules(cha, scope);
	}

	public CallGraphAnalysis getCallGraphAnalysis() {
		return cga;
	}

}
