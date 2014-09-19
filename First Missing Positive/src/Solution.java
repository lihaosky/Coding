/**
 *  Given an unsorted integer array, find the first missing positive integer.

For example,
Given [1,2,0] return 3,
and [3,4,-1,1] return 2.

Your algorithm should run in O(n) time and uses constant space. 
 * @author lihaosky
 *
 */
public class Solution {
    public int firstMissingPositive(int[] A) {
    	for (int i = 0; i < A.length; i++) {
    		if (A[i] > 0 && A[i] != i + 1 && A[i] <= A.length) {
    			int index = A[i] - 1;
    			int tmp = A[i];
    			A[i] = A[index];
    			A[index] = tmp;
    			if (A[i] != A[index]) {
    				i--;
    			}
    		}
    	}
    	for (int i = 0; i < A.length; i++) {
    		if (A[i] != i + 1) {
    			return i + 1;
    		}
    	}
    	return A.length + 1;
    }
    
    public static void main(String[] args) {
    	int[] array = {1, 1};
    	int[] array1 = {3, 4, -1, 1};
    	System.out.println(new Solution().firstMissingPositive(array));
    	System.out.println(new Solution().firstMissingPositive(array1));
    	for (int i = 0; i < 100; i++);
    }
}
