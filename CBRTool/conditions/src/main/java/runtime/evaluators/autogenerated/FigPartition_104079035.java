package runtime.evaluators.autogenerated;

import java.lang.ref.WeakReference;
import java.util.List;
import java.util.Iterator;

import runtime.evaluators.AtLeastOneConditionEvaluator;
public class FigPartition_104079035 extends AtLeastOneConditionEvaluator {
	private Object currentObject;
	private String clsName;

	public FigPartition_104079035(String clsName) {
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

						String sV3 = expression("[java.lang.AbstractStringBuilder.sizeTable.length","int");
						Integer V3 = !sV3.isEmpty() ? Integer.parseInt(sV3) : null;
						String sV4 = expression("[java.lang.AbstractStringBuilder.sizeTable[0]","int");
						Integer V4 = !sV4.isEmpty() ? Integer.parseInt(sV4) : null;
						String sV6 = expression("[java.lang.AbstractStringBuilder.sizeTable[1]","int");
						Integer V6 = !sV6.isEmpty() ? Integer.parseInt(sV6) : null;
						String sV5 = expression("layer.contents.elementData.length","int");
						Integer V5 = !sV5.isEmpty() ? Integer.parseInt(sV5) : null;
						String sV1 = expression("layer.contents.a.length","int");
						Integer V1 = !sV1.isEmpty() ? Integer.parseInt(sV1) : null;
						String sV2 = expression("layer.contents.size","int");
						Integer V2 = !sV2.isEmpty() ? Integer.parseInt(sV2) : null;

						appendToPoolFigPartition_104079035_10(V1);
						appendToPoolFigPartition_104079035_4(V2, V3);
						appendToPoolFigPartition_104079035_11(V1);
						appendToPoolFigPartition_104079035_13(V1);
						appendToPoolFigPartition_104079035_14(V1);
						appendToPoolFigPartition_104079035_3(V2, V3, V4);
						appendToPoolFigPartition_104079035_7(V2, V5);
						appendToPoolFigPartition_104079035_9(V2);
						appendToPoolFigPartition_104079035_1(V6, V2, V3, V4);
						appendToPoolFigPartition_104079035_2(V6, V2, V3, V4);
						appendToPoolFigPartition_104079035_5(V2);
						appendToPoolFigPartition_104079035_12(V1);
						appendToPoolFigPartition_104079035_6(V2, V5);
						appendToPoolFigPartition_104079035_0(V2, V3, V4);
						appendToPoolFigPartition_104079035_15(V1);
						appendToPoolFigPartition_104079035_8(V2);
				} 
			}
		}
	}

 private void appendToPoolFigPartition_104079035_10(Integer V1) {

		String pathCondition = "appendToPoolFigPartition_104079035_10";
		if(V1 == null){
		 Character val = values.get(pathCondition);
		 if (val.equals('U'))
		 values.put(pathCondition, 'U');
		 else if (val.equals('T'))
		 values.put(pathCondition, 'T');
		 else if (val.equals('F'))
		 values.put(pathCondition, 'F');
		} else if (V1 >= 0 && V1 != 0 && true){
		 values.put(pathCondition, 'T');
		} else {
		 Character val = values.get(pathCondition);
		 if (val.equals('F') || val.equals('U'))
		 values.put(pathCondition, 'F');
		 else
		 values.put(pathCondition, 'T');
		}
 }


 private void appendToPoolFigPartition_104079035_4(Integer V2, Integer V3) {

		String pathCondition = "appendToPoolFigPartition_104079035_4";
		if(V2 == null || V3 == null){
		 Character val = values.get(pathCondition);
		 if (val.equals('U'))
		 values.put(pathCondition, 'U');
		 else if (val.equals('T'))
		 values.put(pathCondition, 'T');
		 else if (val.equals('F'))
		 values.put(pathCondition, 'F');
		} else if (V2 != 0 && V2 <= 0 && V3 >= 0 && V3 <= 0){
		 values.put(pathCondition, 'T');
		} else {
		 Character val = values.get(pathCondition);
		 if (val.equals('F') || val.equals('U'))
		 values.put(pathCondition, 'F');
		 else
		 values.put(pathCondition, 'T');
		}
 }


 private void appendToPoolFigPartition_104079035_11(Integer V1) {

		String pathCondition = "appendToPoolFigPartition_104079035_11";
		if(V1 == null){
		 Character val = values.get(pathCondition);
		 if (val.equals('U'))
		 values.put(pathCondition, 'U');
		 else if (val.equals('T'))
		 values.put(pathCondition, 'T');
		 else if (val.equals('F'))
		 values.put(pathCondition, 'F');
		} else if (V1 >= 0 && V1 != 0 && true && 1 != V1 && 1 < V1){
		 values.put(pathCondition, 'T');
		} else {
		 Character val = values.get(pathCondition);
		 if (val.equals('F') || val.equals('U'))
		 values.put(pathCondition, 'F');
		 else
		 values.put(pathCondition, 'T');
		}
 }


 private void appendToPoolFigPartition_104079035_13(Integer V1) {

		String pathCondition = "appendToPoolFigPartition_104079035_13";
		if(V1 == null){
		 Character val = values.get(pathCondition);
		 if (val.equals('U'))
		 values.put(pathCondition, 'U');
		 else if (val.equals('T'))
		 values.put(pathCondition, 'T');
		 else if (val.equals('F'))
		 values.put(pathCondition, 'F');
		} else if (V1 >= 0 && V1 != 0 && true && 1 != V1 && 1 < V1 && 2 == V1){
		 values.put(pathCondition, 'T');
		} else {
		 Character val = values.get(pathCondition);
		 if (val.equals('F') || val.equals('U'))
		 values.put(pathCondition, 'F');
		 else
		 values.put(pathCondition, 'T');
		}
 }


 private void appendToPoolFigPartition_104079035_14(Integer V1) {

		String pathCondition = "appendToPoolFigPartition_104079035_14";
		if(V1 == null){
		 Character val = values.get(pathCondition);
		 if (val.equals('U'))
		 values.put(pathCondition, 'U');
		 else if (val.equals('T'))
		 values.put(pathCondition, 'T');
		 else if (val.equals('F'))
		 values.put(pathCondition, 'F');
		} else if (V1 >= 0 && V1 != 0 && true && 1 == V1){
		 values.put(pathCondition, 'T');
		} else {
		 Character val = values.get(pathCondition);
		 if (val.equals('F') || val.equals('U'))
		 values.put(pathCondition, 'F');
		 else
		 values.put(pathCondition, 'T');
		}
 }


 private void appendToPoolFigPartition_104079035_3(Integer V2, Integer V3, Integer V4) {

		String pathCondition = "appendToPoolFigPartition_104079035_3";
		if(V2 == null || V3 == null || V4 == null){
		 Character val = values.get(pathCondition);
		 if (val.equals('U'))
		 values.put(pathCondition, 'U');
		 else if (val.equals('T'))
		 values.put(pathCondition, 'T');
		 else if (val.equals('F'))
		 values.put(pathCondition, 'F');
		} else if (V2 != 0 && V2 <= 0 && V3 >= 0 && V3 > 0 && V4 < 0 && 1 >= V3){
		 values.put(pathCondition, 'T');
		} else {
		 Character val = values.get(pathCondition);
		 if (val.equals('F') || val.equals('U'))
		 values.put(pathCondition, 'F');
		 else
		 values.put(pathCondition, 'T');
		}
 }


 private void appendToPoolFigPartition_104079035_7(Integer V2, Integer V5) {

		String pathCondition = "appendToPoolFigPartition_104079035_7";
		if(V2 == null || V5 == null){
		 Character val = values.get(pathCondition);
		 if (val.equals('U'))
		 values.put(pathCondition, 'U');
		 else if (val.equals('T'))
		 values.put(pathCondition, 'T');
		 else if (val.equals('F'))
		 values.put(pathCondition, 'F');
		} else if (V2 != 0 && V2 > 0 && V5 >= 0 && V5 <= 0){
		 values.put(pathCondition, 'T');
		} else {
		 Character val = values.get(pathCondition);
		 if (val.equals('F') || val.equals('U'))
		 values.put(pathCondition, 'F');
		 else
		 values.put(pathCondition, 'T');
		}
 }


 private void appendToPoolFigPartition_104079035_9(Integer V2) {

		String pathCondition = "appendToPoolFigPartition_104079035_9";
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


 private void appendToPoolFigPartition_104079035_1(Integer V6, Integer V2, Integer V3, Integer V4) {

		String pathCondition = "appendToPoolFigPartition_104079035_1";
		if(V6 == null || V2 == null || V3 == null || V4 == null){
		 Character val = values.get(pathCondition);
		 if (val.equals('U'))
		 values.put(pathCondition, 'U');
		 else if (val.equals('T'))
		 values.put(pathCondition, 'T');
		 else if (val.equals('F'))
		 values.put(pathCondition, 'F');
		} else if (V2 != 0 && V2 <= 0 && V3 >= 0 && V3 > 0 && V4 < 0 && 1 < V3 && V6 >= 0){
		 values.put(pathCondition, 'T');
		} else {
		 Character val = values.get(pathCondition);
		 if (val.equals('F') || val.equals('U'))
		 values.put(pathCondition, 'F');
		 else
		 values.put(pathCondition, 'T');
		}
 }


 private void appendToPoolFigPartition_104079035_2(Integer V6, Integer V2, Integer V3, Integer V4) {

		String pathCondition = "appendToPoolFigPartition_104079035_2";
		if(V6 == null || V2 == null || V3 == null || V4 == null){
		 Character val = values.get(pathCondition);
		 if (val.equals('U'))
		 values.put(pathCondition, 'U');
		 else if (val.equals('T'))
		 values.put(pathCondition, 'T');
		 else if (val.equals('F'))
		 values.put(pathCondition, 'F');
		} else if (V2 != 0 && V2 <= 0 && V3 >= 0 && V3 > 0 && V4 < 0 && 1 < V3 && V6 < 0){
		 values.put(pathCondition, 'T');
		} else {
		 Character val = values.get(pathCondition);
		 if (val.equals('F') || val.equals('U'))
		 values.put(pathCondition, 'F');
		 else
		 values.put(pathCondition, 'T');
		}
 }


 private void appendToPoolFigPartition_104079035_5(Integer V2) {

		String pathCondition = "appendToPoolFigPartition_104079035_5";
		if(V2 == null){
		 Character val = values.get(pathCondition);
		 if (val.equals('U'))
		 values.put(pathCondition, 'U');
		 else if (val.equals('T'))
		 values.put(pathCondition, 'T');
		 else if (val.equals('F'))
		 values.put(pathCondition, 'F');
		} else if (V2 != 0 && V2 <= 0){
		 values.put(pathCondition, 'T');
		} else {
		 Character val = values.get(pathCondition);
		 if (val.equals('F') || val.equals('U'))
		 values.put(pathCondition, 'F');
		 else
		 values.put(pathCondition, 'T');
		}
 }


 private void appendToPoolFigPartition_104079035_12(Integer V1) {

		String pathCondition = "appendToPoolFigPartition_104079035_12";
		if(V1 == null){
		 Character val = values.get(pathCondition);
		 if (val.equals('U'))
		 values.put(pathCondition, 'U');
		 else if (val.equals('T'))
		 values.put(pathCondition, 'T');
		 else if (val.equals('F'))
		 values.put(pathCondition, 'F');
		} else if (V1 >= 0 && V1 != 0 && true && 1 != V1 && 1 < V1 && 2 != V1){
		 values.put(pathCondition, 'T');
		} else {
		 Character val = values.get(pathCondition);
		 if (val.equals('F') || val.equals('U'))
		 values.put(pathCondition, 'F');
		 else
		 values.put(pathCondition, 'T');
		}
 }


 private void appendToPoolFigPartition_104079035_6(Integer V2, Integer V5) {

		String pathCondition = "appendToPoolFigPartition_104079035_6";
		if(V2 == null || V5 == null){
		 Character val = values.get(pathCondition);
		 if (val.equals('U'))
		 values.put(pathCondition, 'U');
		 else if (val.equals('T'))
		 values.put(pathCondition, 'T');
		 else if (val.equals('F'))
		 values.put(pathCondition, 'F');
		} else if (V2 != 0 && V2 > 0 && V5 >= 0 && V5 > 0){
		 values.put(pathCondition, 'T');
		} else {
		 Character val = values.get(pathCondition);
		 if (val.equals('F') || val.equals('U'))
		 values.put(pathCondition, 'F');
		 else
		 values.put(pathCondition, 'T');
		}
 }


 private void appendToPoolFigPartition_104079035_0(Integer V2, Integer V3, Integer V4) {

		String pathCondition = "appendToPoolFigPartition_104079035_0";
		if(V2 == null || V3 == null || V4 == null){
		 Character val = values.get(pathCondition);
		 if (val.equals('U'))
		 values.put(pathCondition, 'U');
		 else if (val.equals('T'))
		 values.put(pathCondition, 'T');
		 else if (val.equals('F'))
		 values.put(pathCondition, 'F');
		} else if (V2 != 0 && V2 <= 0 && V3 >= 0 && V3 > 0 && V4 >= 0){
		 values.put(pathCondition, 'T');
		} else {
		 Character val = values.get(pathCondition);
		 if (val.equals('F') || val.equals('U'))
		 values.put(pathCondition, 'F');
		 else
		 values.put(pathCondition, 'T');
		}
 }


 private void appendToPoolFigPartition_104079035_15(Integer V1) {

		String pathCondition = "appendToPoolFigPartition_104079035_15";
		if(V1 == null){
		 Character val = values.get(pathCondition);
		 if (val.equals('U'))
		 values.put(pathCondition, 'U');
		 else if (val.equals('T'))
		 values.put(pathCondition, 'T');
		 else if (val.equals('F'))
		 values.put(pathCondition, 'F');
		} else if (V1 >= 0 && V1 == 0){
		 values.put(pathCondition, 'T');
		} else {
		 Character val = values.get(pathCondition);
		 if (val.equals('F') || val.equals('U'))
		 values.put(pathCondition, 'F');
		 else
		 values.put(pathCondition, 'T');
		}
 }


 private void appendToPoolFigPartition_104079035_8(Integer V2) {

		String pathCondition = "appendToPoolFigPartition_104079035_8";
		if(V2 == null){
		 Character val = values.get(pathCondition);
		 if (val.equals('U'))
		 values.put(pathCondition, 'U');
		 else if (val.equals('T'))
		 values.put(pathCondition, 'T');
		 else if (val.equals('F'))
		 values.put(pathCondition, 'F');
		} else if (V2 != 0 && V2 > 0){
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