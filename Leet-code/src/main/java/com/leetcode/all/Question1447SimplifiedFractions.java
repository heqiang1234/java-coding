package com.leetcode.all;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: demo
 * @description: 1447. 最简分数
 * @author: Mr.He
 * @create: 2022-02-10 14:34
 **/
public class Question1447SimplifiedFractions {

    public static List<String> simplifiedFractions(int n) {
        List<String> res = new ArrayList<>();
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                if (judgeStatus(i,j) == 1) {
                    res.add(j + "/" + i);
                }
            }
        }
        return res;
    }

    public static int judgeStatus(int num1,int num2){
        if (num2 == 0){
            return num1;
        }
        return judgeStatus(num2,num1 % num2);

    }

    public static void main(String[] args) {
        System.out.println(simplifiedFractions(6));
    }
}
