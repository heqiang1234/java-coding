package com.leetcode.all;

/**
 * @program: demo
 * @description: 540. 有序数组中的单一元素
 * @author: Mr.He
 * @create: 2022-02-14 09:46
 **/
public class Question540SingleNonDuplicate {

    public static int singleNonDuplicate(int[] nums) {
        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            res = nums[i] ^ res;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,1,2,3,3,4,4,8,8};
        System.out.println(singleNonDuplicate(nums));
    }

}
