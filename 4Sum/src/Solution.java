import java.util.ArrayList;
import java.util.Arrays;

/**
 * Given an array S of n integers, are there elements a, b, c, and d in S such that a + b + c + d = target? Find all unique quadruplets in the array which gives the sum of target.

Note:

    Elements in a quadruplet (a,b,c,d) must be in non-descending order. (ie, a ≤ b ≤ c ≤ d)
    The solution set must not contain duplicate quadruplets.
 * @author lihaosky
 *
 * Solution: similiar to 3sum. Just change to 4
 */
public class Solution {
    public ArrayList<ArrayList<Integer>> fourSum(int[] num, int target) {
        ArrayList<ArrayList<Integer>> resultList = new ArrayList<ArrayList<Integer>>();
        if (num.length < 4) {
        	return resultList;
        }
        Arrays.sort(num);
        
        for (int i = 0; i < num.length - 3; i++) {
        	int threeTarget = target - num[i];
        	for (int j = i + 1; j < num.length - 2; j++) {
        		int twoTarget = threeTarget - num[j];
        		int start = j + 1;
        		int end = num.length - 1;
        		while (start < end) {
        			if (num[start] + num[end] == twoTarget) {
        				ArrayList<Integer> list = new ArrayList<Integer>();
        				list.add(num[i]);
        				list.add(num[j]);
        				list.add(num[start]);
        				list.add(num[end]);
        				resultList.add(list);
        				start++;
        				end--;
        				while (start < end && num[start] == num[start - 1]) {
        					start++;
        				}
        				while (start < end && num[end] == num[end + 1]) {
        					end--;
        				}
        			} else if (num[start] + num[end] < twoTarget) {
        				start++;
        			} else {
        				end--;
        			}
        		}
        		while (j < num.length - 3 && num[j + 1] == num[j]) {
        			j++;
        		}
        	}
        	while (i < num.length - 4 && num[i + 1] == num[i]) {
        		i++;
        	}
        }
        return resultList;
    }
    
    public static void main(String[] args) {
    	int[] s = {1, 0, -1, 0, 2, -2};
    	ArrayList<ArrayList<Integer>> list = new Solution().fourSum(s, 0);
    	for (ArrayList<Integer> list1 : list) {
    		for (int i : list1) {
    			System.out.print(i + " ");
    		}
    		System.out.println();
    	}
    }
}
