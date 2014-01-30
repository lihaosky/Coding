/*
 * Reverse digits of an integer.
 * 
 * Example1: x = 123, return 321
 * Example2: x = -123, return -321 
 * 
 * Have you thought about this?

 * Here are some good questions to ask before coding. Bonus points for you if you have already thought through this!
 * If the integer's last digit is 0, what should the output be? ie, cases such as 10, 100.
 * Did you notice that the reversed integer might overflow? Assume the input is a 32-bit integer, then the reverse of 1000000003 overflows. How should you handle such cases?
 * Throw an exception? Good, but what if throwing an exception is not an option? You would then have to re-design the function (ie, add an extra parameter).
 */
/**
 * Solution: this is an easy one!
 * @author hali3
 *
 */
public class Solution {
    public int reverse(int x) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
    	int sign = 1;
    	if (x < 0) {
    		sign = -1;
    	}
    	int retVal = 0;
    	x = Math.abs(x);
    	while (x != 0) {
    		retVal = retVal * 10 + x  % 10;
    		x /= 10;
    	}
    	
        return retVal * sign;
    }
    
    public static void main(String[] args) {
    	System.out.println(new Solution().reverse(0));
    	System.out.println(new Solution().reverse(-1));
    	System.out.println(new Solution().reverse(1));
    	System.out.println(new Solution().reverse(21));
    	System.out.println(new Solution().reverse(111987));
    }
}
