package util;

import java.awt.event.MouseEvent;
import java.lang.reflect.Field;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JPanel;

import org.tigris.gef.base.Editor;
import org.tigris.gef.presentation.Fig;

import buffer.SystemResponseTimeBuffer;
import model.SystemResponseTimeEvent;

import org.apache.log4j.Logger;

public final class AspectUtil {

	final static Logger logger = Logger.getLogger(AspectUtil.class);

	private AspectUtil() {}

	public static String getActionNameFromMouseEvent(MouseEvent mouseEvent) {
		String actionName = "";

		if (mouseEvent.getSource() instanceof JButton) {
			JButton clickedButton = (JButton) mouseEvent.getSource();
			actionName = "clickOnButton" + clickedButton.getIcon().toString().replaceAll(" ", "_");
		} else if (mouseEvent.getSource() instanceof JPanel) {
			try {
				Class<?> cls = Class.forName("org.tigris.gef.graph.presentation.JGraphInternalPane");
				Field field  = cls.getDeclaredField("_editor");
				field.setAccessible(true);
				Editor editor = (Editor) field.get(mouseEvent.getSource());
				
				Fig currentFig = editor.getCurrentFig();
				if (currentFig != null) {
					actionName = "clickOn" + editor.getCurrentFig().getClass().getSimpleName();
				} else {
					actionName = "clickOnPanel(" + mouseEvent.getX() + "," + mouseEvent.getY() + ")";
				}

			} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException | ClassNotFoundException e) {
				logger.error(e);
			}		
		} else {
			actionName = "clickOn" + mouseEvent.getSource().getClass();
		}
		logger.info(actionName);

		return actionName;
	}
	
	public static String getActionNameFromMouseEventWithDetails(MouseEvent mouseEvent) {
		String actionName = "";
		logger.info(mouseEvent.getSource().getClass());

		if (mouseEvent.getSource() instanceof JButton) {
			JButton clickedButton = (JButton) mouseEvent.getSource();
			actionName = "clickOnButton" + clickedButton.getIcon().toString().replaceAll(" ", "_");
		} else if (mouseEvent.getSource() instanceof JPanel) {
			actionName = "clickOnPanel(" + mouseEvent.getX() + "," + mouseEvent.getY() + ")";
		} else {
			actionName = "clickOn" + mouseEvent.getSource().getClass();
		}
		logger.info(actionName);

		return actionName;
	}
	
	public static Long getActionTotalTime(SystemResponseTimeBuffer buffer) {
		
		Long totalTime = 0L;

		boolean iterate = true;

		while (iterate) {
			SystemResponseTimeEvent event = buffer.readItem();
			if (event != null) {
				totalTime += event.getClockTime();
			}else {
				iterate = false;
			}
		}

		buffer.clear();

		return totalTime;
	}

	public static boolean setMonitoring(double probability) {
		double max = 1;
		double min = 0;
		Random r = new Random();
		double random = min + r.nextDouble() * (max - min);
		
		if (random < probability)
			return true;
		else
			return false;
	}
}
