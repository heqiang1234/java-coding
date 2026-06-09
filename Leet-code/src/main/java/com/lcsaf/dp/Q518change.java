package com.lcsaf.dp;

// 377. 组合总和 Ⅳ
public class Q518change {


   // https://leetcode.cn/problems/combination-sum-iv/
    /**
     *
     *
     * @param amount
     * @param coins
     * @return
     */
    //TODO。这题和037题目的差异点
    public int change(int amount, int[] coins) {

        int[] f = new int[amount + 1];
        f[0] = 1;
        for (int i = 0; i < coins.length; i++) {
            for (int j = 1; j <= amount; j++) {
                if (j >= coins[i]) {
                    f[j] += f[j - coins[i]];
                }

            }
        }
        return f[amount];
    }

    public int dfs(int[] coins, int target) {


        return 0;
    }

}
