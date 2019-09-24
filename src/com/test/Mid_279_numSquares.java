package com.test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


/*
 * ���������� n��
 * �ҵ����ɸ���ȫƽ���������� 1, 4, 9, 16, ...��
 * ʹ�����ǵĺ͵��� n��
 * ����Ҫ����ɺ͵���ȫƽ�����ĸ������١�
 * 
 * ������ǣ�BFS ��������㷨
 * ע��BFS  һ�㶼�����������Ȩͼ
 */
public class Mid_279_numSquares {
	public static void main(String[] args) {
		int n = 12;
		System.out.println(numSquares(n));
	}
	public static int numSquares(int n) {
		List<Integer> squares = generateSquares(n);
		//System.out.println(squares.toString());
        Queue<Integer> queue = new LinkedList<Integer>();
        boolean[] marked = new boolean[n+1];
        queue.add(n);
        marked[n] = true;
        int level = 0;
        while (!queue.isEmpty()) {
        	int size = queue.size();
			//Integer cur = queue.poll();
			level++;
			while (size-- > 0) {
				Integer cur = queue.poll();
				for (int i = 0; i < squares.size(); i++) {
					Integer next = cur - squares.get(i);
					if (next < 0) {
						continue;
					}
					if (next == 0) {
						return level;
					}
					if (marked[next] == true) {
						continue;
					}
					marked[next] = true;
					queue.add(next);
				}
			}
			
		}
        return n;
    }
	public static List<Integer> generateSquares(int n) {
		List<Integer> squares = new ArrayList<Integer>();
		int square = 1;
		int index = 1;
		while (square <= n) {
			squares.add(square);
			index++;
			square = index * index;
		}
		return squares;
	}
}
