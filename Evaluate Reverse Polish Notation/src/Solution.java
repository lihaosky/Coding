import java.util.Stack;


public class Solution {
    public int evalRPN(String[] tokens) {
    	if (tokens == null || tokens.length <= 0) {
    		return 0;
    	}
        Stack<Integer> valueStack = new Stack<Integer>();
        for (String token : tokens) {
        	if (token.equals("+")) {
        		int operand1 = valueStack.pop();
        		int operand2 = valueStack.pop();
        		valueStack.push(operand1 + operand2);
        	} else if (token.equals("-")) {
        		int operand1 = valueStack.pop();
        		int operand2 = valueStack.pop();
        		valueStack.push(operand2 - operand1);
        	} else if (token.equals("*")) {
        		int operand1 = valueStack.pop();
        		int operand2 = valueStack.pop();
        		valueStack.push(operand2 * operand1);
        	} else if (token.equals("/")) {
        		int operand1 = valueStack.pop();
        		int operand2 = valueStack.pop();
        		valueStack.push(operand2 / operand1);
        	} else {
        		valueStack.push(Integer.parseInt(token));
        	}
        }
        return valueStack.pop();
    }
}
