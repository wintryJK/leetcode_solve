package com.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

/*
 * ��δ������������ҵ��� k ������Ԫ�ء�
 * ��ע�⣬����Ҫ�ҵ������������ĵ� k ������Ԫ�أ������ǵ� k ����ͬ��Ԫ�ء�
 * ����: [3,2,1,5,6,4] �� k = 2
 * �����5
 */
public class Mid_215_findKthLargest {
	public static void main(String[] args) {
		int[] nums = {8,2,9,6,5,3,7};
		int a = findKthLargest(nums, 3);
		
		System.out.println(a);
	}
	public static int findKthLargest(int[] nums, int k) {
		/*
		 * ����һ :
		 * ֱ��ʹ��API�������������򣬵õ�������k��Ԫ�ؾͿ���
		 */
		//Arrays.sort(nums);
		//return nums[nums.length-k];
		
		/*
		 * ��������
		 * ͨ�����ȶ���ʵ�ֵ�С������ʵ��
		 * �󶥶ѣ��ڵ���ӽڵ㶼��
		 * С���ѣ��ڵ���ӽڵ㶼С
		 * PriorityQueue ���ö�����С����ʵ��
		 * ���ȶ��е��������ܱ�֤ÿ��ȡ����Ԫ�ض��Ƕ�����Ȩֵ��С��
		 * ��Java�����ȶ���ÿ��ȡ��СԪ�أ�C++�����ȶ���ÿ��ȡ���Ԫ�أ���
		 * ����ǣ�浽�˴�С��ϵ��Ԫ�ش�С�����п���ͨ��Ԫ�ر������Ȼ˳��natural ordering��
		 * Ҳ����ͨ������ʱ����ıȽ�����Comparator��������C++�ķº�������
		 * Java��PriorityQueueʵ����Queue�ӿڣ����������nullԪ�أ�
		 * ��ͨ����ʵ�֣�����˵��ͨ����ȫ��������complete binary tree��
		 * ʵ�ֵ�С���ѣ�����һ����Ҷ�ӽڵ��Ȩֵ�����������������ӽڵ��Ȩֵ����
		 * Ҳ����ζ�ſ���ͨ����������ΪPriorityQueue�ĵײ�ʵ�֡�
		 * 
		 * 
		 * ����PriorityQueue Ĭ�� �Ĺ�������ʵ�ֵ�С����
		 * ÿ��size����k  �������� �Ķ�����Ҳ������С��Ԫ��
		 * 
		 * ����Լ�ʵ�ֱȽ�����ʵ�ֵĴ󶥶�
		 * ÿ��size����k  �������еĶ�����Ҳ��������Ԫ��
		 */
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		for (int i = 0; i < nums.length; i++) {
			pq.add(nums[i]);
			if (pq.size()>k) {
				//System.out.println(pq.peek());
				pq.poll();
			}
			System.out.println("peek --->" + pq.peek());
			for(Integer num:pq) {
				
				System.out.print(num + "-->");
			}
			System.out.println();
		}
		System.out.println("--------------------");
		PriorityQueue<Integer> pq2 = new PriorityQueue<Integer>(11,new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				
				return o2 - o1;
			}
		});
		for (int i = 0; i < nums.length; i++) {
			pq2.add(nums[i]);
			if (pq2.size()>k) {
				//System.out.println(pq.peek());
				pq2.poll();
			}
			for(Integer num:pq2) {
				System.out.print(num + "-->");
			}
			System.out.println();
		}
		//System.out.println(Arrays.toString(nums));
		return nums[nums.length-k];
    }
}
