package com.leetcode.wangdaostudy;

/**
 * @author HQ
 * @program: java-coding
 * @description: 704.二分查找
 * @date 2022-08-16 23:38:28
 */
public class Question07_704Search {

    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target){
                return mid;
            } else if (nums[mid] > target){
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }

}
