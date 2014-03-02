/**
 * Given two numbers represented as strings, return multiplication of the numbers as a string.
 * Note: The numbers can be arbitrarily large and are non-negative.
 * @author lihaosky
 *
 */
public class Solution {
	public String multiply(String num1, String num2) {
		if (num1.equals("0") || num2.equals("0")) {
			return "0";
		}
		StringBuilder solution = new StringBuilder();
		for (int i = num2.length() - 1; i >= 0; i--) {
			String tmp = "";
			int carry = 0;
			for (int j = num1.length() - 1; j >= 0; j--) {
				int mul = (num1.charAt(j) - '0') * (num2.charAt(i) - '0') + carry;
				tmp += (mul % 10);
				carry = mul / 10;
			}
			if (carry != 0) {
				tmp += carry;
			}
			int solPos = num2.length() - 1 - i, tmpPos = 0;
			carry = 0;
			while (tmpPos < tmp.length() || solPos < solution.length()) {
				int sum;
				if (tmpPos < tmp.length() && solPos < solution.length()) {
					sum = (tmp.charAt(tmpPos) - '0') + (solution.charAt(solPos) - '0') + carry;
					solution.setCharAt(solPos, (char)(sum % 10 + '0'));
					tmpPos++;
					solPos++;
				} else if (tmpPos < tmp.length()) {
					sum = tmp.charAt(tmpPos) - '0' + carry;
					solution.append(sum % 10);
					tmpPos++;
					solPos++;
				} else {
					sum = solution.charAt(solPos) - '0' + carry;
					solution.setCharAt(solPos, (char)(sum % 10));
					solPos++;
				}
				carry = sum / 10;
			}
			if (carry != 0) {
				solution.append(carry);
			}
		}
		return solution.reverse().toString();
	}
	
	public static void main(String[] args) {
		System.out.println(new Solution().multiply("100", "119"));
	}
}
