import java.util.ArrayList;
import java.util.Hashtable;



/*
Given an array of integers, find two numbers such that they add up to a specific target number.

The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2. Please note that your returned answers (both index1 and index2) are not zero-based.

You may assume that each input would have exactly one solution.

Input: numbers={2, 7, 11, 15}, target=9
Output: index1=1, index2=2
*/

public class TwoSum {
	public static int[] twoSum(int[] numbers, int target) {
		Hashtable<Integer, ArrayList<Integer>> numberTable = new Hashtable<Integer, ArrayList<Integer>>();
		for (int i = 0; i < numbers.length; i++) {
			ArrayList<Integer> list = numberTable.get(numbers[i]);
			if (list != null) {
				list.add(i + 1);
			} else {
				list = new ArrayList<Integer>();
				list.add(i + 1);
				numberTable.put(numbers[i], list);
			}
		}
		for (int i = 0; i < numbers.length; i++) {
			int diff = target - numbers[i];
			if (diff != numbers[i]) {
				ArrayList<Integer> list = numberTable.get(diff);
				if (list != null) {
					if (list.get(0) > i + 1) {
						return new int[] {i + 1, list.get(0)};
					} else {
						return new int[] {list.get(0), i + 1};
					}
				}
			} else {
				ArrayList<Integer> list = numberTable.get(diff);
				if (list.size() > 1) {
					return new int[] {list.get(0), list.get(1)};
				}
			}
		}
		return null;
	}
	
	public static void main(String[] args) {
		int[] numbers = {2, 7, 11, 15};
		System.out.println(twoSum(numbers, 9)[0] + " " + twoSum(numbers, 9)[1]);
	}
}
