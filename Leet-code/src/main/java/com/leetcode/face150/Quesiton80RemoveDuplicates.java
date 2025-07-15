package com.leetcode.face150;

public class Quesiton80RemoveDuplicates {

    // 0,0,1,1,1,1,2,3,3
    public int removeDuplicates(int[] nums) {

        // 定义一个左右指针，如果出现了次数超过2的，那么就使用指针将最后一个数字移动至前面，然后最后几位不访问了。
        int leftPoin = 0, rightPoint = nums.length;
        int resLen = 0, len = nums.length, count = 0, lastNum = Integer.MAX_VALUE;
        int index = 0;
        while (leftPoin <= rightPoint) {
            if (count == 2 && nums[index] == lastNum) {
                count = 0;
            } else {
                if (nums[index] == lastNum) {
                    count++
                }
            }
        }
//        for (int i = 0; i < len; i++) {
//            if (nums[i])
//        }

        return 0;
    }

}
