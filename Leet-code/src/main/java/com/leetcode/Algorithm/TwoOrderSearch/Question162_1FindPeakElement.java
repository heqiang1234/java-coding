package com.leetcode.Algorithm.TwoOrderSearch;

/**
 * @author HQ
 * @program: java-coding
 * @description: 126.寻找峰值
 * @date 2022-07-03 23:10:15
 */
public class Question162_1FindPeakElement {

    //二分

    //因为规定了最右侧的部分为-无穷
    public static int findPeakElement(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[mid + 1]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return right;
    }

    public static void main(String[] args) {
        System.out.println(findPeakElement(new int[]{1,2}));
    }

}
