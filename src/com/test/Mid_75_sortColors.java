package com.test;

import java.beans.IntrospectionException;
import java.util.Arrays;

/*
 * 给定�?个包含红色�?�白色和蓝色�?
 * �?共 n 个元素的数组，原地对它们进行排序�?
 * 使得相同颜色的元素相邻，
 * 并按照红色�?�白色�?�蓝色顺序排列�??
 * 
 * 此题中，我们使用整数 0、�?1 �? 2 分别表示红色、白色和蓝色�?
 * 
 * 注意:
 * 不能使用代码库中的排序函数来解决这道题�??
 * 输入: [2,0,2,1,1,0]
 * 输出: [0,0,1,1,2,2]
 */
public class Mid_75_sortColors {
	public static void main(String[] args) {
		int[] nums = {2,0,2,0,1,0};
		sortColors(nums);
		System.out.println(Arrays.toString(nums));
	}
    public static void sortColors(int[] nums) {
        int p0 = 0;
        int curr = 0;
        int p2 = nums.length - 1;
        while(curr <= p2) {
        	if (nums[curr] == 0) {
				Swap(nums,p0,curr);
				p0++;
				curr++;
			}else if (nums[curr] == 2) {
				Swap(nums, p2, curr);
				p2--;
			}else {
				curr++;
			}
        }
    } 
    public static void Swap(int[] nums,int i,int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
}
