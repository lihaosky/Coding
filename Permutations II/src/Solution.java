import java.util.*;

public class Solution {
    public List<List<Integer>> permuteUnique(int[] num) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        Arrays.sort(num);
        solve(num, 0, res);
        return res;
    }
    
    public void swap(int[] num, int i, int j) {
        int tmp = num[i];
        num[i] = num[j];
        num[j] = tmp;
    }
    
    public void solve(int[] num, int start, List<List<Integer>> res) {
        if (start >= num.length) {
            List<Integer> l = new ArrayList<Integer>();
            for (int i = 0; i < num.length; i++) {
                l.add(num[i]);
            }
            res.add(l);
            return;
        }
        for (int i = start; i < num.length; i++) {
            if (i != start) {
            	if (num[start] == num[i]) {
            		continue;
            	}
            	int j;
            	for (j = start + 1; j < i; j++) {
            		if (num[i] == num[j]) {
            			break;
            		}
            	}
            	if (j != i) {
            		continue;
            	}
            }
            swap(num, i, start);
            solve(num, start + 1, res);
            swap(num, i, start);
        }
    }
    
    public static void main(String[] args) {
    	int[] a = {-1, -1, 1, 0, 1, 2};
    	List<List<Integer>> res = (new Solution().permuteUnique(a));
    	for (int i = 0; i < res.size(); i++) {
    		for (int j = i + 1; j < res.size(); j++) {
    			List<Integer> l1 = res.get(i);
    			List<Integer> l2 = res.get(j);
    			int k;
    			for (k = 0; k < l1.size(); k++) {
    				if (l1.get(k) != l2.get(k)) {
    					break;
    				}
    			}
    			if (k == l1.size()) {
    				System.out.println("Same");
    				for (int m = 0; m < l1.size(); m++) {
    					System.out.print(l1.get(m) + " ");
    				}
    				System.out.println();
    			}
    		}
    	}
    }
}