package com.leetcode.sginin;

import java.util.HashMap;

/**
 * @author: Mr.He
 * @create: 2022-09-27 08:50
 * @description: 面试题 01.02. 判定是否互为字符重排
 **/
public class Question0102CheckPermutation {

    public boolean CheckPermutation(String s1, String s2) {
        if (s1.length() != s2.length()){
            return false;
        }
        HashMap<Character,Integer> map = new HashMap<>();
        for (int i = 0; i < s1.length(); i++) {
            map.put(s1.charAt(i),map.getOrDefault(s1.charAt(i),0) + 1);
        }

        for (int i = 0; i < s2.length(); i++) {
            map.put(s2.charAt(i),map.getOrDefault(s2.charAt(i),0) - 1);
        }

        for (int num: map.values()) {
            if (num != 0){
                return false;
            }
        }
        return true;
    }

    public boolean CheckPermutation1(String s1, String s2) {
        if (s1.length() != s2.length()){
            return false;
        }
        int sum = 0, m =0;
        for (int i = 0; i < s1.length(); i++) {
            m ^= s1.charAt(i);
            sum += s1.charAt(i);
        }

        for (int i = 0; i < s2.length(); i++) {
            m ^= s2.charAt(i);
            sum -= s2.charAt(i);
        }
        if (m != 0) return false;
        if (sum == 0) return true;
        return false;
    }

}
