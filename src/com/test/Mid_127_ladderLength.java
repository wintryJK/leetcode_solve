package com.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
 * 给定两个单词（beginWord 和 endWord）和一个字典，
 * 找到从 beginWord 到 endWord 的最短转换序列的长度。
 * 转换需遵循如下规则：
 * 每次转换只能改变一个字母。
 * 转换过程中的中间单词必须是字典中的单词。
 * 说明:
 * 如果不存在这样的转换序列，返回 0。
 * 所有单词具有相同的长度。
 * 所有单词只由小写字母组成。
 * 字典中不存在重复的单词。
 * 你可以假设 beginWord 和 endWord 是非空的，且二者不相同。
 * 输入:
 * beginWord = "hit",
 * endWord = "cog",
 * wordList = ["hot","dot","dog","lot","log","cog"]
 * 输出: 5
 * 解释: 一个最短转换序列是 "hit" -> "hot" -> "dot" -> "dog" -> "cog",
 * 返回它的长度 5。
 */
public class Mid_127_ladderLength {
	public static void main(String[] args) {
		List<String> wordList = new LinkedList<String>(
				Arrays.asList("hot","dot","dog","lot","log","cog"));
		String beginWord = "hit";
		String endWord = "cog";
		System.out.println(ladderLength(beginWord, endWord, wordList));
	}
	public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
		wordList.add(beginWord);
		int N = wordList.size();
		int start = N - 1;
		int end = 0;
		while (end < N && !wordList.get(end).equals(endWord)) {
			end++;
		}
		if (end == N) {
			return 0;
		}
		List<Integer>[] graphic = buildGraphic(wordList);
		return minPathLength(graphic, start, end);
    }
	public static List<Integer>[] buildGraphic(List<String> wordList) {
		int N = wordList.size();
		List<Integer>[] graphic = new List[N];
		for (int i = 0; i < N; i++) {
			graphic[i] = new ArrayList<Integer>();
			for (int j = 0; j < N; j++) {
				if (isConnect(wordList.get(i),wordList.get(j))) {
					graphic[i].add(j);
				}
			}
		}
		return graphic;
	}
	public static boolean isConnect(String a,String b) {
		int diff = 0;
		for (int i = 0; i < a.length(); i++) {
			if (a.charAt(i) != b.charAt(i)) {
				diff++;
			}
		}
		return diff == 1;
	}
	public static int minPathLength(List<Integer>[] graphic,int start,int end) {
		Queue<Integer> queue = new LinkedList<Integer>();
		boolean[] marked = new boolean[graphic.length];
		queue.add(start);
		marked[start] = true;
		int path = 1;
		while (!queue.isEmpty()) {
			int size = queue.size();
			path++;
			while (size-- > 0) {
				int cur = queue.poll();
				for (int i = 0; i < graphic[cur].size(); i++) {
					int next = graphic[cur].get(i);
					if (next == end) {
						return path;
					}
					if (marked[next] == true) {
						continue;
					}
					marked[next] = true;
					queue.add(next);
				}
			}
		}
		return 0;
	}
}
