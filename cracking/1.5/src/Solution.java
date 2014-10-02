/**
 * Replace every space in a string with %20
 * @author Hao
 *
 */
public class Solution {
	public static String replace(String s) {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == ' ') {
				sb.append("%20");
			} else {
				sb.append(s.charAt(i));
			}
		}
		return sb.toString();
	}
	
	public static void main(String[] args) {
		String s = "li hao is ";
		System.out.println(Solution.replace(s));
	}
}
