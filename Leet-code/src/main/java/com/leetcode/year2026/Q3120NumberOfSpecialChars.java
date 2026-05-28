package com.leetcode.year2026;

import java.util.HashSet;

/**
 * @author heqiang
 * @date 2026年05月26日15:40
 */
public class Q3120NumberOfSpecialChars {

    public static int numberOfSpecialChars(String word) {
        int count = 0;
        HashSet<Object> set = new HashSet<>();
        for (char ch : word.toCharArray()){
            // 改变，大变小，
            if (set.contains(ch)){
                continue;
            }
            if ((set.contains((char )(ch - 32) ) )
                    || (set.contains((char )(ch + 32)))){
                count++;
            }
            set.add(ch);
        }
        return count;
    }

    public static int numberOfSpecialChars2(String word) {
        int count = 0;
        int[] mask = new int[2]; // 大写字母集合，小写字母集合
        for (char c : word.toCharArray()){
            // 用 c>>5&1 区分大小写， c&31 获取c是第几个字母
            mask[c>> 5 & 1] |= 1 << (c & 31);
        }
        return Integer.bitCount(mask[0] & mask[1]);
    }

    public static void main(String[] args) {
        System.out.println((char)97);
        System.out.println(numberOfSpecialChars("aaAbcBC"));
    }

}
