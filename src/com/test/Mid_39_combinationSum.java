package com.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * 给定一个无重复元素的数组 candidates 和一个目标数 target ，
 * 找出 candidates 中所有可以使数字和为 target 的组合。

candidates 中的数字可以无限制重复被选取。

说明：

所有数字（包括 target）都是正整数。
解集不能包含重复的组合。 
示例 1:

输入: candidates = [2,3,6,7], target = 7,
所求解集为:
[
  [7],
  [2,2,3]
]
 */
public class Mid_39_combinationSum {
	public static void main(String[] args) {
		int[] candidates = {2,3,6,7};
		int target = 7;
		System.out.println(new Mid_39_combinationSum().combinationSum(candidates, target).toString());
	}
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> combinations = new ArrayList<List<Integer>>();
    	if (candidates == null || candidates.length == 0) {
			return combinations;
		}
    	List<Integer> tempCombination = new ArrayList<Integer>();
    	Arrays.sort(candidates);
    	backtracking(combinations,tempCombination,0,target,candidates);
    	return combinations;
    }
	private void backtracking(List<List<Integer>> combinations, List<Integer> tempCombination, int start, int target,
			int[] candidates) {
		if (target == 0) {
			combinations.add(new ArrayList<Integer>(tempCombination));
			return;
		}
		for(int i = start; i < candidates.length; i++) {
			if (candidates[i] <= target) {
				tempCombination.add(candidates[i]);
				backtracking(combinations, tempCombination, i, target - candidates[i], candidates);
				tempCombination.remove(tempCombination.size() - 1);
			}else {
				break;
			}
		}
	}
    
}
