/*
 * Write a function to find the longest common prefix string amongst an array of strings. 
 */
public class Solution {
	public String longestCommonPrefix1(String[] strs) {
		if (strs.length <= 0) {
			return "";
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < strs[0].length(); i++) {
			char c = strs[0].charAt(i);
			for (int j = 1; j < strs.length; j++) {
				if ( i >= strs[j].length() || strs[j].charAt(i) != c) {
					return sb.toString();
				}
			}
			sb.append(c);
		}
		return sb.toString();
	}
	
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
		
		System.out.println(new Solution().longestCommonPrefix1(strs));
		System.out.println(new Solution().longestCommonPrefix1(strs1));
		System.out.println(new Solution().longestCommonPrefix1(strs2));
		int a = 10;
		System.out.println(-a);
	}
}
