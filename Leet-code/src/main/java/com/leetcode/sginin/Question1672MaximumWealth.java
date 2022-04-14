package com.leetcode.sginin;

import com.leetcode.all.MaxProduct;

/**
 * @program: java-coding
 * @description: 1672. 最富有客户的资产总量
 * @author: Mr.He
 * @create: 2022-04-14 22:36
 **/
public class Question1672MaximumWealth {

    public static int maximumWealth(int[][] accounts) {
        int maxValue = 0;
        int start = 0;
        int end = accounts.length - 1;
        while (start <= end){
            int startValue = getValue(accounts[start]);
            int endValue = getValue(accounts[end]);
            int tempValue = 0;
            start++;
            end--;
            if (startValue > endValue){
                tempValue = startValue;
            }else {
                tempValue = endValue;
            }
            maxValue = Math.max(tempValue,maxValue);
        }
        return maxValue;
    }

    public static int getValue(int[] acct){
        int sum = 0;
        for (int i = 0; i < acct.length; i++) {
            sum += acct[i];
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(maximumWealth(new int[][]{{1,5},{7,3},{3,5}}));
    }
    
}
