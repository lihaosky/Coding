/**
 * The set [1,2,3,…,n] contains a total of n! unique permutations.

By listing and labeling all of the permutations in order,
We get the following sequence (ie, for n = 3):

    "123"
    "132"
    "213"
    "231"
    "312"
    "321"

Given n and k, return the kth permutation sequence.

Note: Given n will be between 1 and 9 inclusive.
 * @author lihaosky
 *
 */
public class Solution {
    public String getPermutation(int n, int k) {
        boolean[] used = new boolean[n];
        int count = 1;
        for (int i = 2; i < n; i++) {
            count *= i;
        }
        return findPermutation(k - 1, used, count, n - 1);
    }
    public String findPermutation(int k, boolean[] used, int count, int n) {
        if (n == 0) {
            for (int i = 0; i < used.length; i++) {
                if (used[i] == false) {
                    return (i + 1) + "";
                }
            }
        }
        int index = k / count;
        int notUsedCount = 0;
        for (int i = 0; i < used.length; i++) {
            if (used[i] == false) {
                if (notUsedCount == index) {
                    used[i] = true;
                    return (i + 1) + findPermutation(k % count, used, count / n, n - 1);
                }
                notUsedCount++;
            }
        }
        return "";
    }
    
    public static void main(String[] args) {
    	System.out.println(new Solution().getPermutation(4, 7));
    }
}
