package com.test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


/*
 * 给定正整数 n，
 * 找到若干个完全平方数（比如 1, 4, 9, 16, ...）
 * 使得它们的和等于 n。
 * 你需要让组成和的完全平方数的个数最少。
 * 
 * 考察点是：BFS 广度优先算法
 * 注意BFS  一般都是用来求解无权图
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
