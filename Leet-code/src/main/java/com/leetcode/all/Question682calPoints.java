package com.leetcode.all;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @program: demo
 * @description: 682. 棒球比赛
 * @author: Mr.He
 * @create: 2022-03-26 13:14
 **/
public class Question682calPoints {

    public static int calPoints(String[] ops) {
        String str = "C,D,+";
        Stack<Integer> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < ops.length; i++) {
            if (str.contains(ops[i])) {
                int len = list.size();
                if (ops[i].equals("C")) {
                    list.remove(len - 1);
                }
                if (ops[i].equals("D")) {
                    int temp = list.get(len - 1);
                    list.add(temp * 2);
                }
                if (ops[i].equals("+")) {
                    list.add(list.get(len - 1) + list.get(len - 2));
                }
            } else {
                list.add(Integer.parseInt(ops[i]));
            }
        }
        int sum = 0;
        for (int i = 0; i < list.size(); i++) {
            sum += list.get(i);
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(calPoints(new String[]{"5", "2", "C", "D", "+"}));
    }

}
