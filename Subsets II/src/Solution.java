import java.util.*;

public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] num) {
        List<List<Integer>> solution = new ArrayList<List<Integer>>();
        List<Integer> list = new ArrayList<Integer>();
        solution.add(list);
        
        Arrays.sort(num);
        int i = 0;
        while (i < num.length) {
        	int count = 1;
        	int n = num[i];
        	while (i + 1 < num.length && num[i] == num[i + 1]) {
        		i++;
        		count++;
        	}
        	List<List<Integer>> tmpList = new ArrayList<List<Integer>>();
        	for (List<Integer> l : solution) {
        		for (int j = 1; j <= count; j++) {
        			List<Integer> newList = new ArrayList<Integer>();
        			newList.addAll(l);
        			for (int k = 0; k < j; k++) {
        				newList.add(n);
        			}
        			tmpList.add(newList);
        		}
        	}
        	solution.addAll(tmpList);
        	i++;
        }
        print(solution);
        return solution;
    }
    
    void print(List<List<Integer>> list) {
    	System.out.println(list.size());
    	for (List<Integer> l : list) {
    		for (Integer i : l) {
    			System.out.print(i + " ");
    		}
    		System.out.println();
    	}
    }
    
    public static void main(String[] args) {
    	int[] array = {1, 2, 2, 2};
    	new Solution().subsetsWithDup(array);
    }
}
