/**
 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 * You are given a target value to search. If found in the array return its index, otherwise return -1.
 * You may assume no duplicate exists in the array.
 * 
 * @author lihaosky
 *
 */
public class Solution {
    public int search(int[] A, int target) {
    	int l = 0;
    	int r = A.length - 1;
    	while (l <= r) {
    		int mid = (l + r) / 2;
    		if (A[mid] == target) {
    			return mid;
    		}
    		if (A[mid] >= A[l]) {
    			if (A[mid] > target && target >= A[l]) {
    				r = mid - 1;
    			} else {
    				l = mid + 1;
    			}
    		} else {
    			if (target >= A[l] || target < A[mid]) {
    				r = mid - 1;
    			} else {
    				l = mid + 1;
    			}
    		}
    	}
    	return -1;
    }
    
    public int searchRange(int[] A, int start, int end, int target) {
    	if (start > end) {
    		return -1;
    	}
    	int mid = (end - start) / 2 + start;
    	if (target == A[mid]) {
    		return mid;
    	}
    	if (target > A[mid]) {
			int retVal = searchRange(A, mid + 1, end, target);
			if (retVal != -1) {
				return retVal;
			}
    		if (A[mid] < A[start]) {
    			retVal = searchRange(A, start, mid - 1, target);
    		}
    		return retVal;
    	} else {
    		int retVal = searchRange(A, start, mid - 1, target);
    		if (retVal != -1) {
    			return retVal;
    		}
    		if (A[mid] > A[end]) {
    			retVal = searchRange(A, mid + 1, end, target);
    		}	
    		return retVal;
    	}
    }
    
    public static void main(String[] args) {
    	int[] num = {5, 6, 7, 1, 2, 3, 4};
    	int[] num1 = {1, 2, 3, 4};
    	int[] num2 = {1};
    	int[] num3 = {4, 5, 1};
    	
    	System.out.println(new Solution().search(num, 0));
    	System.out.println(new Solution().search(num, -1));
    	System.out.println(new Solution().search(num, 1));
    	System.out.println(new Solution().search(num, 2));
    	System.out.println(new Solution().search(num, 4));
    	System.out.println(new Solution().search(num, 5));
    	System.out.println(new Solution().search(num, 7));
    	System.out.println(new Solution().search(num1, 1));
    	System.out.println(new Solution().search(num1, 0));
    	System.out.println(new Solution().search(num1, 4));
    	System.out.println(new Solution().search(num2, 1));
    	System.out.println(new Solution().search(num2, 0));
    	System.out.println(new Solution().search(num2, 5));
    	System.out.println(new Solution().search(num3, 4));
    	System.out.println(new Solution().search(num3, 5));
    }
}
