package com.leetcode.sginin;

/**
 * @program: java-coding
 * @description: 357. 统计各位数字都不同的数字个数
 * @author: Mr.He
 * @create: 2022-04-12 22:00
 **/
public class Question357CountNumbersWithUniqueDigits {

    public static int countNumbersWithUniqueDigits(int n) {
        if (n == 0){
            return 1;
        }
        if (n == 1){
            return 10;
        }
        int num= 9;
        int sum = 10; //1位的数量
        for (int i = 0; i < n - 1; i++) {
            num *=  (9 - i);
            sum += num;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(countNumbersWithUniqueDigits(3));
    }

}
