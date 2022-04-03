package com.leetcode.all;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: demo
 * @description: 728. 自除数
 * @author: Mr.He
 * @create: 2022-03-31 10:00
 **/
public class Question728SelfDividingNumbers {

    public static List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> res = new ArrayList<>();
        for (int i = left; i <= right; i++) {
            if (i < 10){
                res.add(i);
            } else {
                if (judgeInt(i)) {
                    res.add(i);
                }
            }
        }
        return res;
    }

    public static Boolean judgeInt(int num){
        int num1 = num;
        while (num1 != 0){
            int num2 = num1 % 10;
            num1 /= 10;
            if (num2 == 0){
                return false;
            }
            if (num % num2 != 0){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        selfDividingNumbers(47,85);
    }
}
