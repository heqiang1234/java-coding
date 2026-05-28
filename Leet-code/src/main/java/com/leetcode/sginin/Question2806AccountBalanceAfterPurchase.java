package com.leetcode.sginin;

/**
 * 2806. 取整购买后的账户余额
 */
public class Question2806AccountBalanceAfterPurchase {

    public int accountBalanceAfterPurchase(int purchaseAmount) {
//        int res = 0;
//        int temnIndex = purchaseAmount / 10;
//        int secIndex = purchaseAmount % 10;
//
//        if (secIndex >= 5){
//            res = 10 + temnIndex * 10;
//        } else {
//            res = temnIndex * 10;
//        }
//
//        return 100 - res;    -- 常规解法
        //四舍五入！
        return 100 - (purchaseAmount + 5) / 10 * 10;
    }
}
