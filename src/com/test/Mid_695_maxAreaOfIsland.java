package com.test;

import java.util.Iterator;

public class Mid_695_maxAreaOfIsland {
	private static int m;
	private static int n;
	private static int[][] directions = {{1,0},{-1,0},{0,1},{0,-1}};
	public static void main(String[] args) {
		int[][] grid = {{0,0,1,0,0,0,0,1,0,0,0,0,0},
						{0,0,0,0,0,0,0,1,1,1,0,0,0},
						{0,1,1,0,1,0,0,0,0,0,0,0,0},
						{0,1,0,0,1,1,0,0,1,0,1,0,0},
						{0,1,0,0,1,1,0,0,1,1,1,0,0},
						{0,0,0,0,0,0,0,0,0,0,1,0,0},
						{0,0,0,0,0,0,0,1,1,1,0,0,0},
						{0,0,0,0,0,0,0,1,1,0,0,0,0}};
		System.out.println(maxAreaOfIsland(grid));
	}
	public static int maxAreaOfIsland(int[][] grid) {
		if (grid == null || grid.length == 0) {
			return 0;
		}
		int m = grid.length;
		int n= grid[0].length;
		int maxArea = 0;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				maxArea = Math.max(maxArea, dfs(grid,i,j));
			}
		}
		return maxArea;
    }
	public static int dfs(int[][] grid,int i,int j) {
		int m = grid.length;
		int n= grid[0].length;
		if (i >= m || j >= n || i < 0 || j < 0 || grid[i][j] == 0) {
			return 0;
		}
		grid[i][j] = 0;
		int area = 1;
		for(int[] d:directions) {
			area += dfs(grid, i + d[0], j + d[1]);
		}
		return area;
	}
	
}
