package com.leetcode.sginin;

/**
 * @program: java-coding
 * @description: 762. 二进制表示中质数个计算置位
 * @author: Mr.He
 * @create: 2022-04-05 13:13
 **/
public class Question762CountPrimeSetBits {

    static {

    }

    public int countPrimeSetBits(int left, int right) {
        int res = 0;
        return res;
    }

    public Boolean JudgeNum(int num) {
        int count = 0;
        while (num != 0) {
            count += num % 2;
            num = num / 2;
        }
        if (Judgeum1(count)){
            return true;
        } else {
            return false;
        }
    }

    public Boolean Judgeum1(int num){
        if (num == 2 || num == 3 || num == 5 || num == 7 || num == 11){
            return true;
        }
        for (int i = 0; i < num; i++) {

        }

        return false;
    }
}
