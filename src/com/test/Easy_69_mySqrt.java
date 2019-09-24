package com.test;


/*
 * 计算并返回 x 的平方根，其中 x 是非负整数。
 * 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
 */
public class Easy_69_mySqrt {
	public static void main(String[] args) {
		System.out.println(mySqrt(Integer.MAX_VALUE));
	}
	public static int mySqrt(int x) {
        if (x <= 1) {
			return x;
		}
		long left = 0;
        long right = x/2;
        while(left < right) {
        	long mid = left + (right - left + 1)/2;
        	long square = mid*mid;
        	if (square == x) {
				return (int)square;
			}else if (square > x) {
				right = mid - 1;
			}else {
				left = mid;
			}
        }
        return (int)left;
    }
}
