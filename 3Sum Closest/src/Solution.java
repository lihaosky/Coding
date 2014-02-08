import java.util.Arrays;


public class Solution {
    public int threeSumClosest(int[] num, int target) {
    	if (num.length < 3) {
    		return 0;
    	}
    	int closeNum = num[0] + num[1] + num[2];
    	Arrays.sort(num);
    	for (int i = 0; i < num.length - 2; i++) {
    		int start = i + 1;
    		int end = num.length - 1;
    		while (start < end) {
    			int sum = num[i] + num[start] + num[end];
    			if (sum == target) {
    				return target;
    			} else if (sum < target) {
    				start++;
    			} else {
    				end--;
    			}
    			if (Math.abs(sum - target) < Math.abs(closeNum - target)) {
    				closeNum = sum;
    			}
    		}
    	}
        return closeNum;
    }
    
    public static void main(String[] args) {
    	int[] num = {-1, 2, 1, 4};
    	int target = 1;
    	System.out.println(new Solution().threeSumClosest(num, target));
    }
}
