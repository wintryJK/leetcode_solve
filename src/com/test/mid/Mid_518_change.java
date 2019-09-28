package com.test.mid;

public class Mid_518_change {
	public static void main(String[] args) {
		int[] coins = {1,2,5};
		int amount = 11;
		System.out.println(new Mid_518_change().change(amount, coins));
	}
	public int change(int amount, int[] coins) {
	    if (amount == 0 || coins == null || coins.length == 0) {
	        return 0;
	    }
	    int[] dp = new int[amount + 1];
	    dp[0] = 1;
	    for (int coin : coins) {
	        for (int i = coin; i <= amount; i++) {
	            dp[i] += dp[i - coin];
	        }
	    }
	    return dp[amount];
	}
}
