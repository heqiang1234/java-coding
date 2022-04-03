package com.leetcode.interview;

import java.util.HashSet;
import java.util.Set;

/**
 * @program: demo
 * @description: 面试题 01.01. 判定字符是否唯一
 * @author: Mr.He
 * @create: 2021-12-02 10:56
 **/
public class Question01IsUnique {

    //通过数据结构，解决该问题
    public static boolean isUnique(String s) {
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            if (set.contains(s.charAt(i))) {
                return false;
            } else {
                set.add(s.charAt(i));
            }
        }
        return true;
    }

    //非数据结构解决问题
    //& 与  同为1，才为1，这样可以判断存在某一位是一样得值，说明之前出现一个1，我们后续出现得值，一定为1得，所以可以判断
    //|=   a |= b  相当于  a = a|b   |，只要有一个1，就为1，可以将之前出现过得1保存下来
    public static boolean isUniqueSecond(String s) {
        long high64 = 0;
        long low64 = 0;
        for (char c : s.toCharArray()) {
            if (c > 64) {
                long bitIndex = 1 << (c - 64);
                if ((high64 & bitIndex) != 0) {
                    return false;
                }
                high64 |= bitIndex;
            } else {
                long bitIndex = 1 << c;
                if ((low64 & bitIndex) != 0) {
                    return false;
                }
                low64 |= bitIndex;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isUniqueSecond("leetCode"));
    }
}
