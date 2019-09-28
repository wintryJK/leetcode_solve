package com.test;

import java.util.ArrayList;
import java.util.List;

/*
 * 给定�?个只包含数字的字符串，复原它并返回所有可能的 IP 地址格式�?
 * 输入: "25525511135"
 * 输出: ["255.255.11.135", "255.255.111.35"]
 * 
 */
public class Mid_93_restoreIpAddresses {
    public static void main(String[] args) {
		String s = "25525511135";
		System.out.println(new Mid_93_restoreIpAddresses().restoreIpAddresses(s).toString());
		
	}
	public List<String> restoreIpAddresses(String s) {
        List<String> addresses = new ArrayList<String>();
        if (s == null || s.length() == 0) {
			return addresses;
		}
        StringBuilder tempAddress = new StringBuilder();
        doRestoreIpAddresses(0,tempAddress,addresses,s);
        return addresses;
    }
	private void doRestoreIpAddresses(int k, StringBuilder tempAddress, List<String> addresses, String s) {
		if (k == 4 || s.length() == 0 || s.length() > 12) {
			if (k == 4 && s.length() == 0) {
				addresses.add(tempAddress.toString());
			}
		}
		for(int i = 0; i < s.length() && i <= 2; i++) {
			// 如果端口号类�?   .0.  是可以的
			// 但是类似 .011. 不可�?
			if (i!=0 && s.charAt(0) == '0') {
				break;
			}
			String part = s.substring(0, i + 1);
			if (Integer.valueOf(part) <= 255) {
				if (tempAddress.length() != 0) {
					part = "." + part;
				}
				tempAddress.append(part);
				doRestoreIpAddresses(k + 1, tempAddress, addresses, s.substring(i + 1));
				tempAddress.delete(tempAddress.length() - part.length(), tempAddress.length());
			}
		}
	}
	
}
