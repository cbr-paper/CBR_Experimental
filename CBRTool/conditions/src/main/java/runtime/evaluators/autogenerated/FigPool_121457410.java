package runtime.evaluators.autogenerated;

import java.lang.ref.WeakReference;
import java.util.List;

import runtime.evaluators.AtLeastOneConditionEvaluator;

import java.util.Iterator;
public class FigPool_121457410 extends AtLeastOneConditionEvaluator {
	private Object currentObject;
	private String clsName;

	public FigPool_121457410(String clsName) {
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

						String sV3 = expression("[org.tigris.gef.base.Globals._pcListeners.table[((nameFig.hashCode()) & (2147483647)) % ([org.tigris.gef.base.Globals._pcListeners.table.length)].hash","int");
						Integer V3 = !sV3.isEmpty() ? Integer.parseInt(sV3) : null;
						String sV4 = expression("[org.argouml.uml.diagram.ui.FigRole.$assertionsDisabled","boolean");
						Integer V4 = !sV4.isEmpty() ? parseBoolean(sV4) : null;
						String sV1 = expression("[org.tigris.gef.base.Globals._pcListeners.table.length","int");
						Integer V1 = !sV1.isEmpty() ? Integer.parseInt(sV1) : null;
						String sV2 = expression("nameFig.hashCode()","int");
						Integer V2 = !sV2.isEmpty() ? Integer.parseInt(sV2) : null;

						setFillColorFigPool_121457410_2(V1, V2, V3);
						setFillColorFigPool_121457410_1(V4);
						setFillColorFigPool_121457410_0(V4);
						setFillColorFigPool_121457410_4(V1, V2);
				} 
			}
		}
	}

 private void setFillColorFigPool_121457410_2(Integer V1, Integer V2, Integer V3) {

		String pathCondition = "setFillColorFigPool_121457410_2";
		if(V1 == null || V2 == null || V3 == null){
		 Character val = values.get(pathCondition);
		 if (val.equals('U'))
		 values.put(pathCondition, 'U');
		 else if (val.equals('T'))
		 values.put(pathCondition, 'T');
		 else if (val.equals('F'))
		 values.put(pathCondition, 'F');
		} else if (V1 >= 0 && (V2 & 2147483647) % V1 >= 0 && (V2 & 2147483647) % V1 < V1 && V3 == V2){
		 values.put(pathCondition, 'T');
		} else {
		 Character val = values.get(pathCondition);
		 if (val.equals('F') || val.equals('U'))
		 values.put(pathCondition, 'F');
		 else
		 values.put(pathCondition, 'T');
		}
 }


 private void setFillColorFigPool_121457410_1(Integer V4) {

		String pathCondition = "setFillColorFigPool_121457410_1";
		if(V4 == null){
		 Character val = values.get(pathCondition);
		 if (val.equals('U'))
		 values.put(pathCondition, 'U');
		 else if (val.equals('T'))
		 values.put(pathCondition, 'T');
		 else if (val.equals('F'))
		 values.put(pathCondition, 'F');
		} else if (V4 != 0){
		 values.put(pathCondition, 'T');
		} else {
		 Character val = values.get(pathCondition);
		 if (val.equals('F') || val.equals('U'))
		 values.put(pathCondition, 'F');
		 else
		 values.put(pathCondition, 'T');
		}
 }


 private void setFillColorFigPool_121457410_0(Integer V4) {

		String pathCondition = "setFillColorFigPool_121457410_0";
		if(V4 == null){
		 Character val = values.get(pathCondition);
		 if (val.equals('U'))
		 values.put(pathCondition, 'U');
		 else if (val.equals('T'))
		 values.put(pathCondition, 'T');
		 else if (val.equals('F'))
		 values.put(pathCondition, 'F');
		} else if (V4 == 0){
		 values.put(pathCondition, 'T');
		} else {
		 Character val = values.get(pathCondition);
		 if (val.equals('F') || val.equals('U'))
		 values.put(pathCondition, 'F');
		 else
		 values.put(pathCondition, 'T');
		}
 }


 private void setFillColorFigPool_121457410_4(Integer V1, Integer V2) {

		String pathCondition = "setFillColorFigPool_121457410_4";
		if(V1 == null || V2 == null){
		 Character val = values.get(pathCondition);
		 if (val.equals('U'))
		 values.put(pathCondition, 'U');
		 else if (val.equals('T'))
		 values.put(pathCondition, 'T');
		 else if (val.equals('F'))
		 values.put(pathCondition, 'F');
		} else if (V1 >= 0 && (V2 & 2147483647) % V1 >= 0 && (V2 & 2147483647) % V1 < V1){
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
