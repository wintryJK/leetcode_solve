package com.test.mid;
/*
 * 你是�?个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有�?定的现金。这个地方所有的房屋都围成一圈，这意味着第一个房屋和�?后一个房屋是紧挨�?的�?�同时，相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同�?晚上被小偷闯入，系统会自动报警�??

给定�?个代表每个房屋存放金额的非负整数数组，计算你在不触动警报装置的情况下，能够偷窃到的最高金额�??

示例 1:

输入: [2,3,2]
输出: 3
解释: 你不能先偷窃 1 号房屋（金额 = 2），然后偷窃 3 号房屋（金额 = 2�?, 因为他们是相邻的�?
示例 2:

输入: [1,2,3,1]
输出: 4
解释: 你可以先偷窃 1 号房屋（金额 = 1），然后偷窃 3 号房屋（金额 = 3）�??
     偷窃到的�?高金�? = 1 + 3 = 4 �?

 */
public class Mid_213_rob {
	public static void main(String[] args) {
		int[] nums = {1,2,3,1};
		int[] nums2 = {2,3,2};
		System.out.println(new Mid_213_rob().rob(nums2));
	}
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
			return 0;
		}
        int n = nums.length;
        if (n == 1) {
			return nums[0];
		}
        return Math.max(rob(nums,0,n-2), rob(nums,1,n-1));
    }
	private int rob(int[] nums,int start, int end) {
		int pre2 = 0,pre1 = 0;
		for (int i = start; i <= end; i++) {
			int cur = Math.max(pre1, pre2 + nums[i]);
			pre2 = pre1;
			pre1 = cur;
		}
		return pre1;
	}
}
