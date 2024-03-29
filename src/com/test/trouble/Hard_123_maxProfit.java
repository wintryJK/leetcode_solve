package com.test.trouble;

public class Hard_123_maxProfit {
	public static void main(String[] args) {
		int[] prices = {3,3,5,0,0,3,1,4};
		System.out.println(new Hard_123_maxProfit().maxProfit(prices));
	}
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
			return 0;
		}
        int n = prices.length;
        int max_k = 2;
        int[][][] dp = new int[n][max_k + 1][2];
        for(int i = 0; i < n; i++) {
        	for(int k = 1; k <= max_k; k++) {
        		if (i == 0) {
					dp[i][k][0] = 0;
					dp[i][k][1] = -prices[i];
				}else {
					dp[i][k][0] = Math.max(dp[i-1][k][0], dp[i-1][k][1] + prices[i]);
					dp[i][k][1] = Math.max(dp[i-1][k][1], dp[i-1][k-1][0] - prices[i]);
				}
        	}
        }
        return dp[n-1][max_k][0];
    }
}
