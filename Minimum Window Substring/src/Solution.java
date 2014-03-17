import java.util.HashMap;

/**
 *  Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).

For example,
S = "ADOBECODEBANC"
T = "ABC"

Minimum window is "BANC".

Note:
If there is no such window in S that covers all characters in T, return the emtpy string "".

If there are multiple such windows, you are guaranteed that there will always be only one unique minimum window in S. 
 * @author hali3
 *
 */
public class Solution {
    public String minWindow(String S, String T) {
        String res = "";
        HashMap<Character, Integer> charMap = new HashMap<Character, Integer>();
        int expected_count = 0;
        int total_count = 0;
        int min = -1;
        int len = 0;
        for (int i = 0; i < T.length(); i++) {
        	Integer count = charMap.get(T.charAt(i));
        	if (count == null) {
        		charMap.put(T.charAt(i), -1);
        		expected_count++;
        	}
        }
        for (int i = 0; i < S.length(); i++) {
        	if (charMap.containsKey(S.charAt(i))) {
        		if (charMap.get(S.charAt(i)) == -1) {
        			charMap.put(S.charAt(i), 1);
        			total_count++;
        			if (min == -1) {
        				min = i;
        			}
        			if (total_count == expected_count) {
        				if (i - min + 1 < len) {
        					len = i - min + 1;
        					res = S.substring(min, min + len);
        				}
        			}
        		} else {
        			
        		}
        	}
        }
        return res;
    }
    
    public static void main(String[] args) {
    	System.out.println(new Solution().minWindow("ADOBECODEBANC", "ABC"));
    }
}
