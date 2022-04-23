package com.leetcode.all;

import com.sun.org.apache.regexp.internal.RE;

import java.util.Arrays;

/**
 * @program: java-coding
 * @description: 581. 最短无序连续子数组
 * @author: Mr.He
 * @create: 2022-04-18 16:03
 **/
public class Question581FindUnsortedSubarray {

    public static int findUnsortedSubarray(int[] nums) {
        int len = nums.length;
        int left = -1;
        int maxNum = Integer.MIN_VALUE;
        int right = -1;
        int minNum = Integer.MAX_VALUE;

        for (int i = 0; i < len; i++) {
            if (maxNum <= nums[i]) {
                maxNum = nums[i];
            } else {
                right = i;
            }

            if (minNum < nums[len - i - 1]) {
                left = len - i - 1;
            } else {
                minNum = nums[len - i - 1];
            }
        }
        return right == -1 ? 0 : right - left + 1;
    }

    public static void main(String[] args) {
        System.out.println(findUnsortedSubarray(new int[]{1, 3, 2, 3, 3}));
        System.out.println(findUnsortedSubarray(new int[]{1, 2, 3, 4}));
        System.out.println(findUnsortedSubarray(new int[]{1}));
    }

    public static int findUnsortedSubarray1(int[] nums) {
        int len = nums.length;
        int[] numsTemp = new int[len];
        System.arraycopy(nums, 0, numsTemp, 0, len);
        Arrays.sort(numsTemp);
        int leftIndex = 0;
        int rightIndex = len;
        for (int i = 0; i < len; i++) {
            if (nums[i] == numsTemp[i]) {
                leftIndex++;
            } else {
                break;
            }
        }

        for (int i = len - 1; i >= 0; i--) {
            if (nums[i] == numsTemp[i]) {
                rightIndex--;
            } else {
                break;
            }
        }

        if (leftIndex < rightIndex) {
            return rightIndex - leftIndex + 1;
        }
        return 0;
    }

}
