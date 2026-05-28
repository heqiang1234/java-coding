package com.leetcode.sginin;

/**
 * @author heqiang
 * @date 2025年08月29日8:30
 */
public class Quesrion3021flowerGame {

    public static long flowerGame(int n, int m) {
        int x1 = 0, x2 = 0,y1 = 0,y2 = 0;
        x1 = n /2;
        return (long)(n/2) * (m - m/2) + (long) (n - n/2) *(m/2);
    }

    public static void main(String[] args) {
        System.out.println(flowerGame(3, 2));
    }

}
