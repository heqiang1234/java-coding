package com.leetcode.face150;

public class Q02RemoveElement {
    public static int removeElement(int[] nums, int val) {
        int count = 0;
        int[] newNums = new int[nums.length];
        if (nums == null || nums.length == 0) {
            return 0;
        }
        for (int i = 0, j = 0; i < nums.length; i++) {
            if (nums[i] == val) {
                //
            } else {
                newNums[j++] = nums[i];
                count++;
            }
        }
        for (int i = 0; i < count; i++) {
            nums[i] = newNums[i];
        }

        return count;
    }

    public static void main(String[] args) {
        removeElement(new int[]{3, 2, 2, 3}, 3);
    }

}
