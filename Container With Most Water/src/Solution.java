/*
 * Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai). 
 * n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). 
 * Find two lines, which together with x-axis forms a container, such that the container contains the most water.
 * Note: You may not slant the container. 
 */

/**
 * Solution. With two pointers pointing to left and right most. Move the smaller one towards middle.
 * Larger must exist in the middle
 * @author lihaosky
 *
 */
public class Solution {
	/**
	 * This is a O(n^2) solution
	 * @param height
	 * @return
	 */
    public int maxArea1(int[] height) {
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
    
    /**
     * This is a O(n) solution
     * @param height
     * @return
     */
    public int maxArea(int[] height) {
        int maxArea = 0;
        int left = 0, right = height.length - 1;
        
        while (left < right) {
        	int area = (right - left) * Math.min(height[left], height[right]);
        	maxArea = Math.max(maxArea, area);
        	if (height[left] < height[right]) {
        		left++;
        	} else {
        		right--;
        	}
        }
        return maxArea;
    }
    
    public static void main(String[] args) {
    }
}