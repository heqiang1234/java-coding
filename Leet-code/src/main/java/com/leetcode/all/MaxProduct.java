package com.leetcode.all;

import java.util.ArrayList;
import java.util.List;

/**
 * @author HQ
 * @program: demo
 * @description: 最大乘积
 * @date 2021-12-13 21:42:54
 */
public class MaxProduct {

    public static int maxProduct(int[] nums) {

        if (nums.length == 0) {
            return 0;
        }

        int maxValue = nums[0];
        int maxValueFu = nums[0];

        List<Integer> list = new ArrayList<>();

        for (int i = 1; i < nums.length; i++) {
            int temp = maxValue;
            maxValue = Math.max(maxValue, temp * nums[i]);
            maxValueFu = maxValueFu * nums[i];
            maxValue = Math.max(maxValue,maxValueFu);
//            if (nums[i] == 0 && i <= nums.length - 1) {
//                maxValue = nums[i+1];
//            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] nums = {2,3,-2,4,-2,5,0,2};
        maxProduct(nums);
    }
}
