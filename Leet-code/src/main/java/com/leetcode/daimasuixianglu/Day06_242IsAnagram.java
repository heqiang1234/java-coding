package com.leetcode.daimasuixianglu;

/**
 * @author: Mr.He
 * @create: 2022-10-17 15:11
 * @description: 242. 有效的字母异位词
 **/
public class Day06_242IsAnagram {

    public static boolean isAnagram(String s, String t) {
        if (s.length() != s.length()) return false;
        StringBuilder str = new StringBuilder(t);
        for (char ch : s.toCharArray()){
            System.out.println(str.indexOf(ch + ""));
        }
        return false;
    }

    public static void main(String[] args) {
        isAnagram("anagram","nagaram");
    }

}
