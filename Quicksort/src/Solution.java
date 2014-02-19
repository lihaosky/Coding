import java.util.Random;

/**
 * Quick sort with different partition method
 * 
 * @author hali3
 *
 */
public class Solution {
	public void quicksort(int[] array) {
		quicksortRecursive(array, 0, array.length - 1);
	}
	
	public void quicksortRecursive(int[] array, int start, int end) {
		if (start >= end) {
			return;
		}
		int pivot = partition(array, start, end);
		quicksortRecursive(array, start, pivot - 1);
		quicksortRecursive(array, pivot + 1, end);
	}
	
	public int partition1(int[] array, int start, int end) {
		Random r = new Random();
		int pivot = r.nextInt(end - start + 1) + start;
		int tmp = array[pivot];
		array[pivot] = array[end];
		array[end] = tmp;
		int l = start - 1;
		for (int h = start; h < end; h++) {
			if (array[h] < array[end]) {
				l++;
				tmp = array[h];
				array[h] = array[l];
				array[l] = tmp;
			}
		}
		l++;
		tmp = array[end];
		array[end] = array[l];
		array[l] = tmp;
		return l;
	}
	
	public int partition(int[] array, int start, int end) {
		Random r = new Random();
		int pivot = r.nextInt(end - start + 1) + start;
		int tmp = array[pivot];
		array[pivot] = array[end];
		array[end] = tmp;
		int low = start;
		int high = end;
		while (low < high) {
			while (low <= end && array[low] < array[end]) {
				low++;
			}
			while (high >= start && array[high] >= array[end]) {
				high--;
			}
			if (low < high) {
				tmp = array[low];
				array[low] = array[high];
				array[high] = tmp;
			}
		}
		tmp = array[end];
		array[end] = array[low];
		array[low] = tmp;
		return low;
	}
	
	public static void print(int[] array) {
		for (int i : array) {
			System.out.print(i + " ");
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		int[] array = {4, 6, 2, 3, 1, 7};
		int[] array1 = {1, 2};
		int[] array2 = {1};
		int[] array3 = {2, 1};
		int[] array4 = {3, 2, 1};
		new Solution().quicksort(array);
		new Solution().quicksort(array1);
		new Solution().quicksort(array2);
		new Solution().quicksort(array3);
		new Solution().quicksort(array4);
		Solution.print(array);
		Solution.print(array1);
		Solution.print(array2);
		Solution.print(array3);
		Solution.print(array4);
	}
}
