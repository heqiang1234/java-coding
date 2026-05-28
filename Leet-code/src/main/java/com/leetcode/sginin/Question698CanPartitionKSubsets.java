package com.leetcode.sginin;

/**
 * @author: Mr.He
 * @create: 2022-09-20 16:50
 * @description: 698. 划分为k个相等的子集
 **/
public class Question698CanPartitionKSubsets {

    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0, maxValue = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            maxValue = Math.max(maxValue, nums[i]);
        }
        if (maxValue > (sum * 1.0 / k * 1.0) || (sum * 1.0 / k * 1.0) % 1 != 0) {
            return false;
        }


        return true;
    }

}
