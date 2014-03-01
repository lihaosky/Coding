/**
 *  Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.

For example,
Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6. 
 * @author lihaosky
 *
 */
public class Solution {
	public int trap(int[] A) {
		int[] maxL = new int[A.length];
		int max = 0, sum = 0;
		for (int i = 0; i < A.length; i++) {
			if (A[i] > max) {
				max = A[i];
			}
			maxL[i] = max;
		}
		max = 0;
		for (int i = A.length - 1; i >= 0; i--) {
			if (A[i] > max) {
				max = A[i];
			}
			int low = Math.min(max, maxL[i]);
			if (low > A[i]) {
				sum += (low - A[i]);
			}
		}
		return sum;
	}
	
	public static void main(String[] args) {
		int[] a = {5, 1, 1, 5};
		System.out.println(new Solution().trap(a));
	}
}
