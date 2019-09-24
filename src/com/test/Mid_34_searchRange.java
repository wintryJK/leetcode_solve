package com.test;

import java.util.Arrays;

/*
 * 二分查找法
 * 
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。
 * 找出给定目标值在数组中的开始位置和结束位置。
 * 你的算法时间复杂度必须是 O(log n) 级别。
 * 如果数组中不存在目标值，返回 [-1, -1]。
 * 
 * 输入: nums = [5,7,7,8,8,10], target = 8
 * 输出: [3,4]
 */
public class Mid_34_searchRange {
	public static void main(String[] args) {
		int[] nums = { 5,7,7,8,8,10 };
		int[] nums2 = { 2,2 };
		System.out.println(binarySearch(nums, 9));
		System.out.println(Arrays.toString(searchRange(nums2, 2)));
	}
	/*
	 * 这里要求的时间复杂度为O(log n)级别，明显是让我们使用二分查找
	 * 但是典型的二分查找只能返回一个数，所以刚开始我的想法是，
	 * 一个用来查找左边界，另一个用来查找右边界
	 * 但是这样需要写两个二分查找
	 * 更好的方法是，都是用来查找左边界
	 * 一个参数放入 target 另一个放入 target + 1
	 */
    public static int[] searchRange(int[] nums, int target) {
		int start = binarySearch(nums, target);
		int end = binarySearch(nums, target + 1) - 1;
		if (start == nums.length || nums[start] != target) {
			return new int[] {-1,-1};
		}else {
			return new int[] {start , end};
		}
    }
    public static int binarySearch(int[] nums, int target) {
		int left = 0;
		int right = nums.length;
		while (left < right) {
			int mid = left + (right - left)/2;
			if (nums[mid] < target) {
				left = mid + 1;
			}else {
				right = mid;
			}
		}
		return left;
	}
    
}
