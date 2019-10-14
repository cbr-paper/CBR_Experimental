package pathconditions;

import static defs.Defs.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;

import java.util.Arrays;
import java.util.HashSet;

import jbse.apps.run.RunParameters;
import jbse.apps.run.RunParameters.DecisionProcedureType;
import jbse.apps.run.RunParameters.InteractionMode;
import jbse.apps.run.RunParameters.StepShowMode;
import jbse.apps.run.fragmented.RunFragmented;
import jbse.apps.settings.ParseException;
import jbse.apps.settings.SettingsReader;
import jbse.mem.fragmented.PathConditionFragmented;
import utils.StaticAnalysisUtilities;

public final class SymbolicExecutionAnalysis {

	final static Logger logger = Logger.getLogger(SymbolicExecutionAnalysis.class);

	/** JBSE Run object modified for Fragmented Monitoring */
	private RunFragmented runFragmented;

	/**
	 * Object containing information about the method to be symbolically executed
	 */
	private MetadataMethod metaDataMethod;

	/** List containing all the libraries to be analyzed */
	private List<String> applicationClassPath;

	private StatisticsFragmented statisticsFragmented;

	private PathConditionFilter pathConditionFilter;

	public SymbolicExecutionAnalysis(List<String> applicationClassPath, MetadataMethod metaDataMethod) {
		this.metaDataMethod = metaDataMethod;
		this.applicationClassPath = applicationClassPath;
	}

	/**
	 * Filter path conditions, simplify them and set MetaDataMethod
	 */
	public void filterPathConditions() {
		logger.debug("Starting filtering for method: " + metaDataMethod.getName());
		
		pathConditionFilter = new PathConditionFilter(runFragmented.getFinalStates(), metaDataMethod.getName(), metaDataMethod.hashCode());
		pathConditionFilter.filterClausesFromPathCondition();
		pathConditionFilter.simplifyPathConditions();
		metaDataMethod.setPathConditions(getPathConditionsFragmented());

		/* set the symbols used by SE variables */
		metaDataMethod.setSymbols();
	}

	public HashSet<PathConditionFragmented> getPathConditionsFragmented() {
		return pathConditionFilter.getPathConditionsFragmented();
	}

	public void printOutPathCondition() {
		logger.debug("Printing out path conditions...");
		
		if (getPathConditionsFragmented().size() == 0) {
			logger.debug("No Fragmented Path Conditions for method: " + metaDataMethod.getName());
		}
		setupStatistics();

		PrintStreamOutPCFragmented printStreamOut = new PrintStreamOutPCFragmented();
		printStreamOut.printOutFragmentedPathConditions(metaDataMethod, getPathConditionsFragmented(),
				statisticsFragmented);
	}

	/**
	 * Executes symbolically a method
	 * 
	 * @param filter
	 *            Clauses will be filtered if true
	 */
	public void runSymbolicExecution() {
		logger.debug("Running Symbolic Execution for method: " + metaDataMethod.getName());

		final RunParameters p = new RunParameters();

		// set parameters
		set(p, metaDataMethod);

		// run the symbolic execution process
		runFragmented = new RunFragmented(p);
		runFragmented.run();
	}

	/**
	 * Settings of the symbolic execution analysis
	 * 
	 * @param p
	 * @param method
	 * @param outFile
	 */
	private void set(RunParameters p, MetadataMethod method) {
		logger.debug("Setting parameters to the Symbolic Execution for the method: " + method.getName()
				+ " with parameters: " + method.getDescriptor());

		try {
			new SettingsReader(fragmentedHome + "src/main/resources/lics_rules.jbse").fillRunParameters(p);
		} catch (FileNotFoundException e) {
			logger.error("Error: settings file not found.");
			System.exit(1);
		} catch (ParseException e) {
			logger.error("Error: settings file syntactically ill-formed.");
			System.exit(2);
		} catch (IOException e) {
			logger.error("Error while closing settings file.");
			System.exit(2);
		}

		List<String> newClassPath = new ArrayList<String>(Arrays.asList(classPath));
		newClassPath.addAll(applicationClassPath);
		String[] classPathVarArg = new String[newClassPath.size()];
		classPathVarArg = newClassPath.toArray(classPathVarArg);

		p.addClasspath(classPathVarArg);
		p.setMethodSignature(method.getClassFullyQualifiedNameJVM(), method.getDescriptor(), method.getName());
		p.setOutputFileName(StaticAnalysisUtilities.createLogFile(jbseOutput, metaDataMethod));
		p.setShowOnConsole(false);
		p.setDecisionProcedureType(DecisionProcedureType.Z3);
		p.setExternalDecisionProcedurePath(z3Path);
		p.setDoSignAnalysis(true);
		p.setStepShowMode(StepShowMode.LEAVES);
		p.setInteractionMode(InteractionMode.ONLY_BRANCH_DECISION);
		p.setTimeout(60, TimeUnit.SECONDS);
		p.setDepthScope(10);
		p.setCountScope(1000);

	}

	public void setupStatistics() {
		statisticsFragmented = new StatisticsFragmented(runFragmented);
		statisticsFragmented.setTotalPCFragmented(getPathConditionsFragmented().size());
		statisticsFragmented.setTotalTraces(pathConditionFilter.getPathConditionCounter());
	}

}