package filter;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.log4j.Logger;

import utils.StaticAnalysisUtilities;

import static defs.Defs.*;

public class ConditionFilter {

	private String[] expressions;

	private String[][] results;

	private String[] previousExpressions;

	final static Logger logger = Logger.getLogger(ConditionFilter.class);

	public ConditionFilter(boolean checker) {
		this.expressions = getLogExpressions();
		this.results = getLogFile();

		if (!checker) {
			this.results = pruneRows(results);
			this.results = pruneColumns(results);
			this.results = pruneRows(results);
		} else {
			this.previousExpressions = getLogPreviousExpressions();
			this.results = filterExpressionsFromPreviousResults();
			this.results = pruneRows(results);
		}
	}

	/**
	 * Print out the filtered expressions in a log file
	 * 
	 * @param filename
	 * @param m
	 *            the expressions to be printed out
	 */
	public void printExpressions(String filename, String[] m) {
		BufferedWriter outputWriter = null;
		try {
			outputWriter = new BufferedWriter(new FileWriter(logs + filename));
			for (int i = 0; i < m.length; i++) {
				outputWriter.write(m[i] + "\n");
			}
			outputWriter.flush();
			outputWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Print out the filtered results in a log file
	 * 
	 * @param filename
	 * @param m
	 *            the matrix to be printed out
	 */
	public void printResults(String filename, String[][] m) {
		BufferedWriter outputWriter = null;
		try {
			outputWriter = new BufferedWriter(new FileWriter(logs + filename));
			for (int i = 0; i < m.length; i++) {
				outputWriter.write(String.join(";", m[i]) + "\n");
			}
			outputWriter.flush();
			outputWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	/**
	 * Checks if {@code matrix} contains a vector {@code values}
	 * 
	 * @param matrix
	 * @param values
	 * @return
	 */
	private boolean containsArray(List<String[]> matrix, String[] values) {
		for (String[] rowMatrix : matrix)
			if (Arrays.equals(rowMatrix, values))
				return true;
		return false;
	}

	private String[][] convertArrayListOfStringArrayTo2DArray(List<String[]> m) {
		String[][] newMatrix = new String[m.size()][m.get(0).length];
		newMatrix = m.toArray(new String[0][0]);
		return newMatrix;
	}

	private String[] pruneExpression(int index) {
		logger.debug("effectively pruning column: " + index);
		String[] newExpressions = new String[expressions.length - 1];
		int i, j;
		i = j = 0;
		while (j < expressions.length) {
			if (j == index)
				j++;
			else {
				newExpressions[i++] = expressions[j++];
			}
		}
		return newExpressions;
	}

	/**
	 * Filter expressions from the expressions.log file
	 * 
	 * @param indexes
	 */
	private void filterExpressions(List<Integer> indexes) {
		String[] newExpressions = new String[indexes.size()];

		for (int i = 0; i < indexes.size(); i++) {
			newExpressions[i] = expressions[indexes.get(i)];
		}
		expressions = newExpressions;
	}

	public String[] getExpressions() {
		return expressions;
	}

	/**
	 * Get the expressions of expressions.log
	 * 
	 * @return
	 */
	private String[] getLogExpressions() {
		File file = new File(logs + StaticAnalysisUtilities.getLastAvailableDirectoryOnPath(logs) + "/expressions.log");

		ArrayList<String> expressions = new ArrayList<String>();

		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
			String line;
			while ((line = br.readLine()) != null) {
				String[] values = line.split(";");
				for (String value : values)
					expressions.add(value);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return expressions.toArray(new String[0]);
	}

	private String[][] getLogFile() {

		File file = new File(logs + StaticAnalysisUtilities.getLastAvailableDirectoryOnPath(logs) + "/results.log");

		// fill the matrix with the values saved in results.log
		ArrayList<ArrayList<String>> matrix = new ArrayList<ArrayList<String>>();

		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
			String line;
			while ((line = br.readLine()) != null) {
				String[] values = line.split(";");
				ArrayList<String> newRow = new ArrayList<String>();
				for (String value : values) {
					newRow.add(value);
				}
				matrix.add(newRow);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		// return square array
		return matrix.stream().map(u -> u.toArray(new String[0])).toArray(String[][]::new);
	}

	public String[][] getResults() {
		return results;
	}

	public String[][] heuristicPruning() {
		logger.debug("heuristicPruning...");
		String[][] results = this.results;

		int j = 0;
		while (j < results[0].length) {
			logger.debug("Results size: " + results[0].length + " pruning column j: " + j);
			String[][] tempResults = pruneColumn(results, j);
			tempResults = pruneRows(tempResults);
			// if it remains the same, it should be removed
			if (tempResults.length == results.length) {
				results = tempResults;
				expressions = pruneExpression(j);
			} else {
				j++;
			}
		}
		return results;
	}

	/**
	 * Prune the column indicated by {@code index}
	 * 
	 * @param index
	 * @return A two-dimensional matrix with one less column
	 */
	private String[][] pruneColumn(String[][] m, int index) {

		String[][] tMatrix = transposeMatrix(m);
		List<String[]> newMatrix = new ArrayList<String[]>();

		for (int i = 0; i < tMatrix.length; i++) {
			if (i != index)
				newMatrix.add(tMatrix[i]);
		}

		String[][] filteredMatrix = convertArrayListOfStringArrayTo2DArray(newMatrix);

		return transposeMatrix(filteredMatrix);
	}

	/**
	 * Prune the columns with the same values
	 * 
	 * @param m
	 * @return
	 */
	private String[][] pruneColumns(String[][] m) {
		logger.debug("pruneColumns...");
		String[][] transposedMatrix = transposeMatrix(m);
		List<String[]> newMatrix = new ArrayList<String[]>();
		List<Integer> indexes = new ArrayList<>();

		for (int i = 0; i < transposedMatrix.length; i++) {
			boolean elementsAreEqual = true;
			String first = transposedMatrix[i][0];
			for (int j = 1; j < transposedMatrix[0].length && elementsAreEqual; j++) {
				if (!transposedMatrix[i][j].equals(first))
					elementsAreEqual = false;
			}
			if (!elementsAreEqual) {
				newMatrix.add(transposedMatrix[i]);
				indexes.add(i);
			}
		}
		// also filter the expressions
		filterExpressions(indexes);

		String[][] filteredMatrix = convertArrayListOfStringArrayTo2DArray(newMatrix);

		return transposeMatrix(filteredMatrix);
	}

	/**
	 * Remove the rows with the same values
	 * 
	 * @param m
	 * @return
	 */
	private String[][] pruneRows(String[][] m) {
		logger.debug("pruneRows...");
		List<String[]> newMatrix = new ArrayList<String[]>();

		for (int i = 0; i < m.length; i++) {
			if (!containsArray(newMatrix, m[i])) {
				newMatrix.add(m[i]);
			}
		}
		String[][] filteredMatrix = convertArrayListOfStringArrayTo2DArray(newMatrix);

		return filteredMatrix;
	}

	/**
	 * Transpose a matrix
	 * 
	 * @param m
	 * @return
	 */
	private String[][] transposeMatrix(String[][] m) {
		String[][] temp = new String[m[0].length][m.length];
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m[0].length; j++) {
				temp[j][i] = m[i][j];
			}
		}
		return temp;
	}

	private String[] getLogPreviousExpressions() {
		File file = new File(
				logs + StaticAnalysisUtilities.getLastAvailableDirectoryOnPath(logs) + "/h_expressions.log");

		ArrayList<String> expressions = new ArrayList<String>();

		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
			String line;
			while ((line = br.readLine()) != null) {
				String[] values = line.split(";");
				for (String value : values)
					expressions.add(value);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return expressions.toArray(new String[0]);
	}

	private String[][] filterExpressionsFromPreviousResults() {
		String[][] results = this.results;
		List<String> listOfPreviousResults = Arrays.asList(this.previousExpressions);

		int j = 0;
		while (expressions.length != listOfPreviousResults.size()) {
			if (!listOfPreviousResults.contains(expressions[j])) {
				results = pruneColumn(results, j);
				expressions = pruneExpression(j);
				j = 0;
			} else
				j++;
		}

		return results;

	}

}
