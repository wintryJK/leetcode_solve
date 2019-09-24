package com.test.mid;
/*
 * 给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。

说明：每次只能向下或者向右移动一步。

示例:

输入:
[
  [1,3,1],
  [1,5,1],
  [4,2,1]
]
输出: 7
解释: 因为路径 1→3→1→1→1 的总和最小。
 */
public class Mid_64_minPathSum {
	public static void main(String[] args) {
		int[][] grid = {{1,3,1},
						{1,5,1},
						{4,2,1}};
		System.out.println(new Mid_64_minPathSum().minPathSum(grid));
	}
    public int minPathSum(int[][] grid) {
        if (grid == null || grid[0].length == 0) {
			return 0;
		}
        int n = grid.length;
        int m = grid[0].length;
        int[] dp = new int[m];
        for (int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				if (j == 0) {
					dp[j] = dp[j];
				}else if (i == 0) {
					dp[j] = dp[j - 1];
				}else {
					dp[j] = Math.min(dp[j], dp[j-1]);
				}
				dp[j] += grid[i][j];
			}
		}
        return dp[m - 1];
    }
}
