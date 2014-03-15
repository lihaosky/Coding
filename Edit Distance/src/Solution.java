/**
 *  Given two words word1 and word2, find the minimum number of steps required to convert word1 to word2. (each operation is counted as 1 step.)

You have the following 3 operations permitted on a word:

a) Insert a character
b) Delete a character
c) Replace a character
 * @author hali3
 *
 */
public class Solution {
    public int minDistance(String word1, String word2) {
        int[][] num = new int[word1.length() + 1][word2.length() + 1];
        num[0][0] = 0;
        for (int i = 1; i < word1.length() + 1; i++) {
            num[i][0] = i;
        }
        for (int i = 1; i < word2.length() + 1; i++) {
            num[0][i] = i;
        }
        for (int i = 1; i < word1.length() + 1; i++) {
            for (int j = 1; j < word2.length() + 1; j++) {
                int min = Integer.MAX_VALUE;
                // Replace or do nothing
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    min = num[i - 1][j - 1];
                } else {
                    min = num[i - 1][j - 1] + 1;
                }
                min = Math.min(min, num[i - 1][j] + 1); // Insert into word2
                min = Math.min(min, num[i][j - 1] + 1); // Delete from word2
                num[i][j] = min;
            }
        }
        return num[word1.length()][word2.length()];
    }
}
