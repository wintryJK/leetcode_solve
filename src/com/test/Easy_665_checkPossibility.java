package com.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * 给定一个长度为 n 的整数数组，
 * 你的任务是判断在最多改变 1 个元素的情况下，
 * 该数组能否变成一个非递减数列。
 * 我们是这样定义一个非递减数列的： 
 * 对于数组中所有的 i (1 <= i < n)，满足 
 * array[i] <= array[i + 1]。
 */
public class Easy_665_checkPossibility {
	public static void main(String[] args) {
		int[] nums1 = {2,3,3,2,4};
		int[] nums2 = {4,2,3};
		int[] nums3 = {1,2,3,9,4,5};
		System.out.println(checkPossibility(nums3));
	}
	public static boolean checkPossibility(int[] nums) {
        if (nums.length <= 1) {
			return true;
		}
        int cnt = 0;
        for (int i = 1; i < nums.length && cnt < 2; i++) {
			if (nums[i] >= nums[i-1]) {
				continue;
			}
			cnt++;
			if (i-2 >= 0 && nums[i] < nums[i-2]) {
				nums[i] = nums[i-1];
			}else {
				nums[i-1] = nums[i];
			}
		}
        return cnt<=1;
    }
}
