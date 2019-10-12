package runtime.evaluators.autogenerated;

import java.lang.ref.WeakReference;
import java.util.List;

import runtime.evaluators.AtLeastOneConditionEvaluator;

import java.util.Iterator;
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

						String sV2 = expression("nameFig._rightMargin","int");
						Integer V2 = !sV2.isEmpty() ? Integer.parseInt(sV2) : null;
						String sV1 = expression("nameFig._leftMargin","int");
						Integer V1 = !sV1.isEmpty() ? Integer.parseInt(sV1) : null;
						String sV6 = expression("nameFig._botMargin","int");
						Integer V6 = !sV6.isEmpty() ? Integer.parseInt(sV6) : null;
						String sV4 = expression("nameFig._font.size","int");
						Integer V4 = !sV4.isEmpty() ? Integer.parseInt(sV4) : null;
						String sV3 = expression("nameFig._lineWidth","int");
						Integer V3 = !sV3.isEmpty() ? Integer.parseInt(sV3) : null;
						String sV5 = expression("nameFig._topMargin","int");
						Integer V5 = !sV5.isEmpty() ? Integer.parseInt(sV5) : null;

						getMinimumSizeFigPartition_1481300586_16(V6, V1, V2, V3, V4, V5);
				} 
			}
		}
	}

 private void getMinimumSizeFigPartition_1481300586_16(Integer V6, Integer V1, Integer V2, Integer V3, Integer V4, Integer V5) {

		String pathCondition = "getMinimumSizeFigPartition_1481300586_16";
		if(V6 == null || V1 == null || V2 == null || V3 == null || V4 == null || V5 == null){
		 Character val = values.get(pathCondition);
		 if (val.equals('U'))
		 values.put(pathCondition, 'U');
		 else if (val.equals('T'))
		 values.put(pathCondition, 'T');
		 else if (val.equals('F'))
		 values.put(pathCondition, 'F');
		} else if (64 >= 30 + V1 + V2 + 2 * V3 && 256 >= V4 + V5 + V6 + 2 * V3){
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
