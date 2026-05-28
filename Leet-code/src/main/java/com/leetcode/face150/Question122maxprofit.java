package com.leetcode.face150;

/**
 * @author heqiang
 * @date 2025年08月27日12:33
 */
public class Question122maxprofit {

    /**
     * 给你一个整数数组 prices ，其中 prices[i] 表示某支股票第 i 天的价格。
     * <p>
     * 在每一天，你可以决定是否购买和/或出售股票。你在任何时候 最多 只能持有 一股 股票。你也可以先购买，然后在 同一天 出售。
     * <p>
     * 返回 你能获得的 最大 利润 。
     * <p>
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * 输入：prices = [7,1,5,3,6,4]
     * 输出：7
     * 解释：在第 2 天（股票价格 = 1）的时候买入，在第 3 天（股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5 - 1 = 4。
     * 随后，在第 4 天（股票价格 = 3）的时候买入，在第 5 天（股票价格 = 6）的时候卖出, 这笔交易所能获得利润 = 6 - 3 = 3。
     * 最大总利润为 4 + 3 = 7 。
     * 示例 2：
     * <p>
     * 输入：prices = [1,2,3,4,5]
     * 输出：4
     * 解释：在第 1 天（股票价格 = 1）的时候买入，在第 5 天 （股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5 - 1 = 4。
     * 最大总利润为 4 。
     * 示例 3：
     * <p>
     * 输入：prices = [7,6,4,3,1]
     * 输出：0
     * 解释：在这种情况下, 交易无法获得正利润，所以不参与交易可以获得最大利润，最大利润为 0。
     */

    public static int maxProfit(int[] prices) {
        int len = prices.length, maxValue = 0;
        int curretnPro = prices[0]; // 手里的股票的价格
        for (int i = 1; i < len; i++) {
            //int curretnPro = prices[i];
            if (prices[i] - curretnPro > 0) {
                maxValue += (prices[i] - curretnPro);
            }
            curretnPro = prices[i];
        }
        return maxValue;
    }

    public static void main(String[] args) {
        maxProfit(new int[]{7, 1, 5, 3, 6, 4});
    }
}
