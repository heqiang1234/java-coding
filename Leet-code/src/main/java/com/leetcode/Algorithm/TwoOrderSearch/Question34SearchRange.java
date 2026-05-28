package com.leetcode.Algorithm.TwoOrderSearch;

/**
 * @author: Mr.He
 * @create: 2022-04-27 10:34
 * @description: 34. 在排序数组中查找元素的第一个和最后一个位置
 **/
public class Question34SearchRange {
    public static int[] searchRange(int[] nums, int target) {
        int[] res = new int[]{-1, -1};
        int len = nums.length;
        int left = 0, right = len - 1;
        int count = 0;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == 0){
                count++;
            }
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        if (count == 0){
            return res;
        }
        res[0] = left;
        left = 0;
        right = len;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        res[1] = right;
        return res;
    }

    public static void main(String[] args) {
        searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8);
    }
}
