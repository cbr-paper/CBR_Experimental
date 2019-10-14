package staticanalysis;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.jar.Attributes;
import java.util.jar.JarFile;
import java.util.jar.Manifest;

import org.apache.log4j.Logger;

import utils.StaticAnalysisUtilities;


public class JarDependencies {

	final static Logger logger = Logger.getLogger(JarDependencies.class);

	private String path;
	
	private boolean isPlugin;

	private Map<String, String> requiredJars = new ConcurrentHashMap<String, String>();

	public JarDependencies(String path, boolean isPlugin) {
		this.path = path;
		this.isPlugin = isPlugin;
	}

	public void collectNamesRequiredJars(String jarPath) {
		logger.debug("Collecting names of jars... " + jarPath);
		// from first jar
		collectRequiredJars(jarPath);
	}

	private void collectRequiredJars(String jarPath) {
		logger.debug("Obtaining all the required bundles for the Plugin " + jarPath);
		
		if (isPlugin)
			getRequiredJarsFromPlugin(jarPath);
		else
			getRequiredJarsFromJar(jarPath);
		
		return;
	}

	public List<String> getRequiredJars(boolean showBundles) {
		if (showBundles) {
			logger.debug("Getting list of required bundles");
			StaticAnalysisUtilities.printJars(requiredJars);
		}

		return new ArrayList<String>(requiredJars.values());
	}

	protected void getRequiredJarsFromJar(String jarPath) {
		Manifest m;
		try {
			m = new JarFile(jarPath).getManifest();

			if (m == null)
				return;

			Attributes mainAttribs = m.getMainAttributes();

			if (mainAttribs.getValue("Class-Path") == null)
				return;

			String[] jars = mainAttribs.getValue("Class-Path").split(" ");

			for (String jar : jars) {
				Path p = Paths.get(jar);
				Path parent = p.getParent();
				String parentString = parent != null ? parent.toString() + "/" : "";
		
				requiredJars.put(p.getFileName().toString(), path + parentString + p.getFileName().toString());
				logger.info(p.getFileName().toString() +" "+ path + parentString + p.getFileName().toString());

			}
		} catch (IOException e) {
			logger.error("Can't open jar path: " + jarPath);
		}

	}
	
	protected List<String> getRequiredJarsFromPlugin(String jarPath) {
		List<String> jarNames = new ArrayList<String>();
		Manifest m;
		try {
			m = new JarFile(jarPath).getManifest();
			Attributes mainAttribs = m.getMainAttributes();

			if (mainAttribs.getValue("Require-Bundle") == null)
				return jarNames;

			String[] bundles = mainAttribs.getValue("Require-Bundle").split("\",");

			for (String bundle : bundles) {

				jarNames.add(bundle.split(";")[0]);

			}
		} catch (IOException e) {
			logger.error("Can't open jar path: " + jarPath);
		}

		return jarNames;
	}

}