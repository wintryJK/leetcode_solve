package com.test;

/*
 * ����һ���������� nums ���ҵ�һ���������͵����������飨���������ٰ���һ��Ԫ�أ������������͡�
 * ����: [-2,1,-3,4,-1,2,1,-5,4],
 * ���: 6
 * ����: ���������� [4,-1,2,1] �ĺ����Ϊ 6��
 */
public class Easy_53_maxSubArray {
	public static void main(String[] args) {
		int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
		System.out.println(maxSubArray(nums));
	}
    public static int maxSubArray(int[] nums) {
        int presum = nums[0];
        int maxsum = presum;
        for (int i = 1; i < nums.length; i++) {
			presum = presum > 0 ? presum + nums[i] : nums[i];
			maxsum = Math.max(presum, maxsum);
		}
        return maxsum;
    }
}
