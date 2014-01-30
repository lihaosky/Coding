/*
 * Given a string S, find the longest palindromic substring in S. 
 * You may assume that the maximum length of S is 1000, and there exists one unique longest palindromic substring.
 */

/**
 * Solution: Record if s[i...j] is palindrome and for j + 1, if s[i] == s[j + 1] and s[i + 1][j - 1] is palindrome,
 * Then s[i][j] is palindrome.
 * @author hali3
 *
 */
public class Solution {
    public String longestPalindrome(String s) {
    	if (s.length() == 0 || s.length() == 1) {
    		return s;
    	}
    	
    	int longest = 1, start, end;
    	start = end = 0;
    	
        boolean[][] isPalindrome = new boolean[s.length()][s.length()];
 
        for (int i = 0; i < s.length(); i++) {
        	isPalindrome[i][i] = true;
        }
        
        for (int i = 1; i < s.length(); i++) {
        	for (int j = 0; j < i; j++) {
        		if (s.charAt(i) == s.charAt(j) && (i - j == 1 || isPalindrome[j + 1][i - 1] == true)) {
        			isPalindrome[j][i] = true;
        			int len = i - j + 1;
        			if (len > longest) {
        				longest = len;
        				start = j;
        				end = i;
        			}
        		}
        	}
        }
        return s.substring(start, end + 1);
    }
    
    public static void main(String[] args) {
    	String s = "abbbba";
    	System.out.println(new Solution().longestPalindrome(s));
    }
}
