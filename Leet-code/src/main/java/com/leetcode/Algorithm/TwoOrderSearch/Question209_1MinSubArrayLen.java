package com.leetcode.Algorithm.TwoOrderSearch;

/**
 * @author HQ
 * @program: java-coding
 * @description: 209_1.209. 长度最小的子数组
 * @date 2022-06-22 21:43:22
 */
public class Question209_1MinSubArrayLen {

    public static int minSubArrayLen(int target, int[] nums) {
        int len = nums.length;
        int[] sum = new int[len + 1];
        sum[0] = 0;
        for (int i = 0; i < len; i++) {
            sum[i + 1] = sum[i] + nums[i];
        }
        int minLen = Integer.MAX_VALUE;
        for (int i = 0; i < sum.length; i++) {
            int temp = sum[i] + target;
            int index = binSearchNum(sum, temp);
            if (index >= 0) {
                minLen = Math.min(minLen, index - i);
            }
        }
        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }

    public static int binSearchNum(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        int ans = Integer.MAX_VALUE;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] > target) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    public static void main(String[] args) {
        System.out.println(minSubArrayLen(7, new int[]{2, 3, 1, 2, 4, 3}));
    }

}
