public class Solution {
    public int maxArea(int[] height) {
        int maxArea = 0;
        for (int i = 0; i < height.length; i++) {
            for (int j = i + 1; j < height.length; j++) {
                if ((j - i) * Math.min(height[i], height[j]) > maxArea) {
                    maxArea = (j - i) * Math.min(height[i], height[j]);
                }
            }
        }
        return maxArea;
    }
}