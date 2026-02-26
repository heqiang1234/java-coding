package com.leetcode.sginin;

import java.util.Arrays;

public class Question2411smallestSubarrays {

    public static int[] smallestsubarrars(int[] nums){
        int len = nums.length - 1;
        int [] res = new int[nums.length];
        for (int i = 0; i <= len; i++) {
            res[i] = maxY(nums,i,len);
        }
        return res;
    }

    public static int maxY(int [] nums,int index,int len){
        int count = 0,curMax = 0,curNum = 0;
        for (int i = index; i <= len; i++) {
            if ((curNum | nums[i]) > curMax){
                count = i - index;
                curMax = curNum | nums[i];
            }
            curNum = curNum | nums[i];
        }
        return count + 1;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(smallestsubarrars(new int[]{1, 0, 2, 1, 3})));

        System.out.println(1 | 3);
        System.out.println(1 | 11);
    }
}
