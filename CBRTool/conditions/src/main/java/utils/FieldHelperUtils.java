package utils;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.Map;

import org.apache.log4j.Logger;

public class FieldHelperUtils {
	final static Logger logger = Logger.getLogger(FieldHelperUtils.class);
	
	/**
	 * Get the field value of array type for {@code index}
	 * 
	 * @param cls Corresponding class that has an array field
	 * @param fieldName name of the field to be evaluated
	 * @param index the array index
	 */
	public static Object getArrayFieldValue(Class<?> cls, String fieldName, int index) {
		logger.debug("getArrayFieldValue(cls, fieldName): " + cls + ", " + fieldName);

		Object result = null;
		Object indexValue = null;

		try {
			Field myField = cls.getDeclaredField(fieldName);
			myField.setAccessible(true);

			result = myField.get(null);

			indexValue = Array.get(result, index);

			if (indexValue == null)
				indexValue = new Object();

		} catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException e) {
			indexValue = new Object();
		}

		logger.debug("getArrayFieldValue output: " + indexValue.toString());
		return indexValue;
	}
	
	/**
	 * Get the field value of array type for {@code index} for object
	 * {@code currentObject}
	 * 
	 * @param currentObject
	 * @param fieldName
	 * @param index
	 */
	public static Object getArrayFieldValue(Object currentObject, String fieldName, int index) {
		logger.debug("getArrayFieldValue(currentObject, fieldName): " + currentObject.getClass().getName() + ", "
				+ fieldName);

		Object result = null;
		Object indexValue = null;
		Field field = null;
		Class<? extends Object> c = null;

		try {
			c = currentObject.getClass();

			field = c.getDeclaredField(fieldName);
			field.setAccessible(true);

			result = field.get(currentObject);

			indexValue = Array.get(result, index);

			if (indexValue == null)
				indexValue = new Object();

		} catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException e) {
			logger.error(e);
			indexValue = new Object();
		}

		logger.debug("getArrayFieldValue output: " + indexValue.toString());
		return indexValue;
	}
	
	/**
	 * Get class of path
	 * @param path
	 * @return
	 * @throws NullPointerException
	 */
	public static Class<?> getClass(String path) throws NullPointerException {
		logger.debug("getClass(path): " + path);
		Class<?> cls = null;

		int lastDot = path.lastIndexOf(".");
		if (lastDot == -1)
			throw new NullPointerException();

		String className = path.substring(0, lastDot);

		try {
			cls = Class.forName(className);
		} catch (ClassNotFoundException e) {
			cls = getClass(className);
		}
		return cls;
	}
	
	/**
	 * Get {@link Field} from {@code cls} indicated in {@code fieldName} 
	 * 
	 * @param cls
	 * @param fieldName
	 * @return corresponding {@link Field}
	 * @throws NoSuchFieldException
	 */
	private static Field getField(Class<?> cls, String fieldName) throws NoSuchFieldException {
		logger.debug("getField(cls, fieldName): " + cls.getName() + ", " + fieldName);
		Field result;

		if (cls.equals(Object.class))
			throw new NoSuchFieldException();

		try {
			result = cls.getDeclaredField(fieldName);
		} catch (NoSuchFieldException e) {
			Class<?> sc = cls.getSuperclass();
			result = getField(sc, fieldName);
		}
		logger.debug("getField output: " + result.getType());
		return result;
	}
	
	/**
	 * Get runtime {@link Field} value for class {@code cls}
	 * 
	 * @param cls
	 * @param fieldName
	 * @return {@link Object} with the corresponding value
	 */
	public static Object getFieldValue(Class<?> cls, String fieldName) {
		logger.debug("getFieldValue(cls, fieldName): " + cls + ", " + fieldName);

		Object result = null;
		Field field = null;

		try {
			field = cls.getDeclaredField(fieldName);
			field.setAccessible(true);
			result = field.get(null);

			if (result == null) {
				logger.debug("Field " + fieldName + " of type " + field.getType() + " returned null");
				result = new Object();
			}
		} catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException e) {
			result = new Object();
		}

		logger.debug("getFieldValue output: " + result.getClass());
		return result;
	}
	
	/**
	 * Get runtime {@link Field} value for {@code fieldName} of object
	 * {@code currentObject}
	 * @param currentObject
	 * @param fieldName
	 * @return {@link Object} with the value of {@code fieldName}
	 * @throws IllegalAccessException 
	 * @throws IllegalArgumentException 
	 */
	public static Object getFieldValue(Object currentObject, String fieldName) throws IllegalArgumentException, IllegalAccessException {
		logger.debug(
				"getFieldValue(currentObject, fieldName): " + currentObject.getClass().getName() + ", " + fieldName);

		Object result = null;
		Field field;
		Class<? extends Object> c = currentObject.getClass();

		try {
			field = getField(c, fieldName);
			field.setAccessible(true);
			result = field.get(currentObject);

			if (result == null) {
				logger.debug("Field " + fieldName + " of type " + field.getType() + " is null");
				result = new Object();
			} else if (isArray(result) && isArrayEmpty(result)) {
				logger.debug("Array field " + fieldName + " of type " + field.getType() + " is empty");
				result = new Object();
			} else if (isCollection(result) && isCollectionEmpty(result)) {
				logger.debug("Collection field " + fieldName + " of type " + field.getType() + " is empty");
				result = new Object();
			}
		} catch (NoSuchFieldException e) {
			result = new Object();
		}

		return result;
	}

	public static Object getHashCodeValue(Object currentObject) {
		logger.debug("getHashCodeValue(currentObject): " + currentObject.getClass().getName());
		Object result = null;
		try {
			result = currentObject.hashCode();
		} catch (Exception e) {
			logger.error("Exception: " + e.getMessage());
			result = new Object();
		}

		logger.debug("getHashCodeValue output: " + result.toString());
		return result;
	}

	static Object getLengthValue(Class<?> cls, String fieldName) {
		logger.debug("getLengthValue(cls, fieldName): " + cls.getName() + ", " + fieldName);

		Object result = null;
		Object object = null;

		Field myField;
		try {
			myField = cls.getDeclaredField(fieldName);
			myField.setAccessible(true);
			object = myField.get(null);
			result = Array.getLength(object);
		} catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException e) {
			logger.debug(e.getMessage());
			result = new Object();
		}

		logger.debug("getLengthValue output: " + result.toString());
		return result;
	}

	public static Object getLengthValue(Object currentObject, String fieldName) {
		logger.debug(
				"getLengthValue(currentObject, fieldName): " + currentObject.getClass().toString() + ", " + fieldName);
		Object object = null;
		Object result = null;

		try {
			Class<? extends Object> c = currentObject.getClass();
			Field field = getField(c, fieldName);
			field.setAccessible(true);
			object = field.get(currentObject);

			// get length of array field
			result = Array.getLength(object);

		} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException e) {
			result = new Object();
		}

		logger.debug("getLengthValue output: " + result.toString());
		return result;

	}

	static Object getSizeCollection(Object object) {
		logger.debug("getSizeCollection(object): " + object.getClass().toString());
		Object result = null;
		try {
			result = object.getClass().getMethod("size").invoke(object);
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException
				| SecurityException e) {
			logger.error(e.getMessage());
			result = new Object();
		}
		return result;
	}

	/**
	 * Checks whether the object is an array or not
	 * 
	 * @param object
	 * @return
	 */
	public static boolean isArray(Object object) {
		return object != null && object.getClass().isArray();
	}

	/**
	 * Checks whether the array represented by {@code object} is empty or not
	 * 
	 * @param object
	 */
	public static boolean isArrayEmpty(Object object) {
		return Array.getLength(object) > 0 ? false : true;
	}

	/**
	 * Checks whether the object is a collection or not
	 * 
	 * @param object
	 */
	public static boolean isCollection(Object object) {
		return object instanceof Collection || object instanceof Map;
	}

	/**
	 * Checks whether the collection represented by {@code object} is empty or not
	 * 
	 * @param object
	 * @return true if is it empty; otherwise false
	 */
	public static boolean isCollectionEmpty(Object object) {
		int size = 0;

		try {
			Method m = object.getClass().getMethod("size");
			m.setAccessible(true);
			size = (Integer) m.invoke(object);
		} catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException
				| InvocationTargetException e) {
			logger.error(e);
		}

		return size > 0 ? false : true;
	}
}
