package com.leetcode.face150;

public class Q03RemoveDuplicates {

    public static int removeDuplicates(int[] nums) {
        int len = nums.length;
        if (len == 0) return 0;
        if (len == 1) return 1;
        // 左指针位置拿来填补数字，右指针进行数据的遍历
        int leftPointer = 0, rightPointer = 1;

        while (rightPointer < len) {
            if (nums[leftPointer] == nums[rightPointer]) {
                rightPointer++; // 如果相等，右指针向右移动
            } else {
                nums[++leftPointer] = nums[rightPointer];
                rightPointer++;
            }
        }
        return leftPointer + 1;

    }

    public static void main(String[] args) {
        removeDuplicates(new int[]{1, 1, 2});
    }
}
