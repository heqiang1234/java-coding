package com.leetcode.jianzhioffer;

/**
 * @author HQ
 * @create 2021/11/29 22:14
 *
 * @desc 剑指 Offer 42. 连续子数组的最大和
 */
public class Question42MaxSubArray {

    public static int maxSubArray(int[] nums) {

        if (nums.length == 0) {
            return 0;
        }

        int pre = 0;
        int maxNum = nums[0];

        for (int i = 0; i < nums.length; i++) {
            pre = Math.max(pre + nums[i], nums[i]);
            maxNum = Math.max(maxNum, pre);
        }
        return maxNum;
    }

    public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(nums));
    }
}
