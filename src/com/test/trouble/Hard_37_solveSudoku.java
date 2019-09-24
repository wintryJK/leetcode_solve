package com.test.trouble;

import java.util.Arrays;

/*
 * 编写一个程序，通过已填充的空格来解决数独问题。

一个数独的解法需遵循如下规则：

数字 1-9 在每一行只能出现一次。
数字 1-9 在每一列只能出现一次。
数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。
空白格用 '.' 表示。

 */
public class Hard_37_solveSudoku {
	private boolean[][] rowsUsed = new boolean[9][10];
	private boolean[][] colsUsed = new boolean[9][10];
	private boolean[][] cubesUsed = new boolean[9][10];
	private char[][] board;
	public static void main(String[] args) {
		char[][] board = {{'5','3','.','.','7','.','.','.','.'},
						{'6','.','.','1','9','5','.','.','.'},
						{'.','9','8','.','.','.','.','6','.'},
						{'8','.','.','.','6','.','.','.','3'},
						{'4','.','.','8','.','3','.','.','1'},
						{'7','.','.','.','2','.','.','.','6'},
						{'.','6','.','.','.','.','2','8','.'},
						{'.','.','.','4','1','9','.','.','5'},
						{'.','.','.','.','8','.','.','7','9'}};
		Hard_37_solveSudoku solve = new Hard_37_solveSudoku();
		solve.solveSudoku(board);
		for (int i = 0; i < board.length; i++) {
			System.out.println(Arrays.toString(board[i]));
		}
	}
    public void solveSudoku(char[][] board) {
        this.board = board;
        if (board == null || board.length == 0 || board[0].length == 0) {
			return;
		}
        for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (board[i][j] != '.') {
					int num = board[i][j] - '0';
					rowsUsed[i][num] = true;
					colsUsed[j][num] = true;
					cubesUsed[cubeNum(i,j)][num] = true;
				}
			}
		}
        backtracking(0,0);
    }
	private boolean backtracking(int row, int col) {
		while (row < 9 && board[row][col] != '.') {
			row = col == 8 ? row + 1 : row;
			col = col == 8 ? 0 : col + 1;
		}
		if (row == 9) {
			return true;
		}
		for(int i = 1; i <= 9; i++) {
			if (rowsUsed[row][i] || colsUsed[col][i] || cubesUsed[cubeNum(row, col)][i]) {
				continue;
			}
			board[row][col] = (char)(i + '0');
			rowsUsed[row][i] = colsUsed[col][i] = cubesUsed[cubeNum(row, col)][i] = true;
			if (backtracking(row, col)) {
				return true;
			}
			rowsUsed[row][i] = colsUsed[col][i] = cubesUsed[cubeNum(row, col)][i] = false;
			board[row][col] = '.';
		}
		return false;
	}
	private int cubeNum(int i, int j) {
		int row = i/3;
		int col = j/3;
		return row*3 + col;
	}
}
