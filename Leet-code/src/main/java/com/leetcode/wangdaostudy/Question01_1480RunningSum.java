package com.leetcode.wangdaostudy;

/**
 * @author HQ
 * @program: java-coding
 * @description: 1480. 一维数组的动态和
 * @date 2022-08-09 23:02:46
 */
public class Question01_1480RunningSum {

    public int[] runningSum(int[] nums) {
        int[] res = new int[nums.length];
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            res[i] += sum;
        }
        return res;
    }
}
