/*
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: 
 * (you may want to display this pattern in a fixed font for better legibility) 
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * And then read line by line: "PAHNAPLSIIGYIR"
 * Write the code that will take a string and make this conversion given a number of rows: 
 * convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR"
 * 
 */

/**
 * Solution: Find the patten
 * 
 * @author hali3
 *
 */
public class Solution {
    public String convert(String s, int nRows) {
    	if (nRows == 1) {
    		return s;
    	}
        int gap = (nRows - 1) * 2;
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < nRows; i++) {
        	if (i == 0 || i == nRows - 1) {
        		for (int j = i; j < s.length(); j += gap) {
        			sb.append(s.charAt(j));
        		}
        	} else {
        		int isDown = 1;
	        	for (int j = i; j < s.length(); ) {
	        		sb.append(s.charAt(j));
	        		if (isDown == 1) {
	        			j += (nRows - i - 1) * 2; 
	        		} else {
	        			j += i * 2;
	        		}
	        		isDown = 1 - isDown;
	        	}
        	}
        }
        
        return sb.toString();
    }
    
    public static void main(String[] args) {
    	System.out.println(new Solution().convert("PAYPALISHIRING", 3));
    }
}
