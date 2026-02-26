package com.leetcode.face150;

public class Question55Jump {

    public boolean canJump(int[] nums) {

        return dp(nums.length, nums.length - 1, nums);
    }

    public boolean dp(int len, int index, int[] nums) {
        int end = nums.length - 1;
        for (int i = end - 1; i >= 0; i--) {
            if (nums[i] + i >= end) {
                end = i;
            }
        }
        return end == 0;
    }

    public static int jump(int[] nums) {
        int maxIndex = 0;
        int end = 0;
        int step = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            maxIndex = Math.max(maxIndex, i + nums[i]); // 将目前最远的点记录下来
            if (i == end) { // 当当前的点和之前的最长记录相等，则将下一次最大记录下来。搭桥
                end = maxIndex;
                step++;
            }
        }

        return step;
    }

    public static void main(String[] args) {
        System.out.printf("", jump(new int[]{2, 3, 1, 1, 4}));
    }


}
