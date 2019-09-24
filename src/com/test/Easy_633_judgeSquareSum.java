package com.test;
/*
 * ����һ���Ǹ����� c ����Ҫ�ж��Ƿ������������ a �� b��ʹ�� a2 + b2 = c��
 * ����: 5
 * ���: True
 * ����: 1 * 1 + 2 * 2 = 5
 */
public class Easy_633_judgeSquareSum {
	public static void main(String[] args) {
		int a = 2;
		System.out.println((int)Math.sqrt(2));
		System.out.println(judgeSquareSum(a));
	}
	public static boolean judgeSquareSum(int c) {
		boolean flag = false;
		// ע��������Ҫ i<=j  ��������2 = 1*1 + 1*1 Ҳ�ǿ��Ե�
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
