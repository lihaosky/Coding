
public class Calculator {
	private String expression;
	private int curIndex;
	private boolean isError;
	
	public Calculator(String exp) {
		expression = exp;
		curIndex = 0;
		isError = false;
	}
	
	public double calculate() {
		double result = expr();
		if (curIndex < expression.length()) {
			isError = true;
		}
		if (isError) {
			System.out.println("Syntax error");
			return 0;
		}
		return result;
	}
	
	private void eatSpace() {
		while (curIndex < expression.length() && (expression.charAt(curIndex) == '\t' || expression.charAt(curIndex) == ' ')) {
			curIndex++;
		}
	}
	
	private double expr() {
		double result = term();
		eatSpace();
		// Nothing left
		if (curIndex >= expression.length()) {
			return result;
		}
		// Expect '+'
		if (expression.charAt(curIndex) == '+') {
			curIndex++;
			return result + expr();
		} 
		// Expect '-'
		if (expression.charAt(curIndex) == '-') {
			curIndex++;
			return result - expr();
		}
		// After term can be ')'
		if (expression.charAt(curIndex) != ')') {
			isError = true;
		}
		return result;
	}
	
	private double term() {
		double result = factor();
		eatSpace();
		if (curIndex >= expression.length()) {
			return result;
		}
		if (expression.charAt(curIndex) == '*') {
			curIndex++;
			return result * term();
		}
		if (expression.charAt(curIndex) == '/') {
			curIndex++;
			double right = term();
			if (right == 0.0) {
				isError = true;
				System.err.println("Divided by 0");
				return 0;
			}
			return result / right;
		}
		if (expression.charAt(curIndex) != '+' && expression.charAt(curIndex) != '-' && expression.charAt(curIndex) != ')') {
			isError = true;
		} 
		return result;
	}
	
	private double factor() {
		eatSpace();
		if (curIndex >= expression.length()) {
			isError = true;
			return 0;
		}
		String number = "";
		if ((expression.charAt(curIndex) >= '0' && expression.charAt(curIndex) <= '9') || expression.charAt(curIndex) == '.') {
			while (true) {
				number += expression.charAt(curIndex);
				curIndex++;
				eatSpace();
				if (curIndex >= expression.length()) {
					break;
				}
				if ((expression.charAt(curIndex) < '0' || expression.charAt(curIndex) > '9') && expression.charAt(curIndex) != '.') {
					break;
				}
			}
			double result = 0;
			try {
				result = Double.parseDouble(number);
			} catch (Exception e) {
				isError = true;
			}
			return result;
		}
		if (expression.charAt(curIndex) == '(') {
			curIndex++;
			double result = expr();
			if (curIndex >= expression.length() || expression.charAt(curIndex) != ')') {
				isError = true;
			}
			curIndex++;
			return result;
		}
		return 0;
	}
	
	public static void main(String[] args) {
		Calculator c = new Calculator("123 * 34");
		System.out.println(c.calculate());
		c = new Calculator("1 + 2 + 3.4 + 5");
		System.out.println(c.calculate());
		c = new Calculator("0 + 0.0");
		System.out.println(c.calculate());
		c = new Calculator("23 * (1 + 2)");
		System.out.println(c.calculate());
		c = new Calculator("23 * 1 + 2");
		System.out.println(c.calculate());
		c = new Calculator("100 / (12 - 3 * 4)");
		System.out.println(c.calculate());
		c = new Calculator("100 / (13 + 3 * 4)");
		System.out.println(c.calculate());
		c = new Calculator("100 / 3 * 4)");
		System.out.println(c.calculate());
		c = new Calculator("100 - 10))");
		System.out.println(c.calculate());
		c = new Calculator("100 a- 10ab");
		System.out.println(c.calculate());
	}
}
