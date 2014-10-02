/**
 *  Find the contiguous subarray within an array (containing at least one number) which has the largest sum.

For example, given the array [−2,1,−3,4,−1,2,1,−5,4],
the contiguous subarray [4,−1,2,1] has the largest sum = 6. 
 * @author lihaosky
 *
 */
public class Solution {
    public int maxSubArray(int[] A) {
        int max = Integer.MIN_VALUE;
        int maxAtI = Integer.MIN_VALUE;
        for (int i = 0; i < A.length; i++) {
            if (maxAtI < 0) {
                maxAtI = A[i];
            } else {
                maxAtI += A[i];
            }
            if (maxAtI > max) {
                max = maxAtI;
            }
        }
        return max;
    }
    
    public int maxSubArray1(int[] A) {
        int max = Integer.MIN_VALUE, subMax = 0;
        for (int i = 0; i < A.length; i++) {
            subMax += A[i];
            if (subMax > max) {
                max = subMax;
            }
            if (subMax < 0) {
                subMax = 0;
            }
        }
        return max;
    }
}
