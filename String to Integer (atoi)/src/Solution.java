/*
 * Implement atoi to convert a string to an integer.
 * Hint: Carefully consider all possible input cases. 
 * If you want a challenge, please do not see below and ask yourself what are the possible input cases.
 * Notes: It is intended for this problem to be specified vaguely (ie, no given input specs). 
 * You are responsible to gather all the input requirements up front. 
 * 
 * Requirements for atoi:
 * The function first discards as many whitespace characters as necessary until the first non-whitespace character is found. 
 * Then, starting from this character, takes an optional initial plus or minus sign followed 
 * by as many numerical digits as possible, and interprets them as a numerical value.
 * The string can contain additional characters after those that form the integral number, which are ignored and have no effect on the behavior of this function.
 * If the first sequence of non-whitespace characters in str is not a valid integral number, 
 * or if no such sequence exists because either str is empty or it contains only whitespace characters, 
 * no conversion is performed. If no valid conversion could be performed, 
 * a zero value is returned. If the correct value is out of the range of representable values, 
 * INT_MAX (2147483647) or INT_MIN (-2147483648) is returned.
 */

public class Solution {
	public int atoi(String str) {
		// null or empty string, return 0
		if (str == null || str.length() == 0) {
			return 0;
		}
        str = str.trim(); // Trim leading and trailing spaces
        // Empty string after trimming
        if (str.length() == 0) {
        	return 0;
        }
        // First character isn't valid, return 0
        if (str.charAt(0) != '+' && str.charAt(0) != '-' && (str.charAt(0) > '9' || str.charAt(0) < '0')) {
        	return 0;
        }
        int sign = 1, i = 0;
        long retVal = 0;
        if (str.charAt(0) == '-' || str.charAt(0) == '+') {
        	if (str.charAt(0) == '-') {
        		sign = -1;
        	}
        	i++;
        }
        for (; i < str.length(); i++) {
        	if (str.charAt(i) > '9' || str.charAt(i) < '0') {
        		return (int) retVal * sign;
        	} else {
        		retVal = retVal * 10 + (str.charAt(i) - '0');
        		if (retVal * sign > Integer.MAX_VALUE) {
        			return Integer.MAX_VALUE;
        		}
        		if (retVal * sign < Integer.MIN_VALUE) {
        			return Integer.MIN_VALUE;
        		}
        	}
        }
        
        return (int) retVal * sign;
    }
	
	public static void main(String[] args) {
		System.out.println(new Solution().atoi("1234"));
		System.out.println(new Solution().atoi("-1234"));
		System.out.println(new Solution().atoi("12 34"));
		System.out.println(new Solution().atoi("1 234"));
		System.out.println(new Solution().atoi("+1234"));
		System.out.println(new Solution().atoi("abcd1234"));
		System.out.println(new Solution().atoi("1abcd234"));
		System.out.println(new Solution().atoi("1234abcd"));
		System.out.println(new Solution().atoi("2147483647"));
		System.out.println(new Solution().atoi("-2147483648"));
		System.out.println(new Solution().atoi("2147483648"));
		System.out.println(new Solution().atoi("-2147483649"));
		
	}
}
