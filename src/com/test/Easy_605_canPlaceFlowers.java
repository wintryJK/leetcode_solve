package com.test;

/*
 * 假设你有�?个很长的花坛，一部分地块种植了花，另�?部分却没有�??
 * 可是，花卉不能种植在相邻的地块上，它们会争夺水源，两者都会死去�??
 * 
 * 给定�?个花坛（表示为一个数组包�?0�?1，其�?0表示没种植花�?1表示种植了花），
 * 和一个数 n 。能否在不打破种植规则的情况下种入 n 朵花�?
 * 能则返回True，不能则返回False�?

 */
public class Easy_605_canPlaceFlowers {
	public static void main(String[] args) {
		int[] flowerbed = {1,0,0,0,1};
		System.out.println(canPlaceFlowers(flowerbed, 2));
	}
    public static boolean canPlaceFlowers(int[] flowerbed, int n) {
        if (flowerbed.length == 0) {
			return false;
		}
        int cnt = 0;
        for (int i = 0; i < flowerbed.length; i++) {
        	if (flowerbed[i] == 1) {
				continue;
			}
			int pre = i == 0 ? 0 : flowerbed[i-1];
			int next = i == flowerbed.length - 1 ? 0 : flowerbed[i+1];
        	if (pre == 0 && next == 0) {
				cnt++;
				flowerbed[i] = 1;
			}
		}
        return cnt>=n;
    }
}
