package com.leetcode.specialProblem.tenxunjingxuan;

import org.springframework.boot.autoconfigure.mustache.MustacheTemplateAvailabilityProvider;

import java.util.*;

/**
 * @author HQ
 * @program: java-coding
 * @description: 20. 有效的括号
 * @date 2022-06-10 20:06:21
 *                  20:20:14
 */
public class Question20IsValid {

    public static boolean isValid(String s) {
        Stack<Character> queue = new Stack<>();
        String str = "([{";
        Map<Character, Character> mapCh = new HashMap<>();
        mapCh.put(')', '(');
        mapCh.put('}', '{');
        mapCh.put(']', '[');
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (str.contains(ch + "")) {
                queue.push(ch);
            } else {
                if (queue.size() > 0) {
                    char stCh = queue.pop();
                    if (mapCh.get(ch) != stCh) {
                        return false;
                    }
                } else {
                    return false;
                }

            }
        }
        if (queue.size() > 0) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isValid("]"));
    }

}
