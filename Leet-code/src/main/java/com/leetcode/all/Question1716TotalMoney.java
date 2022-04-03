package com.leetcode.all;

/**
 * @program: demo
 * @description: 1716. 计算力扣银行的钱
 * @author: Mr.He
 * @create: 2022-01-15 14:44
 **/
public class Question1716TotalMoney {

    public static int totalMoney(int n) {
        int totalMoney = 0;
        int totalCount = 0;
        int m = n/7;
        int m1 = 0;
        while (m + 1 != m1){
            for (int i = 1; i <= 7; i++) {
                if (n == totalCount) {
                    return totalMoney;
                }
                totalMoney += (i + m1);
                totalCount++;
            }
            m1++;
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(totalMoney(20));
    }
}
