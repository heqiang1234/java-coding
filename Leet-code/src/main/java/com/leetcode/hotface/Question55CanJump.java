package com.leetcode.hotface;

/**
 * @author HQ
 * @program: java-coding
 * @description: 55.跳跃游戏
 * @date 2022-09-15 22:36:13
 */
public class Question55CanJump {

    //我真的会动态规划
    //不断的从后面往前逼近，如果能到达，则将end移动到该位置
    public boolean canJump(int[] nums) {
        int end = nums.length - 1;
        for (int i = nums.length - 2; i >= 0 ; i--) {
            //判断该位置的移动的值，加上此时的坐标  是否大于等于最后的位置，如果true，则改变end位置
            if (nums[i] + i >= end){
                end = i;
            }
        }
        //如果最后end位置能到0，则说明可以
        return end == 0;
    }

}
