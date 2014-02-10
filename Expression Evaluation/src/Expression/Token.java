package Expression;
/**
 * Token class
 * @author lihaosky
 *
 */

import java.util.ArrayList;

public class Token {
	
	public static ArrayList<String> ignoreCharacters = new ArrayList<String>();
	
	static {
		ignoreCharacters.add(" ");
		ignoreCharacters.add("\t");
	}
	
	public static final int OPERAND = 0;
	public static final int OPERATOR = 1;
	public static final int LEFTBRACE = 2;
	public static final int RIGHTBRACE = 3;
	
	private int type;
	private Operand operand = null;
	private Operator operator = null;
	
	public Token(Operator operator) {
		this.operator = operator;
		type = OPERATOR;
	}
	
	public Token(Operand operand) {
		this.operand = operand;
		type = OPERAND;
	}
	
	public Token(String string) {
		if (string.equals("(")) {
			type = LEFTBRACE;
		} else if (string.equals(")")) {
			type = RIGHTBRACE;
		} else {
			throw new ExpressionException("Invlid Token");
		}
	}
	
	public Operator getOperator() {
		if (type == OPERAND) {
			throw new ExpressionException("Type is operand");
		}
		return operator;
	}
	
	public Operand getOperand() {
		if (type == OPERATOR) {
			throw new ExpressionException("Type is operator");
		}
		return operand;
	}
	
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
}
