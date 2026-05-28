package com.leetcode.sginin;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author HQ
 * @program: java-coding
 * @description: 1475.商品折扣后的最终价格
 * @date 2022-09-01 21:41:26
 */
public class Question1475FinalPrices {

    public static int[] finalPrices(int[] prices) {
        int len = prices.length;
        for (int i = 0; i < len; i++) {
            int j = i + 1;
            int discount = 0;
            while (j < len){
                if (prices[i] >= prices[j]){
                    discount= prices[j];
                    break;
                } else {
                    j++;
                }
            }
            prices[i] = prices[i] - discount;
        }
        return prices;
    }

    public static int[] finalPrices1(int[] prices) {
        int n = prices.length;
        int [] ans = new int[n];
        Deque<Integer> d = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            while (!d.isEmpty() && prices[d.peekLast()] >= prices[i]){
                int idx = d.pollLast();
                ans[idx] = prices[idx] - prices[i];
            }
            d.addLast(i);
            ans[i] = prices[i];
        }
        return ans;
    }


    public static void main(String[] args) {
        finalPrices1(new int[]{8,4,6,2,3});
    }
}
