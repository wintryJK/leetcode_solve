package com.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

/*
 * 在未排序的数组中找到第 k 个最大的元素。
 * 请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 * 输入: [3,2,1,5,6,4] 和 k = 2
 * 输出：5
 */
public class Mid_215_findKthLargest {
	public static void main(String[] args) {
		int[] nums = {8,2,9,6,5,3,7};
		int a = findKthLargest(nums, 3);
		
		System.out.println(a);
	}
	public static int findKthLargest(int[] nums, int k) {
		/*
		 * 方法一 :
		 * 直接使用API来完成数组的排序，得到倒数第k个元素就可以
		 */
		//Arrays.sort(nums);
		//return nums[nums.length-k];
		
		/*
		 * 方法二：
		 * 通过优先队列实现的小顶堆来实现
		 * 大顶堆：节点比子节点都大
		 * 小顶堆：节点比子节点都小
		 * PriorityQueue 是用二叉树小顶堆实现
		 * 优先队列的作用是能保证每次取出的元素都是队列中权值最小的
		 * （Java的优先队列每次取最小元素，C++的优先队列每次取最大元素）。
		 * 这里牵涉到了大小关系，元素大小的评判可以通过元素本身的自然顺序（natural ordering）
		 * 也可以通过构造时传入的比较器（Comparator，类似于C++的仿函数）。
		 * Java中PriorityQueue实现了Queue接口，不允许放入null元素；
		 * 其通过堆实现，具体说是通过完全二叉树（complete binary tree）
		 * 实现的小顶堆（任意一个非叶子节点的权值，都不大于其左右子节点的权值），
		 * 也就意味着可以通过数组来作为PriorityQueue的底层实现。
		 * 
		 * 
		 * 这里PriorityQueue 默认 的构造器是实现的小顶堆
		 * 每次size大于k  弹出队列 的顶部，也就是最小的元素
		 * 
		 * 如果自己实现比较器，实现的大顶堆
		 * 每次size大于k  弹出队列的顶部，也就是最大的元素
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
