package com.test;

import java.util.ArrayList;
import java.util.List;

/*
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 * 输入："23"
 * 输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 */
public class Mid_17_letterCombinations {
	private final String[] KEYS = {" ","","abc","def","ghi","jkl","mno","pqrs","tuv","xyz"};
	public static void main(String[] args) {
		String digits = "23";
		System.out.println(new Mid_17_letterCombinations().letterCombinations(digits).toString());
	}
    public List<String> letterCombinations(String digits) {
        List<String> combinations = new ArrayList<String>();
        if (digits == null || digits.length() == 0) {
			return combinations;
		}
        doCombinations(new StringBuilder(), combinations, digits);
        return combinations;
    }
    public void doCombinations(StringBuilder prefix,List<String> combinations,final String digits) {
    	if (prefix.length() == digits.length()) {
			combinations.add(prefix.toString());
			return;
		}
    	int curDigit = digits.charAt(prefix.length()) - '0';
    	for(char c:KEYS[curDigit].toCharArray()) {
    		prefix.append(c);
    		doCombinations(prefix, combinations, digits);
    		prefix.deleteCharAt(prefix.length() - 1);
    	}
    }
}
