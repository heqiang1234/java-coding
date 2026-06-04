package com.leetcode.year2026;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.leetcode.all.Question1219GetMaximumGold.n;

/**
 * @author heqiang
 * @date 2026年05月30日14:15
 */
public class Q2602minOperations {

    public static List<Long> minOperations(int[] nums, int[] queries) {
        int n_len = nums.length;
        List<Long> res = new ArrayList<>();
        Long[] sum = new Long[n_len + 1];
        sum[0] = 0L;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            sum[i + 1] = nums[i] + sum[i];
        }
        for (int query : queries) {
            int index = lower_bound(nums, query);
            Long left = (long) query * index - sum[index];
            Long right = sum[n_len] - sum[index] - (long) query * (n_len - index);
            res.add(left + right);
        }
        return res;
    }

    public static int lower_bound(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target){
                left = mid + 1;
            }
            else{
                right = mid - 1;
            }
        }
        return left;
    }

    public static int lower_bound1(int[] nums, int target) {
        int left = 0, right = nums.length; // 左闭右开 [left,right)
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target){
                left = mid + 1;  // [mid + 1,right)
            }
            else{
                right = mid; // [left,mid)
            }
        }
        return left;
    }

    public static void main(String[] args) {
        minOperations(new int[]{47, 50, 97, 58, 87, 72, 41, 63, 41, 51, 17, 21, 7, 100, 69, 66, 79, 92, 84, 9, 57, 26, 26, 28, 83, 38},
                new int[]{50, 84, 76, 41, 64, 82, 20, 22, 64, 7, 38, 92, 39, 28, 22, 3, 41, 46, 47, 50, 88, 51, 9, 49, 38, 67, 26, 65, 89, 27, 71, 25, 77, 72, 65, 41, 84, 68, 51, 26, 84, 24, 79, 41, 96, 83, 92, 9, 93, 84, 35, 70, 74, 79, 37, 38, 26, 26, 41, 26});
    }

}
