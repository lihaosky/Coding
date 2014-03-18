/**
 *  Given a 2D board and a word, find if the word exists in the grid.

The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.

For example,
Given board =

[
  ["ABCE"],
  ["SFCS"],
  ["ADEE"]
]

word = "ABCCED", -> returns true,
word = "SEE", -> returns true,
word = "ABCB", -> returns false.
 * @author hali3
 *
 */
public class Solution {
    public boolean exist(char[][] board, String word) {
    	if (board == null || board[0].length <= 0) {
    		return false;
    	}
    	if (word == null || word.length() == 0) {
    		return true;
    	}
    	boolean[][] used = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
        	for (int j = 0; j < board[0].length; j++) {
        		if (board[i][j] == word.charAt(0)) {
        			used[i][j] = true;
        			if (search(board, word, 1, used, i, j)) {
        				return true;
        			}
        		}
        	}
        }
        return false;
    }
    
    public boolean search(char[][] board, String word, int start, boolean[][] used, int row, int col) {
    	int rowNum = board.length;
    	int colNum = board[0].length;
    	
    	if (start >= word.length()) {
    		System.out.println(row + " " + col);
    		return true;
    	}
    	//Go left
    	if (col - 1 >= 0 && !used[row][col - 1] && board[row][col - 1] == word.charAt(start)) {
    		used[row][col - 1] = true;
    		if (search(board, word, start + 1, used, row, col - 1)) {
    			System.out.println(row + " " + col);
    			return true;
    		}
    	}
    	// Go up
    	if (row - 1 >= 0 && !used[row - 1][col] && board[row - 1][col] == word.charAt(start)) {
    		used[row - 1][col] = true;
    		if (search(board, word, start + 1, used, row - 1, col)) {
    			System.out.println(row + " " + col);
    			return true;
    		}
    	}
    	// Go right
    	if (col + 1 < colNum && !used[row][col + 1] && board[row][col + 1] == word.charAt(start)) {
    		used[row][col + 1] = true;
    		if (search(board, word, start + 1, used, row, col + 1)) {
    			System.out.println(row + " " + col);
    			return true;
    		}
    	}
    	// Go down
    	if (row + 1 < rowNum && !used[row + 1][col] && board[row + 1][col] == word.charAt(start)) {
    		used[row + 1][col] = true;
    		if (search(board, word, start + 1, used, row + 1, col)) {
    			System.out.println(row + " " + col);
    			return true;
    		}
    	}
    	used[row][col] = false;
    	return false;
    }
    
    public static void main(String[] args) {
    	char[][] b = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
    	System.out.println(new Solution().exist(b, "ABCCED"));
    	System.out.println(new Solution().exist(b, "SEE"));
    	System.out.println(new Solution().exist(b, "ABCB"));
    }
}
