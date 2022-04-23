package com.leetcode.hotinterview;

/**
 * @program: java-coding
 * @description: 34. 在排序数组中查找元素的第一个和最后一个位置
 * @author: Mr.He
 * @create: 2022-04-16 21:09
 **/
public class Question34SearchRange {

    //直接查找 第一个元素和最后一个元素
    public static int[] searchRange(int[] nums, int target) {
        int[] res = new int[]{-1, -1};
        int startIndex = 0;
        int endIndex = nums.length - 1;
        Boolean startFlag = false;
        Boolean endFlag = false;
        while (startIndex <= endIndex) {
            if (nums[startIndex] == target && !startFlag) {
                res[0] = startIndex;
                startFlag = true;
            } else if (!startFlag) {
                startIndex++;
            }

            if (nums[endIndex] == target && !endFlag) {
                res[1] = endIndex;
                endFlag = true;
            } else if (!endFlag) {
                endIndex--;
            }
            if (endFlag && startFlag) {
                return res;
            }
        }
        return res;
    }


    //二分
    public static int[] searchRange1(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] <= target) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        return nums;

    }

    public int binarry(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) >> 1;
            if (nums[left] < nums[mid]) {
                left++;
            }
            if (nums[right] > nums[mid]) {
                right--;
            }
            if (nums[mid] == 1){

            }
        }
        return 0;
    }


    public static void main(String[] args) {
        searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8);
    }

}
