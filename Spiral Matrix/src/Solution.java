import java.util.ArrayList;

/**
 * Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.

For example,
Given the following matrix:

[
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
]

You should return [1,2,3,6,9,8,7,4,5]. 
 * @author hali3
 *
 */
/**
 * Take care of cases where row or column number is 1
 * @author hali3
 *
 */
public class Solution {
    public ArrayList<Integer> spiralOrder(int[][] matrix) {
    	ArrayList<Integer> res = new ArrayList<Integer>();
        int rowNum = matrix.length;
        if (rowNum == 0) {
        	return res;
        }
        int colNum = matrix[0].length;
        
        for (int i = 0; i < (Math.min(rowNum, colNum) + 1) / 2; i++) {
        	for (int j = i; j < colNum - i; j++) {
        		res.add(matrix[i][j]);
        	}
        	for (int j = i + 1; j < rowNum - i; j++) {
        		res.add(matrix[j][colNum - i - 1]);
        	}
        	for (int j = colNum - i - 2; rowNum - i - 1 != i && j >= i; j--) {
        		res.add(matrix[rowNum - i - 1][j]);
        	}
        	for (int j = rowNum - i - 2; colNum - i - 1 != i && j >= i + 1; j--) {
        		res.add(matrix[j][i]);
        	}
        }
        
        return res;
    }
}
