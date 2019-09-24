package com.test;
/*
 * 给定一个二维的矩阵，包含 'X' 和 'O'（字母 O）。
 * 找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充。
 * 
 * 示例:
 * X X X X
 * X O O X
 * X X O X
 * X O X X
 * 运行你的函数后，矩阵变为：
 * X X X X
 * X X X X
 * X X X X
 * X O X X
 * 
 * 被围绕的区间不会存在于边界上，
 * 换句话说，任何边界上的 'O' 都不会被填充为 'X'。 
 * 任何不在边界上，或不与边界上的 'O' 相连的 'O' 最终都会被填充为 'X'。
 * 如果两个元素在水平或垂直方向相邻，则称它们是“相连”的。
 * 
 */
public class Mid_130_solve {
	private int[][] directions = {{1,0},{-1,0},{0,-1},{0,1}};
	public static void main(String[] args) {
		char[][] board = {{'X','X','X','X'},
						{'X','O','O','X'},
						{'X','X','O','X'},
						{'X','O','X','X'}};
		new Mid_130_solve().solve(board);
		for(char[] c:board) {
			System.out.println(String.valueOf(c));
		}
	}
    public void solve(char[][] board) {
        if (board == null || board.length == 0) {
			return;
		}
        int m = board.length;
        int n = board[0].length;
        for(int i = 0; i < m; i++) {
        	dfs(board,i,0);
        	dfs(board,i,n-1);
        }
        for(int j = 0; j < n; j++) {
        	dfs(board, 0, j);
        	dfs(board, m-1, j);
        }
        for(int i = 0; i < m; i++) {
        	for(int j = 0; j < n; j++) {
        		if (board[i][j] == 'T') {
					board[i][j] = 'O';
				}else if (board[i][j] == 'O') {
					board[i][j] = 'X';
				}
        	}
        }
    }
    public void dfs(char[][] board,int i,int j) {
    	int m = board.length;
        int n = board[0].length;
    	if (i < 0 || j < 0 || i >= m || j >= n || board[i][j] != 'O') {
			return;
		}
    	board[i][j] = 'T';
    	for (int[] d:directions) {
			dfs(board, i + d[0], j + d[1]);
		}
    }
}
