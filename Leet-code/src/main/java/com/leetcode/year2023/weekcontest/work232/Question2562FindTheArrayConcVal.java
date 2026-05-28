package com.leetcode.year2023.weekcontest.work232;

/**
 * @author HQ
 * @program: java-coding
 * @description: 2562. 找出数组的串联值
 * @date 2023-02-15 22:12:44
 */
public class Question2562FindTheArrayConcVal {

    //  [5,14,13,8,12]
    public long findTheArrayConcVal(int[] nums) {
        int left = 0,right = nums.length - 1;
        long ans = 0;
        while (left < right){
            StringBuilder str = new StringBuilder();
            str.append(nums[left]);
            str.append(nums[right]);
            ans += Long.parseLong(str.toString());
        }
        if (left == right){
            ans += nums[left];
        }
        return ans;
    }

}
