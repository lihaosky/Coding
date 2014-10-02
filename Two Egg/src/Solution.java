class A {
	public static int a = B.b;
}

class B {
	public static int b = A.a;
}

public class Solution {
	public static int steps(int floorNum, int eggNum) {
		int[][] opt = new int[floorNum + 1][eggNum + 1];
		for (int i = 1; i <= floorNum; i++) {
			opt[i][1] = i;
		}
		for (int i = 1; i <= eggNum; i++) {
			opt[1][i] = 1;
			opt[0][i] = 0;
		}
		for (int i = 2; i <= floorNum; i++) {
			for (int j = 2; j <= eggNum; j++) {
				int min = Integer.MAX_VALUE;
				for (int k = 1; k <= i; k++) {
					int max = Math.max(opt[k - 1][j - 1], opt[i - k][j]) + 1;
					if (max <= min) {
						min = max;
					}
				}
				opt[i][j] = min;
			}
		}
		return opt[floorNum][eggNum];
	}
	
	public static void main(String[] args) {
		System.out.println(Solution.steps(1000, 10));
		System.out.println(A.a);
		System.out.println(B.b);
	}
}
