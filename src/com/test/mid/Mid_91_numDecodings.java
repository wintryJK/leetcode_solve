package com.test.mid;

import javax.xml.transform.Templates;

/*
 * 一条包含字母 A-Z 的消息通过以下方式进行了编码：

'A' -> 1
'B' -> 2
...
'Z' -> 26
给定一个只包含数字的非空字符串，请计算解码方法的总数。

示例 1:

输入: "12"
输出: 2
解释: 它可以解码为 "AB"（1 2）或者 "L"（12）。
示例 2:

输入: "226"
输出: 3
解释: 它可以解码为 "BZ" (2 26), "VF" (22 6), 或者 "BBF" (2 2 6) 。
 */
public class Mid_91_numDecodings {
	public static void main(String[] args) {
		String s = "10";
		System.out.println(new Mid_91_numDecodings().numDecodings(s));
	}
	public int numDecodings(String s) {
		if (s == null || s.length() == 0 || s.charAt(0) == '0') {
			return 0;
		}
		int n = s.length();
		int[] dp = new int[n];
		dp[0] = 1;
		for(int i = 1; i < n; i++) {
			if (s.charAt(i) == '0') {
				if (s.charAt(i-1) == '1' || s.charAt(i-1) == '2') {
					if (i == 1) {
						dp[i] = 1;
					}else {
						dp[i] = dp[i-2];
					}
				}else {
					return 0;
				}
			}else {
				if(s.charAt(i - 1) == '1'||s.charAt(i-1) == '2' && s.charAt(i) >= '1' && s.charAt(i) <= '6'){
					if (i == 1) {
						dp[i] = dp[i-1] + 1;
					}else {
						dp[i] = dp[i-1] + dp[i-2];
					}					
				}else {
					dp[i] = dp[i-1];
				}
			}
		}
		return dp[n-1];
	}
//	public int numDecodings(String s) {
//		if (s.charAt(0) == '0') {
//			return 0;
//		}
//		int pre = 1;
//		int cur = 1;
//		for(int i = 1; i < s.length(); i++) {
//			int tmp = cur;
//			if (s.charAt(i) == '0') {
//				if (s.charAt(i-1) == '1' || s.charAt(i-1) == '2') {
//					cur = pre;
//				}else {
//					return 0;
//				}
//			}else if(s.charAt(i-1) == '1' || (s.charAt(i-1) == '2' && s.charAt(i) >= '1' && s.charAt(i) <= '6')){
//				cur += pre;
//			}
//			pre = tmp;
//		}
//		return cur;
//	}
}
