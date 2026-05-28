package com.leetcode.face150;

import java.util.Arrays;

/**
 * @author heqiang
 * @date 2025年07月30日17:26
 */
public class Question189Rotate {

    public void rotate(int[] nums, int k) {
        int len = nums.length;
        int [] nums1  =new int[len];
        for (int i = 0; i < len; i++) {
            int newIndex = (i + k) % len;
            nums1[newIndex] = nums[i];
        }
        for (int i = 0; i < len; i++) {
            nums[i] = nums1[i];
        }
    }
}
