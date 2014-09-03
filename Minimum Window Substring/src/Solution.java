

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
    	int[] needFind = new int[300];
    	int[] foundCount = new int[300];
    	int count = 0;
    	for (int i = 0; i < T.length(); i++) {
    		needFind[T.charAt(i)]++;
    	}
    	int start = 0, end = 0;
    	for (start = 0; start < S.length() && needFind[S.charAt(start)] < 1; start++);
    	if (start >= S.length()) {
    		return "";
    	}
    	int solStart = -1, solEnd = -1;
    	for (end = start; end < S.length(); end++) {
    		int c = S.charAt(end);
    		if (needFind[c] >= 1) {
    			foundCount[c]++;
    			if (foundCount[c] <= needFind[c]) {
    				count++;
    			}
    			if (count == T.length()) {
    				solEnd = end;
    				solStart = start;
    				break;
    			}
    		}
    	}
    	if (solStart == -1) {
    		return "";
    	}
		for (; start <= end; start++) {
			int oldC = S.charAt(start);
			if (needFind[oldC] >= 1) {
				if (foundCount[oldC] > needFind[oldC]) {
					foundCount[oldC]--;
				} else {
					break;
				}
			}
		}
		if (end - start < solEnd - solStart) {
			solEnd = end;
			solStart = start;
		}
    	end++;
    	for (; end < S.length(); end++) {
    		int c = S.charAt(end);
    		if (needFind[c] >= 1) {
    			// Not found yet
    			foundCount[c]++;
    			for (; start <= end; start++) {
    				int oldC = S.charAt(start);
    				if (needFind[oldC] >= 1) {
	    				if (foundCount[oldC] > needFind[oldC]) {
	    					foundCount[oldC]--;
	    				} else {
	    					break;
	    				}
    				}
    			}
    		}
    		if (end - start < solEnd - solStart) {
    			solEnd = end;
    			solStart = start;
    		}
    	}
    	return S.substring(solStart, solEnd + 1);
    }
    
    public void print(int[] need, int[] count) {
    	for (int i = 0; i < count.length; i++) {
    		if (need[i] >= 1) {
    			System.out.println((char)i + ": " + count[i]);
    		}
    	}
    	System.out.println("\n\n");
    }
    
    public static void main(String[] args) {
    	System.out.println(new Solution().minWindow("bba", "ab"));
    }
}
