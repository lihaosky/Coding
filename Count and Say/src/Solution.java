/**
 * The count-and-say sequence is the sequence of integers beginning as follows:
1, 11, 21, 1211, 111221, ...

1 is read off as "one 1" or 11.
11 is read off as "two 1s" or 21.
21 is read off as "one 2, then one 1" or 1211.

Given an integer n, generate the nth sequence.

Note: The sequence of integers will be represented as a string.

 * @author lihaosky
 *
 */
public class Solution {
    public String countAndSay(int n) {
        String retString = "1";
        for (int i = 1; i < n; i++) {
        	retString = getNext(retString);
        }
        return retString;
    }
    
    public String getNext(String str) {
    	String retString = "";
    	int count = 1;
    	for (int i = 1; i < str.length(); i++) {
    		if (str.charAt(i) == str.charAt(i - 1)) {
    			count++;
    		} else {
    			retString += (count + "" + str.charAt(i - 1));
    			count = 1;
    		}
    	}
    	retString += (count + "" + str.charAt(str.length() - 1));
    	return retString;
    }
    
    public static void main(String[] args) {
    	System.out.println(new Solution().countAndSay(1));
    	System.out.println(new Solution().countAndSay(2));
    	System.out.println(new Solution().countAndSay(3));
    	System.out.println(new Solution().countAndSay(4));
    	System.out.println(new Solution().countAndSay(5));
    }
}
