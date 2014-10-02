/**
 * If a string has all unique characters
 * @author Hao
 *
 */
public class Solution {
	public boolean isUnique(String a) {
		for (int i = 0; i < a.length(); i++) {
			for (int j = i + 1; j < a.length(); j++) {
				if (a.charAt(i) == a.charAt(j)) {
					return false;
				}
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		System.out.println(new Solution().isUnique("abcd"));
		System.out.println(new Solution().isUnique("a"));
		System.out.println(new Solution().isUnique("aa"));
		System.out.println(new Solution().isUnique("abcdb"));
	}
}
