import java.util.ArrayList;
import java.util.Arrays;

/**
 *  Given a collection of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

Each number in C may only be used once in the combination.

Note:

    All numbers (including target) will be positive integers.
    Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
    The solution set must not contain duplicate combinations.

For example, given candidate set 10,1,2,7,6,1,5 and target 8,
A solution set is:
[1, 7]
[1, 2, 5]
[2, 6]
[1, 1, 6] 
 * @author lihaosky
 *
 */
public class Solution {
    public ArrayList<ArrayList<Integer>> combinationSum2(int[] candidates, int target) {
    	ArrayList<ArrayList<Integer>> solutionList = new ArrayList<ArrayList<Integer>>();
    	if (candidates == null || candidates.length == 0) {
    		return solutionList;
    	}
        Arrays.sort(candidates);
        ArrayList<Integer> tmpList = new ArrayList<Integer>();
        findCombination(candidates, target, 0, tmpList, solutionList);
        return solutionList;
    }
    
    public void findCombination(int[] candidates, int target, int index, ArrayList<Integer> curList, ArrayList<ArrayList<Integer>> solution) {
    	for (int i = index; i < candidates.length; i++) {
    		if (i > 0 && i != index && candidates[i] == candidates[i - 1]) {
    			continue;
    		}
			if (candidates[i] == target) {
				ArrayList<Integer> newList = new ArrayList<Integer>(curList);
				newList.add(candidates[i]);
				solution.add(newList);
			} else if (candidates[i] < target){
				ArrayList<Integer> newList = new ArrayList<Integer>(curList);
				newList.add(candidates[i]);
				findCombination(candidates, target - candidates[i], i + 1, newList, solution);
			} else {
				return;
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
    	int[] candidates = {1, 1, 1, 1, 1, 1, 1};
    	printList(new Solution().combinationSum2(candidates, 3));
    	int[][] matrix = new int[2][3];
    	System.out.println(matrix[0].length);
    	System.out.println(matrix);
    	
    }
}
