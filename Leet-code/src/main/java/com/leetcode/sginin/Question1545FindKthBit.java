package com.leetcode.sginin;

import com.sun.deploy.util.StringUtils;

/**
 * @author heqiang
 * @date 2026年03月03日15:51
 */
public class Question1545FindKthBit {

    public static char findKthBit(int n, int k) {
        // 构造出这个字符串
        StringBuilder str = new StringBuilder("0");
        String s0 = "0";
        int index = 0;
        for (int i = 2; i <= n; i++) {
           // str.append(str.toString());
            s0 = str.toString();
            str.append("1");
            str.append(reverse(invert(s0)));
            int cc = 2 * ((i - 1) - 1) + 1;
            index += cc;
        }

        return str.charAt(k -1);
    }

    public static String invert(String sn) {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < sn.length(); i++) {
            if (sn.charAt(i) == '0') {
                s.append('1');
            } else
                s.append('0');
        }
        return s.toString();
    }

    public static String reverse(String sn) {
        StringBuilder s = new StringBuilder();
        for (int i = sn.length() - 1; i >= 0; i--) {
                s.append(sn.charAt(i));
        }
        return s.toString();
    }


    public static void main(String[] args) {
        System.out.println(findKthBit(4, 11));
    }


}
