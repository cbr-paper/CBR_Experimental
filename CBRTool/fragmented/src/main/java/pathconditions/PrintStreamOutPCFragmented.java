package pathconditions;

import static defs.Defs.fragmentedOutput;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.HashSet;

import jbse.apps.fragmented.PathConditionFormatter;
import jbse.mem.fragmented.PathConditionFragmented;
import utils.PrintStreamOut;
import utils.StaticAnalysisUtilities;

public class PrintStreamOutPCFragmented extends PrintStreamOut {

	private PathConditionFormatter pathConditionFormatter;
	private String outFragmented = null;

	/** Message: total traces. */
	private static final String MSG_END_TRACES_TOT = "Analyzed path conditions: ";

	/** Message: total path conditions for fragmented monitoring. */
	private static final String MSG_END_PC_TOTAL = "Path Conditions Fragmented: ";

	/** Message: total safe traces. */
	private static final String MSG_END_TRACES_SAFE = "Safe: ";

	/** Message: total unsafe traces. */
	private static final String MSG_END_TRACES_UNSAFE = "Unsafe: ";

	public void printOutFragmentedPathConditions(MetadataMethod metaDataMethod,
			HashSet<PathConditionFragmented> pathConditionsFragmented, StatisticsFragmented statisticsFragmented) {

		// sets the input, output and error streams
		this.out = new PrintStream[2];
		this.log = new PrintStream[2];
		this.err = new PrintStream[2];

		// sets the output file
		outFragmented = StaticAnalysisUtilities.createLogFile(fragmentedOutput, metaDataMethod);

		try {
			final File f = new File(outFragmented);
			this.err[1] = new PrintStream(f);
		} catch (FileNotFoundException e) {
			err(ERROR_DUMP_FILE_OPEN);
			this.err[1] = null;
		}
		this.out[1] = this.log[1] = this.err[1];
		this.pathConditionFormatter = new PathConditionFormatter();

		int i = 1;
		for (PathConditionFragmented pcf : pathConditionsFragmented) {
			log("Path Condition " + (i++) + ":");
			emitPathCondition(pcf);
			log("----" + LINE_SEP);
		}

		log(MSG_END_TRACES_TOT + statisticsFragmented.getTotalTraces() + ", " + MSG_END_TRACES_SAFE
				+ statisticsFragmented.getTracesSafe() + ", " + MSG_END_TRACES_UNSAFE
				+ statisticsFragmented.getTracesUnsafe() + ", " + MSG_END_PC_TOTAL
				+ statisticsFragmented.getTotalPCFragmented());
	}

	private void emitPathCondition(PathConditionFragmented pcf) {
		this.pathConditionFormatter.cleanup();
		this.pathConditionFormatter.formatPathConditionFragmented(pcf);
		outNoBreak(this.pathConditionFormatter.emit());
	}

}
