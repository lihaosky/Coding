/*
 * Determine whether an integer is a palindrome. Do this without extra space.
 */

/**
 * Solution: Get digit count first. Then get left and right digit one by one and compare.
 * @author hali3
 *
 */
public class Solution {
    public boolean isPalindrome(int x) {
    	if (x < 0) {
    		return false;
    	}
    	int count = digitCount(x);
    	int rightBase = 10;
    	int leftBase = 1;
    	for (int i = 0; i < count - 1; i++) {
    		leftBase *= 10;
    	}
    	for (int i = 0; i < count / 2; i++) {
    		int leftDigit = (x / leftBase) % 10;
    		leftBase /= 10;
    		int rightDigit = (x % rightBase) / (rightBase / 10);
    		rightBase *= 10;
    		if (leftDigit != rightDigit) {
    			return false;
    		}
    	}
    	return true;
    }
    
    public int digitCount(int x) {
    	int count = 0;
    	while (x != 0) {
    		count++;
    		x /= 10;
    	}
    	return count;
    }
    
    public static void main(String[] args) {
    	System.out.println(new Solution().isPalindrome(1000));
    	System.out.println(new Solution().isPalindrome(1001));
    	System.out.println(new Solution().isPalindrome(1));
    	System.out.println(new Solution().isPalindrome(9));
    	System.out.println(new Solution().isPalindrome(102201));
    	System.out.println(new Solution().isPalindrome(101));
    }
}
