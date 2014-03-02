/**
 * You are given an n x n 2D matrix representing an image.

Rotate the image by 90 degrees (clockwise).

Follow up:
Could you do this in-place?
 * @author lihaosky
 *
 */
public class Solution {
	public void rotate(int[][] matrix) {
		for (int layer = 0; layer < (matrix.length + 1) / 2; layer++) {
			for (int i = layer; i < matrix.length - layer - 1; i++) {
				int tmp = matrix[layer][i];
				matrix[layer][i] = matrix[matrix.length - i - 1][layer];
				matrix[matrix.length - i - 1][layer] = matrix[matrix.length - layer - 1][matrix.length - i - 1];
				matrix[matrix.length - layer - 1][matrix.length - i - 1] = matrix[i][matrix.length - layer - 1];
				matrix[i][matrix.length - layer - 1] = tmp;
			}
		}
	}
	
	public static void main(String[] args) {
		int[][] matrix = {
				{1, 2, 3, 4},
				{5, 6, 7, 8}, 
				{9, 10, 11, 12},
				{13, 14, 15, 16}
		};
		new Solution().rotate(matrix);
		for (int[] row : matrix) {
			for (int num : row) {
				System.out.print(num + " ");
			}
			System.out.println();
		}
		
	}
}
