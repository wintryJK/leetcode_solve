package com.test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
/*
 * 编写一个函数，以字符串作为输入，反转该字符串中的元音字母。
 * 输入: "hello"
 * 输出: "holle"
 */
public class Easy_345_reverseVowels {
	public static void main(String[] args) {
		String string = "leetcode";
		System.out.println(reverseVowels(string));
	}
	public static String reverseVowels(String s) {
		Set<Character> vowels = new HashSet<Character>(
				Arrays.asList('a','e','i','o','u','A','E','I','O','U'));
		int i=0,j=s.length()-1;
		char[] result = new char[s.length()];
		while(i<=j) {
			if (vowels.contains(s.charAt(i)) && vowels.contains(s.charAt(j))) {
				result[i] = s.charAt(j);
				result[j] = s.charAt(i);
				i++;
				j--;
			}else if(vowels.contains(s.charAt(i))){
				//result[i] = s.charAt(i);
				result[j] = s.charAt(j);
				//i++;
				j--;
			}else if(vowels.contains(s.charAt(j))){
				result[i] = s.charAt(i);
				i++;
			}else {
				result[i] = s.charAt(i);
				result[j] = s.charAt(j);
				i++;
				j--;
			}
		}
		return new String(result);
	}
}
