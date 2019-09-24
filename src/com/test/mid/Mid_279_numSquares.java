package com.test.mid;

import java.util.ArrayList;
import java.util.List;

/*
 * 给定正整数 n，找到若干个完全平方数（比如 1, 4, 9, 16, ...）使得它们的和等于 n。
 * 你需要让组成和的完全平方数的个数最少。
 * 上次使用广度优先遍历，这次使用动态规划
 */
public class Mid_279_numSquares {
	public static void main(String[] args) {
		System.out.println(new Mid_279_numSquares().generateSquare(12).toString());
	}
	public int numSquares(int n) {
		List<Integer> squares = new ArrayList<Integer>();
		squares = generateSquare(n);
		System.out.println(squares.toString());
		int[] dp = new int[n+1];
		for(int i = 1; i <= n; i++) {
			int min = Integer.MAX_VALUE;
			for(int square:squares) {
				if (square > n) {
					break;
				}
				// 这里的意思是:
				// 比如12
				// 拆分成 12 = 1 + dp[12-1]; //这里本身也是多了一个平方数所以加1
				// 或者是 12 = 4 + dp[12-4];
				// 取最小值
				min = Math.min(min, dp[i - square] + 1);
			}
			dp[i] = min;
		}
		return dp[n];
	}
	private List<Integer> generateSquare(int n) {
		List<Integer> squares = new ArrayList<Integer>();
		int square = 1;
		int cnt = 1;
		while (square <= n) {
			squares.add(square);
			cnt++;
			square = cnt*cnt;
		}
		return squares;
	}
}
