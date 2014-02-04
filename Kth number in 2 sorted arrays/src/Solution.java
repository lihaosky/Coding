/**
 * Find the Kth number in two sorted array
 * @author hali3
 *
 */
public class Solution {
	int findKthNumber(int[] array1, int[] array2, int k) {
		if (k > array1.length + array2.length) {
			return -1;
		}
		return findKthNumberRecursive(array1, array2, k, 0, array1.length, 0, array2.length);
	}
	
	int findKthNumberRecursive(int[] array1, int[] array2, int k, int a1Start, int a1Size, int a2Start, int a2Size) {
		// array1 is empty
		if (a1Size == 0) {
			return array2[a2Start + k - 1];
		}
		// array2 is empty
		if (a2Size == 0) {
			return array1[a1Start + k - 1];
		}
		// If find the first number, compare directly
		if (k == 1) {
			if (array1[a1Start] > array2[a2Start]) {
				return array2[a2Start];
			} else {
				return array1[a1Start];
			}
		}
		// array1 has less than k number
		if (a1Size < k) {
			// In this case the number in array2 is larger than exactly k - 1 numbers
			if (array1[a1Start + a1Size - 1] < array2[a2Start + k - a1Size - 1]) {
				return array2[a2Start + k - a1Size - 1];
			}
			// Now the number lies in array1[start...start + size - 1] and array2[start + 1...start + size - 1]
			// One number is chopped, so find k - 1 th number
			else {
				return findKthNumberRecursive(array1, array2, k - 1, a1Start, a1Size, a2Start + 1, a2Size - 1);
			}
		}
		// array2 has less than k number
		if (a2Size < k) {
			if (array2[a2Start + a2Size - 1] < array1[a1Start + k - a2Size - 1]) {
				return array1[a1Start + a1Size - 1];
			} else {
				return findKthNumberRecursive(array1, array2, k - 1, a1Start + 1, a1Size - 1, a2Start, a2Size);
			}
		}
		// They have larger than k number, compare the middle one
		// In this case, the number lies in array1[start...start+k/2] and array2[start+k/2, start+size-1]
		if (array1[a1Start + k / 2] > array2[a2Start + k / 2]) {
			return findKthNumberRecursive(array1, array2, k - k / 2, a1Start, 1 + k / 2, a2Start + k / 2, a2Size - k / 2);
		} else {
			return findKthNumberRecursive(array1, array2, k - k / 2, a1Start + k / 2, a1Size - k / 2, a2Start, 1 + k / 2);
		}
	}
	
	public static void main(String[] args) {
		int[] a1 = {1};
		int[] a2 = {4, 5, 7, 9};
		System.out.println(new Solution().findKthNumber(a1, a2, 2));
	}
}
