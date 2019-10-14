package utils;

import java.io.PrintStream;

import jbse.apps.IO;

public abstract class PrintStreamOut {
	/** The {@link PrintStream}s for the output. */
	protected PrintStream[] out = null;

	/** The {@link PrintStream}s for log information. */
	protected PrintStream[] log = null;

	/** The {@link PrintStream}s for errors (critical log information). */
	protected PrintStream[] err = null;

	/** Error: unable to open dump file. */
	protected static final String ERROR_DUMP_FILE_OPEN = "Could not open the dump file. The session will be displayed on console only.";

	/** Constant for line separator. */
	protected static final String LINE_SEP = System.getProperty("line.separator");

	/**
	 * Gets a line of text on the input stream.
	 * 
	 * @param s the input prompt.
	 * @return the read line.
	 */
	public String in(String prompt) {
		return IO.readln(this.out, prompt);
	}

	/**
	 * Prints a line of text on the output streams.
	 * 
	 * @param s the text to be printed.
	 */
	public void out(String s) {
		IO.println(this.out, s);
	}

	/**
	 * Prints some text on the output streams.
	 * 
	 * @param s the text to be printed.
	 */
	public void outNoBreak(String s) {
		IO.print(this.out, s);
	}

	/**
	 * Prints a line of text on the log streams.
	 * 
	 * @param s the text to be printed.
	 */
	public void log(String s) {
		IO.println(this.log, s);
	}

	/**
	 * Prints a line of text on the error streams.
	 * 
	 * @param s the text to be printed.
	 */
	public void err(String s) {
		IO.println(this.err, s);
	}
}
