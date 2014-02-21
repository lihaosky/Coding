/**
 *  You are given a string, S, and a list of words, L, that are all of the same length. Find all starting indices of substring(s) in S that is a concatenation of each word in L exactly once and without any intervening characters.

For example, given:
S: "barfoothefoobarman"
L: ["foo", "bar"]

You should return the indices: [0,9].
(order does not matter). 
 * @author lihaosky
 *
 */
import java.util.*;

public class Solution {
    public ArrayList<Integer> findSubstring(String S, String[] L) {
        int len = 0;
        ArrayList<Integer> resultList = new ArrayList<Integer>();
        
        for (int i = 0; i < L.length; i++) {
        	len += L[i].length();
        }
        for (int i = 0; i < S.length() - len + 1; i++) {
        	boolean[] used = new boolean[L.length];
        	if (isMatch(S.substring(i, i + len), L, used)) {
        		resultList.add(i);
        	}
        }
        return resultList;
    }
    
    public boolean isMatch(String s, String[] l, boolean[] used) {
        if (s.equals("")) {
        	for (int i = 0; i < l.length; i++) {
        		if (!used[i] && !l[i].equals("")) {
        			return false;
        		}
        	}
        	return true;
        }
        for (int i = 0; i < l.length; i++) {
        	if (!used[i] && s.startsWith(l[i])) {
        		used[i] = true;
        		if (isMatch(s.substring(l[i].length()), l, used)) {
        			return true;
        		} else {
        			used[i] = false;
        		}
        	}
        }
        return false;
    }
    
    public ArrayList<Integer> findSubstring1(String S, String[] L) {
        int totalLen= 0;
        int len = L[0].length();
        ArrayList<Integer> resultList = new ArrayList<Integer>();
        Hashtable<String, Integer> occurNum = new Hashtable<String, Integer>();
        for (int i = 0; i < L.length; i++) {
            Integer val = occurNum.get(L[i]);
            if (val == null) {
                occurNum.put(L[i], 1);
            } else {
                occurNum.put(L[i], val + 1);
            }
        }
        totalLen = len * L.length;
        for (int i = 0; i < S.length() - totalLen + 1; i++) {
        	if (isMatch(S.substring(i, i + totalLen), len, occurNum)) {
        		resultList.add(i);
        	}
        }
        return resultList;
    }
    
    public boolean isMatch(String s, int len, Hashtable<String, Integer> occurNum) {
        Hashtable<String, Integer> curNum = new Hashtable<String, Integer>();
        for (int i = 0; i < s.length(); i += len) {
            if (!occurNum.containsKey(s.substring(i, i + len))) {
                return false;
            } else {
                Integer val = curNum.get(s.substring(i, i + len));
                if (val == null) {
                    curNum.put(s.substring(i, i + len), 1);
                } else {
                    curNum.put(s.substring(i, i + len), val + 1);
                }
            }
        }
        for (String key : occurNum.keySet()) {
            if (curNum.get(key) != occurNum.get(key)) {
                return false;
            }
        }
        return true;
    }
    public void test(int[] a) {
    	a[0] = 100;
    }
    public static void main(String[] args) {
    	int[] a = new int[1];
    	String[] s = {"bar", "foo"};
    	new Solution().test(a);
    	System.out.println(a[0]);
    	for (int i : new Solution().findSubstring1("barfoothefoobarman", s)) {
    		System.out.println(i);
    	}
    }
}
