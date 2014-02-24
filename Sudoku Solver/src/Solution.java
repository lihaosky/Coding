/**
 * Write a program to solve a Sudoku puzzle by filling the empty cells.

Empty cells are indicated by the character '.'.

You may assume that there will be only one unique solution. 
 * @author lihaosky
 *
 */
public class Solution {
    public void solveSudoku(char[][] board) {
        boolean[][] present = new boolean[9][9];
        for (int i = 0; i < 9; i++) {
        	for (int j = 0; j < 9; j++) {
        		if (board[i][j] != '.') {
        			present[i][j] = true;
        		}
        	}
        }
        solve(board, 0, 0, present);
    }
    
    public boolean solve(char[][] board, int x, int y, boolean[][] present) {
    	if (x >= 9) {
    		return true;
    	}
    	if (present[x][y]) {
    		if (!isValid(board, x, y)) {
    			return false;
    		}
    		if (y == 8) {
    			y = 0;
    			x++;
    		} else {
    			y++;
    		}
    		return solve(board, x, y, present);
    	} else {
    		for (char c = '1'; c <= '9'; c++) {
    			board[x][y] = c;
    			if (isValid(board, x, y)) {
	    			int newx, newy;
	    			if (y == 8) {
	    				newx = x + 1;
	    				newy = 0;
	    			} else {
	    				newx = x;
	    				newy = y + 1;
	    			}
	
	    			if (solve(board, newx, newy, present)) {
	    				return true;
	    			}
    			}
    		}
    		board[x][y] = '.';
    		return false;
    	}
    }
    
    public boolean isValid(char[][] board, int x, int y) {
    	if (x < 0 || x >= 9 || y < 0 || y >= 9) {
    		return false;
    	}
    	if (board[x][y] < '1' || board[x][y] > '9') {
    		return false;
    	}
    	for (int i = 0; i < 9; i++) {
    		if (i == y) {
    			continue;
    		}
    		if (board[x][i] == board[x][y]) {
    			return false;
    		}
    	}
    	for (int i = 0; i < 9; i++) {
    		if (i == x) {
    			continue;
    		}
    		if (board[i][y] == board[x][y]) {
    			return false;
    		}
    	}
    	for (int i = (x / 3) * 3; i < (x / 3) * 3 + 3; i++) {
    		for (int j = (y / 3) * 3; j < (y / 3) * 3 + 3; j++) {
    			if (i == x && j == y) {
    				continue;
    			}
    			if (board[i][j] == board[x][y]) {
    				return false;
    			}
    		}
    	}
    	return true;
    }
    
    public void printBoard(char[][] board) {
    	for (int i = 0; i < 9; i++) {
    		for (int j = 0; j < 9; j++) {
    			System.out.print(board[i][j] + " ");
    		}
    		System.out.println();
    	}
    }
    
    public static void main(String[] args) {
    	char[][] board = {
    			{'5', '3', '.', '.', '7', '.', '.', '.', '.'},
    			{'6', '.', '.', '1', '9', '5', '.', '.', '.'},
    			{'.', '9', '8', '.', '.', '.', '.', '6', '.'},
    			{'8', '.', '.', '.', '6', '.', '.', '.', '3'},
    			{'4', '.', '.', '8', '.', '3', '.', '.', '1'},
    			{'7', '.', '.', '.', '2', '.', '.', '.', '6'},
    			{'.', '6', '.', '.', '.', '.', '2', '8', '.'},
    			{'.', '.', '.', '4', '1', '9', '.', '.', '5'},
    			{'.', '.', '.', '.', '8', '.', '.', '7', '9'}
    	};
    	new Solution().solveSudoku(board);
    	new Solution().printBoard(board);
    }
}
