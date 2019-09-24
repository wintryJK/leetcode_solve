package com.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Easy_524_findLongestWord {
	public static void main(String[] args) {
		String string = "abpcplea";
		List<String> list = new ArrayList<String>(Arrays.asList("ale","apple","monkey","plea"));
		//int a = string.compareTo("acd");
		System.out.println(findLongestWord(string, list));
	}
	public static String findLongestWord(String s, List<String> d) {
		String longestWord = "";
		for(String target:d) {
			int l1 = longestWord.length();
			int l2 = target.length();
			if (l2<l1 || (l1==l2 && longestWord.compareTo(target)<0)) {
				continue;
			}
			if (isSubStr(s, target)) {
				longestWord = target;
			}
		}
		return longestWord;
        
    }
	public static boolean isSubStr(String s,String target) {
		int i = 0,j = 0;
		while(i<s.length() && j<target.length()) {
			if (s.charAt(i) == target.charAt(j)) {
				i++;
				j++;
			}else {
				i++;
			}
		}
		if (j==target.length()) {
			return true;
		}else {
			return false;
		}
	}
}
