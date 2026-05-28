package com.leetcode.Algorithm.huadongchuangkou;

/**
 * @author heqiang
 * @date 2025年07月31日13:02
 */
public class Question643FindMaxAverage {

    public static double findMaxAverage(int[] nums, int k) {
        double res = Integer.MIN_VALUE;
        double nowSum = 0.0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            count++;
            nowSum += nums[i];

            if (count < k){
                continue;
            }
            if (k == count){
                res = Math.max(res,nowSum / k);
                count -- ;

                nowSum -= nums[i - k + 1];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(findMaxAverage(new int[]{5},1));
    }

}
