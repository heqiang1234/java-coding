package com.leetcode.weektest.week504;


/**
 * @author heqiang
 * @date 2026年05月31日15:23
 */
public class Q1CountScore {

    public static int digitFrequencyScore(int n) {
        int res = 0;
        while (n > 0){
            int num = n %10;
            res+= num;
            n/= 10;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(digitFrequencyScore(122));
    }

}
