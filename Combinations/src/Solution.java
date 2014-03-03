import java.util.ArrayList;

/**
 *  Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.

For example,
If n = 4 and k = 2, a solution is:

[
  [2,4],
  [3,4],
  [2,3],
  [1,2],
  [1,3],
  [1,4],
]

 * @author lihaosky
 *
 */
public class Solution {
    public ArrayList<ArrayList<Integer>> combine(int n, int k) {
    	ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
    	if (n < k) {
    		return res;
    	}
        if (k == 1) {
        	for (int i = 1; i <= n; i++) {
        		ArrayList<Integer> list = new ArrayList<Integer>();
        		list.add(i);
        		res.add(list);
        	}
        	return res;
        }
        ArrayList<ArrayList<Integer>> res1 = combine(n - 1, k - 1);
        ArrayList<ArrayList<Integer>> res2 = combine(n - 1, k);
        for (ArrayList<Integer> list : res1) {
        	list.add(n);
        	res.add(list);
        }
        res.addAll(res2);
        return res;
    }
    
    public static void printList(ArrayList<ArrayList<Integer>> res) {
    	for (ArrayList<Integer> list : res) {
    		for (int i : list) {
    			System.out.print(i + " ");
    		}
    		System.out.println();
    	}
    }
    
    public static void main(String[] args) {
    	printList(new Solution().combine(1, 1));
    }
}
