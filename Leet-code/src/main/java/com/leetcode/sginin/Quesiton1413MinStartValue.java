package com.leetcode.sginin;

/**
 * @author HQ
 * @program: java-coding
 * @description: 1413. 逐步求和得到正数的最小值
 * @date 2022-08-09 22:26:39
 */
public class Quesiton1413MinStartValue {

    public static int minStartValue(int[] nums) {
        int res = Integer.MAX_VALUE;
        int minVlaue = 10000;
        for (int i = 0; i < nums.length; i++) {
            minVlaue += nums[i];
            res = Math.min(minVlaue,res);
        }
        return res >= 10001 ? 1 : (10000 - Math.abs(res)) + 1;
    }

    public static void main(String[] args) {
        System.out.println(minStartValue(new int[]{2,3,5,-5,-1}));
    }
}
