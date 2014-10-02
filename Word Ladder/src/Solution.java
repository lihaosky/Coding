import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.*;
/**
 *  Given two words (start and end), and a dictionary, find the length of shortest transformation sequence from start to end, such that:

    Only one letter can be changed at a time
    Each intermediate word must exist in the dictionary

For example,

Given:
start = "hit"
end = "cog"
dict = ["hot","dot","dog","lot","log"]

As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
return its length 5.

Note:

    Return 0 if there is no such transformation sequence.
    All words have the same length.
    All words contain only lowercase alphabetic characters.

 * @author hali3
 *
 */
public class Solution {
    public int ladderLength(String start, String end, Set<String> dict) {
        int len = 1, curLayer = 1, nextLayer = 0;
        Set<String> visited = new HashSet<String>();
        Queue<String> queue = new LinkedList<String>();
        queue.add(start);
        visited.add(start);
        while (!queue.isEmpty()) {
            String s = queue.remove();
            curLayer--;
            Set<String> neighbors = neighbors(s);
            for (String neighbor : neighbors) {
                if (neighbor.equals(end)) {
                    return len + 1;
                }
                if (dict.contains(neighbor) && !visited.contains(neighbor)) {
                    queue.add(neighbor);
                    visited.add(neighbor);
                    nextLayer++;
                }
            }
            if (curLayer == 0) {
                curLayer = nextLayer;
                nextLayer = 0;
                len++;
            }
        }
        return 0;
    }
    
    public Set<String> neighbors(String s) {
        Set<String> res = new HashSet<String>();
        for (int i = 0; i < s.length(); i++) {
            for (char c = 'a'; c <= 'z'; c++) {
                if (c != s.charAt(i)) {
                    StringBuffer sb = new StringBuffer(s);
                    sb.setCharAt(i, c);
                    res.add(sb.toString());
                }
            }
        }
        return res;
    }
    
	public int ladderLength(String start, String end, HashSet<String> dict) {
		Queue<String> wordQueue = new LinkedList<String>();
		int curLevel = 0;
		int nextLevel = 0;
		int distance = 0;
		
		wordQueue.add(start);
		curLevel = 1;
		distance = 1;
		
		while (!wordQueue.isEmpty()) {
			String word = wordQueue.remove();
			if (isNeighbour(word, end)) {
				return distance + 1;
			}
			curLevel--;
			StringBuffer sb = new StringBuffer(word);
			for (int i = 0; i < sb.length(); i++) {
				for (char c = 'a'; c <= 'z'; c++) {
					if (c == sb.charAt(i)) {
						continue;
					}
					char temp = sb.charAt(i);
					sb.setCharAt(i, c);
					if (dict.contains(sb.toString())) {
						wordQueue.add(sb.toString());
						nextLevel++;
						dict.remove(sb.toString());
					}
					sb.setCharAt(i, temp);
				}
			}
			if (curLevel == 0) {
				curLevel = nextLevel;
				nextLevel = 0;
				distance++;
			}
		}
		return 0;
	}
	
	public boolean isNeighbour(String s1, String s2) {
		if (s1.length() != s2.length()) {
			return false;
		}
		boolean isDiff = false;
		for (int i = 0; i < s1.length(); i++) {
			if (s1.charAt(i) != s2.charAt(i)) {
				if (isDiff) {
					return false;
				}
				isDiff = true;
			}
		}
		return isDiff;
	}
	
	
	public static void main(String[] args) {
		Set<String> set = new HashSet<String>();
		set.add("hot");
		set.add("cog");
		set.add("dog");
		set.add("tot");
		set.add("hog");
		set.add("hop");
		set.add("pot");
		set.add("dot");
		
		
		System.out.println(new Solution().ladderLength("hot", "dog", set));
	}
	
}
