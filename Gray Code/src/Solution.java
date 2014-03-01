import java.util.ArrayList;

/**
 * The gray code is a binary numeral system where two successive values differ in only one bit.

Given a non-negative integer n representing the total number of bits in the code, print the sequence of gray code. A gray code sequence must begin with 0.

For example, given n = 2, return [0,1,3,2]. Its gray code sequence is:

00 - 0
01 - 1
11 - 3
10 - 2

Note:
For a given n, a gray code sequence is not uniquely defined.

For example, [0,2,3,1] is also a valid gray code sequence according to the above definition.

For now, the judge is able to judge based on one instance of gray code sequence. Sorry about that.
 * @author lihaosky
 *
 */
public class Solution {
    public ArrayList<Integer> grayCode(int n) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        if (n == 0) {
        	list.add(0);
        	return list;
        }
        if (n == 1) {
        	list.add(0);
        	list.add(1);
        	return list;
        }
        ArrayList<Integer> tmpList = grayCode(n - 1);
        int pow = 1 << (n - 1);
        list = new ArrayList<Integer>(tmpList);
        for (int i = tmpList.size() - 1; i >= 0; i--) {
        	list.add(pow + tmpList.get(i));
        }
        return list;
    }
    
    public ArrayList<Integer> grayCode1(int n) {
    	ArrayList<Integer> list = new ArrayList<Integer>();
    	list.add(0);
    	for (int i = 1; i < n; i++) {
    		int base = 1 << (i - 1);
    		for (int j = list.size() - 1; j >= 0; j--) {
    			list.add(base + list.get(j));
    		}
    	}
    	return list;
    }
    
    public static void main(String[] args) {
    	for (int i : new Solution().grayCode(2)) {
    		System.out.print(i + " ");
    	}
    }
}
