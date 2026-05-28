package com.leetcode.sginin;

/**
 * @author heqiang
 * @date 2025年11月27日16:49
 */
public class Question3391MaxSubarraySum {

    public long maxSubarraySum(int[] nums, int k) {

        int res = Integer.MIN_VALUE;
        int preRes = 0, count = 0, curRes = 0;
        // 记录下前一个符合条件的元素和，如果相加大于原先的，且大于此次的，则长度相加，
        for (int i = 0; i < nums.length; i++) {
            count++;
            curRes += nums[i];
            if (count % k == 0) {
                // res
            }
        }
        return 1l;
    }

}
