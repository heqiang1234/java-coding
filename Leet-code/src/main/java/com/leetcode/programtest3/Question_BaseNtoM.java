package com.leetcode.programtest3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author: Mr.He
 * @create: 2022-09-19 09:28
 * @description: 从10转换为任意进制，从任意进制转换为10进制
 **/
public class Question_BaseNtoM {

    /**
     * 从10进制转换到任意进制
     *
     * @param num 10进制数字
     * @param n   需要转换为的进制，目标进制
     * @return 返回N进制的字符串
     */
    public static String Base10toBaseN(int num, int n) {
        StringBuilder res = new StringBuilder();//最后的结果返回字段
        List<Character> tempStr = new ArrayList<>();//储存得到的字符，便于后续翻转
        String chars = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";//进制的数字集合
        //短除法
        while (num > 0) {
            int numT = num % n; //余数当次使用
            num = num / n;//除数下次使用
            tempStr.add(chars.charAt(numT));
        }
        //反转
        for (int i = tempStr.size() - 1; i >= 0; i--) {
            res.append(tempStr.get(i));
        }
        return res.toString();
    }


    /**
     * 乘法   例如 22进制的 4C 转换为10进制，  C * 22 ^ 0 + 4 * 22 ^ 1
     * @param num N进制数字的字符串
     * @param n   表示当前字符串为几进制
     * @return 返回10进制的数字
     */
    public static int BaseNtoBase10(String num, int n) {
        // StringBuilder res = new StringBuilder();
        // for (int i = num.length() - 1; i >= 0 ; i--) {
        //     res.append(num.charAt(i));
        // }
        int sum = 0;
        int len = num.length() -1;
        for (int i = 0; i < len; i++) {
            sum = (sum + (num.charAt(i) > '9' ? num.charAt(i) - 'A' + 10 :num.charAt(i) - '0')) * n;
        }
        if (num.charAt(len) > '9'){
            sum += num.charAt(len) - 'A' + 10;
        } else {
            sum += num.charAt(len) - '0';
        }
        return sum;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
       int num =  sc.nextInt();
       int n = sc.nextInt();
        System.out.println(Base10toBaseN(num, n));
        System.out.println(BaseNtoBase10("4AA1",22));
    }
}
