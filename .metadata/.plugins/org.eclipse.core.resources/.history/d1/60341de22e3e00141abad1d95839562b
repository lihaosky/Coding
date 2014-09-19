/**
 * Divide two integers without using multiplication, division and mod operator. 
 * @author lihaosky
 *
 */
public class Solution {
    public int divide(int dividend, int divisor) {
        int sign = 1;
        if ((dividend < 0 && divisor > 0) || (dividend > 0 && divisor < 0)) {
            sign = -1;
        }
        long longDividend = Math.abs((long)dividend);
        long longDivisor = Math.abs((long)divisor);
        if (longDivisor == 1) {
        	return (int)(sign * longDividend);
        }
        return (int)(sign * divideRecursive(longDividend, longDivisor));
    }
    
    public long divideRecursive(long dividend, long divisor) {
        if (dividend < divisor) {
            return 0;
        }
        long base = divisor;
        long result = 1;
        while (dividend > base) {
            base = base << 1;
            result = result << 1;
        }
        if (dividend == base) {
        	return result;
        }
        base = base >> 1;
        result = result >> 1;
        return result + divideRecursive(dividend - base, divisor);
    }

    public static void main(String[] args) {
    	
    	System.out.println(-1010369383/-2147483648);
    	System.out.println(new Solution().divide(-1010369383, -2147483648));
    }
}
