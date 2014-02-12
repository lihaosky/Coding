import java.util.Stack;

/**
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 * The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
 * 
 * @author lihaosky
 *
 * Solution: using a stack to do this
 */
public class Solution {
    public boolean isValid(String s) {
    	if (s.length() == 0) {
    		return true;
    	}
    	Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {
        	if (s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[') {
        		stack.push(s.charAt(i));
        	} else {
        		if (stack.size() < 1) {
        			return false;
        		}
        		char c = stack.pop();
        		switch (s.charAt(i)) {
        		case ')':
        			if (c != '(') {
        				return false;
        			}
        			break;
        		case '}':
        			if (c != '{') {
        				return false;
        			}
        			break;
        		case ']':
        			if (c != '[') {
        				return false;
        			}
        			break;
        		default:
        			return false;
        		}
        	}
        }
        if (stack.size() != 0) {
        	return false;
        }
        return true;
    }
}
