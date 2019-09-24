package com.test;

import java.util.Arrays;
import java.util.Comparator;

/*
 * ����һ������ļ��ϣ��ҵ���Ҫ�Ƴ��������С������ʹʣ�����以���ص���
 * 1. ������Ϊ������յ����Ǵ���������㡣
 * 2. ���� [1,2] �� [2,3] �ı߽��໥���Ӵ�������û���໥�ص���
 * 
 * ����: [ [1,2], [2,3], [3,4], [1,3] ]
 * ���: 1
 * ����: �Ƴ� [1,3] ��ʣ�µ�����û���ص���
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
		// ����Ƚ���Ҫ���Ƕ�ά���飬��β����������
		// �õ�����Comparator
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
