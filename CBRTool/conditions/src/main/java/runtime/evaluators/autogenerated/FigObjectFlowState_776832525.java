package runtime.evaluators.autogenerated;

import java.lang.ref.WeakReference;
import java.util.List;

import runtime.evaluators.AtLeastOneConditionEvaluator;

import java.util.Iterator;
public class FigObjectFlowState_776832525 extends AtLeastOneConditionEvaluator {
	private Object currentObject;
	private String clsName;

	public FigObjectFlowState_776832525(String clsName) {
		this.clsName = clsName;
	}

	public void monitor() throws ClassNotFoundException, NumberFormatException {

		currentObject = null;
		//currentObject =	 Class.forName(clsName).cast(currentObject); 
		currentObject = Class.forName(clsName, false,Thread.currentThread().getContextClassLoader()).cast(currentObject); 
 		if ( map.containsKey(clsName)) {
 			List<WeakReference<Object>> objectsList =	 map.get(clsName);
 			for (Iterator<WeakReference<Object>> it = objectsList.iterator();it.hasNext();) {
 				WeakReference<Object> object = it.next();
 				if (object.isEnqueued())
 					addQueuedObject(clsName, object);
 				else {
 					currentObject = object.get();
 					sfh.setCurrentStaticObject(currentObject);
 					fh.setCurrentObject(currentObject);

						String sV1 = expression("[org.argouml.uml.diagram.ui.FigRole.$assertionsDisabled","boolean");
						Integer V1 = !sV1.isEmpty() ? parseBoolean(sV1) : null;

						setLineColorFigObjectFlowState_776832525_1(V1);
						setLineColorFigObjectFlowState_776832525_0(V1);
				} 
			}
		}
	}

 private void setLineColorFigObjectFlowState_776832525_1(Integer V1) {

		String pathCondition = "setLineColorFigObjectFlowState_776832525_1";
		if(V1 == null){
		 Character val = values.get(pathCondition);
		 if (val.equals('U'))
		 values.put(pathCondition, 'U');
		 else if (val.equals('T'))
		 values.put(pathCondition, 'T');
		 else if (val.equals('F'))
		 values.put(pathCondition, 'F');
		} else if (V1 != 0){
		 values.put(pathCondition, 'T');
		} else {
		 Character val = values.get(pathCondition);
		 if (val.equals('F') || val.equals('U'))
		 values.put(pathCondition, 'F');
		 else
		 values.put(pathCondition, 'T');
		}
 }


 private void setLineColorFigObjectFlowState_776832525_0(Integer V1) {

		String pathCondition = "setLineColorFigObjectFlowState_776832525_0";
		if(V1 == null){
		 Character val = values.get(pathCondition);
		 if (val.equals('U'))
		 values.put(pathCondition, 'U');
		 else if (val.equals('T'))
		 values.put(pathCondition, 'T');
		 else if (val.equals('F'))
		 values.put(pathCondition, 'F');
		} else if (V1 == 0){
		 values.put(pathCondition, 'T');
		} else {
		 Character val = values.get(pathCondition);
		 if (val.equals('F') || val.equals('U'))
		 values.put(pathCondition, 'F');
		 else
		 values.put(pathCondition, 'T');
		}
 }

}
