/**
 *  Given an array of non-negative integers, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Determine if you are able to reach the last index.

For example:
A = [2,3,1,1,4], return true.

A = [3,2,1,0,4], return false. 
 * @author lihaosky
 *
 */
public class Solution {
    public boolean canJump(int[] A) {
    	if (A.length <= 0) {
    		return false;
    	}
        int maxCover = A[0];
        int i = 1;
        if (maxCover >= A.length - 1) {
        	return true;
        }
        while (i <= maxCover) {
        	int nextCover = i + A[i];
        	if (nextCover >= A.length - 1) {
        		return true;
        	}
        	if (nextCover > maxCover) {
        		maxCover = nextCover;
        	}
        	i++;
        }
        return false;
    }
    
    public boolean canJumpRecursive(int[] A, int start) {
    	if (start >= A.length - 1) {
    		return true;
    	}
    	for (int i = 1; i <= A[start]; i++) {
    		if (canJumpRecursive(A, start + i)) {
    			return true;
    		}
    	}
    	return false;
    }
}
