package com.test;


/*
 * ���㲢���� x ��ƽ���������� x �ǷǸ�������
 * ���ڷ������������������ֻ���������Ĳ��֣�С�����ֽ�����ȥ��
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
