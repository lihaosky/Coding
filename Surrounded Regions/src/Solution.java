/**
 *  Given a 2D board containing 'X' and 'O', capture all regions surrounded by 'X'.

A region is captured by flipping all 'O's into 'X's in that surrounded region.

For example,

X X X X
X O O X
X X O X
X O X X

After running your function, the board should be:

X X X X
X X X X
X X X X
X O X X

 * @author lihaosky
 *
 */
public class Solution {
    public void solve(char[][] board) {
        if (board == null || board.length == 0) {
            return;
        }
        for (int i = 0; i < board[0].length; i++) {
            if (board[0][i] == 'O') {
                updateSurround(0, i, board);
            }
            if (board[board.length - 1][i] == 'O') {
                updateSurround(board.length - 1, i, board);
            }
        }
        for (int i = 0; i < board.length; i++) {
            if (board[i][0] == 'O') {
                updateSurround(i, 0, board);
            }
            if (board[i][board[0].length - 1] == 'O') {
                updateSurround(i, board[0].length - 1, board);
            }
        }
        for (int i = 1; i < board.length - 1; i++) {
            for (int j = 1; j < board[0].length - 1; j++) {
                if (board[i][j] == 'O') {
                    if (getSurround(i, j, board)) {
                        updateSurround(i, j, board);
                    }
                }
                if (board[board.length - i - 1][j] == 'O') {
                    if (getSurround(board.length - i - 1, j, board)) {
                        updateSurround(board.length - i - 1, j, board);
                    }
                }
            }
            for (int j = board[0].length - 2; j >= 0; j--) {
                if (board[i][j] == 'O') {
                    if (getSurround(i, j, board)) {
                        updateSurround(i, j, board);
                    }
                }
                if (board[board.length - i - 1][j] == 'O') {
                    if (getSurround(board.length - i - 1, j, board)) {
                        updateSurround(board.length - i - 1, j, board);
                    }
                }
            }
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
                if (board[i][j] == 'Y') {
                    board[i][j] = 'O';
                }
            }
        }
    }
    
    public boolean getSurround(int x, int y, char[][] board) {
        if (board[x][y] == 'Y') {
            return true;
        }
        if (x - 1 >= 0 && board[x - 1][y] == 'Y') {
            return true;
        }
        if (x + 1 < board.length && board[x + 1][y] == 'Y') {
            return true;
        }
        if (y - 1 >= 0 && board[x][y - 1] == 'Y') {
            return true;
        }
        if (y + 1 < board[0].length && board[x][y + 1] == 'Y') {
            return true;
        }
        return false;
    }
    
    public void updateSurround(int x, int y, char[][] board) {
        board[x][y] = 'Y';
        if (x - 1 >= 0 && board[x - 1][y] == 'O') {
            board[x - 1][y] = 'Y';
        }
        if (x + 1 < board.length && board[x + 1][y] == 'O') {
            board[x + 1][y] = 'Y';
        }
        if (y - 1 >= 0 && board[x][y - 1] == 'O') {
            board[x][y - 1] = 'Y';
        }
        if (y + 1 < board[0].length && board[x][y + 1] == 'O') {
            board[x][y + 1] = 'Y';
        }
    }
    
    public static boolean isPalindrome(String s) {
    	if (s == null || s.length() <= 1) {
    		return true;
    	}
    	int start = 0;
    	int end = s.length() - 1;
    	while (start < end) {
    		if (s.charAt(start) != s.charAt(end)) {
    			System.out.println(s.charAt(start) + " " + s.charAt(end));
    			System.out.println(start);
    			return false;
    		}
    		start++;
    		end--;
    	}
    	return true;
    }
    public static void main(String[] args) {
    	String s = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabbaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
    	System.out.println(isPalindrome(s));
    }
}
