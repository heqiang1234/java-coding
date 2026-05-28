package com.leetcode.sginin;

/**
 * @author heqiang
 * @date 2025年12月03日10:35
 */
public class Question3512MinOperations {

    public static int minOperations(int[] nums, int k) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            res += nums[i];
        }

        return (res - ((res / k) * k));
    }

    public static void main(String[] args) {
        System.out.println(minOperations(new int[]{3, 9, 7}, 5));
    }

}
