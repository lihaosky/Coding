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
		ArrayList<Token> tokenList = Expression.getPostfix("2,3,*,3,/,7,+");
		Token.printTokenList(tokenList);
		System.out.println(Expression.evaluatePostfix(tokenList).getValue());
		ArrayList<Token> infixList = Expression.getInfix("2++3");
		Token.printTokenList(infixList);
		System.out.println(Expression.evaluateInfix("2++3").getValue());
		System.out.println(Expression.evaluateInfix("2+-3").getValue());
		System.out.println(Expression.evaluateInfix("2/0").getValue());
		System.out.println(Expression.evaluateInfix("2+3*45").getValue());
		System.out.println(Expression.evaluateInfix("2+-3*10").getValue());
		System.out.println(Expression.evaluateInfix("2.4*(10+1)++3").getValue());
		
	}
}
