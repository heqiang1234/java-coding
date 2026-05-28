package com.leetcode.face150;

// [0,0,1,1,1,1,2,3,3]
public class Q4removeDuplicatesII {
    public int removeDuplicates(int[] nums) {
        int len = nums.length;
        if (len == 0) return 0;
        if (len == 1) return 1;
        // 左指针位置拿来填补数字，右指针进行数据的遍历
        int leftPointer = 0, rightPointer = 1, count = 1;

        while (rightPointer < len) {
            if (nums[leftPointer] == nums[rightPointer] && count <= 2) {
                rightPointer++; // 如果相等，右指针向右移动
                count++;
            }  else {
                nums[++leftPointer] = nums[rightPointer];
                rightPointer++;
            }
        }
        return leftPointer + 1;
    }
}
