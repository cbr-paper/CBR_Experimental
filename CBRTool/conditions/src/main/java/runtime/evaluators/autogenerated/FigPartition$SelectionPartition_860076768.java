package runtime.evaluators.autogenerated;

import java.lang.ref.WeakReference;
import java.util.List;
import java.util.Iterator;

import runtime.evaluators.AtLeastOneConditionEvaluator;
public class FigPartition$SelectionPartition_860076768 extends AtLeastOneConditionEvaluator {
	private Object currentObject;
	private String clsName;

	public FigPartition$SelectionPartition_860076768(String clsName) {
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

						String sV7 = expression("content.routeFig.routeFig.routeFig.routeFig.routeFig.routeFig._pathItems.elementCount","int");
						Integer V7 = !sV7.isEmpty() ? Integer.parseInt(sV7) : null;
						String sV10 = expression("content.routeFig.routeFig.routeFig.routeFig.routeFig._pathItems.elementCount","int");
						Integer V10 = !sV10.isEmpty() ? Integer.parseInt(sV10) : null;
						String sV2 = expression("content.routeFig.routeFig.routeFig.routeFig._pathItems.elementData.length","int");
						Integer V2 = !sV2.isEmpty() ? Integer.parseInt(sV2) : null;
						String sV1 = expression("content.routeFig.routeFig.routeFig.routeFig._pathItems.elementCount","int");
						Integer V1 = !sV1.isEmpty() ? Integer.parseInt(sV1) : null;
						String sV13 = expression("content.routeFig.routeFig.routeFig._pathItems.elementData.length","int");
						Integer V13 = !sV13.isEmpty() ? Integer.parseInt(sV13) : null;
						String sV9 = expression("content.routeFig.routeFig.routeFig._pathItems.elementCount","int");
						Integer V9 = !sV9.isEmpty() ? Integer.parseInt(sV9) : null;
						String sV12 = expression("content.routeFig.routeFig._pathItems.elementData.length","int");
						Integer V12 = !sV12.isEmpty() ? Integer.parseInt(sV12) : null;
						String sV6 = expression("[java.lang.AbstractStringBuilder.sizeTable.length","int");
						Integer V6 = !sV6.isEmpty() ? Integer.parseInt(sV6) : null;
						String sV8 = expression("content.routeFig.routeFig._pathItems.elementCount","int");
						Integer V8 = !sV8.isEmpty() ? Integer.parseInt(sV8) : null;
						String sV11 = expression("content.routeFig._pathItems.elementData.length","int");
						Integer V11 = !sV11.isEmpty() ? Integer.parseInt(sV11) : null;
						String sV3 = expression("content.routeFig._pathItems.elementCount","int");
						Integer V3 = !sV3.isEmpty() ? Integer.parseInt(sV3) : null;
						String sV5 = expression("content._pathItems.elementData.length","int");
						Integer V5 = !sV5.isEmpty() ? Integer.parseInt(sV5) : null;
						String sV4 = expression("content._pathItems.elementCount","int");
						Integer V4 = !sV4.isEmpty() ? Integer.parseInt(sV4) : null;

						updateHandleBoxFigPartition$SelectionPartition_860076768_30(V1, V2);
						updateHandleBoxFigPartition$SelectionPartition_860076768_7(V3, V4, V5);
						updateHandleBoxFigPartition$SelectionPartition_860076768_11(V6, V3);
						updateHandleBoxFigPartition$SelectionPartition_860076768_13(V3);
						updateHandleBoxFigPartition$SelectionPartition_860076768_37(V7);
						updateHandleBoxFigPartition$SelectionPartition_860076768_2(V4);
						updateHandleBoxFigPartition$SelectionPartition_860076768_38(V7);
						updateHandleBoxFigPartition$SelectionPartition_860076768_22(V6, V8);
						updateHandleBoxFigPartition$SelectionPartition_860076768_28(V8, V9);
						updateHandleBoxFigPartition$SelectionPartition_860076768_26(V9);
						updateHandleBoxFigPartition$SelectionPartition_860076768_9(V3, V4);
						updateHandleBoxFigPartition$SelectionPartition_860076768_21(V8, V3);
						updateHandleBoxFigPartition$SelectionPartition_860076768_36(V10);
						updateHandleBoxFigPartition$SelectionPartition_860076768_1(V4, V5);
						updateHandleBoxFigPartition$SelectionPartition_860076768_4(V11, V3);
						updateHandleBoxFigPartition$SelectionPartition_860076768_12(V6, V3);
						updateHandleBoxFigPartition$SelectionPartition_860076768_0(V4, V5);
						updateHandleBoxFigPartition$SelectionPartition_860076768_3(V4);
						updateHandleBoxFigPartition$SelectionPartition_860076768_35(V10);
						updateHandleBoxFigPartition$SelectionPartition_860076768_33(V9, V1);
						updateHandleBoxFigPartition$SelectionPartition_860076768_10(V3, V4);
						updateHandleBoxFigPartition$SelectionPartition_860076768_19(V8, V3, V4);
						updateHandleBoxFigPartition$SelectionPartition_860076768_14(V8, V12);
						updateHandleBoxFigPartition$SelectionPartition_860076768_29(V9);
						updateHandleBoxFigPartition$SelectionPartition_860076768_24(V9, V13);
						updateHandleBoxFigPartition$SelectionPartition_860076768_18(V8, V3);
						updateHandleBoxFigPartition$SelectionPartition_860076768_16(V8);
						updateHandleBoxFigPartition$SelectionPartition_860076768_5(V11, V3);
						updateHandleBoxFigPartition$SelectionPartition_860076768_31(V1);
						updateHandleBoxFigPartition$SelectionPartition_860076768_6(V3);
						updateHandleBoxFigPartition$SelectionPartition_860076768_15(V8, V12);
						updateHandleBoxFigPartition$SelectionPartition_860076768_20(V8, V3, V4);
						updateHandleBoxFigPartition$SelectionPartition_860076768_32(V9, V1);
						updateHandleBoxFigPartition$SelectionPartition_860076768_8(V3, V4, V5);
						updateHandleBoxFigPartition$SelectionPartition_860076768_25(V9, V13);
						updateHandleBoxFigPartition$SelectionPartition_860076768_27(V8, V9);
						updateHandleBoxFigPartition$SelectionPartition_860076768_17(V8, V11, V3);
						updateHandleBoxFigPartition$SelectionPartition_860076768_23(V8);
						updateHandleBoxFigPartition$SelectionPartition_860076768_34(V1);
				} 
			}
		}
	}

 private void updateHandleBoxFigPartition$SelectionPartition_860076768_30(Integer V1, Integer V2) {

		String pathCondition = "updateHandleBoxFigPartition$SelectionPartition_860076768_30";
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


 private void updateHandleBoxFigPartition$SelectionPartition_860076768_7(Integer V3, Integer V4, Integer V5) {

		String pathCondition = "updateHandleBoxFigPartition$SelectionPartition_860076768_7";
		if(V3 == null || V4 == null || V5 == null){
		 Character val = values.get(pathCondition);
		 if (val.equals('U'))
		 values.put(pathCondition, 'U');
		 else if (val.equals('T'))
		 values.put(pathCondition, 'T');
		 else if (val.equals('F'))
		 values.put(pathCondition, 'F');
		} else if (V3 <= 0 && V4 > 0 && V5 >= 0 && V5 > 0){
		 values.put(pathCondition, 'T');
		} else {
		 Character val = values.get(pathCondition);
		 if (val.equals('F') || val.equals('U'))
		 values.put(pathCondition, 'F');
		 else
		 values.put(pathCondition, 'T');
		}
 }


 private void updateHandleBoxFigPartition$SelectionPartition_860076768_11(Integer V6, Integer V3) {

		String pathCondition = "updateHandleBoxFigPartition$SelectionPartition_860076768_11";
		if(V6 == null || V3 == null){
		 Character val = values.get(pathCondition);
		 if (val.equals('U'))
		 values.put(pathCondition, 'U');
		 else if (val.equals('T'))
		 values.put(pathCondition, 'T');
		 else if (val.equals('F'))
		 values.put(pathCondition, 'F');
		} else if (V3 <= 0 && V6 >= 0 && V6 > 0){
		 values.put(pathCondition, 'T');
		} else {
		 Character val = values.get(pathCondition);
		 if (val.equals('F') || val.equals('U'))
		 values.put(pathCondition, 'F');
		 else
		 values.put(pathCondition, 'T');
		}
 }


 private void updateHandleBoxFigPartition$SelectionPartition_860076768_13(Integer V3) {

		String pathCondition = "updateHandleBoxFigPartition$SelectionPartition_860076768_13";
		if(V3 == null){
		 Character val = values.get(pathCondition);
		 if (val.equals('U'))
		 values.put(pathCondition, 'U');
		 else if (val.equals('T'))
		 values.put(pathCondition, 'T');
		 else if (val.equals('F'))
		 values.put(pathCondition, 'F');
		} else if (V3 <= 0){
		 values.put(pathCondition, 'T');
		} else {
		 Character val = values.get(pathCondition);
		 if (val.equals('F') || val.equals('U'))
		 values.put(pathCondition, 'F');
		 else
		 values.put(pathCondition, 'T');
		}
 }


 private void updateHandleBoxFigPartition$SelectionPartition_860076768_37(Integer V7) {

		String pathCondition = "updateHandleBoxFigPartition$SelectionPartition_860076768_37";
		if(V7 == null){
		 Character val = values.get(pathCondition);
		 if (val.equals('U'))
		 values.put(pathCondition, 'U');
		 else if (val.equals('T'))
		 values.put(pathCondition, 'T');
		 else if (val.equals('F'))
		 values.put(pathCondition, 'F');
		} else if (V7 > 0){
		 values.put(pathCondition, 'T');
		} else {
		 Character val = values.get(pathCondition);
		 if (val.equals('F') || val.equals('U'))
		 values.put(pathCondition, 'F');
		 else
		 values.put(pathCondition, 'T');
		}
 }


 private void updateHandleBoxFigPartition$SelectionPartition_860076768_2(Integer V4) {

		String pathCondition = "updateHandleBoxFigPartition$SelectionPartition_860076768_2";
		if(V4 == null){
		 Character val = values.get(pathCondition);
		 if (val.equals('U'))
		 values.put(pathCondition, 'U');
		 else if (val.equals('T'))
		 values.put(pathCondition, 'T');
		 else if (val.equals('F'))
		 values.put(pathCondition, 'F');
		} else if (V4 > 0){
		 values.put(pathCondition, 'T');
		} else {
		 Character val = values.get(pathCondition);
		 if (val.equals('F') || val.equals('U'))
		 values.put(pathCondition, 'F');
		 else
		 values.put(pathCondition, 'T');
		}
 }


 private void updateHandleBoxFigPartition$SelectionPartition_860076768_38(Integer V7) {

		String pathCondition = "updateHandleBoxFigPartition$SelectionPartition_860076768_38";
		if(V7 == null){
		 Character val = values.get(pathCondition);
		 if (val.equals('U'))
		 values.put(pathCondition, 'U');
		 else if (val.equals('T'))
		 values.put(pathCondition, 'T');
		 else if (val.equals('F'))
		 values.put(pathCondition, 'F');
		} else if (V7 <= 0){
		 values.put(pathCondition, 'T');
		} else {
		 Character val = values.get(pathCondition);
		 if (val.equals('F') || val.equals('U'))
		 values.put(pathCondition, 'F');
		 else
		 values.put(pathCondition, 'T');
		}
 }


 private void updateHandleBoxFigPartition$SelectionPartition_860076768_22(Integer V6, Integer V8) {

		String pathCondition = "updateHandleBoxFigPartition$SelectionPartition_860076768_22";
		if(V6 == null || V8 == null){
		 Character val = values.get(pathCondition);
		 if (val.equals('U'))
		 values.put(pathCondition, 'U');
		 else if (val.equals('T'))
		 values.put(pathCondition, 'T');
		 else if (val.equals('F'))
		 values.put(pathCondition, 'F');
		} else if (V8 <= 0 && V6 >= 0){
		 values.put(pathCondition, 'T');
		} else {
		 Character val = values.get(pathCondition);
		 if (val.equals('F') || val.equals('U'))
		 values.put(pathCondition, 'F');
		 else
		 values.put(pathCondition, 'T');
		}
 }


 private void updateHandleBoxFigPartition$SelectionPartition_860076768_28(Integer V8, Integer V9) {

		String pathCondition = "updateHandleBoxFigPartition$SelectionPartition_860076768_28";
		if(V8 == null || V9 == null){
		 Character val = values.get(pathCondition);
		 if (val.equals('U'))
		 values.put(pathCondition, 'U');
		 else if (val.equals('T'))
		 values.put(pathCondition, 'T');
		 else if (val.equals('F'))
		 values.put(pathCondition, 'F');
		} else if (V9 <= 0 && V8 <= 0){
		 values.put(pathCondition, 'T');
		} else {
		 Character val = values.get(pathCondition);
		 if (val.equals('F') || val.equals('U'))
		 values.put(pathCondition, 'F');
		 else
		 values.put(pathCondition, 'T');
		}
 }


 private void updateHandleBoxFigPartition$SelectionPartition_860076768_26(Integer V9) {

		String pathCondition = "updateHandleBoxFigPartition$SelectionPartition_860076768_26";
		if(V9 == null){
		 Character val = values.get(pathCondition);
		 if (val.equals('U'))
		 values.put(pathCondition, 'U');
		 else if (val.equals('T'))
		 values.put(pathCondition, 'T');
		 else if (val.equals('F'))
		 values.put(pathCondition, 'F');
		} else if (V9 > 0){
		 values.put(pathCondition, 'T');
		} else {
		 Character val = values.get(pathCondition);
		 if (val.equals('F') || val.equals('U'))
		 values.put(pathCondition, 'F');
		 else
		 values.put(pathCondition, 'T');
		}
 }


 private void updateHandleBoxFigPartition$SelectionPartition_860076768_9(Integer V3, Integer V4) {

		String pathCondition = "updateHandleBoxFigPartition$SelectionPartition_860076768_9";
		if(V3 == null || V4 == null){
		 Character val = values.get(pathCondition);
		 if (val.equals('U'))
		 values.put(pathCondition, 'U');
		 else if (val.equals('T'))
		 values.put(pathCondition, 'T');
		 else if (val.equals('F'))
		 values.put(pathCondition, 'F');
		} else if (V3 <= 0 && V4 > 0){
		 values.put(pathCondition, 'T');
		} else {
		 Character val = values.get(pathCondition);
		 if (val.equals('F') || val.equals('U'))
		 values.put(pathCondition, 'F');
		 else
		 values.put(pathCondition, 'T');
		}
 }


 private void updateHandleBoxFigPartition$SelectionPartition_860076768_21(Integer V8, Integer V3) {

		String pathCondition = "updateHandleBoxFigPartition$SelectionPartition_860076768_21";
		if(V8 == null || V3 == null){
		 Character val = values.get(pathCondition);
		 if (val.equals('U'))
		 values.put(pathCondition, 'U');
		 else if (val.equals('T'))
		 values.put(pathCondition, 'T');
		 else if (val.equals('F'))
		 values.put(pathCondition, 'F');
		} else if (V8 <= 0 && V3 <= 0){
		 values.put(pathCondition, 'T');
		} else {
		 Character val = values.get(pathCondition);
		 if (val.equals('F') || val.equals('U'))
		 values.put(pathCondition, 'F');
		 else
		 values.put(pathCondition, 'T');
		}
 }


 private void updateHandleBoxFigPartition$SelectionPartition_860076768_36(Integer V10) {

		String pathCondition = "updateHandleBoxFigPartition$SelectionPartition_860076768_36";
		if(V10 == null){
		 Character val = values.get(pathCondition);
		 if (val.equals('U'))
		 values.put(pathCondition, 'U');
		 else if (val.equals('T'))
		 values.put(pathCondition, 'T');
		 else if (val.equals('F'))
		 values.put(pathCondition, 'F');
		} else if (V10 <= 0){
		 values.put(pathCondition, 'T');
		} else {
		 Character val = values.get(pathCondition);
		 if (val.equals('F') || val.equals('U'))
		 values.put(pathCondition, 'F');
		 else
		 values.put(pathCondition, 'T');
		}
 }


 private void updateHandleBoxFigPartition$SelectionPartition_860076768_1(Integer V4, Integer V5) {

		String pathCondition = "updateHandleBoxFigPartition$SelectionPartition_860076768_1";
		if(V4 == null || V5 == null){
		 Character val = values.get(pathCondition);
		 if (val.equals('U'))
		 values.put(pathCondition, 'U');
		 else if (val.equals('T'))
		 values.put(pathCondition, 'T');
		 else if (val.equals('F'))
		 values.put(pathCondition, 'F');
		} else if (V4 > 0 && V5 >= 0 && V5 <= 0){
		 values.put(pathCondition, 'T');
		} else {
		 Character val = values.get(pathCondition);
		 if (val.equals('F') || val.equals('U'))
		 values.put(pathCondition, 'F');
		 else
		 values.put(pathCondition, 'T');
		}
 }


 private void updateHandleBoxFigPartition$SelectionPartition_860076768_4(Integer V11, Integer V3) {

		String pathCondition = "updateHandleBoxFigPartition$SelectionPartition_860076768_4";
		if(V11 == null || V3 == null){
		 Character val = values.get(pathCondition);
		 if (val.equals('U'))
		 values.put(pathCondition, 'U');
		 else if (val.equals('T'))
		 values.put(pathCondition, 'T');
		 else if (val.equals('F'))
		 values.put(pathCondition, 'F');
		} else if (V3 > 0 && V11 >= 0 && V11 > 0){
		 values.put(pathCondition, 'T');
		} else {
		 Character val = values.get(pathCondition);
		 if (val.equals('F') || val.equals('U'))
		 values.put(pathCondition, 'F');
		 else
		 values.put(pathCondition, 'T');
		}
 }


 private void updateHandleBoxFigPartition$SelectionPartition_860076768_12(Integer V6, Integer V3) {

		String pathCondition = "updateHandleBoxFigPartition$SelectionPartition_860076768_12";
		if(V6 == null || V3 == null){
		 Character val = values.get(pathCondition);
		 if (val.equals('U'))
		 values.put(pathCondition, 'U');
		 else if (val.equals('T'))
		 values.put(pathCondition, 'T');
		 else if (val.equals('F'))
		 values.put(pathCondition, 'F');
		} else if (V3 <= 0 && V6 >= 0 && V6 <= 0){
		 values.put(pathCondition, 'T');
		} else {
		 Character val = values.get(pathCondition);
		 if (val.equals('F') || val.equals('U'))
		 values.put(pathCondition, 'F');
		 else
		 values.put(pathCondition, 'T');
		}
 }


 private void updateHandleBoxFigPartition$SelectionPartition_860076768_0(Integer V4, Integer V5) {

		String pathCondition = "updateHandleBoxFigPartition$SelectionPartition_860076768_0";
		if(V4 == null || V5 == null){
		 Character val = values.get(pathCondition);
		 if (val.equals('U'))
		 values.put(pathCondition, 'U');
		 else if (val.equals('T'))
		 values.put(pathCondition, 'T');
		 else if (val.equals('F'))
		 values.put(pathCondition, 'F');
		} else if (V4 > 0 && V5 >= 0 && V5 > 0){
		 values.put(pathCondition, 'T');
		} else {
		 Character val = values.get(pathCondition);
		 if (val.equals('F') || val.equals('U'))
		 values.put(pathCondition, 'F');
		 else
		 values.put(pathCondition, 'T');
		}
 }


 private void updateHandleBoxFigPartition$SelectionPartition_860076768_3(Integer V4) {

		String pathCondition = "updateHandleBoxFigPartition$SelectionPartition_860076768_3";
		if(V4 == null){
		 Character val = values.get(pathCondition);
		 if (val.equals('U'))
		 values.put(pathCondition, 'U');
		 else if (val.equals('T'))
		 values.put(pathCondition, 'T');
		 else if (val.equals('F'))
		 values.put(pathCondition, 'F');
		} else if (V4 <= 0){
		 values.put(pathCondition, 'T');
		} else {
		 Character val = values.get(pathCondition);
		 if (val.equals('F') || val.equals('U'))
		 values.put(pathCondition, 'F');
		 else
		 values.put(pathCondition, 'T');
		}
 }


 private void updateHandleBoxFigPartition$SelectionPartition_860076768_35(Integer V10) {

		String pathCondition = "updateHandleBoxFigPartition$SelectionPartition_860076768_35";
		if(V10 == null){
		 Character val = values.get(pathCondition);
		 if (val.equals('U'))
		 values.put(pathCondition, 'U');
		 else if (val.equals('T'))
		 values.put(pathCondition, 'T');
		 else if (val.equals('F'))
		 values.put(pathCondition, 'F');
		} else if (V10 > 0){
		 values.put(pathCondition, 'T');
		} else {
		 Character val = values.get(pathCondition);
		 if (val.equals('F') || val.equals('U'))
		 values.put(pathCondition, 'F');
		 else
		 values.put(pathCondition, 'T');
		}
 }


 private void updateHandleBoxFigPartition$SelectionPartition_860076768_33(Integer V9, Integer V1) {

		String pathCondition = "updateHandleBoxFigPartition$SelectionPartition_860076768_33";
		if(V9 == null || V1 == null){
		 Character val = values.get(pathCondition);
		 if (val.equals('U'))
		 values.put(pathCondition, 'U');
		 else if (val.equals('T'))
		 values.put(pathCondition, 'T');
		 else if (val.equals('F'))
		 values.put(pathCondition, 'F');
		} else if (V1 <= 0 && V9 <= 0){
		 values.put(pathCondition, 'T');
		} else {
		 Character val = values.get(pathCondition);
		 if (val.equals('F') || val.equals('U'))
		 values.put(pathCondition, 'F');
		 else
		 values.put(pathCondition, 'T');
		}
 }


 private void updateHandleBoxFigPartition$SelectionPartition_860076768_10(Integer V3, Integer V4) {

		String pathCondition = "updateHandleBoxFigPartition$SelectionPartition_860076768_10";
		if(V3 == null || V4 == null){
		 Character val = values.get(pathCondition);
		 if (val.equals('U'))
		 values.put(pathCondition, 'U');
		 else if (val.equals('T'))
		 values.put(pathCondition, 'T');
		 else if (val.equals('F'))
		 values.put(pathCondition, 'F');
		} else if (V3 <= 0 && V4 <= 0){
		 values.put(pathCondition, 'T');
		} else {
		 Character val = values.get(pathCondition);
		 if (val.equals('F') || val.equals('U'))
		 values.put(pathCondition, 'F');
		 else
		 values.put(pathCondition, 'T');
		}
 }


 private void updateHandleBoxFigPartition$SelectionPartition_860076768_19(Integer V8, Integer V3, Integer V4) {

		String pathCondition = "updateHandleBoxFigPartition$SelectionPartition_860076768_19";
		if(V8 == null || V3 == null || V4 == null){
		 Character val = values.get(pathCondition);
		 if (val.equals('U'))
		 values.put(pathCondition, 'U');
		 else if (val.equals('T'))
		 values.put(pathCondition, 'T');
		 else if (val.equals('F'))
		 values.put(pathCondition, 'F');
		} else if (V8 <= 0 && V3 <= 0 && V4 > 0){
		 values.put(pathCondition, 'T');
		} else {
		 Character val = values.get(pathCondition);
		 if (val.equals('F') || val.equals('U'))
		 values.put(pathCondition, 'F');
		 else
		 values.put(pathCondition, 'T');
		}
 }


 private void updateHandleBoxFigPartition$SelectionPartition_860076768_14(Integer V8, Integer V12) {

		String pathCondition = "updateHandleBoxFigPartition$SelectionPartition_860076768_14";
		if(V8 == null || V12 == null){
		 Character val = values.get(pathCondition);
		 if (val.equals('U'))
		 values.put(pathCondition, 'U');
		 else if (val.equals('T'))
		 values.put(pathCondition, 'T');
		 else if (val.equals('F'))
		 values.put(pathCondition, 'F');
		} else if (V8 > 0 && V12 >= 0 && V12 > 0){
		 values.put(pathCondition, 'T');
		} else {
		 Character val = values.get(pathCondition);
		 if (val.equals('F') || val.equals('U'))
		 values.put(pathCondition, 'F');
		 else
		 values.put(pathCondition, 'T');
		}
 }


 private void updateHandleBoxFigPartition$SelectionPartition_860076768_29(Integer V9) {

		String pathCondition = "updateHandleBoxFigPartition$SelectionPartition_860076768_29";
		if(V9 == null){
		 Character val = values.get(pathCondition);
		 if (val.equals('U'))
		 values.put(pathCondition, 'U');
		 else if (val.equals('T'))
		 values.put(pathCondition, 'T');
		 else if (val.equals('F'))
		 values.put(pathCondition, 'F');
		} else if (V9 <= 0){
		 values.put(pathCondition, 'T');
		} else {
		 Character val = values.get(pathCondition);
		 if (val.equals('F') || val.equals('U'))
		 values.put(pathCondition, 'F');
		 else
		 values.put(pathCondition, 'T');
		}
 }


 private void updateHandleBoxFigPartition$SelectionPartition_860076768_24(Integer V9, Integer V13) {

		String pathCondition = "updateHandleBoxFigPartition$SelectionPartition_860076768_24";
		if(V9 == null || V13 == null){
		 Character val = values.get(pathCondition);
		 if (val.equals('U'))
		 values.put(pathCondition, 'U');
		 else if (val.equals('T'))
		 values.put(pathCondition, 'T');
		 else if (val.equals('F'))
		 values.put(pathCondition, 'F');
		} else if (V9 > 0 && V13 >= 0 && V13 > 0){
		 values.put(pathCondition, 'T');
		} else {
		 Character val = values.get(pathCondition);
		 if (val.equals('F') || val.equals('U'))
		 values.put(pathCondition, 'F');
		 else
		 values.put(pathCondition, 'T');
		}
 }


 private void updateHandleBoxFigPartition$SelectionPartition_860076768_18(Integer V8, Integer V3) {

		String pathCondition = "updateHandleBoxFigPartition$SelectionPartition_860076768_18";
		if(V8 == null || V3 == null){
		 Character val = values.get(pathCondition);
		 if (val.equals('U'))
		 values.put(pathCondition, 'U');
		 else if (val.equals('T'))
		 values.put(pathCondition, 'T');
		 else if (val.equals('F'))
		 values.put(pathCondition, 'F');
		} else if (V8 <= 0 && V3 > 0){
		 values.put(pathCondition, 'T');
		} else {
		 Character val = values.get(pathCondition);
		 if (val.equals('F') || val.equals('U'))
		 values.put(pathCondition, 'F');
		 else
		 values.put(pathCondition, 'T');
		}
 }


 private void updateHandleBoxFigPartition$SelectionPartition_860076768_16(Integer V8) {

		String pathCondition = "updateHandleBoxFigPartition$SelectionPartition_860076768_16";
		if(V8 == null){
		 Character val = values.get(pathCondition);
		 if (val.equals('U'))
		 values.put(pathCondition, 'U');
		 else if (val.equals('T'))
		 values.put(pathCondition, 'T');
		 else if (val.equals('F'))
		 values.put(pathCondition, 'F');
		} else if (V8 > 0){
		 values.put(pathCondition, 'T');
		} else {
		 Character val = values.get(pathCondition);
		 if (val.equals('F') || val.equals('U'))
		 values.put(pathCondition, 'F');
		 else
		 values.put(pathCondition, 'T');
		}
 }


 private void updateHandleBoxFigPartition$SelectionPartition_860076768_5(Integer V11, Integer V3) {

		String pathCondition = "updateHandleBoxFigPartition$SelectionPartition_860076768_5";
		if(V11 == null || V3 == null){
		 Character val = values.get(pathCondition);
		 if (val.equals('U'))
		 values.put(pathCondition, 'U');
		 else if (val.equals('T'))
		 values.put(pathCondition, 'T');
		 else if (val.equals('F'))
		 values.put(pathCondition, 'F');
		} else if (V3 > 0 && V11 >= 0 && V11 <= 0){
		 values.put(pathCondition, 'T');
		} else {
		 Character val = values.get(pathCondition);
		 if (val.equals('F') || val.equals('U'))
		 values.put(pathCondition, 'F');
		 else
		 values.put(pathCondition, 'T');
		}
 }


 private void updateHandleBoxFigPartition$SelectionPartition_860076768_31(Integer V1) {

		String pathCondition = "updateHandleBoxFigPartition$SelectionPartition_860076768_31";
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


 private void updateHandleBoxFigPartition$SelectionPartition_860076768_6(Integer V3) {

		String pathCondition = "updateHandleBoxFigPartition$SelectionPartition_860076768_6";
		if(V3 == null){
		 Character val = values.get(pathCondition);
		 if (val.equals('U'))
		 values.put(pathCondition, 'U');
		 else if (val.equals('T'))
		 values.put(pathCondition, 'T');
		 else if (val.equals('F'))
		 values.put(pathCondition, 'F');
		} else if (V3 > 0){
		 values.put(pathCondition, 'T');
		} else {
		 Character val = values.get(pathCondition);
		 if (val.equals('F') || val.equals('U'))
		 values.put(pathCondition, 'F');
		 else
		 values.put(pathCondition, 'T');
		}
 }


 private void updateHandleBoxFigPartition$SelectionPartition_860076768_15(Integer V8, Integer V12) {

		String pathCondition = "updateHandleBoxFigPartition$SelectionPartition_860076768_15";
		if(V8 == null || V12 == null){
		 Character val = values.get(pathCondition);
		 if (val.equals('U'))
		 values.put(pathCondition, 'U');
		 else if (val.equals('T'))
		 values.put(pathCondition, 'T');
		 else if (val.equals('F'))
		 values.put(pathCondition, 'F');
		} else if (V8 > 0 && V12 >= 0 && V12 <= 0){
		 values.put(pathCondition, 'T');
		} else {
		 Character val = values.get(pathCondition);
		 if (val.equals('F') || val.equals('U'))
		 values.put(pathCondition, 'F');
		 else
		 values.put(pathCondition, 'T');
		}
 }


 private void updateHandleBoxFigPartition$SelectionPartition_860076768_20(Integer V8, Integer V3, Integer V4) {

		String pathCondition = "updateHandleBoxFigPartition$SelectionPartition_860076768_20";
		if(V8 == null || V3 == null || V4 == null){
		 Character val = values.get(pathCondition);
		 if (val.equals('U'))
		 values.put(pathCondition, 'U');
		 else if (val.equals('T'))
		 values.put(pathCondition, 'T');
		 else if (val.equals('F'))
		 values.put(pathCondition, 'F');
		} else if (V8 <= 0 && V3 <= 0 && V4 <= 0){
		 values.put(pathCondition, 'T');
		} else {
		 Character val = values.get(pathCondition);
		 if (val.equals('F') || val.equals('U'))
		 values.put(pathCondition, 'F');
		 else
		 values.put(pathCondition, 'T');
		}
 }


 private void updateHandleBoxFigPartition$SelectionPartition_860076768_32(Integer V9, Integer V1) {

		String pathCondition = "updateHandleBoxFigPartition$SelectionPartition_860076768_32";
		if(V9 == null || V1 == null){
		 Character val = values.get(pathCondition);
		 if (val.equals('U'))
		 values.put(pathCondition, 'U');
		 else if (val.equals('T'))
		 values.put(pathCondition, 'T');
		 else if (val.equals('F'))
		 values.put(pathCondition, 'F');
		} else if (V1 <= 0 && V9 > 0){
		 values.put(pathCondition, 'T');
		} else {
		 Character val = values.get(pathCondition);
		 if (val.equals('F') || val.equals('U'))
		 values.put(pathCondition, 'F');
		 else
		 values.put(pathCondition, 'T');
		}
 }


 private void updateHandleBoxFigPartition$SelectionPartition_860076768_8(Integer V3, Integer V4, Integer V5) {

		String pathCondition = "updateHandleBoxFigPartition$SelectionPartition_860076768_8";
		if(V3 == null || V4 == null || V5 == null){
		 Character val = values.get(pathCondition);
		 if (val.equals('U'))
		 values.put(pathCondition, 'U');
		 else if (val.equals('T'))
		 values.put(pathCondition, 'T');
		 else if (val.equals('F'))
		 values.put(pathCondition, 'F');
		} else if (V3 <= 0 && V4 > 0 && V5 >= 0 && V5 <= 0){
		 values.put(pathCondition, 'T');
		} else {
		 Character val = values.get(pathCondition);
		 if (val.equals('F') || val.equals('U'))
		 values.put(pathCondition, 'F');
		 else
		 values.put(pathCondition, 'T');
		}
 }


 private void updateHandleBoxFigPartition$SelectionPartition_860076768_25(Integer V9, Integer V13) {

		String pathCondition = "updateHandleBoxFigPartition$SelectionPartition_860076768_25";
		if(V9 == null || V13 == null){
		 Character val = values.get(pathCondition);
		 if (val.equals('U'))
		 values.put(pathCondition, 'U');
		 else if (val.equals('T'))
		 values.put(pathCondition, 'T');
		 else if (val.equals('F'))
		 values.put(pathCondition, 'F');
		} else if (V9 > 0 && V13 >= 0 && V13 <= 0){
		 values.put(pathCondition, 'T');
		} else {
		 Character val = values.get(pathCondition);
		 if (val.equals('F') || val.equals('U'))
		 values.put(pathCondition, 'F');
		 else
		 values.put(pathCondition, 'T');
		}
 }


 private void updateHandleBoxFigPartition$SelectionPartition_860076768_27(Integer V8, Integer V9) {

		String pathCondition = "updateHandleBoxFigPartition$SelectionPartition_860076768_27";
		if(V8 == null || V9 == null){
		 Character val = values.get(pathCondition);
		 if (val.equals('U'))
		 values.put(pathCondition, 'U');
		 else if (val.equals('T'))
		 values.put(pathCondition, 'T');
		 else if (val.equals('F'))
		 values.put(pathCondition, 'F');
		} else if (V9 <= 0 && V8 > 0){
		 values.put(pathCondition, 'T');
		} else {
		 Character val = values.get(pathCondition);
		 if (val.equals('F') || val.equals('U'))
		 values.put(pathCondition, 'F');
		 else
		 values.put(pathCondition, 'T');
		}
 }


 private void updateHandleBoxFigPartition$SelectionPartition_860076768_17(Integer V8, Integer V11, Integer V3) {

		String pathCondition = "updateHandleBoxFigPartition$SelectionPartition_860076768_17";
		if(V8 == null || V11 == null || V3 == null){
		 Character val = values.get(pathCondition);
		 if (val.equals('U'))
		 values.put(pathCondition, 'U');
		 else if (val.equals('T'))
		 values.put(pathCondition, 'T');
		 else if (val.equals('F'))
		 values.put(pathCondition, 'F');
		} else if (V8 <= 0 && V3 > 0 && V11 >= 0){
		 values.put(pathCondition, 'T');
		} else {
		 Character val = values.get(pathCondition);
		 if (val.equals('F') || val.equals('U'))
		 values.put(pathCondition, 'F');
		 else
		 values.put(pathCondition, 'T');
		}
 }


 private void updateHandleBoxFigPartition$SelectionPartition_860076768_23(Integer V8) {

		String pathCondition = "updateHandleBoxFigPartition$SelectionPartition_860076768_23";
		if(V8 == null){
		 Character val = values.get(pathCondition);
		 if (val.equals('U'))
		 values.put(pathCondition, 'U');
		 else if (val.equals('T'))
		 values.put(pathCondition, 'T');
		 else if (val.equals('F'))
		 values.put(pathCondition, 'F');
		} else if (V8 <= 0){
		 values.put(pathCondition, 'T');
		} else {
		 Character val = values.get(pathCondition);
		 if (val.equals('F') || val.equals('U'))
		 values.put(pathCondition, 'F');
		 else
		 values.put(pathCondition, 'T');
		}
 }


 private void updateHandleBoxFigPartition$SelectionPartition_860076768_34(Integer V1) {

		String pathCondition = "updateHandleBoxFigPartition$SelectionPartition_860076768_34";
		if(V1 == null){
		 Character val = values.get(pathCondition);
		 if (val.equals('U'))
		 values.put(pathCondition, 'U');
		 else if (val.equals('T'))
		 values.put(pathCondition, 'T');
		 else if (val.equals('F'))
		 values.put(pathCondition, 'F');
		} else if (V1 <= 0){
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