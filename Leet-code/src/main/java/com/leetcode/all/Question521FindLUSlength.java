package com.leetcode.all;

/**
 * @program: demo
 * @description: 521. 最长特殊序列 Ⅰ
 * @author: Mr.He
 * @create: 2022-03-05 14:58
 **/
public class Question521FindLUSlength {

    public static int findLUSlength(String a, String b) {
        return a.equals(b) ? -1 : Math.max(a.length(),b.length());
    }

    public static void main(String[] args) {
        System.out.println(findLUSlength("abc", "dcb"));
    }
}
