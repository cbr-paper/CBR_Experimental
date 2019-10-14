package launchers;

import static defs.Defs.serializedObjects;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import codegeneration.AtLeastOneConditionFactory;
import pathconditions.MetadataMethod;

/**
 * Regenerate Evaluator from Symbolic Execution results
 *
 */
public class RegenerateEvaluatorsFromSE {
	final static Logger logger = Logger.getLogger(SecondPhaseLauncher.class);

	private List<MetadataMethod> results = new ArrayList<MetadataMethod>();
	
	public RegenerateEvaluatorsFromSE() {
		logger.debug("Starting RegenerateEvaluatorsFromSE...");
		retrieveSymbolicExecutionResults();
		compilateConditions();
	}
	
	public static void main(String[] args) {
		new RegenerateEvaluatorsFromSE();
	}
	
	private void retrieveSymbolicExecutionResults() {
		logger.debug("Retrieving symbolic execution results...");
		File folder = new File(serializedObjects);
		File[] listOfFiles = folder.listFiles();

		for (int i = 0; i < listOfFiles.length; i++) {
			if (listOfFiles[i].isFile()) {
				FileInputStream fis;
				ObjectInputStream in;
				MetadataMethod mdm;
				try {
					fis = new FileInputStream(listOfFiles[i]);
					in = new ObjectInputStream(fis);
					mdm = (MetadataMethod) in.readObject();
					results.add(mdm);
					in.close();
				} catch (IOException | ClassNotFoundException e) {
					e.printStackTrace();
				}
			}
		}
		logger.debug("Results size: " + results.size());
	}
	
	public void compilateConditions() {
		logger.debug("Compile filtered conditions...");
		AtLeastOneConditionFactory atLeastCondition = new AtLeastOneConditionFactory(results);
		atLeastCondition.writeJavaClass();
	}
}
