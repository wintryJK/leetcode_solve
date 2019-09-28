package com.test;

/*
 * 给定�?个数组，它的第 i 个元素是�?支给定股票第 i 天的价格�?
 * 如果你最多只允许完成�?笔交易（即买入和卖出�?支股票），设计一个算法来计算你所能获取的�?大利润�??
 * 注意你不能在买入股票前卖出股票�??
 * 
 * 输入: [7,1,5,3,6,4]
 * 输出: 5
 * 解释: 
 * 在第 2 天（股票价格 = 1）的时�?�买入，
 * 在第 5 天（股票价格 = 6）的时�?�卖出，
 * �?大利�? = 6-1 = 5 �?
 * 注意利润不能�? 7-1 = 6, 因为卖出价格�?要大于买入价格�??
 * 
 */
public class Easy_121_maxProfit {
	public static void main(String[] args) {
		int[] prices = {7,1,5,3,6,4};
		System.out.println(maxProfit(prices));
	}
	public static int maxProfit(int[] prices) {
		int length = prices.length;
		if (length == 0) {
			return -1;
		}
		int max = 0;
		int soFarMin = prices[0];
		for (int i = 0; i < length; i++) {
			if (prices[i] < soFarMin) {
				soFarMin = prices[i];
			}else {
				max = Math.max(max, prices[i] - soFarMin);
			}			
		}
		return max;
    }
}
