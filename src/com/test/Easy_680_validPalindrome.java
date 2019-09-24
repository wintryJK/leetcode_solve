package com.test;

import java.net.Inet4Address;

/*
 * 给定一个非空字符串 s，最多删除一个字符。判断是否能成为回文字符串。
 * 输入: "aba"
 * 输出: True
 * 输入: "abca"
 * 输出: True
 * 解释: 你可以删除c字符。
 */
public class Easy_680_validPalindrome {
	public static void main(String[] args) {
		String string = "abc";
		System.out.println(validPalindrome(string));
	}
	public static boolean validPalindrome(String s) {
        int i = 0,j=s.length()-1;
        
        while (i<j) {
			if (s.charAt(i)!=s.charAt(j)) {
				return isPalindrome(s, i+1, j) || isPalindrome(s, i, j-1);
			}else {
				i++;
				j--;
			}
		}
        return true;
    }
	public static boolean isPalindrome(String s,int i,int j) {
		while(i<j) {
			if (s.charAt(i) != s.charAt(j)) {
				return false;
			}else {
				i++;
				j--;
			}
		}
		return true;
	}
}
