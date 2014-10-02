import java.util.Hashtable;
import java.util.*;

/**
 *  Given an unsorted array of integers, find the length of the longest consecutive elements sequence.

For example,
Given [100, 4, 200, 1, 3, 2],
The longest consecutive elements sequence is [1, 2, 3, 4]. Return its length: 4.

Your algorithm should run in O(n) complexity. 
 * @author lihaosky
 *
 */
class Boundary {
    public int left;
    public int right;
    
    public Boundary(int left, int right) {
        this.left = left;
        this.right = right;
    }
}

public class Solution {
    public int longestConsecutive1(int[] num) {
        HashMap<Integer, Boundary> intBoundMap = new HashMap<Integer, Boundary>();
        int maxLen = 1;
        for (int i = 0; i < num.length; i++) {
            if (!intBoundMap.containsKey(num[i])) {
                int left = num[i];
                int right = num[i];
                if (intBoundMap.containsKey(num[i] - 1)) {
                    left = intBoundMap.get(num[i] - 1).left;
                }
                if (intBoundMap.containsKey(num[i] + 1)) {
                    right = intBoundMap.get(num[i] + 1).right;
                }
                intBoundMap.put(num[i], new Boundary(left, right));
                if (right - left + 1 > maxLen) {
                    maxLen = right - left + 1;
                }
                intBoundMap.get(left).right = right;
                intBoundMap.get(right).left = left;
            }
        }
        return maxLen;
    }
    
    public int longestConsecutive(int[] num) {
        Hashtable<Integer, int[]> numLowHighTable = new Hashtable<Integer, int[]>();
        int longest = 0;
        for (int i = 0; i < num.length; i++) {
        	int[] lowHigh = numLowHighTable.get(num[i]);
        	if (lowHigh == null) {
        		int[] value = new int[2];
        		value[0] = value[1] = num[i];
        		int[] low = numLowHighTable.get(num[i] - 1);
        		int[] high = numLowHighTable.get(num[i] + 1);
        		if (low == null && high != null) {
        			numLowHighTable.get(high[1])[0] = num[i];
        			value[1] = high[1];
        		} 
        		if (low != null && high == null) {
        			numLowHighTable.get(low[0])[1] = num[i];
        			value[0] = low[0];
        		} 
        		if (low != null && high != null) {
        			numLowHighTable.get(low[0])[1] = high[1];
        			numLowHighTable.get(high[1])[0] = low[0];
        			value[0] = low[0];
        			value[1] = high[1];
        			
        		}
        		numLowHighTable.put(num[i], value);
        		if (value[1] - value[0] + 1 > longest) {
        			longest = value[1] - value[0] + 1;
        		}
        	}
        }
        return longest;
    }
    
    public static void main(String[] args) {
    	int[] num = new int[6];
    	num[0] = 100;
    	num[1] = 4;
    	num[2] = 3;
    	num[3] = 200;
    	num[4] = 1;
    	num[5] = 2;
    	System.out.println(new Solution().longestConsecutive(num));
    }
}
