package com.leetcode.year2023.face150;

import java.util.Arrays;

/**
 * @author HQ
 * @program: java-coding
 * @description: 300. 最长递增子序列
 * @date 2023-11-19 14:18:27
 */
public class Question300LengthOfLIS {

    /**
     * 输入：nums = [10,9,2,5,3,7,101,18]    dp[n] = f
     * 输出：4
     * 解释：最长递增子序列是 [2,3,7,101]，因此长度为 4 。
     *
     * @param nums
     * @return
     */
    public static int lengthOfLIS(int[] nums) {
        int n = nums.length - 1;
        int[] dp = new int[n + 1];
        Arrays.fill(dp, 1);
        int maxValue = 0;
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 1; j <= n; j++) {
                if (nums[i] < nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            maxValue = Math.max(dp[i],maxValue);
        }
        return maxValue;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLIS(new int[]{10, 9, 2, 5, 3, 7, 101, 18}));
    }

}
