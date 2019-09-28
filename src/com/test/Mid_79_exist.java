package com.test;
/*
 * 给定�?个二维网格和�?个单词，找出该单词是否存在于网格中�??
 * 单词必须按照字母顺序，�?�过相邻的单元格内的字母构成�?
 * 其中“相邻�?�单元格是那些水平相邻或垂直相邻的单元格�?
 * 同一个单元格内的字母不允许被重复使用�?
 * board =
[
  ['A','B','C','E'],
  ['S','F','C','S'],
  ['A','D','E','E']
]

给定 word = "ABCCED", 返回 true.
给定 word = "SEE", 返回 true.
给定 word = "ABCB", 返回 false.
 */
public class Mid_79_exist {
	private final int[][] directions = {{1,0},{-1,0},{0,-1},{0,1}};
	public static void main(String[] args) {
		char[][] board = {{'A','B','C','E'},
						{'S','F','C','S'},
						{'A','D','E','E'}};
		char[][] board2 = {{'a','a'}};
		char[][] board3 = {{'C','A','A'},
							{'A','A','A'},
							{'B','C','D'}};
		String word = "SEE";
		String word2 = "aaa";
		String word3 = "AAB";
		System.out.println(new Mid_79_exist().exist(board3, word3));
	}
    public boolean exist(char[][] board, String word) {
        if (word == null || word.length() == 0) {
			return true;
		}
        if (board == null || board.length == 0) {
			return false;
		}
        int m = board.length;
        int n = board[0].length;
        char startChar = word.charAt(0);
        boolean[][] marked = new boolean[m][n];
        //boolean flag = false;
        for(int i = 0; i < m; i++) {
        	for(int j = 0; j < n; j++) {
        		if (board[i][j] == startChar) {
        			if (dfs(1,i,j,marked,board,word)) {
						return true;
					}
				}
        	}
        }
        
        return false;
    }
	private boolean dfs(int curLen,int i, int j, boolean[][] marked, char[][] board, String word) {
		if (curLen == word.length()) {
			return true;
		}
		int m = board.length;
        int n = board[0].length;
        marked[i][j] = true;
        for(int[] d:directions) {
        	int nr = i + d[0];
        	int nc = j + d[1];
        	if (nr < 0 || nc < 0 || nr >= m || nc >= n || marked[nr][nc] || board[nr][nc] != word.charAt(curLen)) {
				continue;
			}
        	//marked[nr][nc] = true;
        	System.out.println("(" + nr + "," + nc + ")");
        	if(dfs(curLen+1,nr,nc,marked,board,word)) {
        		return true;
        	}
        }
        marked[i][j] = false;
		return false;
	}
	
}
