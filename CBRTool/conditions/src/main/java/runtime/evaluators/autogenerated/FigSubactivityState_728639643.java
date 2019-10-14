package runtime.evaluators.autogenerated;

import java.lang.ref.WeakReference;
import java.util.List;
import java.util.Iterator;

import runtime.evaluators.AtLeastOneConditionEvaluator;
public class FigSubactivityState_728639643 extends AtLeastOneConditionEvaluator {
	private Object currentObject;
	private String clsName;

	public FigSubactivityState_728639643(String clsName) {
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

						String sV3 = expression("[org.tigris.gef.base.Globals._pcListeners.table.length","int");
						Integer V3 = !sV3.isEmpty() ? Integer.parseInt(sV3) : null;
						String sV4 = expression("[org.argouml.uml.diagram.ui.ArgoFig.FILL_COLOR.value","char");
						Character V4 = !sV4.isEmpty() ? parseChar(sV4) : null;
						String sV2 = expression("[org.argouml.uml.diagram.ui.ArgoFig.LINE_COLOR.value","char");
						Character V2 = !sV2.isEmpty() ? parseChar(sV2) : null;
						String sV1 = expression("[java.awt.Color.black.value","char");
						Character V1 = !sV1.isEmpty() ? parseChar(sV1) : null;
						String sV5 = expression("[java.awt.Color.white.value","char");
						Character V5 = !sV5.isEmpty() ? parseChar(sV5) : null;
						String sV6 = expression("hashCode()","int");
						Integer V6 = !sV6.isEmpty() ? Integer.parseInt(sV6) : null;

						initFigSubactivityState_728639643_8(V1, V2);
						initFigSubactivityState_728639643_9(V1, V2);
						initFigSubactivityState_728639643_1(V3);
						initFigSubactivityState_728639643_7(V1, V4);
						initFigSubactivityState_728639643_3(V4, V5);
						initFigSubactivityState_728639643_0(V6, V3);
						initFigSubactivityState_728639643_2(V4, V5);
						initFigSubactivityState_728639643_4(V1, V5);
						initFigSubactivityState_728639643_5(V1, V5);
						initFigSubactivityState_728639643_6(V1, V4);
				} 
			}
		}
	}

 private void initFigSubactivityState_728639643_8(Character V1, Character V2) {

		String pathCondition = "initFigSubactivityState_728639643_8";
		if(V1 == null || V2 == null){
		 Character val = values.get(pathCondition);
		 if (val.equals('U'))
		 values.put(pathCondition, 'U');
		 else if (val.equals('T'))
		 values.put(pathCondition, 'T');
		 else if (val.equals('F'))
		 values.put(pathCondition, 'F');
		} else if (V1 == V2){
		 values.put(pathCondition, 'T');
		} else {
		 Character val = values.get(pathCondition);
		 if (val.equals('F') || val.equals('U'))
		 values.put(pathCondition, 'F');
		 else
		 values.put(pathCondition, 'T');
		}
 }


 private void initFigSubactivityState_728639643_9(Character V1, Character V2) {

		String pathCondition = "initFigSubactivityState_728639643_9";
		if(V1 == null || V2 == null){
		 Character val = values.get(pathCondition);
		 if (val.equals('U'))
		 values.put(pathCondition, 'U');
		 else if (val.equals('T'))
		 values.put(pathCondition, 'T');
		 else if (val.equals('F'))
		 values.put(pathCondition, 'F');
		} else if (V1 != V2){
		 values.put(pathCondition, 'T');
		} else {
		 Character val = values.get(pathCondition);
		 if (val.equals('F') || val.equals('U'))
		 values.put(pathCondition, 'F');
		 else
		 values.put(pathCondition, 'T');
		}
 }


 private void initFigSubactivityState_728639643_1(Integer V3) {

		String pathCondition = "initFigSubactivityState_728639643_1";
		if(V3 == null){
		 Character val = values.get(pathCondition);
		 if (val.equals('U'))
		 values.put(pathCondition, 'U');
		 else if (val.equals('T'))
		 values.put(pathCondition, 'T');
		 else if (val.equals('F'))
		 values.put(pathCondition, 'F');
		} else if (V3 >= 0){
		 values.put(pathCondition, 'T');
		} else {
		 Character val = values.get(pathCondition);
		 if (val.equals('F') || val.equals('U'))
		 values.put(pathCondition, 'F');
		 else
		 values.put(pathCondition, 'T');
		}
 }


 private void initFigSubactivityState_728639643_7(Character V1, Character V4) {

		String pathCondition = "initFigSubactivityState_728639643_7";
		if(V1 == null || V4 == null){
		 Character val = values.get(pathCondition);
		 if (val.equals('U'))
		 values.put(pathCondition, 'U');
		 else if (val.equals('T'))
		 values.put(pathCondition, 'T');
		 else if (val.equals('F'))
		 values.put(pathCondition, 'F');
		} else if (V1 != V4){
		 values.put(pathCondition, 'T');
		} else {
		 Character val = values.get(pathCondition);
		 if (val.equals('F') || val.equals('U'))
		 values.put(pathCondition, 'F');
		 else
		 values.put(pathCondition, 'T');
		}
 }


 private void initFigSubactivityState_728639643_3(Character V4, Character V5) {

		String pathCondition = "initFigSubactivityState_728639643_3";
		if(V4 == null || V5 == null){
		 Character val = values.get(pathCondition);
		 if (val.equals('U'))
		 values.put(pathCondition, 'U');
		 else if (val.equals('T'))
		 values.put(pathCondition, 'T');
		 else if (val.equals('F'))
		 values.put(pathCondition, 'F');
		} else if (V5 != V4){
		 values.put(pathCondition, 'T');
		} else {
		 Character val = values.get(pathCondition);
		 if (val.equals('F') || val.equals('U'))
		 values.put(pathCondition, 'F');
		 else
		 values.put(pathCondition, 'T');
		}
 }


 private void initFigSubactivityState_728639643_0(Integer V6, Integer V3) {

		String pathCondition = "initFigSubactivityState_728639643_0";
		if(V6 == null || V3 == null){
		 Character val = values.get(pathCondition);
		 if (val.equals('U'))
		 values.put(pathCondition, 'U');
		 else if (val.equals('T'))
		 values.put(pathCondition, 'T');
		 else if (val.equals('F'))
		 values.put(pathCondition, 'F');
		} else if (V3 >= 0 && (V6 & 2147483647) % V3 >= 0 && (V6 & 2147483647) % V3 < V3){
		 values.put(pathCondition, 'T');
		} else {
		 Character val = values.get(pathCondition);
		 if (val.equals('F') || val.equals('U'))
		 values.put(pathCondition, 'F');
		 else
		 values.put(pathCondition, 'T');
		}
 }


 private void initFigSubactivityState_728639643_2(Character V4, Character V5) {

		String pathCondition = "initFigSubactivityState_728639643_2";
		if(V4 == null || V5 == null){
		 Character val = values.get(pathCondition);
		 if (val.equals('U'))
		 values.put(pathCondition, 'U');
		 else if (val.equals('T'))
		 values.put(pathCondition, 'T');
		 else if (val.equals('F'))
		 values.put(pathCondition, 'F');
		} else if (V5 == V4){
		 values.put(pathCondition, 'T');
		} else {
		 Character val = values.get(pathCondition);
		 if (val.equals('F') || val.equals('U'))
		 values.put(pathCondition, 'F');
		 else
		 values.put(pathCondition, 'T');
		}
 }


 private void initFigSubactivityState_728639643_4(Character V1, Character V5) {

		String pathCondition = "initFigSubactivityState_728639643_4";
		if(V1 == null || V5 == null){
		 Character val = values.get(pathCondition);
		 if (val.equals('U'))
		 values.put(pathCondition, 'U');
		 else if (val.equals('T'))
		 values.put(pathCondition, 'T');
		 else if (val.equals('F'))
		 values.put(pathCondition, 'F');
		} else if (V5 == V1){
		 values.put(pathCondition, 'T');
		} else {
		 Character val = values.get(pathCondition);
		 if (val.equals('F') || val.equals('U'))
		 values.put(pathCondition, 'F');
		 else
		 values.put(pathCondition, 'T');
		}
 }


 private void initFigSubactivityState_728639643_5(Character V1, Character V5) {

		String pathCondition = "initFigSubactivityState_728639643_5";
		if(V1 == null || V5 == null){
		 Character val = values.get(pathCondition);
		 if (val.equals('U'))
		 values.put(pathCondition, 'U');
		 else if (val.equals('T'))
		 values.put(pathCondition, 'T');
		 else if (val.equals('F'))
		 values.put(pathCondition, 'F');
		} else if (V5 != V1){
		 values.put(pathCondition, 'T');
		} else {
		 Character val = values.get(pathCondition);
		 if (val.equals('F') || val.equals('U'))
		 values.put(pathCondition, 'F');
		 else
		 values.put(pathCondition, 'T');
		}
 }


 private void initFigSubactivityState_728639643_6(Character V1, Character V4) {

		String pathCondition = "initFigSubactivityState_728639643_6";
		if(V1 == null || V4 == null){
		 Character val = values.get(pathCondition);
		 if (val.equals('U'))
		 values.put(pathCondition, 'U');
		 else if (val.equals('T'))
		 values.put(pathCondition, 'T');
		 else if (val.equals('F'))
		 values.put(pathCondition, 'F');
		} else if (V1 == V4){
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
