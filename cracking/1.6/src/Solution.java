/**
 * Rotate an NxN matrix by 90 degree clockwise
 * @author Hao
 *
 */
public class Solution {
	public static void rotate(int[][] matrix) {
		int len = matrix.length;
		int layer = len >> 1;
		for (int i = 0; i < layer; i++) {
			for (int j = i; j < len - i - 1; j++) {
				int tmp = matrix[i][j];
				matrix[i][j] = matrix[len - i - 1 - j][i];
				matrix[len - i - 1 - j][i] = matrix[len - i - 1][len - i - 1 - j];
				matrix[len - i - 1][len - i -1 - j] = matrix[j][len - i - 1];
				matrix[j][len - i - 1] = tmp;
			}
		}
	}
	
	public static void printMatrix(int[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		int[][] matrix = {{1}};
		Solution.rotate(matrix);
		Solution.printMatrix(matrix);
		
		int[][] matrix1 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
		Solution.rotate(matrix1);
		Solution.printMatrix(matrix1);
	}
}
