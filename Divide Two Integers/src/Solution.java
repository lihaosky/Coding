/**
 * Divide two integers without using multiplication, division and mod operator. 
 * @author lihaosky
 *
 */
public class Solution {
    public static int divide2(int dividend, int divisor) {
        if (dividend == 0) {
            return 0;
        }
        if (divisor == 1) {
            return dividend;
        }
        boolean neg = false;
        if (dividend < 0 && divisor > 0) {
            neg = true;
        }
        if (dividend > 0 && divisor < 0) {
            neg = true;
        }
        long longDividend = (long)Math.abs(dividend);
        int longDivisor = Math.abs(divisor);
        System.out.println(longDividend);
        System.out.println(longDivisor);
        
        if (longDividend < longDivisor) {
            return 0;
        }
        long res = 0;
        while (longDividend >= longDivisor) {
            long mul = 1;
            long tmpDivisor = longDivisor;
            while (tmpDivisor <= longDividend) {
                mul = mul << 1;
                tmpDivisor = tmpDivisor << 1;
            }
            mul = mul >> 1;
            tmpDivisor = tmpDivisor >> 1;
            longDividend -= tmpDivisor;
            res += mul;
        }
        if (neg) {
            return (int)-res;
        }
        return (int)res;
    }
    
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
    	System.out.println(new Solution().divide2(-1010369383, -2147483648));
    }
}
