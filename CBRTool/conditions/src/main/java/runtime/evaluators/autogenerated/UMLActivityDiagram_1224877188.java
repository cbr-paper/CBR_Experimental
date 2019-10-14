package runtime.evaluators.autogenerated;

import java.lang.ref.WeakReference;
import java.util.List;
import java.util.Iterator;

import runtime.evaluators.AtLeastOneConditionEvaluator;
public class UMLActivityDiagram_1224877188 extends AtLeastOneConditionEvaluator {
	private Object currentObject;
	private String clsName;

	public UMLActivityDiagram_1224877188(String clsName) {
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

						String sV2 = expression("_name.value.length","int");
						Integer V2 = !sV2.isEmpty() ? Integer.parseInt(sV2) : null;
						String sV3 = expression("_name.offset","int");
						Integer V3 = !sV3.isEmpty() ? Integer.parseInt(sV3) : null;
						String sV1 = expression("_name.count","int");
						Integer V1 = !sV1.isEmpty() ? Integer.parseInt(sV1) : null;

						isStateInPartitionUMLActivityDiagram_1224877188_2(V1, V2);
						isStateInPartitionUMLActivityDiagram_1224877188_1(V1, V2, V3);
						isStateInPartitionUMLActivityDiagram_1224877188_0(V1);
						isStateInPartitionUMLActivityDiagram_1224877188_3(V1);
				} 
			}
		}
	}

 private void isStateInPartitionUMLActivityDiagram_1224877188_2(Integer V1, Integer V2) {

		String pathCondition = "isStateInPartitionUMLActivityDiagram_1224877188_2";
		if(V1 == null || V2 == null){
		 Character val = values.get(pathCondition);
		 if (val.equals('U'))
		 values.put(pathCondition, 'U');
		 else if (val.equals('T'))
		 values.put(pathCondition, 'T');
		 else if (val.equals('F'))
		 values.put(pathCondition, 'F');
		} else if (V1 != 0 && V2 >= 0){
		 values.put(pathCondition, 'T');
		} else {
		 Character val = values.get(pathCondition);
		 if (val.equals('F') || val.equals('U'))
		 values.put(pathCondition, 'F');
		 else
		 values.put(pathCondition, 'T');
		}
 }


 private void isStateInPartitionUMLActivityDiagram_1224877188_1(Integer V1, Integer V2, Integer V3) {

		String pathCondition = "isStateInPartitionUMLActivityDiagram_1224877188_1";
		if(V1 == null || V2 == null || V3 == null){
		 Character val = values.get(pathCondition);
		 if (val.equals('U'))
		 values.put(pathCondition, 'U');
		 else if (val.equals('T'))
		 values.put(pathCondition, 'T');
		 else if (val.equals('F'))
		 values.put(pathCondition, 'F');
		} else if (V1 != 0 && V2 >= 0 && V3 >= 0 && V1 >= 0 && V3 + V1 <= V2 && 9 + V1 <= 16){
		 values.put(pathCondition, 'T');
		} else {
		 Character val = values.get(pathCondition);
		 if (val.equals('F') || val.equals('U'))
		 values.put(pathCondition, 'F');
		 else
		 values.put(pathCondition, 'T');
		}
 }


 private void isStateInPartitionUMLActivityDiagram_1224877188_0(Integer V1) {

		String pathCondition = "isStateInPartitionUMLActivityDiagram_1224877188_0";
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


 private void isStateInPartitionUMLActivityDiagram_1224877188_3(Integer V1) {

		String pathCondition = "isStateInPartitionUMLActivityDiagram_1224877188_3";
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

}
