import java.util.ArrayList;
import java.util.Arrays;
import java.util.Hashtable;

/**
 * Given an array of strings, return all groups of strings that are anagrams.

Note: All inputs will be in lower-case.
 * @author lihaosky
 *
 */
public class Solution {
    public ArrayList<String> anagrams(String[] strs) {
        Hashtable<String, ArrayList<String>> table = new Hashtable<String, ArrayList<String>>();
        ArrayList<String> result = new ArrayList<String>();
        for (String s : strs) {
        	char[] charArray = s.toCharArray();
        	Arrays.sort(charArray);
        	String keyString = new String(charArray);
        	ArrayList<String> list = table.get(keyString);
        	if (list == null) {
        		list = new ArrayList<String>();
        		table.put(keyString, list);
        	}
        	list.add(s);
        }
        for (ArrayList<String> list : table.values()) {
        	if (list.size() > 1) {
        		result.addAll(list);
        	}
        }
        return result;
    }
}
