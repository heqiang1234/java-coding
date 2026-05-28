package com.leetcode.year2023.face150;

import com.leetcode.all.MaxProduct;
import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;
import javafx.print.Collation;

import java.util.Arrays;

/**
 * @author HQ
 * @program: java-coding
 * @description: 322.零钱兑换
 * @date 2023-11-19 11:55:46
 */
public class Question322CoinChange {


    public int coinChange(int[] coins, int amount) {

        return dp(coins, amount);
    }

    //递归
//    public static int dfs(int[] coins, int amount) {
//        if (amount == 0){
//            return 0;
//        }
//        for (int i = 0; i < coins.length; i++) {
//            if (coins[i] > amount){
//                continue;
//            }
//            dfs(coins,amount - amount);
//        }
//
//    }

    //
    public static int dp(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        Arrays.sort(coins);
        for (int i = 0; i < dp.length; i++) {
            for (int coin : coins) {
                if (i - coin < 0) {
                    continue;
                }
                dp[i] = Math.min(dp[i], dp[i - coin] + 1);
            }
        }
        return dp[amount] == amount + 1 ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        System.out.println(dp(new int[]{1, 5, 3}, 10000));
    }

}
