package com.leetcode.sginin;

public class Question2110GetDescentPeriods {

    public static long getDescentPeriods(int[] prices) {
        long res = 1;// prices.length;
        int pre = prices[0];
        int len = 1; // 记录此次周期长度
        for (int i = 1; i < prices.length; i++) {
            // 差值为1，则res+1
            if ((pre - prices[i]) == 1) {
                len += 1;
            } else {
                // 当走完本次周期之u，需要计算周期
                len = 1;
            }
            res += len;
            pre = prices[i];
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(getDescentPeriods(new int[]{3, 2, 1, 4}));
    }

}
