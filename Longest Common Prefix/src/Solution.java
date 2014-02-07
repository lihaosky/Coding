/*
 * Write a function to find the longest common prefix string amongst an array of strings. 
 */
public class Solution {
	public String longestCommonPrefix(String[] strs) {
		if (strs.length == 0) {
			return "";
		}
		int minLen = strs[0].length();
		for (int i = 1; i < strs.length; i++) {
			if (strs[i].length() < minLen) {
				minLen = strs[i].length();
			}
		}
		String ans = "";
		for (int i = 0; i < minLen; i++) {
			char targetChar = strs[0].charAt(i);
			for (int j = 1; j < strs.length; j++) {
				if (strs[j].charAt(i) != targetChar) {
					return ans;
				}
			}
			ans += targetChar;
		}
		return ans;
	}
	
	public static void main(String[] args) {
		String[] strs = {"abcd", "abcd", "ab", "abde"};
		String[] strs1 = {"aaaaa", "aaaa", "aaa", "aaaa"};
		String[] strs2 = {"", "", "abcd", "bacd", "adkiekdj"};
		
		System.out.println(new Solution().longestCommonPrefix(strs));
		System.out.println(new Solution().longestCommonPrefix(strs1));
		System.out.println(new Solution().longestCommonPrefix(strs2));
	}
}
