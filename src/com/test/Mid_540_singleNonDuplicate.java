package com.test;


/*
 * 二分查找法
 * 
 * 给定一个只包含整数的有序数组，每个元素都会出现两次，唯有一个数只会出现一次，找出这个数。
 * 
 * 输入: [1,1,2,3,3,4,4,8,8]
 * 输出: 2
 */
public class Mid_540_singleNonDuplicate {
	public static void main(String[] args) {
		int[] nums = {1,1,2,3,3,4,4,8,8};
		System.out.println(singleNonDuplicate(nums));
	}
    public static int singleNonDuplicate(int[] nums) {
        int length = nums.length;
        int left = 0;
        int right = length - 1;
        while (left < right) {
			int mid = left + (right - left)/2;
			if (mid % 2 == 1) {
				mid--;
			}
			if (nums[mid] == nums[mid + 1]) {
				left = mid + 2;
			}else {
				right = mid;
			}
		}
        return nums[left];
    }
}
