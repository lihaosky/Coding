/**
 * Follow up for "Search in Rotated Sorted Array":
What if duplicates are allowed?

Would this affect the run-time complexity? How and why?

Write a function to determine if a given target is in the array.
 * @author hali3
 *
 */
public class Solution {
    public boolean search(int[] A, int target) {
    	if (A == null || A.length <= 0) {
    		return false;
    	}
        int low = 0;
        int high = A.length - 1;
        while (low <= high) {
        	int mid = (low + high) / 2;
        	if (A[mid] == target) {
        		return true;
        	}
        	if (A[mid] > A[low]) {
        		if (target < A[mid] && target >= A[low]) {
        			high = mid - 1;
        		} else {
        			low = mid + 1;
        		}
        	} else if (A[mid] < A[low]){
        		if (target > A[mid] && target <= A[high]) {
        			low = mid + 1;
        		} else {
        			high = mid - 1;
        		}
        	} else {
        		low++;
        	}
        }
        return false;
    }
}
