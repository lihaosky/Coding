/* 
 * Determine if a Sudoku is valid. Empty cells are filled with '.'
 */

/**
 * Solution: check each row and column and each square.
 * @author hali3
 *
 */
public class Solution {
    public boolean isValidSudoku(char[][] board) {
        boolean[] isRowSet = new boolean[10];
        boolean[] isColSet = new boolean[10];
        
        // Check each row and column
        for (int i = 0; i < 9; i++) {
        	for (int j = 0; j < 9; j++) {
        		if (board[i][j] != '.') {
        			if (isRowSet[board[i][j] - '0']) {
        				return false;
        			}
        			isRowSet[board[i][j] - '0'] = true;
        		}
        		if (board[j][i] != '.') {
        			if (isColSet[board[j][i] - '0']) {
        				return false;
        			}
        			isColSet[board[j][i] - '0'] = true;
        		}
        	}
        	reset(isRowSet);
        	reset(isColSet);
        }
        
        // Check square
        for (int i = 0; i < 3; i++) {
        	for (int j = 0; j < 3; j++) {
        		for (int m = i * 3; m < i * 3 + 3; m++) {
        			for (int n = j * 3; n < j * 3 + 3; n++) {
        			    if (board[m][n] != '.') {
            				if (isRowSet[board[m][n] - '0']) {
            					return false;
            				}
            				isRowSet[board[m][n] - '0'] = true;
        			    }
        			}
        		}
        		reset(isRowSet);
        	}
        }
        
        return true;
    }
    
    public void reset(boolean[] set) {
    	for (int i = 0; i < set.length; i++) {
    		set[i] = false;
    	}
    }
}
