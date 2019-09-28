package com.test.mid;

import java.util.Arrays;

public class Mid_322_coinChange {
	public static void main(String[] args) {
		int[] coins = {2,5};
		int amount = 10;
		System.out.println(new Mid_322_coinChange().coinChange(coins, amount));
	}
	public int coinChange(int[] coins, int amount) {
		if (coins == null) {
			return 0;
		}
		int[] dp = new int[amount + 1];
		Arrays.fill(dp, amount + 1);
		dp[0] = 0;
		for (int coin : coins) {
			//int min = Integer.MAX_VALUE;
			for (int i = coin; i <= amount; i++) {
				dp[i] = Math.min(dp[i],dp[i - coin] + 1);
			}
		}
		return dp[amount] > amount ? -1 : dp[amount];
	}
}
