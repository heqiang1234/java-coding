package com.leetcode.year2023.signin;

/**
 * @author: Mr.He
 * @create: 2023-11-20 12:02
 * @description: 53.最大子数组和
 **/
public class Quesition53MaxSubArray {

    /**
     * 状态转移方程 = max(dp[i] + num[i],dp[i-1])
     * 输入：nums = [-2,1,-3,4,-1,2,1,-5,4]  [2,4(1:4),3(-3:3),6(4:6),2(-1:2),3(2:3),1(1:0),-1(-5:-1),4(4:0)]
     * 输出：6
     * 解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
     *
     * @param nums
     * @return
     */
    public static int maxSubArray(int[] nums) {
        int n = nums.length;
        //int[] dp = new int[n+1];
        //dp[n] = 0;
        int sum = 0;
        //Arrays.fill(dp, 0);
        //优化空间，查看该处理，只使用了两个位置，dp[i],dp[i+1]
        int maxValue = Integer.MIN_VALUE;
        for (int i = n - 1; i >= 0; i--) {
            //dp[i] = Math.max(nums[i],dp[i + 1] + nums[i]);
            //maxValue = Math.max(dp[i],maxValue);
            sum = Math.max(nums[i],sum + nums[i]);
            maxValue = Math.max(sum,maxValue);
        }
        return maxValue;
    }

    public static void main(String[] args) {
        System.out.println(maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
    }

}
