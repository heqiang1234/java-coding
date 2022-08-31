package com.leetcode.wangdaostudylevel2;

import io.netty.util.internal.StringUtil;
import org.springframework.web.servlet.support.AbstractFlashMapManager;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 * @author HQ
 * @program: java-coding
 * @description: 43.字符串相乘
 * @date 2022-08-27 15:45:19
 */
public class Day2_Question43Multiply {

    // 我的想法是先逆字符串，这样可以保证可以进位
    public static String multiply(String num1, String num2) {
        String str1 = revertString(num1);
        String str2 = revertString(num2);
        int len1 = str1.length();
        int len2 = str2.length();
        int[] nums = new int[len1 + len2 + 1];
        for (int i = 0; i < len1; i++) {
            for (int j = 0; j < len2; j++) {
                int num = (str1.charAt(i) - '0') * (str2.charAt(j) - '0');
                nums[i + j] += num;
            }
        }
        int inex = 0;
        for (int i = 0; i < len1 + len2 + 1; i++) {
            nums[i] += inex;
            inex = nums[i] / 10;
            nums[i] %= 10;
        }
        StringBuilder resStr = new StringBuilder();
        boolean flag = true;
        for (int i = len1 + len2; i >= 0 ; i--) {
            if (nums[i] == 0 && flag){
                continue;
            } else {
                flag = false;
            }
            if (!flag){
                resStr.append(nums[i]);
            }
        }
        if (flag) resStr.append("0");
        return resStr.toString();
    }

    public static String revertString(String str) {
        StringBuilder stri = new StringBuilder();
        for (int i = str.length() - 1; i >= 0; i--) {
            stri.append(str.charAt(i));
        }
        return stri.toString();
    }

    public static void main(String[] args) {
        System.out.println(multiply("123", "456"));
    }

}
