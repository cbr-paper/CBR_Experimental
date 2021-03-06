package runtime.evaluators.autogenerated;

import java.lang.ref.WeakReference;
import java.util.List;
import java.util.Iterator;

import runtime.evaluators.AtLeastOneConditionEvaluator;
public class FigPartition_1481300586 extends AtLeastOneConditionEvaluator {
	private Object currentObject;
	private String clsName;

	public FigPartition_1481300586(String clsName) {
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

						String sV4 = expression("nameFig._curText.value[nameFig._curText.offset]","char");
						Character V4 = !sV4.isEmpty() ? parseChar(sV4) : null;
						String sV2 = expression("nameFig._curText.value.length","int");
						Integer V2 = !sV2.isEmpty() ? Integer.parseInt(sV2) : null;
						String sV3 = expression("nameFig._curText.offset","int");
						Integer V3 = !sV3.isEmpty() ? Integer.parseInt(sV3) : null;
						String sV1 = expression("nameFig._curText.count","int");
						Integer V1 = !sV1.isEmpty() ? Integer.parseInt(sV1) : null;
						String sV11 = expression("nameFig._lineSpacing","int");
						Integer V11 = !sV11.isEmpty() ? Integer.parseInt(sV11) : null;
						String sV6 = expression("nameFig._rightMargin","int");
						Integer V6 = !sV6.isEmpty() ? Integer.parseInt(sV6) : null;
						String sV5 = expression("nameFig._leftMargin","int");
						Integer V5 = !sV5.isEmpty() ? Integer.parseInt(sV5) : null;
						String sV10 = expression("nameFig._botMargin","int");
						Integer V10 = !sV10.isEmpty() ? Integer.parseInt(sV10) : null;
						String sV8 = expression("nameFig._font.size","int");
						Integer V8 = !sV8.isEmpty() ? Integer.parseInt(sV8) : null;
						String sV7 = expression("nameFig._lineWidth","int");
						Integer V7 = !sV7.isEmpty() ? Integer.parseInt(sV7) : null;
						String sV9 = expression("nameFig._topMargin","int");
						Integer V9 = !sV9.isEmpty() ? Integer.parseInt(sV9) : null;

						getMinimumSizeFigPartition_1481300586_0(V1, V2);
						getMinimumSizeFigPartition_1481300586_1(V1);
						getMinimumSizeFigPartition_1481300586_3(V1);
						getMinimumSizeFigPartition_1481300586_5(V1, V2, V3, V4);
						getMinimumSizeFigPartition_1481300586_19(V6, V7, V8, V9, V10, V5);
						getMinimumSizeFigPartition_1481300586_6(V1, V2);
						getMinimumSizeFigPartition_1481300586_13(V6, V7, V8, V9, V10, V11, V1, V5);
						getMinimumSizeFigPartition_1481300586_15(V6, V7, V8, V9, V10, V11, V1, V5);
						getMinimumSizeFigPartition_1481300586_7(V1);
						getMinimumSizeFigPartition_1481300586_14(V6, V7, V8, V9, V10, V11, V1, V5);
						getMinimumSizeFigPartition_1481300586_8(V6, V7, V8, V9, V10, V11, V1, V5);
						getMinimumSizeFigPartition_1481300586_12(V6, V7, V8, V9, V10, V11, V1, V5);
						getMinimumSizeFigPartition_1481300586_2(V1);
						getMinimumSizeFigPartition_1481300586_16(V6, V7, V8, V9, V10, V5);
						getMinimumSizeFigPartition_1481300586_4(V1, V2, V3, V4);
						getMinimumSizeFigPartition_1481300586_9(V6, V7, V8, V9, V10, V11, V1, V5);
						getMinimumSizeFigPartition_1481300586_10(V6, V7, V8, V9, V10, V11, V1, V5);
						getMinimumSizeFigPartition_1481300586_11(V6, V7, V8, V9, V10, V11, V1, V5);
						getMinimumSizeFigPartition_1481300586_18(V6, V7, V8, V9, V10, V5);
						getMinimumSizeFigPartition_1481300586_17(V6, V7, V8, V9, V10, V5);
				} 
			}
		}
	}

 private void getMinimumSizeFigPartition_1481300586_0(Integer V1, Integer V2) {

		String pathCondition = "getMinimumSizeFigPartition_1481300586_0";
		if(V1 == null || V2 == null){
		 Character val = values.get(pathCondition);
		 if (val.equals('U'))
		 values.put(pathCondition, 'U');
		 else if (val.equals('T'))
		 values.put(pathCondition, 'T');
		 else if (val.equals('F'))
		 values.put(pathCondition, 'F');
		} else if (V1 >= 0 && V1 > 0 && V2 >= 0){
		 values.put(pathCondition, 'T');
		} else {
		 Character val = values.get(pathCondition);
		 if (val.equals('F') || val.equals('U'))
		 values.put(pathCondition, 'F');
		 else
		 values.put(pathCondition, 'T');
		}
 }


 private void getMinimumSizeFigPartition_1481300586_1(Integer V1) {

		String pathCondition = "getMinimumSizeFigPartition_1481300586_1";
		if(V1 == null){
		 Character val = values.get(pathCondition);
		 if (val.equals('U'))
		 values.put(pathCondition, 'U');
		 else if (val.equals('T'))
		 values.put(pathCondition, 'T');
		 else if (val.equals('F'))
		 values.put(pathCondition, 'F');
		} else if (V1 >= 0 && V1 > 0){
		 values.put(pathCondition, 'T');
		} else {
		 Character val = values.get(pathCondition);
		 if (val.equals('F') || val.equals('U'))
		 values.put(pathCondition, 'F');
		 else
		 values.put(pathCondition, 'T');
		}
 }


 private void getMinimumSizeFigPartition_1481300586_3(Integer V1) {

		String pathCondition = "getMinimumSizeFigPartition_1481300586_3";
		if(V1 == null){
		 Character val = values.get(pathCondition);
		 if (val.equals('U'))
		 values.put(pathCondition, 'U');
		 else if (val.equals('T'))
		 values.put(pathCondition, 'T');
		 else if (val.equals('F'))
		 values.put(pathCondition, 'F');
		} else if (V1 < 0){
		 values.put(pathCondition, 'T');
		} else {
		 Character val = values.get(pathCondition);
		 if (val.equals('F') || val.equals('U'))
		 values.put(pathCondition, 'F');
		 else
		 values.put(pathCondition, 'T');
		}
 }


 private void getMinimumSizeFigPartition_1481300586_5(Integer V1, Integer V2, Integer V3, Character V4) {

		String pathCondition = "getMinimumSizeFigPartition_1481300586_5";
		if(V1 == null || V2 == null || V3 == null || V4 == null){
		 Character val = values.get(pathCondition);
		 if (val.equals('U'))
		 values.put(pathCondition, 'U');
		 else if (val.equals('T'))
		 values.put(pathCondition, 'T');
		 else if (val.equals('F'))
		 values.put(pathCondition, 'F');
		} else if (V1 > 0 && V2 >= 0 && V3 >= 0 && V3 < V2 && V4 > 13){
		 values.put(pathCondition, 'T');
		} else {
		 Character val = values.get(pathCondition);
		 if (val.equals('F') || val.equals('U'))
		 values.put(pathCondition, 'F');
		 else
		 values.put(pathCondition, 'T');
		}
 }


 private void getMinimumSizeFigPartition_1481300586_19(Integer V6, Integer V7, Integer V8, Integer V9, Integer V10, Integer V5) {

		String pathCondition = "getMinimumSizeFigPartition_1481300586_19";
		if(V6 == null || V7 == null || V8 == null || V9 == null || V10 == null || V5 == null){
		 Character val = values.get(pathCondition);
		 if (val.equals('U'))
		 values.put(pathCondition, 'U');
		 else if (val.equals('T'))
		 values.put(pathCondition, 'T');
		 else if (val.equals('F'))
		 values.put(pathCondition, 'F');
		} else if (64 < 30 + V5 + V6 + 2 * V7 && 256 < V8 + V9 + V10 + 2 * V7){
		 values.put(pathCondition, 'T');
		} else {
		 Character val = values.get(pathCondition);
		 if (val.equals('F') || val.equals('U'))
		 values.put(pathCondition, 'F');
		 else
		 values.put(pathCondition, 'T');
		}
 }


 private void getMinimumSizeFigPartition_1481300586_6(Integer V1, Integer V2) {

		String pathCondition = "getMinimumSizeFigPartition_1481300586_6";
		if(V1 == null || V2 == null){
		 Character val = values.get(pathCondition);
		 if (val.equals('U'))
		 values.put(pathCondition, 'U');
		 else if (val.equals('T'))
		 values.put(pathCondition, 'T');
		 else if (val.equals('F'))
		 values.put(pathCondition, 'F');
		} else if (V1 > 0 && V2 >= 0){
		 values.put(pathCondition, 'T');
		} else {
		 Character val = values.get(pathCondition);
		 if (val.equals('F') || val.equals('U'))
		 values.put(pathCondition, 'F');
		 else
		 values.put(pathCondition, 'T');
		}
 }


 private void getMinimumSizeFigPartition_1481300586_13(Integer V6, Integer V7, Integer V8, Integer V9, Integer V10, Integer V11, Integer V1, Integer V5) {

		String pathCondition = "getMinimumSizeFigPartition_1481300586_13";
		if(V6 == null || V7 == null || V8 == null || V9 == null || V10 == null || V11 == null || V1 == null || V5 == null){
		 Character val = values.get(pathCondition);
		 if (val.equals('U'))
		 values.put(pathCondition, 'U');
		 else if (val.equals('T'))
		 values.put(pathCondition, 'T');
		 else if (val.equals('F'))
		 values.put(pathCondition, 'F');
		} else if (V1 <= 0 && V8 + V11 < V8 && 64 >= 30 + V5 + V6 + 2 * V7 && 256 < V8 + V9 + V10 + 2 * V7){
		 values.put(pathCondition, 'T');
		} else {
		 Character val = values.get(pathCondition);
		 if (val.equals('F') || val.equals('U'))
		 values.put(pathCondition, 'F');
		 else
		 values.put(pathCondition, 'T');
		}
 }


 private void getMinimumSizeFigPartition_1481300586_15(Integer V6, Integer V7, Integer V8, Integer V9, Integer V10, Integer V11, Integer V1, Integer V5) {

		String pathCondition = "getMinimumSizeFigPartition_1481300586_15";
		if(V6 == null || V7 == null || V8 == null || V9 == null || V10 == null || V11 == null || V1 == null || V5 == null){
		 Character val = values.get(pathCondition);
		 if (val.equals('U'))
		 values.put(pathCondition, 'U');
		 else if (val.equals('T'))
		 values.put(pathCondition, 'T');
		 else if (val.equals('F'))
		 values.put(pathCondition, 'F');
		} else if (V1 <= 0 && V8 + V11 < V8 && 64 < 30 + V5 + V6 + 2 * V7 && 256 < V8 + V9 + V10 + 2 * V7){
		 values.put(pathCondition, 'T');
		} else {
		 Character val = values.get(pathCondition);
		 if (val.equals('F') || val.equals('U'))
		 values.put(pathCondition, 'F');
		 else
		 values.put(pathCondition, 'T');
		}
 }


 private void getMinimumSizeFigPartition_1481300586_7(Integer V1) {

		String pathCondition = "getMinimumSizeFigPartition_1481300586_7";
		if(V1 == null){
		 Character val = values.get(pathCondition);
		 if (val.equals('U'))
		 values.put(pathCondition, 'U');
		 else if (val.equals('T'))
		 values.put(pathCondition, 'T');
		 else if (val.equals('F'))
		 values.put(pathCondition, 'F');
		} else if (V1 > 0){
		 values.put(pathCondition, 'T');
		} else {
		 Character val = values.get(pathCondition);
		 if (val.equals('F') || val.equals('U'))
		 values.put(pathCondition, 'F');
		 else
		 values.put(pathCondition, 'T');
		}
 }


 private void getMinimumSizeFigPartition_1481300586_14(Integer V6, Integer V7, Integer V8, Integer V9, Integer V10, Integer V11, Integer V1, Integer V5) {

		String pathCondition = "getMinimumSizeFigPartition_1481300586_14";
		if(V6 == null || V7 == null || V8 == null || V9 == null || V10 == null || V11 == null || V1 == null || V5 == null){
		 Character val = values.get(pathCondition);
		 if (val.equals('U'))
		 values.put(pathCondition, 'U');
		 else if (val.equals('T'))
		 values.put(pathCondition, 'T');
		 else if (val.equals('F'))
		 values.put(pathCondition, 'F');
		} else if (V1 <= 0 && V8 + V11 < V8 && 64 < 30 + V5 + V6 + 2 * V7 && 256 >= V8 + V9 + V10 + 2 * V7){
		 values.put(pathCondition, 'T');
		} else {
		 Character val = values.get(pathCondition);
		 if (val.equals('F') || val.equals('U'))
		 values.put(pathCondition, 'F');
		 else
		 values.put(pathCondition, 'T');
		}
 }


 private void getMinimumSizeFigPartition_1481300586_8(Integer V6, Integer V7, Integer V8, Integer V9, Integer V10, Integer V11, Integer V1, Integer V5) {

		String pathCondition = "getMinimumSizeFigPartition_1481300586_8";
		if(V6 == null || V7 == null || V8 == null || V9 == null || V10 == null || V11 == null || V1 == null || V5 == null){
		 Character val = values.get(pathCondition);
		 if (val.equals('U'))
		 values.put(pathCondition, 'U');
		 else if (val.equals('T'))
		 values.put(pathCondition, 'T');
		 else if (val.equals('F'))
		 values.put(pathCondition, 'F');
		} else if (V1 <= 0 && V8 + V11 >= V8 && 64 >= 30 + V5 + V6 + 2 * V7 && 256 >= V8 + V11 + V9 + V10 + 2 * V7){
		 values.put(pathCondition, 'T');
		} else {
		 Character val = values.get(pathCondition);
		 if (val.equals('F') || val.equals('U'))
		 values.put(pathCondition, 'F');
		 else
		 values.put(pathCondition, 'T');
		}
 }


 private void getMinimumSizeFigPartition_1481300586_12(Integer V6, Integer V7, Integer V8, Integer V9, Integer V10, Integer V11, Integer V1, Integer V5) {

		String pathCondition = "getMinimumSizeFigPartition_1481300586_12";
		if(V6 == null || V7 == null || V8 == null || V9 == null || V10 == null || V11 == null || V1 == null || V5 == null){
		 Character val = values.get(pathCondition);
		 if (val.equals('U'))
		 values.put(pathCondition, 'U');
		 else if (val.equals('T'))
		 values.put(pathCondition, 'T');
		 else if (val.equals('F'))
		 values.put(pathCondition, 'F');
		} else if (V1 <= 0 && V8 + V11 < V8 && 64 >= 30 + V5 + V6 + 2 * V7 && 256 >= V8 + V9 + V10 + 2 * V7){
		 values.put(pathCondition, 'T');
		} else {
		 Character val = values.get(pathCondition);
		 if (val.equals('F') || val.equals('U'))
		 values.put(pathCondition, 'F');
		 else
		 values.put(pathCondition, 'T');
		}
 }


 private void getMinimumSizeFigPartition_1481300586_2(Integer V1) {

		String pathCondition = "getMinimumSizeFigPartition_1481300586_2";
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


 private void getMinimumSizeFigPartition_1481300586_16(Integer V6, Integer V7, Integer V8, Integer V9, Integer V10, Integer V5) {

		String pathCondition = "getMinimumSizeFigPartition_1481300586_16";
		if(V6 == null || V7 == null || V8 == null || V9 == null || V10 == null || V5 == null){
		 Character val = values.get(pathCondition);
		 if (val.equals('U'))
		 values.put(pathCondition, 'U');
		 else if (val.equals('T'))
		 values.put(pathCondition, 'T');
		 else if (val.equals('F'))
		 values.put(pathCondition, 'F');
		} else if (64 >= 30 + V5 + V6 + 2 * V7 && 256 >= V8 + V9 + V10 + 2 * V7){
		 values.put(pathCondition, 'T');
		} else {
		 Character val = values.get(pathCondition);
		 if (val.equals('F') || val.equals('U'))
		 values.put(pathCondition, 'F');
		 else
		 values.put(pathCondition, 'T');
		}
 }


 private void getMinimumSizeFigPartition_1481300586_4(Integer V1, Integer V2, Integer V3, Character V4) {

		String pathCondition = "getMinimumSizeFigPartition_1481300586_4";
		if(V1 == null || V2 == null || V3 == null || V4 == null){
		 Character val = values.get(pathCondition);
		 if (val.equals('U'))
		 values.put(pathCondition, 'U');
		 else if (val.equals('T'))
		 values.put(pathCondition, 'T');
		 else if (val.equals('F'))
		 values.put(pathCondition, 'F');
		} else if (V1 > 0 && V2 >= 0 && V3 >= 0 && V3 < V2 && V4 <= 13){
		 values.put(pathCondition, 'T');
		} else {
		 Character val = values.get(pathCondition);
		 if (val.equals('F') || val.equals('U'))
		 values.put(pathCondition, 'F');
		 else
		 values.put(pathCondition, 'T');
		}
 }


 private void getMinimumSizeFigPartition_1481300586_9(Integer V6, Integer V7, Integer V8, Integer V9, Integer V10, Integer V11, Integer V1, Integer V5) {

		String pathCondition = "getMinimumSizeFigPartition_1481300586_9";
		if(V6 == null || V7 == null || V8 == null || V9 == null || V10 == null || V11 == null || V1 == null || V5 == null){
		 Character val = values.get(pathCondition);
		 if (val.equals('U'))
		 values.put(pathCondition, 'U');
		 else if (val.equals('T'))
		 values.put(pathCondition, 'T');
		 else if (val.equals('F'))
		 values.put(pathCondition, 'F');
		} else if (V1 <= 0 && V8 + V11 >= V8 && 64 >= 30 + V5 + V6 + 2 * V7 && 256 < V8 + V11 + V9 + V10 + 2 * V7){
		 values.put(pathCondition, 'T');
		} else {
		 Character val = values.get(pathCondition);
		 if (val.equals('F') || val.equals('U'))
		 values.put(pathCondition, 'F');
		 else
		 values.put(pathCondition, 'T');
		}
 }


 private void getMinimumSizeFigPartition_1481300586_10(Integer V6, Integer V7, Integer V8, Integer V9, Integer V10, Integer V11, Integer V1, Integer V5) {

		String pathCondition = "getMinimumSizeFigPartition_1481300586_10";
		if(V6 == null || V7 == null || V8 == null || V9 == null || V10 == null || V11 == null || V1 == null || V5 == null){
		 Character val = values.get(pathCondition);
		 if (val.equals('U'))
		 values.put(pathCondition, 'U');
		 else if (val.equals('T'))
		 values.put(pathCondition, 'T');
		 else if (val.equals('F'))
		 values.put(pathCondition, 'F');
		} else if (V1 <= 0 && V8 + V11 >= V8 && 64 < 30 + V5 + V6 + 2 * V7 && 256 >= V8 + V11 + V9 + V10 + 2 * V7){
		 values.put(pathCondition, 'T');
		} else {
		 Character val = values.get(pathCondition);
		 if (val.equals('F') || val.equals('U'))
		 values.put(pathCondition, 'F');
		 else
		 values.put(pathCondition, 'T');
		}
 }


 private void getMinimumSizeFigPartition_1481300586_11(Integer V6, Integer V7, Integer V8, Integer V9, Integer V10, Integer V11, Integer V1, Integer V5) {

		String pathCondition = "getMinimumSizeFigPartition_1481300586_11";
		if(V6 == null || V7 == null || V8 == null || V9 == null || V10 == null || V11 == null || V1 == null || V5 == null){
		 Character val = values.get(pathCondition);
		 if (val.equals('U'))
		 values.put(pathCondition, 'U');
		 else if (val.equals('T'))
		 values.put(pathCondition, 'T');
		 else if (val.equals('F'))
		 values.put(pathCondition, 'F');
		} else if (V1 <= 0 && V8 + V11 >= V8 && 64 < 30 + V5 + V6 + 2 * V7 && 256 < V8 + V11 + V9 + V10 + 2 * V7){
		 values.put(pathCondition, 'T');
		} else {
		 Character val = values.get(pathCondition);
		 if (val.equals('F') || val.equals('U'))
		 values.put(pathCondition, 'F');
		 else
		 values.put(pathCondition, 'T');
		}
 }


 private void getMinimumSizeFigPartition_1481300586_18(Integer V6, Integer V7, Integer V8, Integer V9, Integer V10, Integer V5) {

		String pathCondition = "getMinimumSizeFigPartition_1481300586_18";
		if(V6 == null || V7 == null || V8 == null || V9 == null || V10 == null || V5 == null){
		 Character val = values.get(pathCondition);
		 if (val.equals('U'))
		 values.put(pathCondition, 'U');
		 else if (val.equals('T'))
		 values.put(pathCondition, 'T');
		 else if (val.equals('F'))
		 values.put(pathCondition, 'F');
		} else if (64 < 30 + V5 + V6 + 2 * V7 && 256 >= V8 + V9 + V10 + 2 * V7){
		 values.put(pathCondition, 'T');
		} else {
		 Character val = values.get(pathCondition);
		 if (val.equals('F') || val.equals('U'))
		 values.put(pathCondition, 'F');
		 else
		 values.put(pathCondition, 'T');
		}
 }


 private void getMinimumSizeFigPartition_1481300586_17(Integer V6, Integer V7, Integer V8, Integer V9, Integer V10, Integer V5) {

		String pathCondition = "getMinimumSizeFigPartition_1481300586_17";
		if(V6 == null || V7 == null || V8 == null || V9 == null || V10 == null || V5 == null){
		 Character val = values.get(pathCondition);
		 if (val.equals('U'))
		 values.put(pathCondition, 'U');
		 else if (val.equals('T'))
		 values.put(pathCondition, 'T');
		 else if (val.equals('F'))
		 values.put(pathCondition, 'F');
		} else if (64 >= 30 + V5 + V6 + 2 * V7 && 256 < V8 + V9 + V10 + 2 * V7){
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
