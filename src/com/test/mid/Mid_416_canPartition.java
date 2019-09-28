package com.test.mid;
/*
 * 给定�?个只包含正整数的非空数组。是否可以将这个数组分割成两个子集，使得两个子集的元素和相等�?

注意:

每个数组中的元素不会超过 100
数组的大小不会超�? 200
示例 1:

输入: [1, 5, 11, 5]

输出: true

解释: 数组可以分割�? [1, 5, 5] �? [11].
 

示例 2:

输入: [1, 2, 3, 5]

输出: false

解释: 数组不能分割成两个元素和相等的子�?.
*/

public class Mid_416_canPartition {
	public static void main(String[] args) {
		int[] nums = {1,5,11,5};
		System.out.println(new Mid_416_canPartition().canPartition(nums));
	}
	public boolean canPartition(int[] nums) {
	    int sum = computeArraySum(nums);
	    if (sum % 2 != 0) {
	        return false;
	    }
	    int W = sum / 2;
	    boolean[] dp = new boolean[W + 1];
	    dp[0] = true;
	    for (int num : nums) {                 // 0-1 背包�?个物品只能用�?�?
	        for (int i = W; i >= num; i--) {   // 从后�?前，先计�? dp[i] 再计�? dp[i-num]
	            dp[i] = dp[i] || dp[i - num];
	        }
	    }
	    return dp[W];
	}

	private int computeArraySum(int[] nums) {
	    int sum = 0;
	    for (int num : nums) {
	        sum += num;
	    }
	    return sum;
	}
}
