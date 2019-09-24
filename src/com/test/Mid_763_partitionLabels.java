package com.test;

import java.util.ArrayList;
import java.util.List;

/*
 * 字符串 S 由小写字母组成。
 * 我们要把这个字符串划分为尽可能多的片段，同一个字母只会出现在其中的一个片段。
 * 返回一个表示每个字符串片段的长度的列表。
 */
public class Mid_763_partitionLabels {
	public static void main(String[] args) {
		String S = "eaaaabaaec";
		System.out.println(partitionLabels(S).toString());
	}
    public static List<Integer> partitionLabels(String S) {
        char[] ch = S.toCharArray();
        int start = 0;
        int end = 0;
        List<Integer> result = new ArrayList<Integer>();
        for (int i = 0; i < ch.length; i++) {
			int next = S.indexOf(ch[i], i+1);
			if (next == -1 && i >= end) {
				result.add(i - start + 1);
				start = i + 1;
			}
			else {
				if (next > end) {
					end = next;
				}
//				else {
//					continue;
//				}
			}
		}
        return result;
    }
}
