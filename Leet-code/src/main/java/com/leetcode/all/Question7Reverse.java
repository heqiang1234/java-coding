package com.leetcode.all;

/**
 * @author: Mr.He
 * @create: 2022-05-27 13:53
 * @description: 7. 整数反转
 **/
public class Question7Reverse {

    public static int reverse(int x) {
        if (x == 0) {
            return x;
        } else if (x < 0) {
            return -1 * doReverse(x);
        } else {
            return doReverse(x);
        }
    }

    public static int doReverse(int num) {
        num = Math.abs(num);
        StringBuilder str = new StringBuilder();
        while (num != 0) {
            str.append(num % 10);
            num = num / 10;
        }
       int res ;
        try{
            res =  Integer.parseInt(str.toString());
        }catch (Exception e){
            res = 0;
        }
       return res;
    }

    public static void main(String[] args) {
        System.out.println(reverse(123));
    }
}
