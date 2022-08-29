package com.leetcode.sginin;

/**
 * @author HQ
 * @program: java-coding
 * @description: 1470. 重新排列数组
 * @date 2022-08-29 21:17:55
 */
public class Question1470Shuffle {

    public static int[] shuffle(int[] nums, int n) {
        int len = nums.length;
        int [] res = new int[len];
        int a = nums[0],b = nums[1];
        for (int i = 0; i < n; i++) {
            a = nums[i + 1];
            b = nums[i + 2];

        }
        return nums;
    }

    public static void main(String[] args) {
        shuffle(new int[]{2,5,1,3,4,7}, 3);
    }

}
