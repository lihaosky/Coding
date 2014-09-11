/**
 * Given a set, find minimum subset sum to a target, each number used once
 * @author hali3
 *
 */

public class Solution {
	
	public static int minSubsetSum(int[] array, int sum) {
		int[][] canSum = new int[sum + 1][array.length + 1];
		for (int i = 1; i <= sum; i++) {
			canSum[i][0] = -1;
		}
		for (int i = 0; i <= array.length; i++) {
			canSum[0][i] = 0;
		}
		for (int i = 1; i <= sum; i++) {
			for (int j = 1; j <= array.length; j++) {
				canSum[i][j] = canSum[i][j - 1];
				if (i >= array[j - 1]) {
					int count = canSum[i - array[j - 1]][j - 1];
					if (canSum[i][j] == -1) {
						if (count != -1) {
							canSum[i][j] = count + 1;
						}
					} else {
						if (count != -1 && count + 1 < canSum[i][j]) {
							canSum[i][j] = count + 1;
						}
					}
				}
			}
		}
		constructMin(array, sum, array.length, canSum);
		return canSum[sum][array.length];
	}
	
	public static void constructMin(int[] array, int sum, int len, int[][] canSum) {
		if (sum == 0) {
			return;
		}
		if (canSum[sum][len] == -1) {
			System.err.println("Can't form!!!");
			return;
		}
		if (canSum[sum][len - 1] == canSum[sum][len]) {
			constructMin(array, sum, len - 1, canSum);
		} else {
			System.out.print(array[len - 1] + " ");
			constructMin(array, sum - array[len - 1], len - 1, canSum);
		}
	}
	/**
	 * Can subset sum to target
	 * @param array
	 * @param sum
	 * @return
	 */
	public static boolean canSum(int[] array, int sum) {
		boolean[][] canSum = new boolean[sum + 1][array.length + 1];
		canSum[0][0] = true;
		for (int i = 1; i <= array.length; i++) {
			canSum[0][i] = true;
		}
		for (int i = 1; i <= sum; i++) {
			canSum[i][0] = false;
		}
		for (int i = 1; i <= sum; i++) {
			for (int j = 1; j <= array.length; j++) {
				if ((i >= array[j - 1] && canSum[i - array[j - 1]][j - 1]) || canSum[i][j - 1]) {
					canSum[i][j] = true;
				}
			}
		}
		if (canSum[sum][array.length]) {
			construct(array, sum, array.length, canSum);
		}
		return canSum[sum][array.length];
	}
	
	public static void construct(int[] array, int sum, int len, boolean[][] canSum) {
		if (sum == 0) {
			return;
		}
		if (canSum[sum][len]) {
			if (sum >= array[len - 1] && canSum[sum - array[len - 1]][len - 1]) {
				System.out.print(array[len - 1] + " ");
				construct(array, sum - array[len - 1], len - 1, canSum);
			} else {
				construct(array, sum, len - 1, canSum);
			}
		} else {
			System.out.println("Error");
		}
	}
	
	public static void main(String[] args) {
		
		int[] array = {1, 2, 4, 5, 7, 8};
		System.out.println(canSum(array, 27));
		int[] array1 = {1, 5, 6, 7};
		System.out.println(Solution.minSubsetSum(array1, 10));
	}
}
