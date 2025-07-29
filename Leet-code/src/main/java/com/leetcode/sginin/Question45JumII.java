package com.leetcode.sginin;

public class Question45JumII {

    public int jump(int[] nums) {
        return dp(nums.length - 1, nums);
    }


    public int dp(int end, int[] nums) {
        if (end <= 0) {
            return 1;
        }
        int nowEnd = end;
        for (int i = end - 1; i >= 0; i--) {
            if (nums[i] + i >= end) {
                nowEnd = i;
            }
        }
        return dp(nowEnd, nums) + 1;
    }

}
