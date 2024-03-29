package com.test;

/*
 * 给定字符串 s 和 t ，判断 s 是否为 t 的子序列。
 * 你可以认为 s 和 t 中仅包含英文小写字母。
 * 字符串 t 可能会很长（长度 ~= 500,000），而 s 是个短字符串（长度 <=100）。
 * 字符串的一个子序列是原始字符串删除一些（也可以不删除）字符而不改变剩余字符相对位置形成的新字符串。
 * （例如，"ace"是"abcde"的一个子序列，而"aec"不是）。
 */

public class Easy_392_isSubsequence {
	public static void main(String[] args) {
		String s = "abc";
		String t = "ahgbd";
		System.out.println(isSubsequence(s, t));
	}
    public static boolean isSubsequence(String s, String t) {
        int sCurr = 0;
        int tCurr = 0;
        while(sCurr < s.length() && tCurr < t.length()) {
        	if (s.charAt(sCurr) == t.charAt(tCurr)) {
				sCurr++;
				tCurr++;
			}else {
				tCurr++;
			}
        }
        return sCurr == s.length();
    }
}
