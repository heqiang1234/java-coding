package com.leetcode.programtest3;

/**
 * @author: Mr.He
 * @create: 2022-09-20 09:22
 * @description: 股票买卖最大费用
 **/
public class Question_MaxProfit {

    public static int get_max_profit(int beginCash, int[] historyPrice) {
        int maxValue = 0;
        int startCash = beginCash;
        for (int i = 0; i < historyPrice.length - 1; i++) {
            int value = historyPrice[i + 1] - historyPrice[i];
            if (value > 0) {
                System.out.println(historyPrice[i] + "  " + value);
                beginCash += (beginCash / historyPrice[i]) * value;
                System.out.println(beginCash);
            }
        }
        return beginCash - startCash;
    }

    static int maxProfit = 0;

    public static int getMaxProfit(int balance, int[] arr) {
        process(0, 0, arr, balance);
        return maxProfit - balance;
    }

    private static void process(int index, int count, int[] arr, int balance) {
        if (index == arr.length) {
            if (maxProfit < balance) {
                maxProfit = balance;
            }
            return;
        }
        // 1、 买入
        if (balance >= arr[index]) {
            process(index + 1, balance / arr[index], arr, balance - balance / arr[index] * arr[index]);
        }
        // 2、不操作
        process(index + 1, count, arr, balance);
        // 3、卖出
        if (count > 0) {
            process(index + 1, 0, arr, balance + count * arr[index]);
        }
    }

    public int maxProfit(int[] prices) {
        int len = prices.length;
        if (len < 2) {
            return 0;
        }

        // cash：持有现金
        // hold：持有股票
        // 状态转移：cash → hold → cash → hold → cash → hold → cash

        int cash = 0;
        int hold = -prices[0];

        int preCash = cash;
        int preHold = hold;
        for (int i = 1; i < len; i++) {
            cash = Math.max(preCash, preHold + prices[i]);
            hold = Math.max(preHold, preCash - prices[i]);

            preCash = cash;
            preHold = hold;
        }
        return cash;
    }


    // int get_max_profit(const double beginCash, const std::vector<int>& historyPrices)
    // {
    //     int profit = 0;
    //     double CashTmp = beginCash;
    //
    //     int PriceLast = 0;
    //     int iFlag = 2; // 1为股价上升中, 2为下跌中
    //     double iAmount = 0; //当前持仓数量
    //     for (int i = 1, iMin = 0, iMax = 0; i < historyPrices.size(); ++i)
    //     {
    //         PriceLast = historyPrices[i - 1];
    //
    //         if (PriceLast < historyPrices[i])
    //         {
    //             // 上涨区间
    //             if (iFlag == 2) //下跌状态时买入最低股价
    //             {
    //                 iMin = PriceLast;
    //                 iAmount = CashTmp / iMin;
    //             }
    //
    //             iFlag = 1;
    //         }
    //         else if (PriceLast > historyPrices[i])
    //         {
    //             // 下跌区间
    //             if (iFlag == 1) //由上涨变为下跌抛出盈利
    //             {
    //                 iMax = PriceLast;
    //                 CashTmp = iAmount * iMax;
    //             }
    //
    //             iFlag = 2;
    //         }
    //
    //         // 最后一天卖出盈利
    //         if (i == historyPrices.size() - 1 && iAmount != 0)
    //         {
    //             CashTmp = iAmount * historyPrices[i];
    //         }
    //     }
    //
    //     profit = CashTmp - beginCash;
    //     return profit;
    // }


    public static void main(String[] args) {
        System.out.println(get_max_profit(10000, new int[]{50, 40, 60, 80, 70, 100}));
    }
}
