import java.util.ArrayList;

/**
 *  Given a collection of numbers, return all possible permutations.

For example,
[1,2,3] have the following permutations:
[1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], and [3,2,1]. 
 * @author lihaosky
 *
 */
public class Solution {
	public ArrayList<ArrayList<Integer>> permute(int[] num) {
		ArrayList<ArrayList<Integer>> sol = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> tmpList = new ArrayList<Integer>();
		permute(num, 0, num.length - 1, sol, tmpList);
		return sol;
	}
	
	public void permute(int[] num, int start, int end, ArrayList<ArrayList<Integer>> sol, ArrayList<Integer> list) {
		if (start == end) {
			list.add(num[start]);
			sol.add(new ArrayList<Integer>(list));
			list.remove(list.size() - 1);
			return;
		}
		for (int i = start; i <= end; i++) {
			if (i != start) {
				int j = i - 1;
				for (; j >= start && num[j] != num[i]; j--);
				if (j >= start) {
					continue;
				}
			}
			int tmp = num[i];
			num[i] = num[start];
			num[start] = tmp;
			list.add(num[start]);
			permute(num, start + 1, end, sol, list);
			list.remove(list.size() - 1);
			tmp = num[i];
			num[i] = num[start];
			num[start] = tmp;
		}
	}
	
	public ArrayList<ArrayList<Integer>> permute(int[] num, int start, int end) {
		ArrayList<ArrayList<Integer>> solution = new ArrayList<ArrayList<Integer>>();
		
		if (start == end) {
			ArrayList<Integer> newList = new ArrayList<Integer>();
			newList.add(num[start]);
			solution.add(newList);
			return solution;
		}
		for (int i = start; i <= end; i++) {
			int tmp = num[i];
			num[i] = num[start];
			num[start] = tmp;
			ArrayList<ArrayList<Integer>> tmpSolution = permute(num, start + 1, end);
			for (ArrayList<Integer> list : tmpSolution) {
				list.add(num[start]);
				solution.add(list);
			}
			tmp = num[i];
			num[i] = num[start];
			num[start] = tmp;
		}
		return solution;
	}
	
	public static void printList(ArrayList<ArrayList<Integer>> sol) {
		for (ArrayList<Integer> list : sol) {
			for (int num : list) {
				System.out.print(num + " ");
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		int[] num = {2, 2, 1, 2};
		printList(new Solution().permute(num));
	}
}
