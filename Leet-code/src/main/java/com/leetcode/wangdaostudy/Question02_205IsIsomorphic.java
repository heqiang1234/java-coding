package com.leetcode.wangdaostudy;

import java.util.HashMap;

/**
 * @author HQ
 * @program: java-coding
 * @description: 205. 同构字符串
 * @date 2022-08-10 22:22:15
 */
public class Question02_205IsIsomorphic {

    public static boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        return isIsomorphicTwo(s, t) && isIsomorphicTwo(t, s);
    }

    public static boolean isIsomorphicTwo(String s, String t) {
        //建立映射关系
        HashMap<Character, Character> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            Character keyS = s.charAt(i);
            Character keyT = t.charAt(i);
            if (map.containsKey(keyS)) {
                if (keyT != map.get(keyS)) {
                    return false;
                }
            } else {
                map.put(keyS, keyT);
            }
        }
        return true;
    }


    public static void main(String[] args) {
        System.out.println(isIsomorphic("badc", "baba"));
    }

}
