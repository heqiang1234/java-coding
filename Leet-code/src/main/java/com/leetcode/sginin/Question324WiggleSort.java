package com.leetcode.sginin;

import java.sql.Array;
import java.util.Arrays;

/**
 * @author HQ
 * @program: java-coding
 * @description: 324.摆动排序2
 * @date 2022-06-28 22:46:43
 */
public class Question324WiggleSort {

    public static void wiggleSort(int[] nums) {
        Arrays.sort(nums);
        int left = 1, right = left + 2;
        int tempLeft = nums[0], tempRight = nums[right];
        int count = nums.length - 1;
        int num = 0;
        while (right <= count) {
            tempLeft = nums[left];
            nums[left] = nums[right];
            nums[right] = tempLeft;
            right = right + 2;
            left = left + 2;
        }
        return;
    }

    public static void main(String[] args) {
        wiggleSort(new int[]{1, 5, 1, 1, 6, 4});
    }
}
