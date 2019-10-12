package fieldhelper;

import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.log4j.Logger;

import utils.ExpressionHelperUtils;
import utils.FieldHelperUtils;

public class FieldHelper {

	final static Logger logger = Logger.getLogger(FieldHelper.class);

	private Object currentObject;
	private String type;

	public FieldHelper() {
	}

	public FieldHelper(Object currentObject, String type) {
		this.currentObject = currentObject;
		this.type = type;
	}

	public void setCurrentObject(Object currentObject) {
		this.currentObject = currentObject;
	}

	public String expression(String path, String type) {
		logger.debug("original expression: " + path);
		this.type = type;
		String result = expression(path);
		logger.debug("result of expression: " + path + " is " + result);
		return result;
	}

	/**
	 * Returns the runtime value of an expression
	 * 
	 * @param path
	 * @return
	 */
	public String expression(String path) {

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
	 * Replace the array's index expression for the actual runtime value
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

		logger.debug("replaceArrayContent output: " + path);
		return path;
	}

	/**
	 * Estimate the runtime value of an expression, first will try to estimate it as
	 * a math expression, if it fails will prove as an object expression
	 * 
	 * @param path
	 * @return
	 */
	private String getValue(String path) {
		logger.debug("getValue(path): " + path);

		String result;

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
			Object returnedObject = getPathFieldValue(path);

			if (returnedObject.getClass().equals(Object.class))
				result = "";
			else
				result = returnedObject.toString();
		}
		logger.debug("getValue output: " + result);
		return result;
	}

	Object getPathFieldValue(String path) {
		logger.debug("getPathFieldValue(path): " + path);

		Object currentObject = this.currentObject;
		String[] splittedPath = path.split("\\.");

		try {
			String previousPartialPath = "";
			Object previousTarget = new Object();

			for (String partialPath : splittedPath) {
				if (currentObject == null) {
					throw new NullPointerException("Current object is null");
				}

				Object objectBkp = currentObject;

				logger.debug("current object: " + currentObject.getClass().getName());

				// if is an array, take just the name not the brackets
				if (ExpressionHelperUtils.containsArray(partialPath))
					partialPath = partialPath.replaceAll("[\\[](.+)[\\]]", "");

				// if path contains the length keyword use a different approach
				if (ExpressionHelperUtils.containsLength(partialPath)) {
					currentObject = FieldHelperUtils.getLengthValue(previousTarget, previousPartialPath);
				} else if (ExpressionHelperUtils.isHashCode(partialPath)) {
					currentObject = FieldHelperUtils.getHashCodeValue(currentObject);
				} else {
					currentObject = FieldHelperUtils.getFieldValue(currentObject, partialPath);
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

		return currentObject;
	}

	public void setType(String type) {
		this.type = type;
	}
}
