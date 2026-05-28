package com.leetcode.year2023.face150;

import java.util.Arrays;
import java.util.List;

/**
 * @author HQ
 * @program: java-coding
 * @description: 120. 三角形最小路径和
 * @date 2023-11-14 22:41:37
 */
public class Question120MinimumTotal {

    private Object Integer;

    //从底到下
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[] dp = new int[n + 1];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                dp[j] = Math.min(dp[j], dp[j + 1]) + triangle.get(i).get(j);
            }
        }
        return dp[0];
    }

    //co
    public int minimumTotal1(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] dp = new int[n + 1][n + 1];
        //int minValue = -9999999;
        for (int i = 1; i < n; i++) {
            dp[i][0] = dp[i - 1][0] + triangle.get(i).get(0);
            for (int j = 0; j < i; j++) {
                dp[i][j] = Math.min(dp[i - 1][j + 1], dp[i - 1][j]) + triangle.get(i).get(j);
            }
            dp[i][i] = dp[i - 1][i - 1] + triangle.get(i).get(i);
        }
        int minTotal = dp[n - 1][0];
        for (int i = 0; i < n; i++) {
            minTotal = Math.min(minTotal,dp[n-1][i]);
        }
        return minTotal;
    }

}
