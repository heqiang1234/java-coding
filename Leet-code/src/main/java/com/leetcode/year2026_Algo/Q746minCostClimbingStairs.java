package com.leetcode.year2026_Algo;

import java.util.Arrays;

/**
 * @author heqiang
 * @date 2026年06月01日11:39
 */
public class Q746minCostClimbingStairs {

    // 定义一定要清楚，要知道是处于哪个状态
    public static int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] memo = new int[n + 2];
        Arrays.fill(memo, -1);
        return dfs(n, memo, cost);
    }

    public static int dfs(int n, int[] memo, int[] cost) {
        if (n <= 1) return 0;

        if (memo[n] != -1) return memo[n];

        return memo[n] = Math.min(dfs(n - 1, memo, cost) + cost[n - 1], dfs(n - 2, memo, cost) + cost[n - 2]);
    }

    // 堆栈
    public static int minCostClimbingStairs1(int[] cost) {
        int n = cost.length;
        int[] f = new int[n + 2];
        f[0] = 0;
        f[1] = 0;
        for (int i = 2; i < n; i++) {
            f[n] = Math.min(f[n - 1] + cost[n - 1], f[n - 2] + cost[n - 2]);
        }

        return f[n];
    }

    //优化空间
    public static int minCostClimbingStairs2(int[] cost) {
        int n = cost.length;

        int f0 = 0,f1 = 0;
        for (int i = 1; i < n; i++) {
            int f_new = Math.min(f1 + cost[i], f0+ cost[i - 1]);
            f0 = f1; // n - 2这个状态
            f1 = f_new; // n-1这个状态
        }

        return f1;
    }

    public static void main(String[] args) {
        //System.out.println(minCostClimbingStairs(new int[]{1, 100, 1, 1, 1, 100, 1, 1, 100, 1}));
        System.out.println(minCostClimbingStairs2(new int[]{10, 15, 20}));
    }

}
