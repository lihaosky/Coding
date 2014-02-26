import java.util.Arrays;

/**
 *  Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.

If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).

The replacement must be in-place, do not allocate extra memory.

Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
1,2,3 --> 1,3,2
3,2,1 --> 1,2,3
1,1,5 --> 1,5,1
 * @author hali3
 *
 */
public class Solution {
    public void nextPermutation(int[] num) {
        int start = 0;
        for (int i = num.length - 2; i >= 0; i--) {
        	int index = -1;
        	int min = Integer.MAX_VALUE;
        	for (int j = i + 1; j < num.length; j++) {
        		if (num[j] > num[i] && num[j] < min) {
        			min = num[j];
        			index = j;
        		}
        	}
        	if (index != -1) {
        		int tmp = num[i];
        		num[i] = num[index];
        		num[index] = tmp;
        		start = i + 1;
        		break;
        	}
        }
        Arrays.sort(num, start, num.length);
    }
    
    public static void main(String[] args) {
    	int[] num = {4,2,0,2,3,2,0};
    	new Solution().nextPermutation(num);
    	for (int i : num) {
    		System.out.println(i);
    	}
    }
}
