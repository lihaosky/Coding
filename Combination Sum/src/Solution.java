import java.util.ArrayList;
import java.util.Arrays;

/**
 *  Given a set of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

The same repeated number may be chosen from C unlimited number of times.

Note:

    All numbers (including target) will be positive integers.
    Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
    The solution set must not contain duplicate combinations.

For example, given candidate set 2,3,6,7 and target 7,
A solution set is:
[7]
[2, 2, 3] 
 * @author lihaosky
 *
 */
public class Solution {
    public ArrayList<ArrayList<Integer>> combinationSum(int[] candidates, int target) {
    	ArrayList<ArrayList<Integer>> solutionList = new ArrayList<ArrayList<Integer>>();
    	if (candidates == null || candidates.length == 0) {
    		return solutionList;
    	}
        Arrays.sort(candidates);
        ArrayList<Integer> tmpList = new ArrayList<Integer>();
        findCombination(candidates, target, candidates[0], tmpList, solutionList);
        return solutionList;
    }
    
    public void findCombination(int[] candidates, int target, int min, ArrayList<Integer> curList, ArrayList<ArrayList<Integer>> solution) {
    	if (target < min) {
    		return;
    	}
    	for (int num : candidates) {
    		if (num >= min) {
    			if (num == target) {
    				ArrayList<Integer> newList = new ArrayList<Integer>(curList);
    				newList.add(num);
    				solution.add(newList);
    			} else {
    				ArrayList<Integer> newList = new ArrayList<Integer>(curList);
    				newList.add(num);
    				findCombination(candidates, target - num, num, newList, solution);
    			}
    		}
    	}
    }
    
    public static void printList(ArrayList<ArrayList<Integer>> list) {
    	for (ArrayList<Integer> numList : list) {
    		for (int num : numList) {
    			System.out.print(num + " ");
    		}
    		System.out.println();
    	}
    }
    public static void main(String[] args) {
    	int[] candidates = {2, 3, 6, 7};
    	printList(new Solution().combinationSum(candidates, 10));
    	
    }
}