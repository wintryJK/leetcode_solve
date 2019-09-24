package com.test;

/*
 * 二分查找法
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 * 请找出其中最小的元素。
 * 你可以假设数组中不存在重复元素。
 * 
 */
public class Mid_153_findMin {
	public static void main(String[] args) {
		int[] nums = {4,5,6,7,0,1,2};
		System.out.println(findMin(nums));
	}
    public static int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
			int mid = left + (right - left)/2;
			if (nums[mid] < nums[right]) {
				right = mid;
			}else {
				left = mid + 1;
			}
		}
        return nums[left];
    }
}
