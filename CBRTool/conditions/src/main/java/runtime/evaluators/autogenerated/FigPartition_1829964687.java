package runtime.evaluators.autogenerated;

import java.lang.ref.WeakReference;
import java.util.List;
import java.util.Iterator;

import runtime.evaluators.AtLeastOneConditionEvaluator;
public class FigPartition_1829964687 extends AtLeastOneConditionEvaluator {
	private Object currentObject;
	private String clsName;

	public FigPartition_1829964687(String clsName) {
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

						String sV3 = expression("[org.tigris.gef.base.Globals._pcListeners.table[(1607884933) % ([org.tigris.gef.base.Globals._pcListeners.table.length)].next.hash","int");
						Integer V3 = !sV3.isEmpty() ? Integer.parseInt(sV3) : null;
						String sV2 = expression("[org.tigris.gef.base.Globals._pcListeners.table[(1607884933) % ([org.tigris.gef.base.Globals._pcListeners.table.length)].hash","int");
						Integer V2 = !sV2.isEmpty() ? Integer.parseInt(sV2) : null;
						String sV1 = expression("[org.tigris.gef.base.Globals._pcListeners.table.length","int");
						Integer V1 = !sV1.isEmpty() ? Integer.parseInt(sV1) : null;

						initFigsFigPartition_1829964687_4(V1);
						initFigsFigPartition_1829964687_0(V1, V2);
						initFigsFigPartition_1829964687_5(V1);
						initFigsFigPartition_1829964687_3(V1, V2);
						initFigsFigPartition_1829964687_2(V1, V2, V3);
						initFigsFigPartition_1829964687_1(V1, V2, V3);
				} 
			}
		}
	}

 private void initFigsFigPartition_1829964687_4(Integer V1) {

		String pathCondition = "initFigsFigPartition_1829964687_4";
		if(V1 == null){
		 Character val = values.get(pathCondition);
		 if (val.equals('U'))
		 values.put(pathCondition, 'U');
		 else if (val.equals('T'))
		 values.put(pathCondition, 'T');
		 else if (val.equals('F'))
		 values.put(pathCondition, 'F');
		} else if (V1 >= 0 && 1607884933 % V1 >= 0 && 1607884933 % V1 < V1){
		 values.put(pathCondition, 'T');
		} else {
		 Character val = values.get(pathCondition);
		 if (val.equals('F') || val.equals('U'))
		 values.put(pathCondition, 'F');
		 else
		 values.put(pathCondition, 'T');
		}
 }


 private void initFigsFigPartition_1829964687_0(Integer V1, Integer V2) {

		String pathCondition = "initFigsFigPartition_1829964687_0";
		if(V1 == null || V2 == null){
		 Character val = values.get(pathCondition);
		 if (val.equals('U'))
		 values.put(pathCondition, 'U');
		 else if (val.equals('T'))
		 values.put(pathCondition, 'T');
		 else if (val.equals('F'))
		 values.put(pathCondition, 'F');
		} else if (V1 >= 0 && 1607884933 % V1 >= 0 && 1607884933 % V1 < V1 && V2 == 1607884933){
		 values.put(pathCondition, 'T');
		} else {
		 Character val = values.get(pathCondition);
		 if (val.equals('F') || val.equals('U'))
		 values.put(pathCondition, 'F');
		 else
		 values.put(pathCondition, 'T');
		}
 }


 private void initFigsFigPartition_1829964687_5(Integer V1) {

		String pathCondition = "initFigsFigPartition_1829964687_5";
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


 private void initFigsFigPartition_1829964687_3(Integer V1, Integer V2) {

		String pathCondition = "initFigsFigPartition_1829964687_3";
		if(V1 == null || V2 == null){
		 Character val = values.get(pathCondition);
		 if (val.equals('U'))
		 values.put(pathCondition, 'U');
		 else if (val.equals('T'))
		 values.put(pathCondition, 'T');
		 else if (val.equals('F'))
		 values.put(pathCondition, 'F');
		} else if (V1 >= 0 && 1607884933 % V1 >= 0 && 1607884933 % V1 < V1 && V2 != 1607884933){
		 values.put(pathCondition, 'T');
		} else {
		 Character val = values.get(pathCondition);
		 if (val.equals('F') || val.equals('U'))
		 values.put(pathCondition, 'F');
		 else
		 values.put(pathCondition, 'T');
		}
 }


 private void initFigsFigPartition_1829964687_2(Integer V1, Integer V2, Integer V3) {

		String pathCondition = "initFigsFigPartition_1829964687_2";
		if(V1 == null || V2 == null || V3 == null){
		 Character val = values.get(pathCondition);
		 if (val.equals('U'))
		 values.put(pathCondition, 'U');
		 else if (val.equals('T'))
		 values.put(pathCondition, 'T');
		 else if (val.equals('F'))
		 values.put(pathCondition, 'F');
		} else if (V1 >= 0 && 1607884933 % V1 >= 0 && 1607884933 % V1 < V1 && V2 != 1607884933 && V3 != 1607884933){
		 values.put(pathCondition, 'T');
		} else {
		 Character val = values.get(pathCondition);
		 if (val.equals('F') || val.equals('U'))
		 values.put(pathCondition, 'F');
		 else
		 values.put(pathCondition, 'T');
		}
 }


 private void initFigsFigPartition_1829964687_1(Integer V1, Integer V2, Integer V3) {

		String pathCondition = "initFigsFigPartition_1829964687_1";
		if(V1 == null || V2 == null || V3 == null){
		 Character val = values.get(pathCondition);
		 if (val.equals('U'))
		 values.put(pathCondition, 'U');
		 else if (val.equals('T'))
		 values.put(pathCondition, 'T');
		 else if (val.equals('F'))
		 values.put(pathCondition, 'F');
		} else if (V1 >= 0 && 1607884933 % V1 >= 0 && 1607884933 % V1 < V1 && V2 != 1607884933 && V3 == 1607884933){
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
