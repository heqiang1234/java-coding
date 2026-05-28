package com.leetcode.sginin;

import java.util.Arrays;
import java.util.List;

/**
 * @author heqiang
 * @date 2025年10月15日9:44
 */
public class Question3349HasIncreasingSubarrays {

    // 用一个滑动窗口试下
    public boolean hasIncreasingSubarrays(List<Integer> nums, int k) {
        int beginIndex = 0, endIndex = k - 1;
        int len = nums.size();
        int[] numsT = new int[len];
        for (int i = 0; i < len; i++) {
            numsT[i] = nums.get(i);
        }

        while (endIndex < len) {


            beginIndex++;
        }

        return false;
    }

    public boolean Judge(int[] nums1) {

        int len = nums1.length;
        for (int i = 0; i < len - 1; i++) {
            if (nums1[i] > nums1[i + 1]) {
                return false;
            }
        }
        return true;
    }

}
