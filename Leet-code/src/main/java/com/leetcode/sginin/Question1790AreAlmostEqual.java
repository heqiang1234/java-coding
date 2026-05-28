package com.leetcode.sginin;

/**
 * @author: Mr.He
 * @create: 2022-10-11 09:29
 * @description: 1790. 仅执行一次字符串交换能否使两个字符串相等
 **/
public class Question1790AreAlmostEqual {

    public static boolean areAlmostEqual(String s1, String s2) {
        int len1 = s1.length();
        int len2 = s2.length();
        if (len1 != len2){
            return false;
        }
        char oldA = ' ';
        char oldB = ' ';
        char newA = ' ';
        char newB = ' ';
        int count = 0;
        for (int i = 0; i < len1; i++) {
            if (s1.charAt(i) != s2.charAt(i)){
                if (count == 0){
                    oldA = s1.charAt(i);
                    newA = s2.charAt(i);
                } else {
                    oldB = s1.charAt(i);
                    newB = s2.charAt(i);
                }
                count++;
            }
            if (count >= 3){
                return false;
            }
        }
        if (oldA == newB && oldB == newA){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        String s1 = "attack", s2 = "defend";
        System.out.println(areAlmostEqual(s1, s2));
    }

}
