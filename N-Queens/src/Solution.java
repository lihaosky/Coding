import java.util.ArrayList;

/**
 * The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.
 * Given an integer n, return all distinct solutions to the n-queens puzzle.

Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space respectively.
 * @author lihaosky
 *
 */
public class Solution {
	public ArrayList<String[]> solveNQueens(int n) {
		ArrayList<String[]> solutionList = new ArrayList<String[]>();
		fillNQueens(new int[n], 0, solutionList);
		return solutionList;
	}
	
	public void fillNQueens(int[] board, int col, ArrayList<String[]> solutionList) {
		for (int i = 0; i < board.length; i++) {
			board[col] = i;
			if (checkCol(board, col)) {
				if (col == board.length - 1) {
					constructList(board, solutionList);
				} else {
					fillNQueens(board, col + 1, solutionList);
				}
			}
		}
	}
	
	public void constructList(int[] board, ArrayList<String[]> solutionList) {
		String[] solution = new String[board.length];
		for (int i = 0; i < board.length; i++) {
			String row = "";
			for (int j = 0; j < board.length; j++) {
				if (board[j] == i) {
					row += "Q";
				} else {
					row += ".";
				}
			}
			solution[i] = row;
		}
		solutionList.add(solution);
	}
	
	public boolean checkCol(int[] board, int col) {
		for (int i = 0; i < col; i++) {
			if (board[i] == board[col]) {
				return false;
			}
			if (Math.abs((i - col)) == Math.abs((board[i] - board[col]))) {
				return false;
			}
		}
		return true;
	}
	
	public static void printList(ArrayList<String[]> list) {
		for (String[] sArray : list) {
			for (String s : sArray) {
				System.out.println(s);
			}
			System.out.println("\n\n");
			
		}
	}
	public static void main(String[] args) {
		ArrayList<String[]> list = new Solution().solveNQueens(5);
		printList(list);
	}
}
