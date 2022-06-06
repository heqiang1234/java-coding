package com.leetcode.all;

/**
 * @author: Mr.He
 * @create: 2022-05-27 16:38
 * @description: 8. 字符串转换整数 (atoi)
 **/
public class Question08MyAtoi {

    public static int myAtoi(String s) {
        int len = s.length();
        if (len <= 0) {
            return 0;
        }
        StringBuilder str = new StringBuilder();
        Boolean isBigZero = true;
        int numLen = 0, numChF = 0;
        for (int i = 0; i < len; i++) {
            char ch = s.charAt(i);
            if (ch >= '0' && ch <= '9') {
                str.append(ch);
                numLen++;
            }  else if (numLen > 0 || numChF > 0) {
                break;
            } else if (ch == '-' || ch == '+') {
                isBigZero = ch == '-' ? false : true;
                numChF++;
            } else if (numLen == 0 && ch != ' ') {
                break;
            }
        }
        int lenStr = str.toString().length();
        long num = 0;
        for (int i = 0; i < lenStr; i++) {
            char trmp = str.charAt(i);
            num = num * 10 + trmp - '0';
            num = isBigZero ? Math.min(num, (long) Integer.MAX_VALUE) : Math.min(num, -(long) Integer.MIN_VALUE);
        }
        return isBigZero ? (int) num : -1 * (int) num;
    }

    public static void main(String[] args) {
        System.out.println(myAtoi("  +-42"));
    }

}

