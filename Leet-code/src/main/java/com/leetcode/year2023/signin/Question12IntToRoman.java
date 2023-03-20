package com.leetcode.year2023.signin;

/**
 * @author HQ
 * @program: java-coding
 * @description: 12.整数转罗马数字
 * @date 2023-03-20 21:55:10
 */
public class Question12IntToRoman {

    static int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    static String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

    public static String intToRoman(int num) {
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < values.length; i++) {
            int value = values[i];
            while (num >= value){
                num -= value;
                str.append(symbols[i]);
            }
            if (num == 0){
                break;
            }
        }
        return str.toString();
    }

    public static void main(String[] args) {
        System.out.println(intToRoman(1994));
    }


}
