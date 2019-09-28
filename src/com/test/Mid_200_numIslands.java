package com.test;

/*
 * 考察点：DFS 深度优先
 * 给定�?个由 '1'（陆地）�? '0'（水）组成的的二维网格，计算岛屿的数量�??
 * �?个岛被水包围，并且它是�?�过水平方向或垂直方向上相邻的陆地连接�?�成的�??
 * 你可以假设网格的四个边均被水包围�?
 * 输入:
 * 11000
 * 11000
 * 00100
 * 00011
 * 输出: 3
 */
public class Mid_200_numIslands {
	private static int[][] directions = {{1,0},{-1,0},{0,1},{0,-1}};
	public static void main(String[] args) {
		// 
		char[][] grid = {{'1','1','0','0','0'},
						{'1','1','0','0','0'},
						{'0','0','1','0','0'},
						{'0','0','0','1','1'}};
		char[][] grid2 = {{'1','0'},{'0','1'}};
		
		System.out.println(numIslands(grid2));
	}
	
    public static int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
			return 0;
		}
        int m = grid.length;
        int n = grid[0].length;
        int islandNum = 0;
        for(int i = 0; i < m; i++) {
        	for(int j = 0; j < n; j++) {
        		if (grid[i][j] != '0') {
					dfs(grid,i,j);
					islandNum++;
				}
        	}
        }
        return islandNum;
    }
    
    public static void dfs(char[][] grid,int i,int j) {
    	int m = grid.length;
        int n = grid[0].length;
    	if (i >= m || j >= n || i < 0 || j < 0 || grid[i][j] == '0') {
			return;
		}
    	grid[i][j] = '0';
    	for(int[] d:directions) {
    		dfs(grid, i + d[0], j + d[1]);
    	}
    }
}
