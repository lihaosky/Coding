package Expression;

import java.util.ArrayList;

/**
 * Tokenizer class
 * @author lihaosky
 *
 */
public class Tokenizer {
	private String expression = "";
	private ArrayList<Operator> operatorList = null;
	
	/**
	 * Constructor
	 * @param expression String expression
	 */
	public Tokenizer(String expression) {
		this(expression, Expression.defaultOperatorList);
	}
	
	/**
	 * Constructor
	 * @param expression String expression
	 * @param operatorList A list of operators
	 */
	public Tokenizer(String expression, ArrayList<Operator> operatorList) {
		this.expression = expression;
		this.operatorList = operatorList;
	}
	
	/**
	 * Get postfix tokens
	 * @return Postfix tokens
	 */
	public String[] getPostfixTokens() {
		return expression.split(",");
	}
	
	/**
	 * If the string is an operator
	 * @param c String to be tested
	 * @return True if it's operator, False otherwise
	 */
	public boolean isOperator(String c) {
		for (Operator op : operatorList) {
			if (op.getName().equals(c)) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Get unary operator with this name
	 * @param s Name
	 * @return Unary operator. null if not exist
	 */
	public Operator getUnary(String s) {
		for (Operator op : operatorList) {
			if (op.getName().equals(s) && op.isUnary()) {
				return op;
			}
		}
		return null;
	}
	
	/**
	 * Get binary operator with this name
	 * @param s Name
	 * @return binary operator. null if not exist
	 */
	public Operator getBinary(String s) {
		for (Operator op : operatorList) {
			if (op.getName().equals(s) && op.isBinary()) {
				return op;
			}
		}
		return null;
	}
	
	/**
	 * Test if string is a unary operator
	 * @param s String to be tested
	 * @return True if it is. False otherwise
	 */
	public boolean isUnaryOperator(String s) {
		for (Operator op : operatorList) {
			if (op.getName().equals(s) && op.isUnary()) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Test if string is a binary operator
	 * @param s String to be tested
	 * @return True if it is. False otherwise
	 */
	public boolean isBinaryOperator(String s) {
		for (Operator op : operatorList) {
			if (op.getName().equals(s) && op.isBinary()) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Get infix tokens
	 * @return Infix tokens
	 */
	public String[] getInfixTokens() {
		ArrayList<String> tokens = new ArrayList<String>();
		
		for (int i = 0; i < expression.length(); i++) {
			if (expression.charAt(i) == '(' || expression.charAt(i) == ')' || isOperator(expression.charAt(i) + "")) {
				tokens.add(expression.charAt(i) + "");
				continue;
			} else {
				String s = "";
				while (i < expression.length() && expression.charAt(i) != '('
						                       && expression.charAt(i) != ')'
						                       && !isOperator(expression.charAt(i) + "")) {
					s += expression.charAt(i);
					i++;
				}
				i--;
				tokens.add(s);
			}
		}
		
		String[] tokenArray = new String[tokens.size()];
		return tokens.toArray(tokenArray);
	}
	

	
}
