package com.leetcode.all;

/**
 * @program: demo
 * @description: 6. Z 字形变换
 * @author: Mr.He
 * @create: 2022-03-01 09:51
 **/
public class Question06Convert {

    public static String convert(String s, int numRows) {
        if (numRows < 2) return s;
        StringBuilder[] str = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            str[i] = new StringBuilder();
        }
        int index = 0, flag = -1;
        for (char c : s.toCharArray()) {
            str[index].append(c);
            if (index == 0 || index == numRows - 1) flag = -flag;
            index += flag;
        }
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            res.append(str[i].toString());
        }
        return res.toString();
    }


    public static void main(String[] args) {
        System.out.println(convert("PAYPALISHIRING", 3));
    }
}
