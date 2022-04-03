package com.leetcode.all;

/**
 * @program: demo
 * @description: 172. 阶乘后的零
 * @author: Mr.He
 * @create: 2022-03-25 09:29
 **/
public class Question172TrailingZeroes {

    public static int trailingZeroes(int n) {
        return n >0 ? 0: n/5 + trailingZeroes(n /5);
    }

    public static void main(String[] args) {
        System.out.println(trailingZeroes(30));
    }
}
