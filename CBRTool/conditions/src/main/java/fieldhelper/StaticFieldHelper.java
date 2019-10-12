package fieldhelper;

import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.log4j.Logger;

import utils.ExpressionHelperUtils;
import utils.FieldHelperUtils;

public class StaticFieldHelper {
	final static Logger logger = Logger.getLogger(StaticFieldHelper.class);

	private Object currentStaticObject;

	private String type;
	private int index;

	public StaticFieldHelper() {
	}

	public void setCurrentStaticObject(Object currentStaticObject) {
		this.currentStaticObject = currentStaticObject;
	}

	public String expression(String path, String type) {
		logger.debug("original expression: " + path);
		this.type = type;
		String result = expression(path);
		logger.debug("result of expression: " + path + " is \"" + result + "\"");
		return result;
	}

	/**
	 * Returns the runtime value of an expression
	 * 
	 * @param path
	 * @return
	 */
	public String expression(String path) {
		logger.debug("expression(path): " + path);

		if (path.charAt(0) == '[')
			path = path.substring(1);

		Stack<String> stack = new Stack<String>();
		String subExpression = "";

		if (ExpressionHelperUtils.containsArray(path)) {
			path = replaceArrayContent(path);
			if (path.isEmpty())
				return "";
		}

		for (int i = 0; i < path.length(); i++) {
			char c = path.charAt(i);
			if (c == '(') {
				stack.push(subExpression);
				subExpression = "";
			} else if (c == ')') {
				String result = getValue(subExpression);
				if (result.isEmpty())
					return "";
				subExpression = stack.pop() + result;
			} else {
				subExpression += c;
			}
		}
		return getValue(subExpression);
	}

	/**
	 * Replace the path between brackets for the actual runtime value
	 * 
	 * @param path
	 * @return
	 */
	private String replaceArrayContent(String path) {
		logger.debug("replaceArrayContent(path): " + path);

		Pattern p1 = Pattern.compile("[\\[](.+)[\\]]");
		Matcher m1 = p1.matcher(path);
		String match = "";
		String group = "";
		while (m1.find()) {
			group = m1.group(1);
			match = m1.group(0);
		}
		String subExpression = expression(group);

		if (subExpression.isEmpty())
			return "";

		path = path.replace(match, "[" + subExpression + "]");
		// save the index of the expression
		setIndex(subExpression);

		logger.debug("replaceArrayContent output: " + path);
		return path;
	}

	private void setIndex(String subExpression) {
		this.index = Integer.parseInt(subExpression);
	}

	/**
	 * get path value using reflection
	 * 
	 * @param path
	 * @return
	 */
	private String getValue(String path) {
		logger.debug("getValue(path): " + path);

		if (path.charAt(0) == '[')
			path = path.substring(1);

		String result = "";

		try {
			if (type.equals("byte")) {
				result = Byte.toString((byte) ExpressionHelperUtils.eval(path));
			} else if (type.equals("short")) {
				result = Short.toString((short) ExpressionHelperUtils.eval(path));
			} else if (type.equals("int")) {
				result = Integer.toString((int) ExpressionHelperUtils.eval(path));
			} else if (type.equals("long")) {
				result = Long.toString((long) ExpressionHelperUtils.eval(path));
			} else if (type.equals("char")) {
				result = Character.toString((char) ExpressionHelperUtils.eval(path));
			} else if (type.equals("float")) {
				result = Float.toString((float) ExpressionHelperUtils.eval(path));
			} else if (type.equals("double")) {
				result = Double.toString(ExpressionHelperUtils.eval(path));
			} else {
				throw new RuntimeException("Not acceptable as math expression");
			}
		} catch (RuntimeException re) {
			logger.debug("getValue exception: it was not a math expression");

			Object returnedObject = getPathFieldValue(path);

			if (returnedObject.getClass().equals(Object.class))
				result = "";
			else
				result = returnedObject.toString();
		}

		logger.debug("getValue output: " + result);
		return result;
	}

	public Object getPathFieldValue(String path) {
		logger.debug("getPathFieldValue(path): " + path);

		// if static with delete the '[' char
		if (path.charAt(0) == '[')
			path = path.substring(1);

		Object currentObject = null;
		Class<?> cls = null;

		// obtain the class of the static object
		try {
			cls = FieldHelperUtils.getClass(path);
		} catch (NullPointerException e) {
			FieldHelper fh = new FieldHelper(currentStaticObject, type);
			currentObject = fh.getPathFieldValue(path);
			return currentObject;
		}

		path = path.replaceAll(cls.getName() + "\\.", "");

		try {

			String previousPartialPath = "";
			Object previousTarget = new Object();

			String[] splittedPath = path.split("\\.");

			for (String partialPath : splittedPath) {

				Object objectBkp = currentObject;

				if (currentObject == null) {
					if (ExpressionHelperUtils.containsArray(partialPath)) {
						partialPath = partialPath.replaceAll("[\\[](.+)[\\]]", "");
						currentObject = FieldHelperUtils.getArrayFieldValue(cls, partialPath, index);
					} else {
						currentObject = FieldHelperUtils.getFieldValue(cls, partialPath);
					}
				} else {
					if (ExpressionHelperUtils.containsLength(partialPath)) {
						if (previousTarget != null)
							currentObject = FieldHelperUtils.getLengthValue(previousTarget, previousPartialPath);
						else
							currentObject = FieldHelperUtils.getLengthValue(cls, previousPartialPath);
					} else if (ExpressionHelperUtils.isHashCode(partialPath)) {
						currentObject = FieldHelperUtils.getHashCodeValue(currentObject);
					} else if (ExpressionHelperUtils.containsArray(partialPath)) {
						partialPath = partialPath.replaceAll("[\\[](.+)[\\]]", "");
						currentObject = FieldHelperUtils.getArrayFieldValue(currentObject, partialPath, index);
					} else {
						currentObject = FieldHelperUtils.getFieldValue(currentObject, partialPath);
					}
				}

				if (currentObject.getClass().equals(Object.class)) {
					logger.debug("Field did not had a value");
					return currentObject;
				}

				previousPartialPath = partialPath;
				previousTarget = objectBkp;
			}
		} catch (IllegalArgumentException | IllegalAccessException e) {
			return new Object();
		}

		logger.debug("getPathFieldValue output : " + currentObject.toString());
		return currentObject;
	}

}
