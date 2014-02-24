/**
 * Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

You may assume no duplicates in the array.

Here are few examples.
[1,3,5,6], 5 → 2
[1,3,5,6], 2 → 1
[1,3,5,6], 7 → 4
[1,3,5,6], 0 → 0 
 * @author lihaosky
 *
 */
public class Solution {
    public int searchInsert(int[] A, int target) {
        int l = 0;
        int h = A.length - 1;
        while (l <= h) {
        	int mid = (l + h) / 2;
        	if (A[mid] == target) {
        		return mid;
        	}
        	if (target < A[mid]) {
        		h = mid - 1;
        	} else {
        		l = mid + 1;
        	}
        }
        return l;
    }
    
    public static void main(String[] args) {
    	int[] a = {1, 2, 3, 5, 7};
    	int[] a1 = {1};
    	int[] a2 = {1, 3, 3, 5, 7};
    	int[] a3 = {3, 3};
    	System.out.println(new Solution().searchInsert(a, 1));
    	System.out.println(new Solution().searchInsert(a, 8));
    	System.out.println(new Solution().searchInsert(a, 0));
    	System.out.println(new Solution().searchInsert(a, 4));
    	System.out.println(new Solution().searchInsert(a1, 2));
    	System.out.println(new Solution().searchInsert(a2, 4));
    	System.out.println(new Solution().searchInsert(a2, 8));
    }
}
