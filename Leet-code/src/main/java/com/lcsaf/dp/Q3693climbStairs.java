package com.lcsaf.dp;

public class Q3693climbStairs {

    public static int climbStairs(int n, int[] costs) {
        return dfs(n, costs);
    }

    public static int dfs(int n, int[] costs) {
        if (n <= 0) return 0;
        return Math.min(Math.min(dfs(n - 1, costs) + costs[Math.max(n - 1, 0)],
                            dfs(n - 2, costs) + costs[Math.max(n - 2, 0)]),
                dfs(n - 3, costs) + costs[Math.max(n - 3, 0)]);
    }

    public static int climbStairs1(int n, int[] costs) {
        int [] f = new int[n+1];


        return 0;
    }


    public static void main(String[] args) {
        System.out.println(climbStairs(4, new int[]{1, 2, 3, 4}));
    }
}
