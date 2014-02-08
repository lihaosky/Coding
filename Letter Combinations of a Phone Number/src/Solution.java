import java.util.ArrayList;

/**
 * Given a digit string, return all possible letter combinations that the number could represent.
 * A mapping of digit to letters (just like on the telephone buttons) is given below.
 * @author hali3
 *
 */
public class Solution {
	// A recursive version
	public ArrayList<String> letterCombinations1(String digits) {
		ArrayList<String> resultList = new ArrayList<String>();
		String[] dToL = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
		if (digits.length() <= 0) {
			resultList.add("");
			return resultList;
		}
		generateList(digits, resultList, dToL, "");
		return resultList;
	}
	
	public void generateList(String digits, ArrayList<String> resultList, String[] dToL, String current) {
		if (digits.length() <= 0) {
			resultList.add(current);
			return;
		}
		int digit = digits.charAt(0) - '0';
		for (int i = 0; i < dToL[digit].length(); i++) {
			generateList(digits.substring(1), resultList, dToL, current + dToL[digit].charAt(i));
		}
	}
	
    public ArrayList<String> letterCombinations(String digits) {
    	ArrayList<String> resultList = new ArrayList<String>();
        String[] dToL = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        if (digits.length() <= 0) {
        	resultList.add("");
        	return resultList;
        }
        int[] curIndex = new int[digits.length()];
        while (true) {
        	StringBuilder sb = new StringBuilder();
        	for (int i = 0; i < digits.length(); i++) {
        		sb.append(dToL[digits.charAt(i) - '0'].charAt(curIndex[i]));
        	}
        	resultList.add(sb.toString());
        	curIndex[digits.length() - 1]++;
        	// BackTrack
        	if (curIndex[digits.length() - 1] == dToL[digits.charAt(digits.length() - 1) - '0'].length()) {
        		int i;
        		for (i = digits.length() - 1; i >= 0; i--) {
        			if (curIndex[i] >= dToL[digits.charAt(i) - '0'].length() - 1) {
        				curIndex[i] = 0;
        			} else {
        				break;
        			}
        		}
        		if (i < 0) {
        			break;
        		} else {
        			curIndex[i]++;
        		}
        	}
        }
        return resultList;
    }
    
    public static void main(String[] args) {
    	ArrayList<String> list = new Solution().letterCombinations1("2345");
    	for (String s : list) {
    		System.out.println(s);
    	}
    }
}
