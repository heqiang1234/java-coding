package com.leetcode.Algorithm.ListNode;

/**
 * @program: java-coding
 * @description: s
 * @author: Mr.He
 * @create: 2022-04-14 15:51
 **/
public class sss {

    public static void main(String[] args) {
        System.out.println(findUnsortedSubarray(new int[]{2, 6, 4, 8, 10, 9, 15}));
        System.out.println(findUnsortedSubarray(new int[]{1, 2, 3, 4}));
        System.out.println(findUnsortedSubarray(new int[]{1}));
    }

    public static int findUnsortedSubarray(int[] nums) {
        int minNum = 0, maxNum = 0;
        boolean flag = false;
        for (int i = 0; i < nums.length; ++i) {
            if (!flag) {
                if (nums[i] < nums[i - 1]) {
                    minNum = nums[i];
                    flag = true;
                }
            } else {
                minNum = Math.min(minNum, nums[i]);
            }
        }
        if (!flag) return 0;
        flag = false;
        for (int i = nums.length - 2; i >= 0; --i) {
            if (!flag) {
                if (nums[i] > nums[i + 1]) {
                    maxNum = nums[i];
                    flag = true;
                } else {
                    maxNum = Math.max(maxNum, nums[i]);
                }
            }
            int lo = 0, hi = 0;
            for (int j = 0; j < nums.length; ++j) {
                if (nums[i] > minNum) {
                    lo = i;
                    break;
                }
            }
            for (int j = nums.length - 1; j >= 0; --j) {
                if (nums[i] < maxNum) {
                    hi = i;
                    break;
                }
            }
            return hi - lo + 1;
        }
        return 0;
    }
}
