package com.leetcode.face150;

/**
 * @author heqiang
 * @date 2025年07月31日16:21
 */
public class Quesiton121MaxProfit {

    /**
     * 输入：[7,1,5,3,6,4]
     * 输出：5
     * 解释：在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
     *      注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格；同时，你不能在买入前卖出股票。
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int maxValue = 0;
        int buyPrice = Integer.MAX_VALUE;
        for (int i = 0; i < prices.length; i++) {
            buyPrice = Math.min(buyPrice,prices[i]);
            maxValue = Math.max(maxValue,prices[i] - buyPrice);
        }

        return maxValue;
    }
}
