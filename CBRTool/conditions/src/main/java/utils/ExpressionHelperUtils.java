package utils;

public class ExpressionHelperUtils {

	/**
	 * Check if {@code path} contains an array
	 * 
	 * @param path
	 * @return
	 */
	public static boolean containsArray(String path) {
		return path.contains("[") && path.contains("]") ? true : false;
	}

	/**
	 * Checks if {@code path} contains a length field
	 * 
	 * @param path
	 * @return
	 */
	public static boolean containsLength(String path) {
		return path.contains("length") ? true : false;
	}

	/**
	 * Evaluate a mathematical expression and return its value as a double
	 * 
	 * @param str
	 * @return The value of the expression
	 */
	public static double eval(final String str) {
		return new Object() {
			int pos = -1, ch;

			boolean eat(int charToEat) {
				while (ch == ' ')
					nextChar();
				if (ch == charToEat) {
					nextChar();
					return true;
				}
				return false;
			}

			void nextChar() {
				ch = (++pos < str.length()) ? str.charAt(pos) : -1;
			}

			double parse() {
				nextChar();
				double x = parseExpression();
				if (pos < str.length())
					throw new RuntimeException("Unexpected: " + (char) ch);
				return x;
			}

			// Grammar:
			// expression = term | expression `+` term | expression `-` term
			// term = factor | term `*` factor | term `/` factor
			// factor = `+` factor | `-` factor | `(` expression `)`
			// | number | functionName factor | factor `^` factor

			double parseExpression() {
				double x = parseTerm();
				for (;;) {
					if (eat('+'))
						x += parseTerm(); // addition
					else if (eat('-'))
						x -= parseTerm(); // subtraction
					else
						return x;
				}
			}

			double parseFactor() {
				if (eat('+'))
					return parseFactor(); // unary plus
				if (eat('-'))
					return -parseFactor(); // unary minus

				double x;
				int startPos = this.pos;
				if (eat('(')) { // parentheses
					x = parseExpression();
					eat(')');
				} else if ((ch >= '0' && ch <= '9') || ch == '.') { // numbers
					while ((ch >= '0' && ch <= '9') || ch == '.')
						nextChar();
					x = Double.parseDouble(str.substring(startPos, this.pos));
				} else if (ch >= 'a' && ch <= 'z') { // functions
					while (ch >= 'a' && ch <= 'z')
						nextChar();
					String func = str.substring(startPos, this.pos);
					x = parseFactor();
					if (func.equals("sqrt"))
						x = Math.sqrt(x);
					else if (func.equals("sin"))
						x = Math.sin(Math.toRadians(x));
					else if (func.equals("cos"))
						x = Math.cos(Math.toRadians(x));
					else if (func.equals("tan"))
						x = Math.tan(Math.toRadians(x));
					else
						throw new RuntimeException("Unknown function: " + func);
				} else {
					throw new RuntimeException("Unexpected: " + (char) ch);
				}

				if (eat('^'))
					x = Math.pow(x, parseFactor()); // exponentiation

				return x;
			}

			double parseTerm() {
				double x = parseFactor();
				for (;;) {
					if (eat('*'))
						x *= parseFactor(); // multiplication
					else if (eat('/'))
						x /= parseFactor(); // division
					else if (eat('&'))
						x = (int) x & (int) parseFactor();
					else if (eat('%'))
						x %= parseFactor();
					else
						return x;
				}
			}
		}.parse();
	}

	public static boolean isHashCode(String partialPath) {
		return partialPath.equals("hashCode") ? true : false;
	}
}
