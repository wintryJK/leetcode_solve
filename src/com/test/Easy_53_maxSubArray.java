package com.test;

/*
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * 输入: [-2,1,-3,4,-1,2,1,-5,4],
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 */
public class Easy_53_maxSubArray {
	public static void main(String[] args) {
		int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
		System.out.println(maxSubArray(nums));
	}
    public static int maxSubArray(int[] nums) {
        int presum = nums[0];
        int maxsum = presum;
        for (int i = 1; i < nums.length; i++) {
			presum = presum > 0 ? presum + nums[i] : nums[i];
			maxsum = Math.max(presum, maxsum);
		}
        return maxsum;
    }
}
