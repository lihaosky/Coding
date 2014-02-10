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
		operatorList = operatorList;
		curIndex = 0;
	}
	
	public Token getNextToken() {
		return new Token("");
	}
	
	public ArrayList<Token> getPostfixTokenList() {
		String[] tokens = expression.split(",");
		for (String token : tokens) {
			
		}
		
	}
}
