/*
 * Given an integer, convert it to a roman numeral.
 * Input is guaranteed to be within the range from 1 to 3999.
 */

public class Solution {
    public String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();
        char[] romanMap = {'M', 'D', 'C', 'L', 'X', 'V', 'I'};
        int scale = 1000;
        
        for (int i = 0; i < romanMap.length; i += 2) {
        	int count = num / scale;
        	if (count != 0) {
        		if (count == 9) {
        			sb.append(romanMap[i]);
        			sb.append(romanMap[i - 2]);
        		} else if (count == 4) {
        			sb.append(romanMap[i]);
        			sb.append(romanMap[i - 1]);
        		} else if (count == 5) {
        			sb.append(romanMap[i - 1]);
        		} else if (count <= 3) {
        			for (int j = 0; j < count; j++) {
        				sb.append(romanMap[i]);
        			}
        		} else {
        			sb.append(romanMap[i - 1]);
        			for (int j = 0; j < count - 5; j++) {
        				sb.append(romanMap[i]);
        			}
        		}
        	}
        	num -= count * scale;
        	scale /= 10;
        }
        return sb.toString();
    }
    
    public static void main(String[] args) {
    	System.out.println(new Solution().intToRoman(1000));
    	System.out.println(new Solution().intToRoman(900));
    	System.out.println(new Solution().intToRoman(890));
    	System.out.println(new Solution().intToRoman((4)));
    	System.out.println(new Solution().intToRoman(7));
    	System.out.println(new Solution().intToRoman(10));
    	System.out.println(new Solution().intToRoman(11));
    }
}
