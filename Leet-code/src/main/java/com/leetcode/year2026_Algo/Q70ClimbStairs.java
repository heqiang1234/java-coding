package com.leetcode.year2026_Algo;

/**
 * @author heqiang
 * @date 2026年06月01日10:59
 */
public class Q70ClimbStairs {

    // 1
    public static int climbStairs(int n) {
        int[] f = new int[n + 1];

        if (n <= 2) return n;
        f[0] = 0;
        f[1] = 1;
        f[2] = 2;

        for (int i = 3; i <= n; i++) {
            f[i] = f[i - 1] + f[i - 2];
        }

        return f[n];
    }

    // 2 记忆化搜索
    public static int climbStairs1(int n) {
        int[] f = new int[n + 1];

        return dfs(n, f);
    }

    public static int dfs(int n, int[] f) {
        if (n <= 1) return 1;

        if (f[n] != 0) return f[n];

        return f[n] = dfs(n - 1, f) + dfs(n - 2, f);
    }

    public static void main(String[] args) {
        climbStairs(4);
    }

}
