package codegeneration;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Collection;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.log4j.Logger;

import jbse.apps.fragmented.PathConditionFormatterCompiling;
import jbse.apps.fragmented.SymbolInformation;
import jbse.mem.fragmented.PathConditionFragmented;
import pathconditions.MetadataMethod;

public class AtLeastOneConditionFactory {

	final static Logger logger = Logger.getLogger(AtLeastOneConditionFactory.class);

	private static final int MAX_SIZE = 600;

	private Collection<MetadataMethod> symbolicExecutionResults;
	private PathConditionFormatterCompiling formatter = new PathConditionFormatterCompiling();

	public AtLeastOneConditionFactory(Collection<MetadataMethod> results) {
		this.symbolicExecutionResults = results;
	}

	public void writeJavaClass() {
		PrintWriter writer;
		String varIndent = "\t\t\t\t\t\t";
		try {
			writer = new PrintWriter(
					"../conditions/src/main/java/runtime/evaluators/AtLeastOneConditionEvaluator.java",
					"UTF-8");

			// manual import
			writer.println("package runtime.evaluators;");
			writer.println("");
			writer.println("import java.util.concurrent.ConcurrentHashMap;");
			writer.println("import java.util.HashMap;");
			writer.println("import java.util.HashSet;");
			writer.println("import java.lang.ref.WeakReference;");
			writer.println("import java.util.List;");
			writer.println("import java.util.Set;");
			writer.println("");
			writer.println("import fieldhelper.FieldHelper;");
			writer.println("import fieldhelper.StaticFieldHelper;");
			writer.println("import runtime.evaluators.autogenerated.*;");
			writer.println("");

			writer.println("public class AtLeastOneConditionEvaluator implements ConditionEvaluator{");

			writer.println("");
			writer.println("	protected FieldHelper fh = new FieldHelper();");
			writer.println("	protected StaticFieldHelper sfh = new StaticFieldHelper();");
			writer.println("");
			writer.println(
					"	protected static HashMap<String, Character> values = new HashMap<String, Character>();");
			writer.println("	protected static ConcurrentHashMap<String,List<WeakReference<Object>>> map;");
			writer.println("");
			writer.println(
					"	protected HashMap<String, Set<WeakReference<Object>>> queuedObjects = new HashMap<>();");
			writer.println("");
			writer.println("");

			int initValues = MAX_SIZE;
			int counter = 1;

			for (MetadataMethod mdm : symbolicExecutionResults) {

				Collection<PathConditionFragmented> pathConditions = mdm.getPathConditions();
				if (pathConditions.isEmpty())
					continue;
				else
					for (PathConditionFragmented pcf : pathConditions) {
						if (initValues == MAX_SIZE)
							writer.println("    	private void initValues" + counter + "() {");

						writer.println("			values.put(\"" + pcf.getMethod().replaceAll("\\<|\\>", "")
								+ mdm.getClassName() + "_" + mdm.hashCode() + "_" + pcf.getCount() + "\",'U');");
						initValues--;

						if (initValues == 0) {
							writer.println("    	}");
							initValues = MAX_SIZE;
							counter++;
						}
					}
			}
			if (initValues > 0)
				writer.println("    	}");

			writer.println("");
			writer.println("	protected void addQueuedObject(String clsName, WeakReference<Object> object) {");
			writer.println("		Set<WeakReference<Object>> objectsSet = queuedObjects.get(clsName);");
			writer.println("		if (objectsSet == null) {");
			writer.println("			objectsSet = new HashSet<>();");
			writer.println("			objectsSet.add(object);");
			writer.println("			queuedObjects.put(clsName, objectsSet);");
			writer.println("		} else if (!objectsSet.contains(object)) {");
			writer.println("			objectsSet.add(object);");
			writer.println("		}");
			writer.println("	}");
			writer.println("");
			writer.println("	@Override");
			writer.println("	public void clearQueue() {");
			writer.println("		queuedObjects.clear();");
			writer.println("	}");
			writer.println("");
			writer.println("	@Override");
			writer.println("	public HashMap<String, Set<WeakReference<Object>>> getQueuedObjects() {");
			writer.println("		return queuedObjects;");
			writer.println("	}");
			writer.println("");
			writer.println("	@Override");
			writer.println("	public int sizeQueuedObjects() {");
			writer.println("		return queuedObjects.size();");
			writer.println("	}");
			writer.println("");
			writer.println("	@Override");
			writer.println(
					"	public HashMap<String, Character> monitorValues(ConcurrentHashMap<String,List<WeakReference<Object>>> map) {");
			writer.println("");
			writer.println("		AtLeastOneConditionEvaluator.map = map;");
			while (counter > 0) {
				writer.println("		initValues" + counter + "();");
				counter--;
			}

			writer.println("		try { ");

			for (MetadataMethod mdm : symbolicExecutionResults) {
				Collection<PathConditionFragmented> pathConditions = mdm.getPathConditions();
				if (pathConditions.isEmpty())
					continue;
				writer.println("				" + mdm.getName().replaceAll("\\<|\\>", "") + mdm.getClassName() + "_"
						+ mdm.hashCode() + "();");

				writeAdditionalClasses(mdm, pathConditions);
			}

			writer.println("		} catch (NumberFormatException e) {");
			writer.println("			e.printStackTrace();");
			writer.println("		} catch (ClassNotFoundException e) {");
			writer.println("			e.printStackTrace();");
			writer.println("		}");

			writer.println("		return values;");
			writer.println("	}");
			writer.println("	");

			for (MetadataMethod mdm : symbolicExecutionResults) {
				Collection<PathConditionFragmented> pathConditions = mdm.getPathConditions();
				if (pathConditions.isEmpty())
					continue;

				writer.println("	private void " + mdm.getName().replaceAll("\\<|\\>", "") + mdm.getClassName() + "_"
						+ mdm.hashCode() + "() throws ClassNotFoundException, NumberFormatException {");

				writer.println("		" + mdm.getClassName() + "_" + mdm.hashCode() + " m = new " + mdm.getClassName()
						+ "_" + mdm.hashCode() + "(\"" + mdm.getClassFullyQualifiedName() + "\");");
				writer.println("		m.monitor();");

				writer.println("	}");

			}
			writer.println("");
			writer.println("	protected String expression(String path, String type) {");
			writer.println("		if (containsHashCode(path))");
			writer.println("			path = path.replace(\"hashCode()\", \"hashCode\"); ");
			writer.println("		if (path.startsWith(\"[\")){");
			writer.println("			return sfh.expression(path, type);");
			writer.println("		} else {");
			writer.println("			return fh.expression(path, type);");
			writer.println("		}");
			writer.println("	}");
			writer.println("	");
			writer.println("	protected boolean containsHashCode(String path) {");
			writer.println("		if (path.contains(\"hashCode()\")) ");
			writer.println("			return true;");
			writer.println("		return false;");
			writer.println("	}");
			writer.println("");
			writer.println("	protected char parseChar(String s) {");
			writer.println("		return s.charAt(0);");
			writer.println("	}");
			writer.println("	");
			writer.println("	protected Integer parseBoolean(String s) {");
			writer.println("		return s.equals(\"true\") ? 1 : 0;");
			writer.println("	}");
			writer.println("");
			writer.println("}");
			writer.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException ue) {
			ue.printStackTrace();
		}
	}

