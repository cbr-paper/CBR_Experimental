package pathconditions;

import static defs.Defs.fragmentedHome;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.HashSet;

import jbse.apps.fragmented.RuleFormatter;
import jbse.apps.fragmented.RuleStandardFormatter;
import utils.LICSResolver;
import utils.PrintStreamOut;

public class PrintStreamOutLICSRules extends PrintStreamOut {

	private RuleFormatter ruleFormatter;
	private RuleStandardFormatter ruleStandardFormatter;
	private String licsRules = null;

	public void printOutLICSRules(HashSet<LICSResolver> subclassesOfInterfaces) {
		// sets the input, output and error streams
		this.out = new PrintStream[2];
		this.log = new PrintStream[2];
		this.err = new PrintStream[2];

		licsRules = fragmentedHome + "src/main/resources/lics_rules.jbse";

		try {
			final File f = new File(licsRules);
			this.err[1] = new PrintStream(f);
		} catch (FileNotFoundException e) {
			err(ERROR_DUMP_FILE_OPEN);
			this.err[1] = null;
		}
		this.out[1] = this.log[1] = this.err[1];
		this.ruleFormatter = new RuleFormatter();

		log("resolve begin" + LINE_SEP);

		int i = subclassesOfInterfaces.size();

		for (LICSResolver pair : subclassesOfInterfaces) {
			if (--i > 0)
				emitRule(pair.getKlass(), pair.getSubklass(), false);
			else
				emitRule(pair.getKlass(), pair.getSubklass(), true);
		}

		log("end" + LINE_SEP);
	}

	private void emitRule(String klass, String subklass, boolean lastOne) {
		this.ruleFormatter.cleanup();
		this.ruleFormatter.formatRule(klass, subklass, lastOne);
		outNoBreak(this.ruleFormatter.emit());
	}

	private void emitStandardRule(String klass, String subklass, boolean lastOne) {
		this.ruleStandardFormatter.cleanup();
		this.ruleStandardFormatter.formatRule(klass, subklass, lastOne);
		outNoBreak(this.ruleStandardFormatter.emit());
	}

	public void printOutLICSRulesStandard(HashSet<LICSResolver> subclassesOfInterfaces) {
		// sets the input, output and error streams
		this.out = new PrintStream[2];
		this.log = new PrintStream[2];
		this.err = new PrintStream[2];

		licsRules = fragmentedHome + "src/main/resources/rules.txt";

		try {
			final File f = new File(licsRules);
			this.err[1] = new PrintStream(f);
		} catch (FileNotFoundException e) {
			err(ERROR_DUMP_FILE_OPEN);
			this.err[1] = null;
		}
		this.out[1] = this.log[1] = this.err[1];
		
		this.ruleStandardFormatter = new RuleStandardFormatter();

		int i = subclassesOfInterfaces.size();

		for (LICSResolver pair : subclassesOfInterfaces) {
			if (--i > 0)
				emitStandardRule(pair.getKlass(), pair.getSubklass(), false);
			else
				emitStandardRule(pair.getKlass(), pair.getSubklass(), true);
		}
	}

}
