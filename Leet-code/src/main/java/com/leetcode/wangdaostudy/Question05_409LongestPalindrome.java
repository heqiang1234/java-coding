package com.leetcode.wangdaostudy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;

/**
 * @author HQ
 * @program: java-coding
 * @description: 409. 最长回文串
 * @date 2022-08-16 22:39:04
 */
public class Question05_409LongestPalindrome {

    public int longestPalindrome(String s) {
//        HashMap<Character,Integer> res= new HashMap<>();
//        for (int i = 0; i < s.length(); i++) {
//            Character ch = s.charAt(i);
//            res.put(ch,res.getOrDefault(ch,0) + 1);
//        }
        int[] chars = new int[128];
        Arrays.fill(chars,0);
        for (int i = 0; i < s.length(); i++) {
            chars[s.charAt(i)]++;
        }
        int count = 0;
        for (int i = 0; i < chars.length; i++) {
            count += chars[i] % 2;
        }

        return count == 0 ? s.length() : s.length() - count + 1;
    }

}
