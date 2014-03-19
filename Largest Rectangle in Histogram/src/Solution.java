/**
 * Given n non-negative integers representing the histogram's bar height where the width of each bar is 1, find the area of largest rectangle in the histogram. 
 * For example,
Given height = [2,1,5,6,2,3],
return 10. 
 * @author hali3
 *
 */
public class Solution {
    public int largestRectangleArea(int[] height) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < height.length; i++) {
        	if (i < height.length - 1 && height[i] <= height[i + 1]) {
        		continue;
        	}
        	int minHeight = height[i];
        	for (int j = i; j >= 0; j--) {
        		if (height[j] < minHeight) {
        			minHeight = height[j];
        		}
        		if (minHeight * (i - j + 1) > max) {
        			max = minHeight * (i - j + 1);
        		}
        	}
        }
        return max;
    }
    
    public static void main(String[] args) {
    	System.out.println(new Solution().largestRectangleArea(new int[] {2, 1, 5, 6, 2, 3}));
    }
}
