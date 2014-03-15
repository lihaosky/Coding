/**
 *  Given an array with n objects colored red, white or blue, sort them so that objects of the same color are adjacent, with the colors in the order red, white and blue.

Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively. 
 * @author hali3
 *
 */

/**
 * Dutch flag problem
 * @author hali3
 *
 */
public class Solution {
    public void sortColors(int[] A) {
        int redPos = -1;
        int bluePos = A.length;
        
        for (int i = 0; i < bluePos; i++) {
            if (A[i] == 0) {
                redPos++;
                A[i] = A[redPos];
                A[redPos] = 0;
            } else if (A[i] == 2) {
                bluePos--;
                A[i] = A[bluePos];
                A[bluePos] = 2;
                i--;
            }
        }
    }
}
