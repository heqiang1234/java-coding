package com.leetcode.hotinterview;

/**
 * @program: demo
 * @description: 55. 跳跃游戏
 * @author: Mr.He
 * @create: 2022-01-24 21:24
 **/
public class Question55CanJump {

    public static boolean flag;

    public static boolean canJump(int[] nums) {
        flag = false;
        dfsJump(nums,0,nums.length -1,0);
        return flag;
    }

    public static void dfsJump(int[] nums, int len, int maxlen,int count) {

        if (len == maxlen) {
            flag = true;
            return;
        }
        if (len > maxlen) {
            return ;
        }
        if (count  > maxlen){
            return ;
        }
        count++;
        //剪枝，
        if (nums[len] == 0){
            return ;
        }
        for (int i = 1; i <= nums[len]; i++) {
            int temp = i + len;
            dfsJump(nums, temp, maxlen,count);
        }
    }

    public static void main(String[] args) {
        int[] nums = {3,2,1,0,4};
        System.out.println(canJump(nums));
    }

}
