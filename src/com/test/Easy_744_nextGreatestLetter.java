package com.test;

/*
 * 二分查找法
 * 
 * 给定一个只包含小写字母的有序数组letters 和一个目标字母 target，
 * 寻找有序数组里面比目标字母大的最小字母。
 * 数组里字母的顺序是循环的。举个例子，如果目标字母target = 'z' 
 * 并且有序数组为 letters = ['a', 'b']，则答案返回 'a'。
 * 
 *    输入:
 * letters = ["c", "f", "j"]
 * target = "a"
 *    输出: "c"
 *    
 * 输入:
 * letters = ["c", "f", "j"]
 * target = "d"
 * 输出: "f"
 */
public class Easy_744_nextGreatestLetter {
	public static void main(String[] args) {
		char[] letters = { 'c','f','j' };
		char target = 'g';
		System.out.println(nextGreatestLetter(letters, target));
	}
    public static char nextGreatestLetter(char[] letters, char target) {
        int length = letters.length;
        int left = 0;
        int right = length - 1;
        while (left < right) {
			int mid = left + (right - left)/2;
			if (letters[mid] <= target) {
				left = mid + 1;
			}else {
				right = mid;
			}
			
		}
        if (left == length - 1 && letters[length - 1] <= target) {
			return letters[0];
		}
        return letters[left];
    }
}
