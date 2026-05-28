package com.leetcode.HightInterview;

import netscape.security.UserTarget;

/**
 * @author HQ
 * @program: java-coding
 * @description: 509. 斐波那契数
 * @date 2022-08-11 23:10:26
 */
public class Question03_509Fib {
    static int [] fi = new int[31];
    static {
        fi[0] = 0;fi[1] = 1;
        for (int i = 2; i <= 30; i++) {
            fi[i] = fi[i - 1] + fi[i - 2];
        }
    }

    public static int fib2(int n) {
        return fi[n];
    }

    public static int fib(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1){
            return 1;
        }
        return fib(n - 1) + fib(n - 2);
    }



    public static void main(String[] args) {
        System.out.println(fib2(4));
    }

}
