package aspects;

import java.awt.event.MouseEvent;

import buffer.SystemResponseTimeBuffer;
import model.SystemResponseTimeEventForExperiment;
import reader.buffer.SystemResponseTimeBufferReader;
import writer.buffer.SystemResponseTimeBufferWriter;

public aspect ActionAspect {

	private static boolean activeLogging = false;

	private boolean firstIteration = true;

	// Buffer that contains the System Response CPU Time of the called methods
	private SystemResponseTimeBuffer buffer = new SystemResponseTimeBuffer();

	// Writer of the buffer that contains System Response CPU Time of UI actions
	private SystemResponseTimeBufferWriter bufferWriterSystemResponseCpuTime = new SystemResponseTimeBufferWriter(
			buffer);

	// Reader of the buffer that contains System Response CPU Time of the called
	// methods
	private SystemResponseTimeBufferReader systemResponseCpuTimeBufferReader = new SystemResponseTimeBufferReader(
			buffer);

	Long start = null;
	Long startClockTime = null;
	Long end = null;
	Long endClockTime = null;

	pointcut startMonitoring():
		execution(* org.argouml.util.UIUtils.loadCommonKeyMap(*));

	Object around(): startMonitoring(){
		Object obj = proceed();

		activeLogging = true;

		return obj;
	}

	/**
	 * Capture click {@code mouseEvent} from GUI.
	 * 
	 * @param mouseEvent
	 */
	pointcut action(MouseEvent mouseEvent):
			(		
					//execution(* org.argouml.uml.diagram.ui.FigEdgeModelElement.mouseReleased(*)) ||
					execution(* org.tigris.gef.base.Editor.mousePressed(*)) ||
					execution(* org.tigris.toolbar.toolbutton.ToolButton.MyMouseListener.mousePressed(*))
			) && 
			args(mouseEvent) && !within(ActionAspect);

	Object around(MouseEvent mouseEvent): action(mouseEvent){
		Object obj = null;

		if (firstIteration) {
			registerLastAction();
			firstIteration = false;
		}

		if (activeLogging) {

			start = System.nanoTime();
			startClockTime = System.currentTimeMillis();

			if (ControlledBurstRecording.cbrEnabled) {
				ControlledBurstRecording.cbrBefore(mouseEvent);
			}
			obj = proceed(mouseEvent);
		} else {
			obj = proceed(mouseEvent);
		}

		return obj;
	}

	pointcut endAddElementToWorkbench():
		execution(void org.argouml.uml.ui.TabProps.setTarget(Object)) && 
		!cflow(execution(* org.argouml.uml.diagram.ui.RadioAction.actionPerformed(*))) &&
		!cflow(execution(* org.argouml.uml.ui.ActionNewDiagram.actionPerformed(*)));

	pointcut mouseReleased():
		 execution(* org.argouml.uml.diagram.ui.ModeLabelDrag.mouseReleased(*)) ;

	pointcut ui():
		( 
			execution(* org.argouml.uml.diagram.ui.FigNodeModelElement.textEditStarted(*)) || // edit connection name
			execution(* org.argouml.uml.diagram.ui.FigEdgeModelElement.textEditStarted(*)) ||
			execution(* org.argouml.uml.ui.ActionNewDiagram.actionPerformed(*)) || // newActivityDiagramButton
			execution(* org.argouml.uml.diagram.ui.RadioAction.actionPerformed(*)) ||
			execution(* org.argouml.uml.diagram.state.ui.ButtonActionNewEvent.actionPerformed(*)) ||
			execution(* org.argouml.uml.ui.behavior.state_machines.ButtonActionNewGuard.actionPerformed(*)) ||
			execution(* org.argouml.uml.ui.behavior.common_behavior.ActionNewCallAction.*.actionPerformed(*)) || 
			execution(* org.argouml.uml.diagram.activity.ui.ActionCreatePartition.createMode(String)) // newSwimlane
		);

	Object around(): ui()  {

		Object obj = null;
		if (activeLogging && start != null && startClockTime != null) {

			obj = proceed();

			if (ControlledBurstRecording.cbrEnabled) {
				ControlledBurstRecording.cbrAfter();
			}

			Long end = System.nanoTime();
			Long endClockTime = System.currentTimeMillis();

			bufferWriterSystemResponseCpuTime.addEventToBuffer(new SystemResponseTimeEventForExperiment(
					thisJoinPoint.getSignature().toString(), end - start, startClockTime, endClockTime));

			start = null;
			startClockTime = null;

		} else {
			obj = proceed();
		}

		return obj;

	}

	Object around(): mouseReleased(){

		Object obj = proceed();

		if (activeLogging && start != null && startClockTime != null) {

			if (ControlledBurstRecording.cbrEnabled) {
				ControlledBurstRecording.cbrAfter();
			}

			Long end = System.nanoTime();
			Long endClockTime = System.currentTimeMillis();

			bufferWriterSystemResponseCpuTime.addEventToBuffer(new SystemResponseTimeEventForExperiment(
					thisJoinPoint.getSignature().toString(), end - start, startClockTime, endClockTime));
			
			start = null;
			startClockTime = null;
		}

		return obj;
	}

	Object around(): endAddElementToWorkbench(){
		Object obj = proceed();

		if (activeLogging && start != null && startClockTime != null) {

			if (ControlledBurstRecording.cbrEnabled) {
				ControlledBurstRecording.cbrAfter();
			}

			Long end = System.nanoTime();
			Long endClockTime = System.currentTimeMillis();

			bufferWriterSystemResponseCpuTime.addEventToBuffer(new SystemResponseTimeEventForExperiment(
					thisJoinPoint.getSignature().toString(), end - start, startClockTime, endClockTime));
			
			start = null;
			startClockTime = null;
		}

		return obj;
	}

	private void registerLastAction() {
		Runtime.getRuntime().addShutdownHook(new Thread() {
			public void run() {
				// Read from the buffer of System Response CPU Time and write to the file
				systemResponseCpuTimeBufferReader.readFromBuffer();
			}
		});
	}

	public static boolean activeLogging() {
		return activeLogging;
	}

}
