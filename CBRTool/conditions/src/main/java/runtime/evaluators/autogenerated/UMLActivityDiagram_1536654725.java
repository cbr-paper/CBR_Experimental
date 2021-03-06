package runtime.evaluators.autogenerated;

import java.lang.ref.WeakReference;
import java.util.List;
import java.util.Iterator;

import runtime.evaluators.AtLeastOneConditionEvaluator;
public class UMLActivityDiagram_1536654725 extends AtLeastOneConditionEvaluator {
	private Object currentObject;
	private String clsName;

	public UMLActivityDiagram_1536654725(String clsName) {
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

						String sV4 = expression("[org.argouml.model.euml.UmlFactoryEUMLImpl.VALID_CONNECTIONS[0].length","int");
						Integer V4 = !sV4.isEmpty() ? Integer.parseInt(sV4) : null;
						String sV5 = expression("[org.argouml.model.mdr.UmlFactoryMDRImpl.VALID_CONNECTIONS[0].length","int");
						Integer V5 = !sV5.isEmpty() ? Integer.parseInt(sV5) : null;
						String sV1 = expression("[org.argouml.model.euml.UmlFactoryEUMLImpl.VALID_CONNECTIONS.length","int");
						Integer V1 = !sV1.isEmpty() ? Integer.parseInt(sV1) : null;
						String sV2 = expression("[org.argouml.model.mdr.UmlFactoryMDRImpl.VALID_CONNECTIONS.length","int");
						Integer V2 = !sV2.isEmpty() ? Integer.parseInt(sV2) : null;
						String sV3 = expression("_name.count","int");
						Integer V3 = !sV3.isEmpty() ? Integer.parseInt(sV3) : null;

						getDependentElementUMLActivityDiagram_1536654725_2(V1);
						getDependentElementUMLActivityDiagram_1536654725_3(V1);
						getDependentElementUMLActivityDiagram_1536654725_7(V2);
						getDependentElementUMLActivityDiagram_1536654725_6(V2);
						getDependentElementUMLActivityDiagram_1536654725_8(V3);
						getDependentElementUMLActivityDiagram_1536654725_9(V3);
						getDependentElementUMLActivityDiagram_1536654725_1(V1, V4);
						getDependentElementUMLActivityDiagram_1536654725_4(V2, V5);
						getDependentElementUMLActivityDiagram_1536654725_5(V2, V5);
						getDependentElementUMLActivityDiagram_1536654725_0(V1, V4);
				} 
			}
		}
	}

 private void getDependentElementUMLActivityDiagram_1536654725_2(Integer V1) {

		String pathCondition = "getDependentElementUMLActivityDiagram_1536654725_2";
		if(V1 == null){
		 Character val = values.get(pathCondition);
		 if (val.equals('U'))
		 values.put(pathCondition, 'U');
		 else if (val.equals('T'))
		 values.put(pathCondition, 'T');
		 else if (val.equals('F'))
		 values.put(pathCondition, 'F');
		} else if (V1 >= 0 && V1 > 0 && true){
		 values.put(pathCondition, 'T');
		} else {
		 Character val = values.get(pathCondition);
		 if (val.equals('F') || val.equals('U'))
		 values.put(pathCondition, 'F');
		 else
		 values.put(pathCondition, 'T');
		}
 }


 private void getDependentElementUMLActivityDiagram_1536654725_3(Integer V1) {

		String pathCondition = "getDependentElementUMLActivityDiagram_1536654725_3";
		if(V1 == null){
		 Character val = values.get(pathCondition);
		 if (val.equals('U'))
		 values.put(pathCondition, 'U');
		 else if (val.equals('T'))
		 values.put(pathCondition, 'T');
		 else if (val.equals('F'))
		 values.put(pathCondition, 'F');
		} else if (V1 >= 0 && V1 <= 0){
		 values.put(pathCondition, 'T');
		} else {
		 Character val = values.get(pathCondition);
		 if (val.equals('F') || val.equals('U'))
		 values.put(pathCondition, 'F');
		 else
		 values.put(pathCondition, 'T');
		}
 }


 private void getDependentElementUMLActivityDiagram_1536654725_7(Integer V2) {

		String pathCondition = "getDependentElementUMLActivityDiagram_1536654725_7";
		if(V2 == null){
		 Character val = values.get(pathCondition);
		 if (val.equals('U'))
		 values.put(pathCondition, 'U');
		 else if (val.equals('T'))
		 values.put(pathCondition, 'T');
		 else if (val.equals('F'))
		 values.put(pathCondition, 'F');
		} else if (V2 >= 0 && V2 <= 0){
		 values.put(pathCondition, 'T');
		} else {
		 Character val = values.get(pathCondition);
		 if (val.equals('F') || val.equals('U'))
		 values.put(pathCondition, 'F');
		 else
		 values.put(pathCondition, 'T');
		}
 }


 private void getDependentElementUMLActivityDiagram_1536654725_6(Integer V2) {

		String pathCondition = "getDependentElementUMLActivityDiagram_1536654725_6";
		if(V2 == null){
		 Character val = values.get(pathCondition);
		 if (val.equals('U'))
		 values.put(pathCondition, 'U');
		 else if (val.equals('T'))
		 values.put(pathCondition, 'T');
		 else if (val.equals('F'))
		 values.put(pathCondition, 'F');
		} else if (V2 >= 0 && V2 > 0 && true){
		 values.put(pathCondition, 'T');
		} else {
		 Character val = values.get(pathCondition);
		 if (val.equals('F') || val.equals('U'))
		 values.put(pathCondition, 'F');
		 else
		 values.put(pathCondition, 'T');
		}
 }


 private void getDependentElementUMLActivityDiagram_1536654725_8(Integer V3) {

		String pathCondition = "getDependentElementUMLActivityDiagram_1536654725_8";
		if(V3 == null){
		 Character val = values.get(pathCondition);
		 if (val.equals('U'))
		 values.put(pathCondition, 'U');
		 else if (val.equals('T'))
		 values.put(pathCondition, 'T');
		 else if (val.equals('F'))
		 values.put(pathCondition, 'F');
		} else if (V3 == 0){
		 values.put(pathCondition, 'T');
		} else {
		 Character val = values.get(pathCondition);
		 if (val.equals('F') || val.equals('U'))
		 values.put(pathCondition, 'F');
		 else
		 values.put(pathCondition, 'T');
		}
 }


 private void getDependentElementUMLActivityDiagram_1536654725_9(Integer V3) {

		String pathCondition = "getDependentElementUMLActivityDiagram_1536654725_9";
		if(V3 == null){
		 Character val = values.get(pathCondition);
		 if (val.equals('U'))
		 values.put(pathCondition, 'U');
		 else if (val.equals('T'))
		 values.put(pathCondition, 'T');
		 else if (val.equals('F'))
		 values.put(pathCondition, 'F');
		} else if (V3 != 0){
		 values.put(pathCondition, 'T');
		} else {
		 Character val = values.get(pathCondition);
		 if (val.equals('F') || val.equals('U'))
		 values.put(pathCondition, 'F');
		 else
		 values.put(pathCondition, 'T');
		}
 }


 private void getDependentElementUMLActivityDiagram_1536654725_1(Integer V1, Integer V4) {

		String pathCondition = "getDependentElementUMLActivityDiagram_1536654725_1";
		if(V1 == null || V4 == null){
		 Character val = values.get(pathCondition);
		 if (val.equals('U'))
		 values.put(pathCondition, 'U');
		 else if (val.equals('T'))
		 values.put(pathCondition, 'T');
		 else if (val.equals('F'))
		 values.put(pathCondition, 'F');
		} else if (V1 >= 0 && V1 > 0 && V4 >= 0 && true && V4 <= 0){
		 values.put(pathCondition, 'T');
		} else {
		 Character val = values.get(pathCondition);
		 if (val.equals('F') || val.equals('U'))
		 values.put(pathCondition, 'F');
		 else
		 values.put(pathCondition, 'T');
		}
 }


 private void getDependentElementUMLActivityDiagram_1536654725_4(Integer V2, Integer V5) {

		String pathCondition = "getDependentElementUMLActivityDiagram_1536654725_4";
		if(V2 == null || V5 == null){
		 Character val = values.get(pathCondition);
		 if (val.equals('U'))
		 values.put(pathCondition, 'U');
		 else if (val.equals('T'))
		 values.put(pathCondition, 'T');
		 else if (val.equals('F'))
		 values.put(pathCondition, 'F');
		} else if (V2 >= 0 && V2 > 0 && V5 >= 0 && true && V5 > 0){
		 values.put(pathCondition, 'T');
		} else {
		 Character val = values.get(pathCondition);
		 if (val.equals('F') || val.equals('U'))
		 values.put(pathCondition, 'F');
		 else
		 values.put(pathCondition, 'T');
		}
 }


 private void getDependentElementUMLActivityDiagram_1536654725_5(Integer V2, Integer V5) {

		String pathCondition = "getDependentElementUMLActivityDiagram_1536654725_5";
		if(V2 == null || V5 == null){
		 Character val = values.get(pathCondition);
		 if (val.equals('U'))
		 values.put(pathCondition, 'U');
		 else if (val.equals('T'))
		 values.put(pathCondition, 'T');
		 else if (val.equals('F'))
		 values.put(pathCondition, 'F');
		} else if (V2 >= 0 && V2 > 0 && V5 >= 0 && true && V5 <= 0){
		 values.put(pathCondition, 'T');
		} else {
		 Character val = values.get(pathCondition);
		 if (val.equals('F') || val.equals('U'))
		 values.put(pathCondition, 'F');
		 else
		 values.put(pathCondition, 'T');
		}
 }


 private void getDependentElementUMLActivityDiagram_1536654725_0(Integer V1, Integer V4) {

		String pathCondition = "getDependentElementUMLActivityDiagram_1536654725_0";
		if(V1 == null || V4 == null){
		 Character val = values.get(pathCondition);
		 if (val.equals('U'))
		 values.put(pathCondition, 'U');
		 else if (val.equals('T'))
		 values.put(pathCondition, 'T');
		 else if (val.equals('F'))
		 values.put(pathCondition, 'F');
		} else if (V1 >= 0 && V1 > 0 && V4 >= 0 && true && V4 > 0){
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
