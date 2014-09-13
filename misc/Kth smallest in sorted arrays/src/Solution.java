
public class Solution {
	public static int findKthSmallest(int[] A, int[] B, int as, int ae, int bs, int be, int k) {
		if (as > ae) {
			return B[k - 1 + bs];
		}
		if (bs > be) {
			return A[k - 1 + as];
		}

		int am = (ae + as) / 2;
		int bm = (be + bs) / 2;
		if (am + bm - as - bs + 2 <= k) {
			if (A[am] > B[bm]) {
				return findKthSmallest(A, B, as, ae, bm + 1, be, k - 1 - bm + bs);
			} else {
				return findKthSmallest(A, B, am + 1, ae, bs, be, k - 1 - am + as);
			}
		} else {
			if (A[am] > B[bm]) {
				return findKthSmallest(A, B, as, am - 1, bs, be, k);
			} else {
				return findKthSmallest(A, B, as, ae, bs, bm - 1, k);
			}
		}
	}
	
	// Find Kth smallest naive merge way
	public static int findKthSmallest(int[] A, int[] B, int k) {
		if (A.length + B.length < k) {
			return -1;
		}
		if (A.length == 0) {
			return B[k - 1];
		}
		if (B.length == 0) {
			return A[k - 1];
		}
		int cur = 0, i = 0, j = 0;
		while (i < A.length && j < B.length) {
			if (cur == k - 1) {
				return Math.min(A[i], B[j]);
			}
			if (A[i] < B[j]) {
				i++;
			} else {
				j++;
			}
			cur++;
		}
		if (i == A.length) {
			return B[k - 1 - cur];
		}
		return A[k - 1 - cur];
	}
	
	public static void main(String[] args) {
		int[] a = {1};
		int[] b = {2, 3};
		System.out.println(Solution.findKthSmallest(a, b, 6));
		System.out.println(Solution.findKthSmallest(a, b, 0, a.length - 1, 0, b.length - 1, 1));
	}
}
