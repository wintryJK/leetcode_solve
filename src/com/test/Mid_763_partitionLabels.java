package com.test;

import java.util.ArrayList;
import java.util.List;

/*
 * �ַ��� S ��Сд��ĸ��ɡ�
 * ����Ҫ������ַ�������Ϊ�����ܶ��Ƭ�Σ�ͬһ����ĸֻ����������е�һ��Ƭ�Ρ�
 * ����һ����ʾÿ���ַ���Ƭ�εĳ��ȵ��б�
 */
public class Mid_763_partitionLabels {
	public static void main(String[] args) {
		String S = "eaaaabaaec";
		System.out.println(partitionLabels(S).toString());
	}
    public static List<Integer> partitionLabels(String S) {
        char[] ch = S.toCharArray();
        int start = 0;
        int end = 0;
        List<Integer> result = new ArrayList<Integer>();
        for (int i = 0; i < ch.length; i++) {
			int next = S.indexOf(ch[i], i+1);
			if (next == -1 && i >= end) {
				result.add(i - start + 1);
				start = i + 1;
			}
			else {
				if (next > end) {
					end = next;
				}
//				else {
//					continue;
//				}
			}
		}
        return result;
    }
}
