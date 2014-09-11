import java.util.*;

public class Solution {
    public List<List<String>> findLadders(String start, String end, Set<String> dict) {
        List<List<String>> res = new ArrayList<List<String>>();
        HashMap<String, List<List<String>>> listMap = new HashMap<String, List<List<String>>>();
        Set<String> visited = new HashSet<String>();
        Queue<String> queue = new LinkedList<String>();
        int curLevel = 1, nextLevel = 0;
        queue.add(start);
        List<List<String>> list = new ArrayList<List<String>>();
        List<String> pathList = new ArrayList<String>();
        pathList.add(start);
        list.add(pathList);
        listMap.put(start, list);
        while (!queue.isEmpty()) {
        	curLevel--;
        	String curNode = queue.remove();
        	if (isNeighbour(curNode, end)) {
        		list = listMap.get(curNode);
        		for (List<String> l : list) {
        			l.add(end);
        			res.add(l);
        		}
        		continue;
        	}
        	if (!res.isEmpty()) {
        		if (curLevel <= 0) {
        			break;
        		} else {
        			continue;
        		}
        	}
        	StringBuffer sb = new StringBuffer(curNode);
        	list = listMap.get(curNode);
        	listMap.remove(curNode);
        	dict.remove(curNode);
        	for (int i = 0; i < sb.length(); i++) {
        		for (char c = 'a'; c <= 'z'; c++) {
        			if (sb.charAt(i) == c) {
        				continue;
        			}
        			char temp = sb.charAt(i);
        			sb.setCharAt(i, c);
        			if (dict.contains(sb.toString())) {
        				if (!visited.contains(sb.toString())) {
        					List<List<String>> newList = new ArrayList<List<String>>();
        					for (List<String> l : list) {
        						List<String> aList = new ArrayList<String>();
        						aList.addAll(l);
        						aList.add(sb.toString());
        						newList.add(aList);
        					}
        					listMap.put(sb.toString(), newList);
	        				queue.add(sb.toString());
	        				nextLevel++;
	        				visited.add(sb.toString());
        				} else {
        					List<List<String>> sbList = listMap.get(sb.toString());
        					for (List<String> l : list) {
        						List<String> aList = new ArrayList<String>();
        						aList.addAll(l);
        						aList.add(sb.toString());
        						sbList.add(aList);
        					}
        				}
        			}
        			sb.setCharAt(i, temp);
        		}
        	}
        	if (curLevel == 0) {
        		curLevel = nextLevel;
        		nextLevel = 0;
        	}
        }
        
        return res;
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
	
	public static void print(List<List<String>> list) {
		for (List<String> l : list) {
			System.out.print("[");
			for (String s : l) {
				System.out.print(s + " ,");
			}
			System.out.println("]");
		}
	}
	
	public static void main(String[] args) {
		HashSet<String> set = new HashSet<String>();
		set.add("hot");
		set.add("dot");
		set.add("dog");
		set.add("log");
		set.add("lot");
		
		System.out.println(new Solution().findLadders("hit", "cog", set));
		
		HashSet<String> set1 = new HashSet<String>();
		set1.add("tex");
		set1.add("ted");
		set1.add("red");
		set1.add("tax");
		set1.add("tad");
		set1.add("den");
		set1.add("rex");
		set1.add("pee");
		System.out.println(new Solution().findLadders("red", "tax", set1));
	}
}
