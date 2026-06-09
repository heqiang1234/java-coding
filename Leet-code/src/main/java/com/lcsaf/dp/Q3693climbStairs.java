package com.lcsaf.dp;

public class Q3693climbStairs {

    public static int climbStairs(int n, int[] costs) {
        int[] memo = new int[n + 1];
        //return dfs1(n, costs, memo);
        return dfs(n,costs);
    }

    // 缺少记忆化，会导致重复计算
    public static int dfs(int n, int[] costs) {
        if (n <= 0) return 0;
        return Math.min(Math.min(dfs(n - 1, costs) + 1, dfs(n - 2, costs) + 4), dfs(n - 3, costs) + 9) + costs[Math.max(n - 1, 0)];
    }

    // 增加一个数组，可以减少重复的分支
    public static int dfs1(int j, int[] costs, int[] memo) {
        if (j <= 0) return 0;
        if (memo[j] != 0) return memo[j];
        int res = Integer.MAX_VALUE;
        // 选出前三步，值最小的那一步，
        for (int i = Math.max(j - 3, 0); i < j; i++) {
            res = Math.min(res, dfs1(i, costs, memo) + (j - i) * (j - i));
        }
        res += costs[j - 1];// 选出来之后，再累加这一步的值，表示到该步的总花费

        return memo[j] = res;
    }


    // 递推
    public static int climbStairs1(int n, int[] costs) {
        int[] f = new int[n + 1];
        f[0] = 0;
        for (int j = 1; j <= n; j++) {
            int res = Integer.MAX_VALUE;
            for (int i = Math.max(j - 3, 0); i < j; i++) {
                res = Math.min(res, f[i] + (j - i) * (j - i));
            }
            res += costs[j - 1];
            f[j] = res;
        }
        return f[n];
    }

    // 省去空间
    public static int climbStairs2(int n, int[] costs) {
        int[] f = new int[n + 1];
        f[0] = 0;
         int f1 = 0,f2 =0,f3 = 0;
        for (int m: costs){
            int new_f = Math.min(f1 + 9,Math.min(f2 + 4,f3 + 1)) + m;
            f1 = f2;
            f2 = f3;
            f3 = new_f;
        }
        return f3;
    }



    public static void main(String[] args) {
        System.out.println(climbStairs2(4, new int[]{1, 2, 3, 4}));
    }
}
