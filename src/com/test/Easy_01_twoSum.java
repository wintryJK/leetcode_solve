package com.test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Easy_01_twoSum {
	public static void main(String[] args) {
		int[] arr = { 1,2,3,4,5 };
		int target = 4;
		int[] result = twoSum(arr, target);
//		for (int i = 0; i < result.length; i++) {
//			System.out.println(result[i]);
//		}
		System.out.println(Arrays.toString(result));
	}
	
	public static int[] twoSum(int[] nums, int target) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < nums.length; i++) {
			int sub = target - nums[i];
			if (map.containsKey(sub)) {
				return new int[] {map.get(sub),i};
			}
			map.put(nums[i], i);
		}
		throw new IllegalArgumentException("NO twoSum solution");
    }
}
