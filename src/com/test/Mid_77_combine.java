package com.test;

import java.util.ArrayList;
import java.util.List;

/*
 * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
 */
public class Mid_77_combine {
	public static void main(String[] args) {
		int n = 4;
		int k = 2;
		System.out.println(new Mid_77_combine().combine(n, k).toString());
	}
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> combines = new ArrayList<List<Integer>>();
    	if (n == 0 || k == 0 || n < k) {
			return combines;
		}
    	List<Integer> combineList = new ArrayList<Integer>();
    	doCombine(combines,combineList,1,k,n);
    	return combines;
    }
	private void doCombine(List<List<Integer>> combines, List<Integer> combineList, int start, int k, int n) {
		if (combineList.size() == k) {
			combines.add(new ArrayList<Integer>(combineList));
			return;
		}
		for(int i = start; i <= n ; i++) {
			combineList.add(i);
			doCombine(combines, combineList, i + 1, k, n);
			combineList.remove(combineList.size() - 1);
		}
	}
    
}
