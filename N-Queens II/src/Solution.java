public class Solution {
    public int totalNQueens(int n) {
        int[] rowPos = new int[n];
        return NQueensNum(rowPos, 0);
    }
    
    public int NQueensNum(int[] rowPos, int row) {
        if (row >= rowPos.length) {
            return 1;
        }
        int sum = 0;
        for (int i = 0; i < rowPos.length; i++) {
            rowPos[row] = i;
            if (valid(rowPos, row)) {
                sum += NQueensNum(rowPos, row + 1);
            }
        }
        return sum;
    }
    
    public boolean valid(int[] rowPos, int row) {
        for (int i = 0; i < row; i++) {
            if (rowPos[i] == rowPos[row]) {
                return false;
            }
        }
        for (int i = 0; i < row; i++) {
            if (row - i == Math.abs(rowPos[row] - rowPos[i])) {
                return false;
            }
        }
        return true;
    }
    
    public static void main(String[] args) {
    	System.out.println(new Solution().totalNQueens(20));
    }
}