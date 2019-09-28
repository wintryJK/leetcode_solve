package com.test;

/*
 * 给定�?个字符串 S 和一个字符串 T，计算在 S 的子序列�? T 出现的个数�??
 * �?个字符串的一个子序列是指，�?�过删除�?些（也可以不删除）字�?
 * 且不干扰剩余字符相对位置�?组成的新字符串�?�（例如�?"ACE" 是�?"ABCDE" 的一个子序列，�?��?"AEC" 不是�?
 */
public class Trouble_115_numDistinct {
	public static void main(String[] args) {
		String t = "rabbit";
		String s = "rabbbit";
		System.out.println(numDistinct(s, t));
	}
    public static int numDistinct(String s, String t) {
        int cnt = 0;
        StringBuilder sbs = new StringBuilder(s);
        StringBuilder sbt = new StringBuilder(t);
        if (isSubStr(sbs, sbt)) {
			cnt = 1;
		}
        for(int i = 0 ; i < sbs.length() ; i++) {
        	sbs = new StringBuilder(s);
            //sbt = new StringBuilder(t);
        	sbs.deleteCharAt(i);
        	if (isSubStr(sbs, sbt)) {
				cnt++;
			}
        }
        return cnt;
    }
    public static boolean isSubStr(StringBuilder s, StringBuilder t) {
		int index = -1;
		for (int i = 0 ; i < t.length() ; i++) {
			index = s.toString().indexOf(t.toString().charAt(i), index + 1);
			if (index == -1) {
				return false;
			}
		}
		return true;
	}
}
