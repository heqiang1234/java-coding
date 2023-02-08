package com.leetcode.year2023.randomdayproblem;

import java.util.Arrays;

/**
 * @author: Mr.He
 * @create: 2023-02-08 17:05
 * @description: 1170.比较字符串最小字母出现频次
 **/
public class Question1170NumSmallerByFrequency {

    public static int[] numSmallerByFrequency(String[] queries, String[] words) {
        int [] quer = new int[queries.length];
        int [] word = new int[words.length];
        for (int i = 0; i < queries.length; i++) {
            quer[i] = f(queries[i]);
        }

        for (int i = 0; i < words.length; i++) {
            word[i] = f(words[i]);
        }

        int [] res = new int[queries.length];
        for (int i = 0; i < res.length; i++) {
            int num = quer[i];
            int count = 0;
            for (int j = 0; j < words.length; j++) {
                if (num < word[j]){
                    count++;
                }
            }
            res[i] = count;
        }
        return res;
    }

    public static int f(String word) {
        int count = 1;
        char temp = word.charAt(0);
        for (int i = 1; i < word.length(); i++) {
            char ch = word.charAt(i);
            if ( temp == ch){
                count++;
            } else if (temp < ch){
                count = 1;
                temp = ch;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] ints = numSmallerByFrequency(new String[]{"bba","abaaaaaa","aaaaaa","bbabbabaab","aba","aa","baab","bbbbbb","aab","bbabbaabb"}, new String[]{"aaabbb","aab","babbab","babbbb","b","bbbbbbbbab","a","bbbbbbbbbb","baaabbaab","aa"});
        System.out.println(Arrays.stream(ints).iterator());
    }

}