	private void writeAdditionalClasses(MetadataMethod mdm, Collection<PathConditionFragmented> pathConditions) {

		PrintWriter writer;
		String varIndent = "\t\t\t\t\t\t";
		try {
			writer = new PrintWriter("../conditions/src/main/java/runtime/evaluators/autogenerated/"
					+ mdm.getClassName() + "_" + mdm.hashCode() + ".java", "UTF-8");
			writer.println("package runtime.evaluators.autogenerated;");
			writer.println("");
			writer.println("import java.lang.ref.WeakReference;");
			writer.println("import java.util.List;");
			writer.println("import java.util.Iterator;");
			writer.println("");
			writer.println("import runtime.evaluators.AtLeastOneConditionEvaluator;");

			writer.println("public class " + mdm.getClassName() + "_" + mdm.hashCode()
					+ " extends AtLeastOneConditionEvaluator {");
			writer.println("	private Object currentObject;");
			writer.println("	private String clsName;");
			writer.println("");
			writer.println("	public " + mdm.getClassName() + "_" + mdm.hashCode() + "(String clsName) {");
			writer.println("		this.clsName = clsName;");
			writer.println("	}");
			writer.println("");
			writer.println("	public void monitor() throws ClassNotFoundException, NumberFormatException {");
			writer.println("");
			writer.println("		currentObject = null;");
			writer.println("		//currentObject =	 Class.forName(clsName).cast(currentObject); ");
			writer.println(
					"		currentObject = Class.forName(clsName, false,Thread.currentThread().getContextClassLoader()).cast(currentObject); ");
			writer.println(" 		if ( map.containsKey(clsName)) {");
			writer.println(" 			List<WeakReference<Object>> objectsList =	 map.get(clsName);");
			writer.println(
					" 			for (Iterator<WeakReference<Object>> it = objectsList.iterator();it.hasNext();) {");
			writer.println(" 				WeakReference<Object> object = it.next();");
			writer.println(" 				if (object.isEnqueued())");
			writer.println(" 					addQueuedObject(clsName, object);");
			writer.println(" 				else {");
			writer.println(" 					currentObject = object.get();");
			writer.println(" 					sfh.setCurrentStaticObject(currentObject);");
			writer.println(" 					fh.setCurrentObject(currentObject);");
			writer.println("");

			for (Entry<String, SymbolInformation> entry : mdm.getSymbols().entrySet()) {
				SymbolInformation value = entry.getValue();

				String stringVariableLine = varIndent + "String " + "s" + value.getId() + " = " + "expression(\""
						+ value.getName() + "\",\"" + value.getType() + "\");";
				String variableLine = varIndent + value.getTypeAsObject() + " " + value.getId() + " = " + "!s"
						+ value.getId() + ".isEmpty() ? " + value.getTypeParse() + "(s" + value.getId() + ") : null;";

				writer.println(stringVariableLine);
				writer.println(variableLine);
			}

			writer.println("");

			for (PathConditionFragmented pcf : pathConditions) {
				emitPathCondition(pcf, mdm.getSymbols());
				String symbols = emitSymbols(mdm.getSymbols());
				writer.println(varIndent + pcf.getMethod().replaceAll("\\<|\\>", "") + mdm.getClassName() + "_"
						+ mdm.hashCode() + "_" + pcf.getCount() + "(" + symbols + ");");
			}

			writer.println("				} ");
			writer.println("			}");
			writer.println("		}");
			writer.println("	}");

			for (PathConditionFragmented pcf : pathConditions) {
				String formattedPathCondition = emitPathCondition(pcf, mdm.getSymbols());
				String symbolsWithtype = emitSymbolsWithType(mdm.getSymbols());
				String checkForNulls = emitCheckForNulls();
				varIndent = "\t\t";

				writer.println("");
				writer.println(" private void " + pcf.getMethod().replaceAll("\\<|\\>", "") + mdm.getClassName() + "_"
						+ mdm.hashCode() + "_" + pcf.getCount() + "(" + symbolsWithtype + ") {");
				writer.println("");
				writer.println(varIndent + "String pathCondition = \"" + pcf.getMethod().replaceAll("\\<|\\>", "")
						+ mdm.getClassName() + "_" + mdm.hashCode() + "_" + pcf.getCount() + "\";");
				writer.println(varIndent + "if(" + checkForNulls + "){");
				writer.println(varIndent + " Character val = values.get(pathCondition);");
				writer.println(varIndent + " if (val.equals('U'))");
				writer.println(varIndent + " values.put(pathCondition, 'U');");
				writer.println(varIndent + " else if (val.equals('T'))");
				writer.println(varIndent + " values.put(pathCondition, 'T');");
				writer.println(varIndent + " else if (val.equals('F'))");
				writer.println(varIndent + " values.put(pathCondition, 'F');");
				writer.println(varIndent + "} else if (" + formattedPathCondition + "){");
				writer.println(varIndent + " values.put(pathCondition, 'T');");
				writer.println(varIndent + "} else {");
				writer.println(varIndent + " Character val = values.get(pathCondition);");
				writer.println(varIndent + " if (val.equals('F') || val.equals('U'))");
				writer.println(varIndent + " values.put(pathCondition, 'F');");
				writer.println(varIndent + " else");
				writer.println(varIndent + " values.put(pathCondition, 'T');");
				writer.println(varIndent + "}");
				writer.println(" }");
				writer.println("");
			}

			writer.println("}");

			writer.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException ue) {
			ue.printStackTrace();
		}

	}

	private String emitSymbolsWithType(Map<String, SymbolInformation> symbols) {
		this.formatter.cleanup();
		this.formatter.formatSymbolsWithType(symbols);
		return this.formatter.emit();
	}

	private String emitSymbols(Map<String, SymbolInformation> symbols) {
		this.formatter.cleanup();
		this.formatter.formatSymbols(symbols);
		return this.formatter.emit();
	}

	private String emitCheckForNulls() {
		this.formatter.cleanup();
		this.formatter.formatCheckForNullSymbols();
		return this.formatter.emit();
	}

	private String emitPathCondition(PathConditionFragmented pcf, Map<String, SymbolInformation> symbols) {
		this.formatter.cleanup();
		this.formatter.formatPathConditionFragmented(pcf, symbols);
		return this.formatter.emit();
	}

}
