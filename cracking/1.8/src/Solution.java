/**
 * isSubstring check whether s1 is a substring of s2. Use it to check whether s3 is an rotation of s4.
 * @author Hao
 *
 */
public class Solution {
	public static boolean isSubstring(String s1, String s2) {
		return s2.indexOf(s1) != -1;
	}
	
	public static boolean isRotation(String s1, String s2) {
		String s3 = s2 + s2;
		return isSubstring(s1, s3);
	}
	
	public static void main(String[] args) {
		System.out.println(Solution.isRotation("waterbottle", "erbottlewat"));
	}
}
