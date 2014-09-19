import java.util.ArrayList;

/**
 * Given array of citations, find max number of paper n with each has citation larger than n
 * @author hali3
 *
 */
public class Solution {
	public static int findHIndex(int[] paper) {
		int[] s = new int[paper.length + 1];
		for (int i = 0; i < paper.length; i++) {
			s[Math.min(paper[i], paper.length)]++;
		}
		int sum = 0;
		for (int i = paper.length - 1; i >= 0; i--) {
			sum += s[i + 1];
			if (sum >= i + 1) {
				return i + 1;
			}
		}
		return 0;
	}
	
	public static void main(String[] args) {
		int[] paper = {4, 3, 5, 6, 7};
		System.out.println(Solution.findHIndex(paper));
		int[][] paper1 = new int[10][];
		paper1[0] = new int[10];
		System.out.println(paper1[0].length);
		
	}
}
