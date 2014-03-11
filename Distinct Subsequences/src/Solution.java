/**
 *  Given a string S and a string T, count the number of distinct subsequences of T in S.

A subsequence of a string is a new string which is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (ie, "ACE" is a subsequence of "ABCDE" while "AEC" is not).

Here is an example:
S = "rabbbit", T = "rabbit"

Return 3. 
 * @author lihaosky
 *
 */
/**
 * Use DP...
 * @author lihaosky
 *
 */
public class Solution {
    public int numDistinct(String S, String T) {
        if (S.length() < T.length()) {
            return 0;
        }
        if (S.length() == T.length()) {
            return S.equals(T) ? 1 : 0;
        }
        int[][] count = new int[S.length() + 1][T.length() + 1];
        count[0][0] = 1;
        for (int i = 1; i <= T.length(); i++) {
            count[0][i] = 0;
            for (int j = 1; j <= S.length(); j++) {
                count[j][0] = 1;
                if (S.charAt(j - 1) == T.charAt(i - 1)) {
                    count[j][i] = count[j - 1][i - 1] + count[j - 1][i];
                } else {
                    count[j][i] = count[j - 1][i];
                }
            }
        }
        return count[S.length()][T.length()];
    }
}