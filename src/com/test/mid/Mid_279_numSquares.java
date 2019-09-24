package com.test.mid;

import java.util.ArrayList;
import java.util.List;

/*
 * ���������� n���ҵ����ɸ���ȫƽ���������� 1, 4, 9, 16, ...��ʹ�����ǵĺ͵��� n��
 * ����Ҫ����ɺ͵���ȫƽ�����ĸ������١�
 * �ϴ�ʹ�ù�����ȱ��������ʹ�ö�̬�滮
 */
public class Mid_279_numSquares {
	public static void main(String[] args) {
		System.out.println(new Mid_279_numSquares().generateSquare(12).toString());
	}
	public int numSquares(int n) {
		List<Integer> squares = new ArrayList<Integer>();
		squares = generateSquare(n);
		System.out.println(squares.toString());
		int[] dp = new int[n+1];
		for(int i = 1; i <= n; i++) {
			int min = Integer.MAX_VALUE;
			for(int square:squares) {
				if (square > n) {
					break;
				}
				// �������˼��:
				// ����12
				// ��ֳ� 12 = 1 + dp[12-1]; //���ﱾ��Ҳ�Ƕ���һ��ƽ�������Լ�1
				// ������ 12 = 4 + dp[12-4];
				// ȡ��Сֵ
				min = Math.min(min, dp[i - square] + 1);
			}
			dp[i] = min;
		}
		return dp[n];
	}
	private List<Integer> generateSquare(int n) {
		List<Integer> squares = new ArrayList<Integer>();
		int square = 1;
		int cnt = 1;
		while (square <= n) {
			squares.add(square);
			cnt++;
			square = cnt*cnt;
		}
		return squares;
	}
}
