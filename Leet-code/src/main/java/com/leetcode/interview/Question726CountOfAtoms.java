package com.leetcode.interview;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @program: demo
 * @description: 726. 原子的数量
 * @author: Mr.He
 * @create: 2021-12-27 17:21
 **/
public class Question726CountOfAtoms {

    public static String countOfAtoms(String formula) {
        if (formula == null || formula.length() <= 0) {
            return "";
        }

        char[] mas = new char[formula.length()];
        for (int i = 0; i < formula.length(); i++) {
            mas[i] = formula.charAt(i);
            System.out.println(mas[i]);
        }

        for (int i = 0; i < mas.length; i++) {
            if (mas[i] == '(') {

            }
        }
        Map<String, Integer> res = new HashMap<>();

        return "";
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        countOfAtoms(s);
    }

}
