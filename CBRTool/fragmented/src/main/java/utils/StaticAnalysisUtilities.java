package utils;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

import org.apache.log4j.Logger;

import com.ibm.wala.classLoader.IClass;
import com.ibm.wala.classLoader.IMethod;
import com.ibm.wala.ipa.callgraph.AnalysisScope;
import com.ibm.wala.ipa.callgraph.CGNode;
import com.ibm.wala.ipa.callgraph.CallGraph;
import com.ibm.wala.ipa.callgraph.Entrypoint;
import com.ibm.wala.ipa.callgraph.impl.DefaultEntrypoint;
import com.ibm.wala.ipa.cha.IClassHierarchy;
import com.ibm.wala.types.ClassLoaderReference;
import com.ibm.wala.types.TypeName;
import com.ibm.wala.util.collections.HashSetFactory;

import pathconditions.MetadataMethod;

public class StaticAnalysisUtilities {

	final static Logger logger = Logger.getLogger(StaticAnalysisUtilities.class);

	private static boolean belongsToScope(String className, List<String> scope) {
		boolean belongs = false;

		for (String pkg : scope) {
			if (className.startsWith(pkg)) {
				belongs = true;
			}
		}
		return belongs;
	}

	/**
	 * Makes the bfs search on the CallGraph
	 * 
	 * @param cg
	 * @param root
	 * @param steps
	 * @param scope
	 * @param forward
	 * @return
	 */
	public static Set<CGNode> bfs(CallGraph cg, CGNode root, int steps, List<String> scope, boolean forward) {
		Set<CGNode> S = new LinkedHashSet<CGNode>();
		Queue<CGNode> Q = new LinkedList<CGNode>();

		S.add(root);
		Q.add(root);
		int i = steps;

		do {
			CGNode current = Q.remove();
			Iterator<CGNode> it = null;
			if (forward)
				it = cg.getSuccNodes(current);
			else
				it = cg.getPredNodes(current);

			while (it.hasNext() && i > 0) {
				CGNode n = it.next();
				if (!S.contains(n) && belongsToScope(getFullClassName(n.getMethod()), scope)) {
					S.add(n);
					Q.add(n);
				}
			}
			i--;
		} while (!Q.isEmpty());

		return S;
	}
	
	//TODO: add scope
	public static boolean isCGNodeReachable(CallGraph cg, CGNode root, CGNode destination) {

		Set<CGNode> S = new LinkedHashSet<CGNode>();
		Queue<CGNode> Q = new LinkedList<CGNode>();

		S.add(root);
		Q.add(root);

		do {
			CGNode current = Q.remove();
			Iterator<CGNode> it = cg.getSuccNodes(current);

			while (it.hasNext()) {
				CGNode n = it.next();

				if (n.equals(destination)) {
					return true;
				}

				if (!S.contains(n)) {
//					logger.debug("Visited: " + n.getMethod().getName());
					S.add(n);
					Q.add(n);
				}
			}
		} while (!Q.isEmpty());

		return false;
	}

	public static boolean containsMethodName(List<String> list, String methodName) {
		for (String method : list)
			if (method.contains(methodName.replaceAll("\\<|\\>", "")))
				return true;
		return false;

	}

	public static void createDirectory(String path) {
		File dir = new File(path);

		if (!dir.exists()) {
			dir.mkdirs();
		}
	}

	public static String createLogFile(String base, MetadataMethod metaDataMethod) {
		File dir = new File(base + metaDataMethod.getClassFullyQualifiedNameJVM());

		if (!dir.exists()) {
			dir.mkdirs();
		}
		return base + metaDataMethod.getClassFullyQualifiedNameJVM() + "/" + metaDataMethod.getName() + "_"
				+ metaDataMethod.getNumberOfParameters() + ".log";
	}

	public static void delete(File f) {
		if (f.isDirectory()) {
			for (File c : f.listFiles())
				delete(c);
		}
		if (!f.delete())
			logger.info("File does not exist");
	}

