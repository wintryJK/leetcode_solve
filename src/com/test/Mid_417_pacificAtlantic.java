package com.test;

import java.util.ArrayList;
import java.util.List;

/*
 * 给定�?�? m x n 的非负整数矩阵来表示�?片大陆上各个单元格的高度�?
 * “太平洋”处于大陆的左边界和上边界，而�?�大西洋”处于大陆的右边界和下边界�??
 * 规定水流只能按照上�?�下、左、右四个方向流动，且只能从高到低或�?�在同等高度上流动�??
 * 请找出那些水流既可以流动到�?�太平洋”，又能流动到�?�大西洋”的陆地单元的坐标�??
 * 给定下面�? 5x5 矩阵:
 *  太平�? ~   ~   ~   ~   ~ 
       ~  1   2   2   3  (5) *
       ~  3   2   3  (4) (4) *
       ~  2   4  (5)  3   1  *
       ~ (6) (7)  1   4   5  *
       ~ (5)  1   1   2   4  *
          *   *   *   *   * 大西�?
返回:
[[0, 4], [1, 3], [1, 4], [2, 2], [3, 0], [3, 1], [4, 0]] (上图中带括号的单�?).

 */
public class Mid_417_pacificAtlantic {
	private int[][] directions = {{1,0},{-1,0},{0,1},{0,-1}};
	private int[][] matrix;
	public static void main(String[] args) {
		int[][] array = {{1,2,2,3,5},{3,2,3,4,4},{2,4,5,3,1},{6,7,1,4,5},{5,1,1,2,4}};
		List<List<Integer>> resultList = new Mid_417_pacificAtlantic().pacificAtlantic(array);
		System.out.println(resultList.toString());
	}
    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
        /*
         * 这道题�?�察的还是DFS，深度优先搜�?
         * 我们可以看到，首先太平洋边上的一排或者是�?列肯定是可以到达�?
         * 那么与他们联通，DFS，的�?有海平面高于他们的也可以到达
         */
    	List<List<Integer>> ret = new ArrayList<>();
    	if (matrix == null || matrix.length == 0) {
			return ret;
		}
    	this.matrix = matrix;
    	int m = matrix.length;
    	int n = matrix[0].length;
    	boolean[][] canReachP = new boolean[m][n];
    	boolean[][] canReachA = new boolean[m][n];
    	for(int i = 0; i < m; i++) {
    		dfs(canReachP,i,0);
    		dfs(canReachA,i,n-1);
    	}
    	int a = 0;
    	for (int i = 0; i < n; i++) {
			dfs(canReachP,0,i);
			dfs(canReachA,m-1,i);
		}
    	
    	for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (canReachA[i][j] && canReachP[i][j]) {
					List<Integer> list = new ArrayList<Integer>();
					list.add(i);
					list.add(j);
					ret.add(list);
				}
			}
		}
    	return ret;
    }
    public void dfs(boolean[][] canReach,int i,int j) {
    	if (canReach[i][j]) {
			return;
		}
    	canReach[i][j] = true;
    	int m = canReach.length;
    	int n = canReach[0].length;
    	for(int[] d:directions) {
    		int nr = i + d[0];
    		int nc = j + d[1];
    		if (nr < 0 || nc < 0 || nr >= m || nc >= n || matrix[i][j] > matrix[nr][nc]) {
				continue;
			}
    		dfs(canReach, nr, nc);
    	}
	}
}
