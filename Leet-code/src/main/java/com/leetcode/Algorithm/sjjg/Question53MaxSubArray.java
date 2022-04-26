package com.leetcode.Algorithm.sjjg;

/**
 * @author: Mr.He
 * @create: 2022-04-24 17:20
 * @description: 53.最大数组和
 **/
public class Question53MaxSubArray {

    //-2,1,-3,4,-1,2,1,-5,4
    public static int maxSubArray(int[] nums){
        int maxValue = 0;
        int pre = 0;
        for (int i = 0; i < nums.length; i++) {
            pre = Math.max(pre + nums[i],nums[i]);
            maxValue = Math.max(maxValue,pre);
        }
        return maxValue;
    }

    public static void main(String[] args) {
        maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4});
    }
}