	public static String getFullClassName(IMethod method) {

		TypeName tn = method.getDeclaringClass().getName();
		return (tn.getPackage() != null ? tn.getPackage().toString().replaceAll("/", "\\.") + "." : "")
				+ tn.getClassName().toString();
	}

	public static String getFullClassName(TypeName tn) {
		return (tn.getPackage() != null ? tn.getPackage().toString().replaceAll("/", "\\.") + "." : "")
				+ tn.getClassName().toString();
	}

	public static String getFullClassNameJVM(TypeName tn) {
		return (tn.getPackage() != null ? tn.getPackage().toString() + "/" : "") + tn.getClassName().toString();
	}

	public static String getFullClassNameJVM(IMethod method) {

		TypeName tn = method.getDeclaringClass().getName();
		return (tn.getPackage() != null ? tn.getPackage().toString() + "/" : "") + tn.getClassName().toString();
	}

	/**
	 * Make public methods of an interface as entrypoints of the CallGraph
	 * 
	 * @param scope
	 * @param cha
	 * @param entryPoints
	 * @return
	 */
	public static Iterable<Entrypoint> makePublicEntrypoints(AnalysisScope scope, IClassHierarchy cha,
			Collection<?> entryPoints) {

		// ClassLoaderReference: defines the meta-information that identifies a
		// class loader. This is effectively a "name" for a class loader.
		ClassLoaderReference clr = scope.getApplicationLoader();

		final HashSet<Entrypoint> result = HashSetFactory.make();
		for (IClass klass : cha) {
			if (klass.getClassLoader().getReference().equals(clr)) {

				Collection<IMethod> allMethods = klass.getDeclaredMethods();
				// IMethod an interface for an object that represent a single
				// java method
				for (IMethod m : allMethods) {
					if (!m.isPublic()) {
						continue;
					}
					TypeName tn = m.getDeclaringClass().getName();
					String fullClassName = (tn.getPackage() != null
							? tn.getPackage().toString().replaceAll("/", "\\.") + "."
							: "") + tn.getClassName().toString();

					if (!entryPoints.contains(fullClassName)) {
						continue;
					}

					result.add(new DefaultEntrypoint(m, cha));
				}
			}
		}
		return result;
	}

	public static void printJars(Map<String, String> requiredBundlesJar) {
		for (Map.Entry<String, String> entry : requiredBundlesJar.entrySet())
			logger.debug("Required-Bundle: " + entry.getValue());
	}

	public static void printMethods(Collection<IMethod> methods) {
		for (IMethod temp : methods) {
			logger.debug(temp.getName().toString() + " " + temp.getDescriptor().toString() + " "
					+ StaticAnalysisUtilities.getFullClassNameJVM(temp));
		}
		logger.debug(methods.size() + " methods discovered");
	}

	/**
	 * Get last available directory on path
	 * 
	 * @param path
	 * @return
	 */
	public static String getLastAvailableDirectoryOnPath(String path) {
		File file = new File(path);
		String[] directories = file.list(new FilenameFilter() {
			@Override
			public boolean accept(File current, String name) {
				return new File(current, name).isDirectory();
			}
		});
		Arrays.sort(directories);
		return directories[directories.length - 1];
	}

	public static boolean isClassInScope(IClass klass, List<String> monitoringScope) {
		String packageClass = klass.getName().getPackage().toString().replaceAll("/", ".");

		for (String pkg : monitoringScope)
			if (packageClass.equals(pkg))
				return true;

		return false;
	}

	public static boolean isClassContainedInScope(IClass klass, List<String> monitoringScope) {
		String packageClass = klass.getName().getPackage().toString().replaceAll("/", ".");

		for (String pkg : monitoringScope)
			if (packageClass.contains(pkg))
				return true;

		return false;
	}

	public static String[] getDirectories(String path) {
		File file = new File(path);

		String[] directories = file.list(new FilenameFilter() {
			@Override
			public boolean accept(File current, String name) {
				return new File(current, name).isDirectory();
			}
		});
		return directories;
	}

	public static String getFullSignature(CGNode cgn) {
		
		return getFullClassName(cgn.getMethod().getDeclaringClass().getName()) + "." + cgn.getMethod().getName().toString();
	}
}
