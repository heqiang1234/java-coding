package com.leetcode.face150;

public class Question55Jump {

    public boolean canJump(int[] nums) {

        return dp(nums.length,nums.length - 1,nums);
    }

    public boolean dp(int len,int index,int [] nums){
        int end = nums.length - 1;
        for (int i = end - 1; i >= 0 ; i--) {
            if (nums[i] + i >= end){
                end = i;
            }
        }
        return end == 0;

    }

}
