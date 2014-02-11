package Expression;

import java.util.ArrayList;

public class Tokenizer {
	private String expression = "";
	private int curIndex;
	private ArrayList<Operator> operatorList = null;
	
	public Tokenizer(String expression) {
		this(expression, Expression.defaultOperatorList);
	}
	
	public Tokenizer(String expression, ArrayList<Operator> operatorList) {
		this.expression = expression;
		this.operatorList = operatorList;
		curIndex = 0;
	}
	
	public Token getNextToken() {
		return new Token("");
	}
	
	public ArrayList<Token> getPostfixTokenList() {
		String[] tokens = expression.split(",");
		ArrayList<Token> tokenList = new ArrayList<Token>();
		if (!generateTokenList(tokens, 0, tokenList)) {
			throw new ExpressionException("Invalid postfix expression");
		}
		return tokenList;
	}
	
	private boolean generateTokenList(String[] tokens, int start, ArrayList<Token> tokenList) {
		// Processed all tokens, now try to evaluate
		if (start == tokens.length) {
			try {
				Expression.evaluatePostfix(tokenList);
				return true;
			} catch (Exception e) {
				return false;
			}
		}
		boolean isOperator = false;
		for (Operator op : operatorList) {
			// This token is an operator
			if (op.getName().equals(tokens[start])) {
				isOperator = true;
				tokenList.add(new Token(op));
				if (generateTokenList(tokens, start + 1, tokenList)) {
					return true;
				}
				tokenList.remove(tokenList.size() - 1);
			}
		}
		if (!isOperator) {
			try {
				Operand operand = new Operand(tokens[start]);
				tokenList.add(new Token(operand));
				if (!generateTokenList(tokens, start + 1, tokenList)) {
					tokenList.remove(tokenList.size() - 1);
					return false;
				}
				return true;
			} catch (Exception e) {
				return false;
			}
		}
		return false;
	}
	
}
