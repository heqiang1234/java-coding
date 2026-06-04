package com.leetcode.year2026_Algo;

/**
 * @author heqiang
 * @date 2026年06月01日13:28
 */
public class Q3693climbStairs {

    public static int climbStairs(int n, int[] costs) {
        //int len = costs.length;
        int [] memo = new int[n+ 1];
        return dfs(n,costs,memo);
    }

    public static int dfs(int n,int[] costs,int [] memo){

        if (n <= 0) return 0;

        if (memo[n] != 0)  return memo[n];


        return memo[n] = costs[n - 1] + Math.min(  dfs((n - 2),costs,memo) + 1,
                Math.min(dfs((n - 3 ),costs,memo) + 4,dfs((n - 4 ),costs,memo) + 9));
    }

    public static void main(String[] args) {
        System.out.println(climbStairs(4, new int[]{5, 1, 6, 2}));
    }

}
