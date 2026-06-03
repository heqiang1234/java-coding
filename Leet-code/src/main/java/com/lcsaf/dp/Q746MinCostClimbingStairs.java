package com.lcsaf.dp;

public class Q746MinCostClimbingStairs {

    // 会超时
    public int minCostClimbingStairs(int[] cost) {
        int[] memo = new int[cost.length];
        return dfs(memo, cost, cost.length);
    }

    public int dfs(int[] memo, int[] cost, int n) {
        if (n <= 1) return 0;
        if (memo[n] != 0) return memo[n];
        return Math.min(dfs(memo, cost, n - 1) + cost[n - 1],
                dfs(memo, cost, n - 2) + cost[n - 2]);
    }

    // 递推 ，这样省去了dfs的处理
    public static int minCostClimbingStairs1(int[] cost) {
        int n = cost.length;
        int[] f = new int[cost.length + 1];
        f[0] = 0;
        f[1] = 0; // 边界值非常重要，这里是从0，1出发，所以0，1作为返回条件
        for (int i = 2; i <= n; i++) {
            // 需要到n, 那么需要考虑n-1,n-2的最小费用
            f[i] = Math.min(f[i - 1] + cost[i - 1], f[i - 2] + cost[i - 2]);
        }
        return f[n];
    }

    //优化空间，由于只用到了前两个状态
    public static int minCostClimbingStairs2(int[] cost) {
        int n = cost.length;
        int pre_f = 0;
        int new_f = 0;
        // 边界值非常重要，这里是从0，1出发，所以0，1作为返回条件
        for (int i = 2; i <= n; i++) {
            // 需要到n, 那么需要考虑n-1,n-2的最小费用
            int ff = Math.min(new_f + cost[i - 1], pre_f + cost[i - 2]);
            pre_f = new_f;
            new_f = ff;
        }
        return new_f;
    }


    public static void main(String[] args) {
        System.out.println(minCostClimbingStairs1(new int[]{1, 100, 1, 1, 1, 100, 1, 1, 100, 1}));
    }


}
