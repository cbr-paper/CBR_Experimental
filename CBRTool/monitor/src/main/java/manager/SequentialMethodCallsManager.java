package manager;

import java.io.File;
import java.io.IOException;

import org.apache.log4j.Logger;

import model.SystemResponseTimeEvent;

public class SequentialMethodCallsManager extends Manager {

	final static Logger logger = Logger.getLogger(SequentialMethodCallsManager.class);

	private String logFile = "";

	private int logCounter = 0;


	public SequentialMethodCallsManager(Class<?> cls) {
		super(cls);
	}

	public void evaluateApplicationState() {
		applicationState = evaluate();
	}
	
	private static class MutableInteger {
		private int value;

		public void decrease() {
			--value;
		}

		public void increase() {
			++value;
		}

		public boolean isZero() {
			return value == 0;
		}
	}

	ThreadLocal<MutableInteger> entryPoints = new ThreadLocal<MutableInteger>() {
		@Override
		protected MutableInteger initialValue() {
			return new MutableInteger();
		}
	};

	public void enter(SystemResponseTimeEvent event) {
		logger.debug("ENTER: " + entryPoints.get().value);
		logger.debug("EVENT: " + event.getMethodSignature());

		if (entryPoints.get().isZero()) {
			try {
//	REFACTOR    logFile = dataWriter.getDir() + "/" + logCounter + ".log";
				new File(logFile).createNewFile();
				// write signature data
				evaluateApplicationState();

				logCounter++;
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		entryPoints.get().increase();
		//REFACTORruntimeDataWriter.writeMethodDetail(event, logFile);
	}

	public void exit(SystemResponseTimeEvent event) {
		entryPoints.get().decrease();

		if (entryPoints.get().isZero()) {
			// write signature data
			evaluateApplicationState();
		}

		logger.debug("EXIT: " + entryPoints.get().value);
	}

}
