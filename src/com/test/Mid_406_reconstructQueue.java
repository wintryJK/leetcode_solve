package com.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/*
 * 假设有打乱顺序的一群人站成一个队列。 
 * 每个人由一个整数对(h, k)表示，
 * 其中h是这个人的身高，k是排在这个人前面且身高大于或等于h的人数。 
 * 编写一个算法来重建这个队列。
 */
public class Mid_406_reconstructQueue {
	public static void main(String[] args) {
		int[][] people = {{7,0},{4,4},{7,1},{5,0},{6,1},{5,2}};
		int[][] result = reconstructQueue(people);
		for (int i = 0; i < result.length; i++) {
			System.out.println(Arrays.toString(result[i]));
		}
	}
	public static int[][] reconstructQueue(int[][] people) {
        if (people == null || people.length == 0 || people[0].length == 0) {
			return new int[0][0];
		}
		//Arrays.sort(people, (o1,o2) -> o1[0] == o2[0] ? o1[1] - o2[1] : o2[0] - o1[0]);
        Arrays.sort(people,new Comparator<int[]>() {
        	@Override
        	public int compare(int[] o1, int[] o2) {
        		// TODO Auto-generated method stub
        		return o1[0] == o2[0] ? o1[1] - o2[1] : o2[0] - o1[0];
        	}
        });
        ArrayList<int[]> list = new ArrayList<int[]>();
        for(int[] a:people) {
        	list.add(a[1], a);
        }
        return list.toArray(new int[people.length][2]);
    }
}
