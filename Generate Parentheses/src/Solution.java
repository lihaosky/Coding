import java.util.ArrayList;

/**
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses. 
 * 
 * @author hali3
 *
 * Solution: recursively solve it. If we have more right bracket left, we can place a right or left. If left or right is equal,
 * we can only place a left. Do this until all are consumed.
 */
public class Solution {
	public ArrayList<String> generateParenthesis(int n) {
        ArrayList<String> list = new ArrayList<String>();
        if (n == 0) {
        	return list;
        }
        generate(n, n, "", list);
        return list;
    } 
	
	public void generate(int leftLeft, int rightLeft, String validString, ArrayList<String> bracketList) {
		if (leftLeft == 0 && rightLeft == 0) {
			bracketList.add(validString);
			return;
		}
		if (leftLeft == 0) {
			generate(0, rightLeft - 1, validString + ")", bracketList);
		} else {
			generate(leftLeft - 1, rightLeft, validString + "(", bracketList);
			if (leftLeft < rightLeft) {
				generate(leftLeft, rightLeft - 1, validString + ")", bracketList);
			}
		}
	}
	
	public static void main(String[] args) {
		ArrayList<String> list = new Solution().generateParenthesis(5);
		for (String s : list) {
			System.out.println(s);
		}
	}
}
