package com.leetcode.sginin;

/**
 * @author heqiang
 * @date 2025年08月05日12:31
 */
public class Question3477NumOfUnplacedFruitsII {

    public static int numOfUnplacedFruits(int[] fruits, int[] baskets) {

        int leftIndex = 0,res = 0;
        for (int i = 0; i < fruits.length; i++) {

            // 选择哪一个篮子。
            for (int j = leftIndex; j < baskets.length; j++) {
                if (baskets[j] > 0 &&  baskets[j] >= fruits[i]) {
                    baskets[j] = 0; // 放了水果，那么就不能再放了，写为0
                   // leftIndex = Math.min(leftIndex, j);
                    res++;
                    break;
                }
            }
        }
        return fruits.length - res;

    }

    public static void main(String[] args) {
        System.out.println(numOfUnplacedFruits(new int[]{4, 2, 5}, new int[]{3, 5, 4}));
    }

}
