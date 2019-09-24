package com.test;

/*
 * �����ַ��� s �� t ���ж� s �Ƿ�Ϊ t �������С�
 * �������Ϊ s �� t �н�����Ӣ��Сд��ĸ��
 * �ַ��� t ���ܻ�ܳ������� ~= 500,000������ s �Ǹ����ַ��������� <=100����
 * �ַ�����һ����������ԭʼ�ַ���ɾ��һЩ��Ҳ���Բ�ɾ�����ַ������ı�ʣ���ַ����λ���γɵ����ַ�����
 * �����磬"ace"��"abcde"��һ�������У���"aec"���ǣ���
 */

public class Easy_392_isSubsequence {
	public static void main(String[] args) {
		String s = "abc";
		String t = "ahgbd";
		System.out.println(isSubsequence(s, t));
	}
    public static boolean isSubsequence(String s, String t) {
        int sCurr = 0;
        int tCurr = 0;
        while(sCurr < s.length() && tCurr < t.length()) {
        	if (s.charAt(sCurr) == t.charAt(tCurr)) {
				sCurr++;
				tCurr++;
			}else {
				tCurr++;
			}
        }
        return sCurr == s.length();
    }
}
