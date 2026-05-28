package com.leetcode.jianzhiofferspecial;

/**
 * @author: Mr.He
 * @create: 2022-08-31 19:53
 * @description: 剑指 Offer II 001. 整数除法
 **/
public class QuestionJzOffer001Divide {

    public static int divide(int a, int b) {
        boolean flag = true;
        if (a + b < a || a + b < b) flag = false;
        int count = 0;
        while ( a > b){
            a = a - b;
            count ++;
        }
        return count;
    }

    public static void main(String[] args) {

    }

}
