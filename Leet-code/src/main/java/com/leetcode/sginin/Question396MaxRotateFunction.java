package com.leetcode.sginin;

/**
 * @program: java-coding
 * @description: 396.旋转函数
 * @author: Mr.He
 * @create: 2022-04-22 19:53
 **/
public class Question396MaxRotateFunction {

    public static int maxRotateFunction(int[] nums) {
        int len = nums.length;
        int maxValue = Integer.MIN_VALUE;
        for (int i = 0; i < len; i++) {
            int maxNum = 0;
            int count = 0;
            for (int j = i; j < len; j++) {
                maxNum += count * nums[j];
                count++;
            }

            for (int j = 0; j < i; j++) {
                maxNum += count * nums[j];
                count++;
            }
            maxValue = Math.max(maxValue,maxNum);
        }
        return maxValue;
    }

    public static void main(String[] args) {
        System.out.println(maxRotateFunction(new int[]{4,15,14,3,14,-8,12,-9,17,-1,15,1,10,19,-7,15,8,7,-8,11}));
    }

}
