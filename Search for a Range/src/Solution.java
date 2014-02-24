/**
 * Given a sorted array of integers, find the starting and ending position of a given target value.

Your algorithm's runtime complexity must be in the order of O(log n).

If the target is not found in the array, return [-1, -1].

For example,
Given [5, 7, 7, 8, 8, 10] and target value 8,
return [3, 4].


 * @author lihaosky
 *
 */
public class Solution {
	public int[] searchRange1(int[] A, int target) {
		int[] result = new int[2];
		result[0] = result[1] = -1;
		int low = 0, high = A.length - 1;
		while (low < high) {
			int mid = (low + high) / 2;
			if (A[mid] < target) {
				low = mid + 1;
			} else if (A[mid] > target) {
				high = mid - 1;
			} else {
				high = result[0] = mid;
			}
		}
		if (result[0] == -1) {
			return result;
		}
		low = 0;
		high = A.length - 1;
		while (low < high) {
			int mid = (low + high) / 2;
			if (A[mid] > target) {
				high = mid - 1;
			} else if (A[mid] < target) {
				low = mid + 1;
			} else {
				result[1] = mid;
				low = mid + 1;
			}
		}
		return result;
	}
	
    public int[] searchRange(int[] A, int target) {
        int[] result = new int[2];
        result[0] = result[1] = -1;
        int firstIndex = search(A, 0, A.length - 1, target);
        if (firstIndex == -1) {
        	return result;
        }
        result[0] = result[1] = firstIndex;
        int lowIndex = search(A, 0, firstIndex - 1, target);
        while (lowIndex != -1) {
        	result[0] = lowIndex;
        	lowIndex = search(A, 0, lowIndex - 1, target);
        }
        int highIndex = search(A, firstIndex + 1, A.length - 1, target);
        while (highIndex != -1) {
        	result[1] = highIndex;
        	highIndex = search(A, highIndex + 1, A.length - 1, target);
        }
        return result;
    }
    
    public int search(int[] A, int start, int end, int target) {
    	if (start > end) {
    		return -1;
    	}
    	int mid = (start + end) / 2;
    	if (A[mid] == target) {
    		return mid;
    	}
    	if (A[mid] > target) {
    		return search(A, start, mid - 1, target);
    	}
    	return search(A, mid + 1, end, target);
    }
}
