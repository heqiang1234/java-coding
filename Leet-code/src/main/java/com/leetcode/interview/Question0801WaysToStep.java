package com.leetcode.interview;

/**
 * @program: demo
 * @description: 面试题 08.01. 三步问题
 * @author: Mr.He
 * @create: 2022-01-07 15:28
 **/
public class Question0801WaysToStep {

    public static int wayToStep(int n) {
        if(n == 0){
            return 0;
        } else if(n == 1){
            return 1;
        } else if (n == 2){
            return 2;
        } else if(n == 3){
            return 4;
        }
        long [] res = new long[n + 1];
        res[0] = 0;
        res[1] = 1;
        res[2] = 2;
        res[3] = 4;
        for (int i = 4; i <= n; i++) {
            res[i] = (res[i - 1] + res[i - 2]+ res[i - 3])% 1000000007;
        }
       return (int)res[n];
    }


    public static void main(String[] args) {
        System.out.println(wayToStep(61));
    }
}
