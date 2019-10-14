package launchers;

import static defs.Defs.EXCLUSIONS;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;

import com.ibm.wala.classLoader.IClass;
import com.ibm.wala.ipa.callgraph.AnalysisScope;
import com.ibm.wala.ipa.cha.ClassHierarchy;
import com.ibm.wala.ipa.cha.ClassHierarchyException;
import com.ibm.wala.ipa.cha.ClassHierarchyFactory;
import com.ibm.wala.types.ClassLoaderReference;
import com.ibm.wala.util.io.FileProvider;

import staticanalysis.AnalysisScopeReader;
import utils.StaticAnalysisUtilities;

public class ProduceTestingFile {

	final static Logger logger = Logger.getLogger(ProduceTestingFile.class);

	/** Path of the interface */
	private String interfaceJar;

	List<String> monitoringScope = new ArrayList<String>();

	public ProduceTestingFile(String interfaceJar, List<String> monitoringScope) {
		this.interfaceJar = interfaceJar;
		this.monitoringScope = monitoringScope;
		launch();
	}

	public static void main(String[] args) {
		new ProduceTestingFile("../argouml.jar",
				Arrays.asList("org.argouml.uml.diagram.activity", "org.argouml.uml.diagram.activity.layout",
						"org.argouml.uml.diagram.activity.ui"));

	}

	private void launch() {
		logger.debug("Starting ProduceTestingFile...");
		try {

			// collect required libraries for analysis

			File exclusionFile = (new FileProvider()).getFile(EXCLUSIONS);

			AnalysisScope scope = AnalysisScopeReader.makeJavaBinaryAnalysisScope(interfaceJar,
					exclusionFile != null ? exclusionFile : new File(EXCLUSIONS));

			ClassHierarchy cha = ClassHierarchyFactory.make(scope);

			ClassLoaderReference clr = scope.getApplicationLoader();
			PrintWriter writer = new PrintWriter("../toTest", "UTF-8");

			Iterator<IClass> iter = cha.iterator();
			while (iter.hasNext()) {
				IClass klass = iter.next();
				if (klass.getClassLoader().getReference().equals(clr)
						&& StaticAnalysisUtilities.isClassInScope(klass, monitoringScope)) {
					writer.print(StaticAnalysisUtilities.getFullClassName(klass.getName()) + ",");
				}
			}

			writer.close();

		} catch (IOException | ClassHierarchyException ex) {
			logger.error(ex.getMessage());
		}
	}

}
