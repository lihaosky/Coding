import java.util.ArrayList;
import java.util.Arrays;

/**
 *  Given a set of distinct integers, S, return all possible subsets.

Note:

    Elements in a subset must be in non-descending order.
    The solution set must not contain duplicate subsets.

For example,
If S = [1,2,3], a solution is:

[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]

 * @author hali3
 *
 */
public class Solution {
    public ArrayList<ArrayList<Integer>> subsets(int[] S) {
        Arrays.sort(S);
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < S.length; i++) {
        	ArrayList<ArrayList<Integer>> tmpRes = new ArrayList<ArrayList<Integer>>();
        	ArrayList<Integer> tmpList = new ArrayList<Integer>();
        	tmpList.add(S[i]);
        	tmpRes.add(tmpList);
        	for (ArrayList<Integer> list : res) {
        		tmpRes.add(list);
        		tmpList = new ArrayList<Integer>(list);
        		tmpList.add(S[i]);
        		tmpRes.add(tmpList);
        	}
        	res = tmpRes;
        }
        res.add(new ArrayList<Integer>());
        return res;
    }
    
    public static void main(String[] args) {
    	ArrayList<ArrayList<Integer>> res = new Solution().subsets(new int[] {3, 2, 4});
    	System.out.println(res.size());
    	for (ArrayList<Integer> list : res) {
    		for (Integer i : list) {
    			System.out.print(i + " ");
    		}
    		System.out.println();
    	}
    }
}
