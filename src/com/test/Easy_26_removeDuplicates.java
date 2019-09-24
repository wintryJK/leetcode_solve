package com.test;

public class Easy_26_removeDuplicates {
	public static void main(String[] args) {
		int[] nums1 = { 1,1,2 };
		int[] nums2 = { 0,0,1,1,2,2,3,3,4 };
//		for (int i = 0; i < removeDuplicates(nums1); i++) {
//			System.out.println(nums1[i]);
//		}
		int length = removeDuplicates(nums2);
		for (int i = 0; i < length; i++) {
			System.out.println(nums2[i]);
		}
	}
	public static int removeDuplicates(int[] nums) {
        int slow = 0;
        int fast = 0;
        int length = nums.length;
        while(fast < length - 1){
            
            if(nums[fast] == nums[fast + 1]){
                fast++;
                continue;
            }
            fast++;
            slow++;
            nums[slow] = nums[fast];
        }
        return slow + 1;
    }
}
