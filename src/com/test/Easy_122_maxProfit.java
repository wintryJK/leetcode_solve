package com.test;

public class Easy_122_maxProfit {
	public static void main(String[] args) {
		int[] prices = {7,1,5,3,6,4};
		System.out.println(maxProfit(prices));
	}
    public static int maxProfit(int[] prices) {
        if (prices.length == 0) {
			return 0;
		}
    	int max = 0;
        for (int i = 1; i < prices.length; i++) {
			if (prices[i] > prices[i-1]) {
				max += prices[i] - prices[i-1];
			}
		}
        return max;
    }
}
