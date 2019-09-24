package com.test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/*
 * ����һ���ǿյ��������飬�������г���Ƶ��ǰ k �ߵ�Ԫ�ء�
 * ����: nums = [1,1,1,2,2,3], k = 2
 * ���: [1,2]
 * ����Լ�������� k ���Ǻ���ģ��� 1 �� k �� �����в���ͬ��Ԫ�صĸ�����
 * ����㷨��ʱ�临�Ӷȱ������� O(n log n) , n ������Ĵ�С��
 */
public class Mid_347_topKFrequent {
	public static void main(String[] args) {
		int[] nums = { 4,1,-1,2,-1,2,3 };
		System.out.println(topKFrequent(nums, 2).toString());
	}
	public static List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int num:nums) {
        	if (map.containsKey(num)) {
				map.put(num, map.get(num) + 1);
			}else {
				map.put(num, 1);
			}
        }
        // ע��Ҫ�Լ���дComparator����
//        PriorityQueue<Integer> topK = new PriorityQueue<Integer>(new Comparator<Integer>() {
//        	@Override
//        	public int compare(Integer o1, Integer o2) {
//        		// TODO Auto-generated method stub
//        		return map.get(o1) - map.get(o2);
//        	}
//		});
        PriorityQueue<Integer> topK = new PriorityQueue<Integer>();
        for(Integer key:map.keySet()) {
        	
        	if (topK.size()<k) {
				topK.add(key);
			}else if(map.get(key) > map.get(topK.peek())){
				topK.poll();
				topK.add(key);
			}
        	System.out.println("map.get(key)--->"+map.get(key));
        	System.out.println("topK.peek()--->"+topK.peek());
        	System.out.println("map.get(topK.peek())"+map.get(topK.peek()));
        	System.out.println("--------------------");
        }
        List<Integer> result = new ArrayList<Integer>();
        for(int i = 0; i < k ; i++) {
        	result.add(topK.poll());
        }
        return result;
    }
}
