/**
 * Determine if two strings are anagram or not
 * @author Hao
 *
 */
public class Solution {
	public static boolean isAnagram(String a, String b) {
		if (a.length() != b.length()) {
			return false;
		}
		int[] charCount = new int[200];
		for (int i = 0; i < a.length(); i++) {
			charCount[a.charAt(i)]++;
			charCount[b.charAt(i)]--;
		}
		for (int i = 0; i < charCount.length; i++) {
			if (charCount[i] != 0) {
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		System.out.println(Solution.isAnagram("abcd", "acdb"));
		System.out.println(Solution.isAnagram("abcd", "acb"));
		System.out.println(Solution.isAnagram("d", "b"));
	}
}
