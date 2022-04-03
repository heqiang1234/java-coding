package com.leetcode.hotinterview;

/**
 * @program: demo
 * @description: 136. 只出现一次的数字
 * @author: Mr.He
 * @create: 2022-01-16 22:31
 **/
public class Question136SingleNumber {

    public static int singleNumber(int[] nums) {
        int ans = nums[0];
        for (int i = 1; i < nums.length; i++) {
            ans ^= nums[i];
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] res = {4,1,2,1,2};
        System.out.println(singleNumber(res));
    }

}
