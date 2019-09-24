package com.test;


/*
 * 在没有辅助栈的情况下，可以使用数学方法来进行反转
 * 首先计算个位数
 * pop operation:
 * pop = x % 10;
 * x /= 10;
 * 反转*10 + 个位数
 * push operation:
 * temp = rev * 10 + pop;
 * rev = temp;
 */
public class Easy_07_reverse {
	public static void main(String[] args) {
		
	}

	public static int reverse(int x) {
		int rev = 0;
		while(x != 0){
			int pop = x%10;
			x=x/10;
			// 这里需要注意是否超过int型的范围
			if(rev > Integer.MAX_VALUE/10)  return 0;
			if(rev < Integer.MIN_VALUE/10)  return 0;
			rev = rev*10 + pop;
		}
		return rev;
	}
}
