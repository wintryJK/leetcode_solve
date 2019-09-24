package com.test;

import java.util.Arrays;
import java.util.Comparator;

/*
 * 给定一个区间的集合，找到需要移除区间的最小数量，使剩余区间互不重叠。
 * 1. 可以认为区间的终点总是大于它的起点。
 * 2. 区间 [1,2] 和 [2,3] 的边界相互“接触”，但没有相互重叠。
 * 
 * 输入: [ [1,2], [2,3], [3,4], [1,3] ]
 * 输出: 1
 * 解释: 移除 [1,3] 后，剩下的区间没有重叠。
 */
public class Mid_435_eraseOverlapIntervals {
	public static void main(String[] args) {
		int[][] array = {{1,2},{2,3},{3,4},{1,3}};
		System.out.println(eraseOverlapIntervals(array));
	}
	public static int eraseOverlapIntervals(int[][] intervals) {
		if (intervals.length == 0) {
			return 0;
		}
		// 这里比较重要的是二维数组，对尾部进行排序
		// 用到的是Comparator
		//Arrays.sort(intervals, Comparator.comparingInt(o -> o[1]));
		Arrays.sort(intervals,new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				// TODO Auto-generated method stub
				return o1[1] - o2[1];
			}
		});
        int cnt = 1;
        int end = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
			if (intervals[i][0] < end) {
				continue;
			}
			cnt++;
			end = intervals[i][1];
		}
        return intervals.length - cnt;
    }
}
