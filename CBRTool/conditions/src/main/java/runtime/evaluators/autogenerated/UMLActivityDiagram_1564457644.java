package runtime.evaluators.autogenerated;

import java.lang.ref.WeakReference;
import java.util.List;
import java.util.Iterator;

import runtime.evaluators.AtLeastOneConditionEvaluator;
public class UMLActivityDiagram_1564457644 extends AtLeastOneConditionEvaluator {
	private Object currentObject;
	private String clsName;

	public UMLActivityDiagram_1564457644(String clsName) {
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

						String sV3 = expression("[org.argouml.model.euml.UmlFactoryEUMLImpl.VALID_CONNECTIONS.length","int");
						Integer V3 = !sV3.isEmpty() ? Integer.parseInt(sV3) : null;
						String sV1 = expression("[org.argouml.model.mdr.UmlFactoryMDRImpl.VALID_CONNECTIONS.length","int");
						Integer V1 = !sV1.isEmpty() ? Integer.parseInt(sV1) : null;
						String sV2 = expression("_name.count","int");
						Integer V2 = !sV2.isEmpty() ? Integer.parseInt(sV2) : null;

						propertyChangeUMLActivityDiagram_1564457644_1(V1);
						propertyChangeUMLActivityDiagram_1564457644_2(V2);
						propertyChangeUMLActivityDiagram_1564457644_3(V2);
						propertyChangeUMLActivityDiagram_1564457644_0(V3);
				} 
			}
		}
	}

 private void propertyChangeUMLActivityDiagram_1564457644_1(Integer V1) {

		String pathCondition = "propertyChangeUMLActivityDiagram_1564457644_1";
		if(V1 == null){
		 Character val = values.get(pathCondition);
		 if (val.equals('U'))
		 values.put(pathCondition, 'U');
		 else if (val.equals('T'))
		 values.put(pathCondition, 'T');
		 else if (val.equals('F'))
		 values.put(pathCondition, 'F');
		} else if (V1 >= 0){
		 values.put(pathCondition, 'T');
		} else {
		 Character val = values.get(pathCondition);
		 if (val.equals('F') || val.equals('U'))
		 values.put(pathCondition, 'F');
		 else
		 values.put(pathCondition, 'T');
		}
 }


 private void propertyChangeUMLActivityDiagram_1564457644_2(Integer V2) {

		String pathCondition = "propertyChangeUMLActivityDiagram_1564457644_2";
		if(V2 == null){
		 Character val = values.get(pathCondition);
		 if (val.equals('U'))
		 values.put(pathCondition, 'U');
		 else if (val.equals('T'))
		 values.put(pathCondition, 'T');
		 else if (val.equals('F'))
		 values.put(pathCondition, 'F');
		} else if (V2 == 0){
		 values.put(pathCondition, 'T');
		} else {
		 Character val = values.get(pathCondition);
		 if (val.equals('F') || val.equals('U'))
		 values.put(pathCondition, 'F');
		 else
		 values.put(pathCondition, 'T');
		}
 }


 private void propertyChangeUMLActivityDiagram_1564457644_3(Integer V2) {

		String pathCondition = "propertyChangeUMLActivityDiagram_1564457644_3";
		if(V2 == null){
		 Character val = values.get(pathCondition);
		 if (val.equals('U'))
		 values.put(pathCondition, 'U');
		 else if (val.equals('T'))
		 values.put(pathCondition, 'T');
		 else if (val.equals('F'))
		 values.put(pathCondition, 'F');
		} else if (V2 != 0){
		 values.put(pathCondition, 'T');
		} else {
		 Character val = values.get(pathCondition);
		 if (val.equals('F') || val.equals('U'))
		 values.put(pathCondition, 'F');
		 else
		 values.put(pathCondition, 'T');
		}
 }


 private void propertyChangeUMLActivityDiagram_1564457644_0(Integer V3) {

		String pathCondition = "propertyChangeUMLActivityDiagram_1564457644_0";
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

}
