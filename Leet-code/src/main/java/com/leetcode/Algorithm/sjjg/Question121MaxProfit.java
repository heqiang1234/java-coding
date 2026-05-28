package com.leetcode.Algorithm.sjjg;

/**
 * @author: Mr.He
 * @create: 2022-04-26 22:38
 * @description: 121. 买卖股票的最佳时机
 **/
public class Question121MaxProfit {

    //[7,1,5,3,6,4]
    public int maxProfit(int[] prices) {
        int maxValue = 0;
        int minPrice = prices[0];
        for (int i = 1; i < prices.length; i++) {
            if (minPrice < prices[i]){
                maxValue = Math.max(maxValue, prices[i] - minPrice);
            } else {
                minPrice = prices[i];
            }
        }
        return maxValue;
    }
}
