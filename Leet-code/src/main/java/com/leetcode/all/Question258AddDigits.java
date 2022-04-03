package com.leetcode.all;

/**
 * @program: demo
 * @description: 258. 各位相加
 * @author: Mr.He
 * @create: 2022-03-03 10:18
 **/
public class Question258AddDigits {

    public static int addDigits(int num) {
        while (num >=10){
            int sum = 0;
            while (num > 0)
            {
                sum += num %10;
                num /= 10;
            }
            num = sum;
        }
        return num;
    }

    public static void main(String[] args) {
        System.out.println(addDigits(708538619));
    }

}
