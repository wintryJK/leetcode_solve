package com.test;

import java.util.Arrays;

/*
 * 假设你是�?位很棒的家长，想要给你的孩子们一些小饼干�?
 * 但是，每个孩子最多只能给�?块饼干�?�对每个孩子 i ，都有一个胃口�?� gi �?
 * 这是能让孩子们满足胃口的饼干的最小尺寸；并且每块饼干 j �?
 * 都有�?个尺�? sj 。如�? sj >= gi ，我们可以将这个饼干 j 分配给孩�? i �?
 * 这个孩子会得到满足�?�你的目标是尽可能满足越多数量的孩子，并输出这个�?大数值�??
 * 
 * 这道题的本质是�?�察贪心算法
 * 给一个孩子的饼干应当尽量小又能满足该孩子，这样大饼干就能拿来给满足度比较大的孩子�?
 * 因为�?小的孩子�?容易得到满足，所以先满足�?小的孩子�?
 */
public class Easy_455_findContentChildren {
	public static void main(String[] args) {
		int[] g = {1,2};
		int[] s = {1,2,3};
		System.out.println(findContentChildren(g, s));
	}
	public static int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int gi = 0;
        int si = 0;
        while(gi < g.length && si < s.length) {
        	if (g[gi] <= s[si]) {
				gi++;
			}
        	si++;
        }
        return gi;
    }
}
