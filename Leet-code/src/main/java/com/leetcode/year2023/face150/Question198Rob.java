package com.leetcode.year2023.face150;

/**
 * @author HQ
 * @program: java-coding
 * @description: 198. 打家劫舍
 * @date 2023-11-19 00:17:23
 */
public class Question198Rob {

    //状态转移方程   fn = f(n + 2) + f(n+ 2+2)+....
    // 只可能间隔1个，或者两个，如果间隔三个，那么其实小于等于间隔1个的，
    //dp的值表示偷到当前房间的金额处理最大值是多少
    public static int rob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n + 3];

        if (n == 1) {
            return nums[0];
        } else if (n == 2) {
            return Math.max(nums[0], nums[1]);
        }
        dp[0] = nums[0];
        dp[1] = nums[1];
        dp[2] = nums[0] + nums[2];
        for (int i = 3; i < n; i++) {
            dp[i] = Math.max(dp[i - 2], dp[i - 3]) + nums[i];
        }
        return Math.max(dp[n - 1], dp[n - 2]);
    }

    //此方法表示dp[N],即到了第N步最大值
    public static int rob1(int[] nums) {
        int n = nums.length;
        int pre = 0;
        int cur = 0;
        for (int i = 2; i < n; i++) {
            int tmep = Math.max(cur, pre + nums[i]);
            pre = cur;
            cur = tmep;
        }
        return cur;
    }

    public static void main(String[] args) {
        System.out.println(rob1(new int[]{2,1,1,2}));
    }
}
