import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

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
		HashSet<String> set = new HashSet<String>();
		set.add("hot");
		set.add("dot");
		set.add("dog");
		set.add("log");
		set.add("lot");
		
		System.out.println(new Solution().ladderLength("hit", "cog", set));
	}
	
}
