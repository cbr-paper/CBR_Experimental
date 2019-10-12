package runtime.evaluators.autogenerated;

import java.lang.ref.WeakReference;
import java.util.List;

import runtime.evaluators.AtLeastOneConditionEvaluator;

import java.util.Iterator;
public class UMLActivityDiagram_1021587214 extends AtLeastOneConditionEvaluator {
	private Object currentObject;
	private String clsName;

	public UMLActivityDiagram_1021587214(String clsName) {
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

						String sV2 = expression("[org.argouml.i18n.Translator.bundles.table.length","int");
						Integer V2 = !sV2.isEmpty() ? Integer.parseInt(sV2) : null;
						String sV1 = expression("[org.argouml.i18n.Translator.initialized","boolean");
						Integer V1 = !sV1.isEmpty() ? parseBoolean(sV1) : null;

						getActionJunctionPseudoStateUMLActivityDiagram_1021587214_31(V1, V2);
						getActionJunctionPseudoStateUMLActivityDiagram_1021587214_20(V1, V2);
						getActionJunctionPseudoStateUMLActivityDiagram_1021587214_19(V1, V2);
						getActionJunctionPseudoStateUMLActivityDiagram_1021587214_36(V1, V2);
				} 
			}
		}
	}

 private void getActionJunctionPseudoStateUMLActivityDiagram_1021587214_31(Integer V1, Integer V2) {

		String pathCondition = "getActionJunctionPseudoStateUMLActivityDiagram_1021587214_31";
		if(V1 == null || V2 == null){
		 Character val = values.get(pathCondition);
		 if (val.equals('U'))
		 values.put(pathCondition, 'U');
		 else if (val.equals('T'))
		 values.put(pathCondition, 'T');
		 else if (val.equals('F'))
		 values.put(pathCondition, 'F');
		} else if (V1 != 0 && V2 >= 0 && (955390812 & V2 - 1) >= 0 && (955390812 & V2 - 1) < V2 && (955390812 & V2 - 1) + 2 < V2 && (955390812 & V2 - 1) + 2 >= 0 && (955390812 & V2 - 1) + 2 < V2 && (955390812 & V2 - 1) + 2 != (955390812 & V2 - 1) && (955390812 & V2 - 1) + 2 + 2 >= V2){
		 values.put(pathCondition, 'T');
		} else {
		 Character val = values.get(pathCondition);
		 if (val.equals('F') || val.equals('U'))
		 values.put(pathCondition, 'F');
		 else
		 values.put(pathCondition, 'T');
		}
 }


 private void getActionJunctionPseudoStateUMLActivityDiagram_1021587214_20(Integer V1, Integer V2) {

		String pathCondition = "getActionJunctionPseudoStateUMLActivityDiagram_1021587214_20";
		if(V1 == null || V2 == null){
		 Character val = values.get(pathCondition);
		 if (val.equals('U'))
		 values.put(pathCondition, 'U');
		 else if (val.equals('T'))
		 values.put(pathCondition, 'T');
		 else if (val.equals('F'))
		 values.put(pathCondition, 'F');
		} else if (V1 != 0 && V2 >= 0 && (13004824 & V2 - 1) >= 0 && (13004824 & V2 - 1) < V2 && (13004824 & V2 - 1) + 2 >= V2 && V2 > 0 && (13004824 & V2 - 1) != 0){
		 values.put(pathCondition, 'T');
		} else {
		 Character val = values.get(pathCondition);
		 if (val.equals('F') || val.equals('U'))
		 values.put(pathCondition, 'F');
		 else
		 values.put(pathCondition, 'T');
		}
 }


 private void getActionJunctionPseudoStateUMLActivityDiagram_1021587214_19(Integer V1, Integer V2) {

		String pathCondition = "getActionJunctionPseudoStateUMLActivityDiagram_1021587214_19";
		if(V1 == null || V2 == null){
		 Character val = values.get(pathCondition);
		 if (val.equals('U'))
		 values.put(pathCondition, 'U');
		 else if (val.equals('T'))
		 values.put(pathCondition, 'T');
		 else if (val.equals('F'))
		 values.put(pathCondition, 'F');
		} else if (V1 != 0 && V2 >= 0 && (13004824 & V2 - 1) >= 0 && (13004824 & V2 - 1) < V2 && (13004824 & V2 - 1) + 2 < V2 && (13004824 & V2 - 1) + 2 >= 0 && (13004824 & V2 - 1) + 2 < V2 && (13004824 & V2 - 1) + 2 != (13004824 & V2 - 1)){
		 values.put(pathCondition, 'T');
		} else {
		 Character val = values.get(pathCondition);
		 if (val.equals('F') || val.equals('U'))
		 values.put(pathCondition, 'F');
		 else
		 values.put(pathCondition, 'T');
		}
 }


 private void getActionJunctionPseudoStateUMLActivityDiagram_1021587214_36(Integer V1, Integer V2) {

		String pathCondition = "getActionJunctionPseudoStateUMLActivityDiagram_1021587214_36";
		if(V1 == null || V2 == null){
		 Character val = values.get(pathCondition);
		 if (val.equals('U'))
		 values.put(pathCondition, 'U');
		 else if (val.equals('T'))
		 values.put(pathCondition, 'T');
		 else if (val.equals('F'))
		 values.put(pathCondition, 'F');
		} else if (V1 != 0 && V2 >= 0 && (661569674 & V2 - 1) >= 0 && (661569674 & V2 - 1) < V2 && (661569674 & V2 - 1) + 2 < V2 && (661569674 & V2 - 1) + 2 >= 0 && (661569674 & V2 - 1) + 2 < V2 && (661569674 & V2 - 1) + 2 != (661569674 & V2 - 1)){
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
