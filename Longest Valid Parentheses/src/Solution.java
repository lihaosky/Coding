import java.util.ArrayList;
import java.util.Stack;

/**
 * Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.

For "(()", the longest valid parentheses substring is "()", which has length = 2.

Another example is ")()())", where the longest valid parentheses substring is "()()", which has length = 4. 
 * @author lihaosky
 *
 */
public class Solution {
    public int longestValidParentheses(String s) {
    	Stack<Character> charStack = new Stack<Character>();
    	Stack<Integer> intStack = new Stack<Integer>();
    	int maxLen = 0;
    	
    	for (int i = 0; i < s.length(); i++) {
    		if (s.charAt(i) == '(') {
    			charStack.push(s.charAt(i));
    			intStack.push(i);
    		} else {
    			if (charStack.isEmpty() == false && charStack.peek() == '(') {
    				charStack.pop();
    				intStack.pop();
    				if (intStack.isEmpty()) {
    					if (i + 1 > maxLen) {
    						maxLen = i + 1;
    					}
    				} else {
    					if (i - intStack.peek() > maxLen) {
    						maxLen = i - intStack.peek();
    					}
    				}
    			} else {
    				charStack.push(s.charAt(i));
    				intStack.push(i);
    			}
    		}
    	}
    	return maxLen;
    }
    
    public int longestValidParentheses1(String s) {
        int max = 0;
        Stack<Integer> stack = new Stack<Integer>();
        int[] len = new int[s.length() + 1];
        
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                if (!stack.empty()) {
                    int match = stack.pop();
                    len[i + 1] = len[match] + i - match + 1;
                    if (len[i + 1] > max) {
                        max = len[i + 1];
                    }
                }
            }
        }
        return max;
    }
    
    public static void main(String[] args) {
    	System.out.println(new Solution().longestValidParentheses("(()"));
    	System.out.println(new Solution().longestValidParentheses("(())"));
    	System.out.println(new Solution().longestValidParentheses(")()())"));
    	System.out.println(new Solution().longestValidParentheses("("));
    	System.out.println(new Solution().longestValidParentheses("(((())))"));
    	System.out.println(new Solution().longestValidParentheses(")())"));
    	
    	char c = '9';
    	c = (char) (c - 8);
    	System.out.println(c);
    	ArrayList<Integer> a = new ArrayList<Integer>();
    	a.addAll(null);
    }
}
