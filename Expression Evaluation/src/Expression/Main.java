package Expression;

import java.util.ArrayList;

public class Main {
	public static void main(String[] args) {
		int type = 0x0;
		type |= 0x1;
		System.out.println(type);
		type |= 0x2;
		System.out.println(type);
		String s = "   abs skdk ";
		String s1 = s.replaceAll(" ", "");
		System.out.println(s1 + " " + s1.length());
		ArrayList<Token> tokenList = new Tokenizer("2,3,*,3,/,7,+").getPostfixTokenList();
		Token.printTokenList(tokenList);
		System.out.println(Expression.evaluatePostfix(tokenList).getValue());
		
	}
}
