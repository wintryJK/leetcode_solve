package com.test.mid;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*
 * 给定�?个无序的整数数组，找到其中最长上升子序列的长度�??

示例:

输入: [10,9,2,5,3,7,101,18]
输出: 4 
解释: �?长的上升子序列是 [2,3,7,101]，它的长度是 4�?
 */
public class Mid_300_lengthOfLIS {
	public static void main(String[] args) {
		int[] nums = {0};
		System.out.println(new Mid_300_lengthOfLIS().lengthOfLIS(nums));
	}
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
			return 0;
		}
        int n = nums.length;
        int[] dp = new int[n + 1];
        for (int i = 0; i < n; i++) {
        	int max = 1;
			for (int j = 0; j < i; j++) {
				if (nums[j] < nums[i]) {
					max = Math.max(max, dp[j] + 1);
				}
			}
			dp[i] = max;
		}
        Arrays.sort(dp);
        return dp[n];
    }
}
