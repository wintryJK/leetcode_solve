package com.test;


/*
 * ��û�и���ջ������£�����ʹ����ѧ���������з�ת
 * ���ȼ����λ��
 * pop operation:
 * pop = x % 10;
 * x /= 10;
 * ��ת*10 + ��λ��
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
			// ������Ҫע���Ƿ񳬹�int�͵ķ�Χ
			if(rev > Integer.MAX_VALUE/10)  return 0;
			if(rev < Integer.MIN_VALUE/10)  return 0;
			rev = rev*10 + pop;
		}
		return rev;
	}
}
