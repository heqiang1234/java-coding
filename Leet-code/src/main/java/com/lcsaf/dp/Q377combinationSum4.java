package com.lcsaf.dp;

import java.util.Arrays;

public class Q377combinationSum4 {

    public static int combinationSum4(int[] nums, int target) {
        int[] memo = new int[target + 1];
        Arrays.fill(memo, -1);
        return dfs(nums, target, memo);
    }

    // memo 数组
    public static int dfs(int[] nums, int target, int[] memo) {

        if (target == 0) {
            return 1;
        }
        if (target < 0) {
            return 0;
        }
        if (memo[target] != -1) {
            return memo[target];
        }
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            if (target - nums[i] >= 0) {
                res += dfs(nums, target - nums[i], memo);
            }
        }
        return res;
    }

    public static int combinationSum41(int[] nums, int target) {
        int[] f = new int[target + 1];
        f[0] = 1;
        for (int i = 1; i <= target; i++) {
            for (int x : nums) {
                if (i - x >= 0) {
                    f[i] += f[i - x];
                }
            }
        }
        return f[target];
    }


    public static void main(String[] args) {
        System.out.println(combinationSum41(new int[]{1, 2, 3}, 4));
    }
}
