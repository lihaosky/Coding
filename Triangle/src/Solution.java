import java.util.ArrayList;

/**
 * Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.

For example, given the following triangle

[
     [2],
    [3,4],
   [6,5,7],
  [4,1,8,3]
]

The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).

Note:
Bonus point if you are able to do this using only O(n) extra space, where n is the total number of rows in the triangle. 
 * @author hali3
 *
 */
public class Solution {
    public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
    	if (triangle == null || triangle.size() == 0) {
    		return 0;
    	}
        int[] levelMin = new int[1];
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < triangle.size(); i++) {
        	int[] tmpMin = new int[triangle.get(i).size()];
        	for (int j = 0; j < triangle.get(i).size(); j++) {
        		if (j == 0) {
        			tmpMin[j] = levelMin[0] + triangle.get(i).get(0);
        		} else if (j == triangle.get(i).size() - 1) {
        			tmpMin[j] = levelMin[j - 1] + triangle.get(i).get(j);
        		} else {
        			tmpMin[j] = Math.min(levelMin[j - 1], levelMin[j]) + triangle.get(i).get(j);
        		}
        	}
        	levelMin = tmpMin;
        }
        for (int i = 0; i < triangle.get(triangle.size() - 1).size(); i++) {
        	if (levelMin[i] < min) {
        		min = levelMin[i];
        	}
        }
        return min;
    }
    
    public static void main(String[] args) {
    	System.out.println(new Solution().minimumTotal(null));
    	ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
    	ArrayList<Integer> tmpList = new ArrayList<Integer>();
    	tmpList.add(2);
    	list.add(tmpList);
    	tmpList = new ArrayList<Integer>();
    	tmpList.add(3);
    	tmpList.add(4);
    	list.add(tmpList);
    	tmpList = new ArrayList<Integer>();
    	tmpList.add(6);
    	tmpList.add(5);
    	tmpList.add(7);
    	list.add(tmpList);
    	tmpList = new ArrayList<Integer>();
    	tmpList.add(4);
    	tmpList.add(1);
    	tmpList.add(8);
    	tmpList.add(3);
    	list.add(tmpList);
    	System.out.println(new Solution().minimumTotal(list));
    }
}
