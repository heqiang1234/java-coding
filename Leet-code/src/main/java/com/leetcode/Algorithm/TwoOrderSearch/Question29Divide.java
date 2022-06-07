package com.leetcode.Algorithm.TwoOrderSearch;

import ch.qos.logback.core.encoder.EchoEncoder;
import org.omg.CORBA.MARSHAL;

/**
 * @author HQ
 * @program: java-coding
 * @description: 29.两数相除
 * @date 2022-06-07 21:46:11
 */
public class Question29Divide {

    public static int divide(int dividend, int divisor) {
        long dividendA = dividend,divisorA = divisor;
        Boolean isEdnTrue = true, isOrTrue = true;
        if (divisor < 0) {
            isOrTrue = false;
        }
        if (dividend < 0) {
            isEdnTrue = false;
        }
        if (dividendA < 0){
            dividendA = -dividendA;
        }
        if (divisorA < 0){
            divisorA = -divisorA;
        }
        long left = 0, right = dividendA;
        while (left < right) {
            long mid = left + right + 1 >> 1;
            if (checkRes(dividendA, divisorA, mid)) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        long res = isEdnTrue == isOrTrue ? left : -1 * left;
        if (res > Integer.MAX_VALUE || res < Integer.MIN_VALUE) return Integer.MAX_VALUE;
        return (int) res;
    }


    public static Boolean checkRes(long x, long y, long z) {
        long ans = 0;
        for (long i = 0; i < y; i++) {
            ans += z;
        }
        return x >= ans;
    }

    //倍增乘法模板
    public Boolean checkRes1(long x, long a, long k) {
        long ans = 0;
        while (k > 0) {
            if ((k & 1) == 1) ans += a;
            k >>= 1;
            a += a;
        }
        return x >= ans;
    }

    public static void main(String[] args) {
        System.out.println(divide(-2147483648, -1));
    }
}
