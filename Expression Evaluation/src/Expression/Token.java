package Expression;

import java.util.ArrayList;

/**
 * Token class
 * 
 * @author lihaosky
 *
 */
public class Token {
	
	private static ArrayList<String> ignoreCharacters = new ArrayList<String>();
	
	static {
		ignoreCharacters.add(" ");
		ignoreCharacters.add("\t");
	}
	
	/**
	 * Operand type
	 */
	public static final int OPERAND = 0;
	/**
	 * Operator type
	 */
	public static final int OPERATOR = 1;
	/**
	 * Left brace type
	 */
	public static final int LEFTBRACE = 2;
	/**
	 * Right brace type
	 */
	public static final int RIGHTBRACE = 3;
	
	private int type;
	private Operand operand = null;
	private Operator operator = null;
	private String name = "";
	
	/**
	 * Constructor
	 * @param operator Operator
	 */
	public Token(Operator operator) {
		this.operator = operator;
		name = operator.getName();
		type = OPERATOR;
	}
	
	/**
	 * Constructor
	 * @param operand Operand
	 */
	public Token(Operand operand) {
		this.operand = operand;
		name = operand.getStringValue();
		type = OPERAND;
	}
	
	/**
	 * Constructor
	 * @param string Bracket
	 */
	public Token(String string) {
		if (string.equals("(")) {
			type = LEFTBRACE;
		} else if (string.equals(")")) {
			type = RIGHTBRACE;
		} else {
			throw new ExpressionException("Invlid Token");
		}
		name = string;
	}
	
	/**
	 * Get name of token
	 * @return Token name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Get operator if the type is operator.
	 * @return Operator
	 * @exception ExpressionException
	 */
	public Operator getOperator() {
		if (type == OPERAND) {
			throw new ExpressionException("Type is operand");
		}
		return operator;
	}
	
	/**
	 * Get operand if the type is operand
	 * @return Operand
	 * @exception ExpressionException
	 */
	public Operand getOperand() {
		if (type == OPERATOR) {
			throw new ExpressionException("Type is operator");
		}
		return operand;
	}
	
	/**
	 * Get token type
	 * @return Token type
	 */
	public int getType() {
		return type;
	}
	
	/**
	 * Remove ignore characters
	 * @param s String to be processed
	 * @return String after removing ignore characters
	 */
	public static String removeIgnoreChars(String s) {
		if (s == null) {
			return "";
		}
		for (String ingoreChar : ignoreCharacters) {
			s = s.replaceAll(ingoreChar, "");
		}
		return s;
	}
	
	/**
	 * Print token list
	 * @param list Token list
	 */
	public static void printTokenList(ArrayList<Token> list) {
		for (Token t : list) {
			System.out.print(t.getName() + " ");
		}
		System.out.println();
	}
}
