import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

/*
 * Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.
 * Note:
 * Elements in a triplet (a,b,c) must be in non-descending order. (ie, a ≤ b ≤ c)
 * The solution set must not contain duplicate triplets.
 */

/**
 * We can use a set to avoid duplicates or scan to avoid them
 * @author lihaosky
 *
 */
class Element {
	int[] elements = new int[3];
	public Element(int a, int b, int c) {
		elements[0] = a;
		elements[1] = b;
		elements[2] = c;
	}
	
	public boolean equals(Object obj) {
		Element objElement = (Element)obj;
		for (int i = 0; i < 3; i++) {
			if (elements[i] != objElement.elements[i]) {
				return false;
			}
		}
		return true;
	}
	
	public int hashCode() {
		return elements[0] + elements[1] + elements[2];
	}
}

public class Solution {
	public ArrayList<ArrayList<Integer>> threeSum1(int[] num) {
		ArrayList<ArrayList<Integer>> resultList = new ArrayList<ArrayList<Integer>>();
		Arrays.sort(num);
		for (int i = 0; i < num.length - 2 && num[i] <= 0; i++) {
			int start = i + 1;
			int end = num.length - 1;
			int target = 0 - num[i];
			while (start < end) {
				if (num[start] + num[end] == target) {
					ArrayList<Integer> tmpList = new ArrayList<Integer>();
					tmpList.add(num[i]);
					tmpList.add(num[start]);
					tmpList.add(num[end]);
					resultList.add(tmpList);
					start++;
					end--;
					while (start < end && num[start - 1] == num[start]) {
						start++;
					}
					while (start < end && num[end + 1] == num[end]) {
						end--;
					}
				} else if (num[start] + num[end] < target) {
					start++;
				} else {
					end--;
				}
			}
			while (i < num.length - 3 && num[i] == num[i + 1]) {
				i++;
			}
		}
		return resultList;
	}
	
    public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
        ArrayList<ArrayList<Integer>> solutionList = new ArrayList<ArrayList<Integer>>();
        HashSet<Element> set = new HashSet<Element>();
        
        Arrays.sort(num);
        for (int i = 0; i < num.length - 2 && num[i] <= 0; i++) {
        	int l = i + 1;
        	int h = num.length - 1;
        	while (l < h) {
        		if (num[i] + num[l] + num[h] == 0) {
        			if (!set.contains(new Element(num[i], num[l], num[h]))) {
        				ArrayList<Integer> intList = new ArrayList<Integer>();
        				intList.add(num[i]);
        				intList.add(num[l]);
        				intList.add(num[h]);
        				solutionList.add(intList);
        				set.add(new Element(num[i], num[l], num[h]));
        			}
        			l++;
        		} else if (num[i] + num[l] + num[h] < 0) {
        			l++;
        		} else {
        			h--;
        		}
        	}
        }
        
        return solutionList;
    }
    
	public static void main(String[] args) {
		HashSet<Element> set = new HashSet<Element>();
		set.add(new Element(1, 2, 3));
		set.add(new Element(1, 2, 3));
		System.out.println(set.size());
		int[] num = {-1, 0, 1, 2, -1, -4};
		ArrayList<ArrayList<Integer>> solutionList = new Solution().threeSum(num);
		for (ArrayList<Integer> intList : solutionList) {
			for (int n : intList) {
				System.out.print(n + " ");
			}
			System.out.println();
		}
		String s = "";
		String[] splitString = s.split(" ");
		System.out.println(splitString.length);
		for (String string : splitString) {
			if (string.equals("")) {
				System.out.print("YES");
			}
			System.out.print(string);
		}
		boolean matches = "a".matches("");
		System.out.println(matches);
		"abcd".substring(4);
	}
}
