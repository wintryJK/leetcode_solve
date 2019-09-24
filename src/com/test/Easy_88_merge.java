package com.test;

import java.util.Arrays;

import javax.sound.midi.Soundbank;
/*
 * 合并两个数组
 */
public class Easy_88_merge {
	public static void main(String[] args) {
		int[] a = {0};
		int[] b = {1};
		merge(a, 0, b, 1);
		System.out.println(Arrays.toString(a));
	}
	public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int index = m + n -1;
        
        int i = m - 1;
        int j = n - 1;
        while(i>=0 || j>=0) {
        	if (i<0) {
				nums1[index--] = nums2[j--];
			}
//        	else if(j<0){
//				nums1[index--] = nums1[i--];
//			}
			else if (nums1[i]<nums2[j]) {
				nums1[index--] = nums2[j--];
				//nums1[index--] = nums1[i--];
			}else {
				nums1[index--] = nums1[i--];
				//nums1[index--] = nums2[j--];
			}
        }
    }
}
