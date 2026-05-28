package com.leetcode.all;

import java.util.ArrayList;
import java.util.List;

/**
 * @author HQ
 * @program: demo
 * @description: 1414. 和为 K 的最少斐波那契数字数目
 * @date 2022-02-03 15:01:44
 */
public class Question1414FindMinFibonacciNumbers {

    public static int findMinFibonacciNumbers(int k) {
        List<Integer> resList = new ArrayList<>();
        resList.add(1);
        int temNum = k;
        int count = 0;
        int num1 = 1, num2 = 1;
        while (num1 + num2 <= k) {
            int num3 = num1 + num2;
            resList.add(num3);
            num1 = num2;
            num2 = num3;
        }
        while (temNum != 0) {
            int lenLeft = 0, lenRight = resList.size() - 1;

            while (lenLeft < lenRight) {
                int mid = lenLeft + lenRight + 1 >> 1;
                if (resList.get(mid) <= temNum){
                    lenLeft = mid;
                } else {
                    lenRight = mid - 1;
                }
            }
            temNum -= resList.get(lenRight);
            count++;
        }


//        for (int i = resList.size() - 1; i >= 0; i--) {
//            if (resList.get(i) <= temNum) {
//                temNum = temNum - resList.get(i);
//
//            }
//        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(findMinFibonacciNumbers(645157245));
    }
}
