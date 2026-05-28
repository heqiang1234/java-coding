package com.leetcode.HightInterview;

/**
 * @author HQ
 * @program: java-coding
 * @description: 167. 两数之和 II - 输入有序数组
 * @date 2022-08-10 19:43:56
 */
public class Question01_167TwoSum {

    public static int[] twoSum(int[] numbers, int target) {
        int len = numbers.length - 1;
        for (int i = 0; i < numbers.length; i++) {
            int tempNum = numbers[i];
            int targetNum = target - tempNum;
            int leftIndex = i > 0 ? binSearch(0, i, numbers, targetNum) : Integer.MAX_VALUE;
            int rightIndex = i < len ? binSearch(i, len, numbers, targetNum) : Integer.MAX_VALUE;
            if (leftIndex != Integer.MAX_VALUE && i != leftIndex) {
                return new int[]{leftIndex + 1, i + 1};
            }
            if (rightIndex != Integer.MAX_VALUE && i != rightIndex) {
                return new int[]{i + 1, rightIndex + 1};
            }
        }
        return new int[]{0, 0};
    }

    public static int binSearch(int left, int right, int[] nums, int target) {
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return Integer.MAX_VALUE;
    }

    public static int[] twoSum1(int[] numbers, int target) {
        if (numbers == null || numbers.length == 0) {
            return new int[]{0};
        }
        int len = numbers.length - 1;
        int left = 0, right = len;
        while (left < right) {
            int sum = numbers[left] + numbers[right];
            if (sum == target) {
                return new int[]{left + 1, right + 1};
            } else if (sum > target) {
                right--;
            } else {
                left++;
            }
        }
        return new int[]{0};
    }

    public static void main(String[] args) {
        int[] res = twoSum(new int[]{0, 0, 3, 4}, 0);
        System.out.println(res);
    }


}
