package com.leetcode.wangdaostudylevel2;

import io.netty.util.internal.StringUtil;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 * @author HQ
 * @program: java-coding
 * @description: 43.字符串相乘
 * @date 2022-08-27 15:45:19
 */
public class Day2_Question43Multiply {

    public String multiply(String num1, String num2) {
        String str1 = revertString(num1);
        String str2 = revertString(num2);
        int len1 = str1.length();
        int len2 = str2.length();
        int maxlen = len1 > len2 ? len1 : len2;
        int minlen = len1 + len2 - maxlen;
        StringBuilder resStr = new StringBuilder();
        for (int i = 0; i < minlen; i++) {
            for (int j = 0; j < maxlen; j++) {
                int num = (num1.charAt(i) - '0') * (num1.charAt(j) - '0');
                
            }
        }
    }

    public String revertString(String str){
        StringBuilder stri = new StringBuilder();
        for (int i = str.length() - 1; i  >= 0 ; i--) {
            stri.append(str.charAt(i));
        }
        return stri.toString();
    }

}
