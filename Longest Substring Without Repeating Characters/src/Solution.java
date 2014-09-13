/*
 * Given a string, find the length of the longest substring without repeating characters. 
 * For example, the longest substring without repeating letters for "abcabcbb" is "abc", which the length is 3. 
 * For "bbbbb" the longest substring is "b", with the length of 1.
 */

/**
 * Solution: At position i, record the position j such that s[j...i] is a substring without repetition.
 * Then for position i + 1, compare s[i + 1] with s[j...i] and update i + 1. 
 * Complexity: O(m^2)
 * DP.
 * @author hali3
 *
 */
public class Solution {
	public int lengthOfLongestSubstring1(String s) {
        int max = 0, curLen = 0;
        int[] appear = new int[150];
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (appear[c] == 0) {
                appear[c] = i + 1;
                curLen++;
                if (curLen > max) {
                    max = curLen;
                }
            } else {
                int start = appear[c] - 1;
                appear = new int[150];
                for (int j = start + 1; j <= i; j++) {
                    appear[s.charAt(j)] = j + 1;
                }
                curLen = i - start;
            }
        }
        
        return max;
	}
	
    public int lengthOfLongestSubstring(String s) {
       if (s.length() == 0) {
    	   return 0;
       }
       int maxLength = 1;
       int start, end;
       int[] localMaxStart = new int[s.length()];
       localMaxStart[0] = 0;
       start = end = 0;
       
       for (int i = 1; i < s.length(); i++) {
    	   int tmpMax = 1;
    	   localMaxStart[i] = i;
    	   for (int j = i - 1; j >= localMaxStart[i - 1]; j--) {
    		   if (s.charAt(j) != s.charAt(i)) {
    			   tmpMax++;
    			   localMaxStart[i] = j;
    		   } else {
    			   break;
    		   }
    	   }
    	   if (tmpMax > maxLength) {
    		   maxLength = tmpMax;
    		   start = localMaxStart[i];
    		   end = i;
    	   }
       }
       
       System.out.println("start is " + start + ", end is " + end);
       return maxLength;
    }
    
    public static void main(String[] args) {
    	String s = "abcabcbb";
    	String s1 = "bbbb";
    	String s2 = "abcdeanyedsehd";
    	
    	System.out.println(new Solution().lengthOfLongestSubstring(s));
    	System.out.println(new Solution().lengthOfLongestSubstring(s1));
    	System.out.println(new Solution().lengthOfLongestSubstring(s2));
    	boolean a = false;
    	System.out.println(!a);
    }
}
