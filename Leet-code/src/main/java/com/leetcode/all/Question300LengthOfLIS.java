package com.leetcode.all;

import java.util.Arrays;

/**
 * @program: demo
 * @description: 300. 最长递增子序列
 * @author: Mr.He
 * @create: 2022-01-12 18:52
 **/
public class Question300LengthOfLIS {

    public static int lengthOfLIS(int[] nums){

        int[] res = new int[nums.length];
        Arrays.fill(res,Integer.MAX_VALUE);
        int first = nums[0];
        int next = Integer.MAX_VALUE;
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            int n = nums[i];
            if (n > next){

            }
            if (n > first){
                next = n;
                count ++;
            } else {
                first = n;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = {10,9,2,5,3,7,101,18};
        System.out.println(lengthOfLIS(nums));
    }


}
