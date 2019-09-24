package com.test.mid;

public class Mid_322_coinChange {
	public static void main(String[] args) {
		int[] coins = {1,2,5};
		int amount = 11;
		System.out.println(new Mid_322_coinChange().coinChange(coins, amount));
	}
	public int coinChange(int[] coins, int amount) {
		if (coins == null) {
			return 0;
		}
		int[] dp = new int[amount + 1];
		dp[0] = 1;
		for (int coin : coins) {
			for (int i = coin; i <= amount; i++) {
				dp[i] = Math.max(dp[i], dp[i-coin]);
			}
		}
		return dp[amount];
	}
}
