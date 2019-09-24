package com.test;

import java.util.ArrayList;
import java.util.List;

/*
 * 给定一个没有重复数字的序列，返回其所有可能的全排列。
 */
public class Mid_46_permute {
	public static void main(String[] args) {
		int[] nums = {1,2,3};
		System.out.println(new Mid_46_permute().permute(nums).toString());
	}
    public List<List<Integer>> permute(int[] nums) {
    	List<List<Integer>> permutes = new ArrayList<List<Integer>>();
    	if (nums == null || nums.length == 0) {
			return permutes;
		}
    	List<Integer> permuteList = new ArrayList<Integer>();
    	boolean[] hasVisited = new boolean[nums.length];
    	backtracking(permutes,permuteList,hasVisited,nums);
    	return permutes;
    }
	private void backtracking(List<List<Integer>> permutes, List<Integer> permuteList, boolean[] hasVisited,
			int[] nums) {
		if (permuteList.size() == nums.length) {
//			if (!permutes.contains(permuteList)) {
//				permutes.add(new ArrayList<Integer>(permuteList));
//			}
			permutes.add(new ArrayList<Integer>(permuteList));
			return;
		}
		for(int i = 0; i < hasVisited.length; i++) {
			if (hasVisited[i]) {
				continue;
			}
			hasVisited[i] = true;
			permuteList.add(nums[i]);
			backtracking(permutes, permuteList, hasVisited, nums);
			hasVisited[i] = false;
			permuteList.remove(permuteList.size() - 1);
			
		}
	}
}
