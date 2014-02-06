/*
 * Given a roman numeral, convert it to an integer.
 * Input is guaranteed to be within the range from 1 to 3999.
 */

public class Solution {
	public int rToi(char c) {
		switch (c) {
		case 'M': return 1000;
		case 'D': return 500;
		case 'C': return 100;
		case 'L': return 50;
		case 'X': return 10;
		case 'V': return 5;
		case 'I': return 1;
		default: return 0;
		}
	}
	
	public int romanToInt2(String s) {
		int number = 0;
		for (int i = 0; i < s.length(); i++) {
			if (i > 0 && rToi(s.charAt(i)) > rToi(s.charAt(i - 1))) {
				number += (rToi(s.charAt(i)) - 2 * rToi(s.charAt(i - 1)));
			} else {
				number += rToi(s.charAt(i));
			}
		}
		return number;
	}
    public int romanToInt(String s) {
    	int number = 0;
        for (int i = 0; i < s.length(); i++) {
        	switch (s.charAt(i)) {
        	case 'M':
        		number += 1000;
        		break;
        	case 'D':
        		number += 500;
        		break;
        	case 'C':
        		if (i + 1 < s.length() && s.charAt(i + 1) == 'M') {
        			number += 900;
        			i++;
        		} else if (i + 1 < s.length() && s.charAt(i + 1) == 'D') {
        			number += 400;
        			i++;
        		} else {
        			number += 100;
        		}
        		break;
        	case 'L':
        		number += 50;
        		break;
        	case 'X':
        		if (i + 1 < s.length() && s.charAt(i + 1) == 'C') {
        			number += 90;
        			i++;
        		} else if (i + 1 < s.length() && s.charAt(i + 1) == 'L') {
        			number += 40;
        			i++;
        		} else {
        			number += 10;
        		}
        		break;
        	case 'V':
        		number += 5;
        		break;
        	case 'I':
        		if (i + 1 < s.length() && s.charAt(i + 1) == 'X') {
        			number += 9;
        			i++;
        		} else if (i + 1 < s.length() && s.charAt(i + 1) == 'V') {
        			number += 4;
        			i++;
        		} else {
        			number += 1;
        		}
        		break;
        	}
        }
        return number;
    }
    
    public static void main(String[] args) {
    	System.out.println(new Solution().romanToInt("XXX"));
    	System.out.println(new Solution().romanToInt("IX"));
    	System.out.println(new Solution().romanToInt("XII"));
    	System.out.println(new Solution().romanToInt("MMXIV"));
    	System.out.println(new Solution().romanToInt("CMXCIX"));
    }
}