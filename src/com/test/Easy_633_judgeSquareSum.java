package com.test;
/*
 * 给定一个非负整数 c ，你要判断是否存在两个整数 a 和 b，使得 a2 + b2 = c。
 * 输入: 5
 * 输出: True
 * 解释: 1 * 1 + 2 * 2 = 5
 */
public class Easy_633_judgeSquareSum {
	public static void main(String[] args) {
		int a = 2;
		System.out.println((int)Math.sqrt(2));
		System.out.println(judgeSquareSum(a));
	}
	public static boolean judgeSquareSum(int c) {
		boolean flag = false;
		// 注意这里需要 i<=j  比如输入2 = 1*1 + 1*1 也是可以的
		for(int i=0,j=(int)Math.sqrt(c);i<=j;) {
			int temp = i*i + j*j;
			if (temp > c) {
				j--;
			}else if (temp < c) {
				i++;
			}else {
				flag = true;
				break;
			}
		}
		
		return flag;
	}
}
