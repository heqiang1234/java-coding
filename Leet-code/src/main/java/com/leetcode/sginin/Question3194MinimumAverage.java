package com.leetcode.sginin;

import java.util.Arrays;

/**
 * @AUTHOR HQ
 * @DATE 2024/10/16
 */
public class Question3194MinimumAverage {

    public static double minimumAverage(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;

        return (nums[len/2 - 1] + nums[len/2]) * 1.0 / 2;
    }

    public static void main(String[] args) {
        System.out.println(minimumAverage(new int[]{1,9,8,3,10,5}));
    }
}
