package com.test;

import java.util.ArrayList;
import java.util.List;

/*
 * 分治法
 * 给定一个含有数字和运算符的字符串，为表达式添加括号，改变其运算优先级以求出不同的结果。
 * 你需要给出所有可能的组合的结果。有效的运算符号包含 +, - 以及 * 。
 * 
 * 输入: "2-1-1"
 * 输出: [0, 2]
 * 解释: 
 * ((2-1)-1) = 0 
 * (2-(1-1)) = 2
 * 
 */
public class Mid_241_diffWaysToCompute {
	public static void main(String[] args) {
		String input = "2*3-4*5";
		System.out.println(diffWaysToCompute(input).toString());
	}
    public static List<Integer> diffWaysToCompute(String input) {
        List<Integer> result = new ArrayList<Integer>();
    	if (input == null || input.length() == 0) {
			return result;
		}
    	for (int i = 0; i < input.length(); i++) {
			char c = input.charAt(i);
			if (c == '+' || c == '-' || c == '*') {
				List<Integer> left = diffWaysToCompute(input.substring(0, i));
				List<Integer> right = diffWaysToCompute(input.substring(i+1));
				for(Integer l : left) {
					for(Integer r : right) {
						switch (c) {
						case '+':
							result.add(l + r);
							break;
						case '-':
							result.add(l - r);
							break;
						case '*':
							result.add(l * r);
						default:
							break;
						}
					}
				}
			}
		}
    	if (result.size() == 0) {
			result.add(Integer.valueOf(input));
		}
    	return result;
    }
}
