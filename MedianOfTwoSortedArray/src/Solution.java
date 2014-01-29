
public class Solution {
    public double findMedianSortedArrays(int A[], int B[]) {
    	if (A.length == 0 && B.length == 0) {
    		return 0;
    	}
    	if (A.length == 0 || B.length == 0) {
    		int[] tmp = null;
    		if (A.length == 0) {
    			tmp = B;
    		} else {
    			tmp = A;
    		}
    		// If length is even, take average. If odd, take median
    		if (tmp.length % 2 == 0) {
    			return (tmp[tmp.length / 2] + tmp[tmp.length / 2 - 1]) / 2.0;
    		} else {
    			return tmp[tmp.length / 2];
    		}
    	}
    	return findMedianSortedArrays(A, B, 0, A.length - 1, 0, B.length - 1);
    }
    
    public double findMedianSortedArrays(int A[], int B[], int aLow, int aHigh, int bLow, int bHigh) {
    	int[] tmp = null;
    	int tmpNumber;
    	// Let A always has less length
    	if (bHigh - bLow < aHigh - aLow) {
    		tmp = A;
    		A = B;
    		B = tmp;
    		tmpNumber = aLow;
    		aLow = bLow;
    		bLow = tmpNumber;
    		tmpNumber = aHigh;
    		aHigh = bHigh;
    		bHigh = tmpNumber;
    	}
    	// Base case, A's length is 1
    	if (aHigh == aLow) {
    		if (bHigh == bLow) {
    			return avg(A[aLow], B[bLow]);
    		}
    		int mid = (bLow + bHigh) / 2;
    		// B has even number
    		if ((bLow + bHigh) % 2 == 1) {
    			if (A[aLow] >= B[mid] && A[aLow] <= B[mid + 1]) {
    				return A[aLow];
    			} else if (A[aLow] < B[mid]) {
    				return B[mid];
    			} else {
    				return B[mid + 1];
    			}
    		} 
    		// B has odd number
    		else {
    			if (A[aLow] <= B[mid - 1]) {
    				return avg(B[mid - 1], B[mid]);
    			} else if (A[aLow] > B[mid - 1] && A[aLow] <= B[mid]) {
    				return avg(A[aLow], B[mid]);
    			} else if (A[aLow] > B[mid] && A[aLow] <= B[mid + 1]) {
    				return avg(A[aLow], B[mid]);
    			} else {
    				return avg(B[mid], B[mid + 1]);
    			}
    		}
    	}
    	// If A's length is 2
    	if (aHigh - aLow == 1) {
    		int mid = (bLow + bHigh) / 2;
    		// B's length is 2
    		if (bHigh - bLow == 1) {
    			if (A[aHigh] < B[mid]) {
    				return avg(A[aHigh], B[mid]);
    			} else if (A[aHigh] >= B[mid] && A[aHigh] <= B[mid + 1] && A[aLow] < B[mid]) {
    				return avg(B[mid], A[aHigh]);
    			} else if (A[aLow] >= B[mid] && A[aHigh] <= B[mid + 1]) {
    				return avg(A[aLow], A[aHigh]);
    			} else if (A[aLow] >= B[mid] && A[aLow] < B[mid + 1] && A[aHigh] > B[mid + 1]) {
    				return avg(A[aLow], B[mid + 1]);
    			} else if (A[aLow] >= B[mid + 1]) {
    				return avg(A[aLow], B[mid + 1]);
    			} else {
    				return avg(B[mid], B[mid + 1]);
    			}
    		}
    		// B has even number
    		if ((bLow + bHigh) % 2 == 1) {
    			if (A[aHigh] <= B[mid - 1]) {
    				return avg(B[mid - 1], B[mid]);
    			} else if (A[aLow] <= B[mid - 1] && A[aHigh] > B[mid - 1] && A[aHigh] <= B[mid + 1]) {
    				return avg(A[aHigh], B[mid]);
    			} else if (A[aLow] <= B[mid - 1] && A[aHigh] > B[mid + 1]) {
    				return avg(B[mid], B[mid + 1]);
    			} else if (A[aLow] > B[mid - 1] && A[aLow] <= B[mid] && A[aHigh] < B[mid + 1]) {
    				return avg(A[aHigh], B[mid]);
    			} else if (A[aLow] > B[mid - 1] && A[aLow] <= B[mid] && A[aHigh] >= B[mid + 1]) {
    				return avg(B[mid], B[mid + 1]);
    			} else if (A[aLow] > B[mid] && A[aHigh] <= B[mid + 1]) {
    				return avg(A[aLow], A[aHigh]);
    			} else if (A[aLow] >= B[mid + 2]) {
    				return avg(B[mid + 1], B[mid + 2]);
    			} else {
    				return avg(A[aLow], B[mid + 1]);
    			}
    		}
    		// B has odd number
    		else {
    			if (A[aHigh] <= B[mid - 1]) {
    				return B[mid - 1];
    			} else if (A[aHigh] > B[mid - 1] && A[aHigh] <= B[mid]) {
    				return A[aHigh];
    			} else if (A[aLow] <= B[mid] && A[aHigh] > B[mid]) {
    				return B[mid];
    			} else if (A[aLow] > B[mid] && A[aLow] <= B[mid + 1]) {
    				return A[aLow];
    			} else {
    				return B[mid + 1];
    			}
    		}
    	}
    	
    	// Recursive case
    	int aMid = (aLow + aHigh) / 2;
    	int bMid = (bLow + bHigh) / 2;
    	
    	if (A[aMid] > B[bMid]) {
    		if ((aLow + aHigh) % 2 == 1) {
    			aMid++;
    		}
    		if (bMid - bLow < aHigh - aMid) {
    			int cutLen = bMid - bLow;
    			return findMedianSortedArrays(A, B, aLow, aHigh - cutLen, bMid, bHigh);
    		} else {
    			int cutLen = aHigh - aMid;
    			return findMedianSortedArrays(A, B, aLow, aMid, bLow + cutLen, bHigh );
    		}
    		
    	} 
    	if ((bLow + bHigh) % 2 == 1) {
    		bMid++;
    	}
    	if (bHigh - bMid < aMid - aLow) {
    		int cutLen = bHigh - bMid;
    		return findMedianSortedArrays(A, B, aLow + cutLen, aHigh, bLow, bMid);
    	} else {
    		int cutLen = aMid - aLow;
    		return findMedianSortedArrays(A, B, aMid, aHigh, bLow, bHigh - cutLen);
    	}
    }
    
    public double avg(int a, int b) {
    	return (a + b) / 2.0;
    }
    
    public static void main(String[] args) {
    	int[] A = {1, 5, 6, 7};
    	int [] B = {2, 3, 4, 8, 9, 10};
    	System.out.println(new Solution().findMedianSortedArrays(A, B));
    }
}
