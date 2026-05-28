package com.leetcode.sginin;

import java.util.Arrays;

/**
 * @author HQ
 * @program: java-coding
 * @description: 1464. 数组中两元素的最大乘积
 * @date 2022-08-26 20:45:16
 */
public class Question1464MaxProduct {

    public int maxProduct(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length - 1;
        return (nums[len - 1] - 1) * (nums[len] - 1);
    }

    public int maxProduct1(int[] nums) {
        int len = nums.length - 1;
        int max = -1, second = -1;
        for (int i = 0; i < len; i++) {
            int num = nums[i];
            if (num > max){
                second = max;
                max = num;
            } else if (num > second){
                second = num;
            }
        }
        return (max - 1) * (second - 1);
    }
}
