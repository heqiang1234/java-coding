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

        quickSort(quer,0,quer.length - 1);
        quickSort(word,0,word.length - 1);
        int [] res = new int[queries.length];
        for (int i = 0; i < res.length; i++) {
            int num = quer[i];
            int count = 0;
            for (int j = 0; j < words.length; j++) {
                if (num < word[j]){
                    count = words.length - j - 1;
                    break;
                }
            }
            res[i] = count;
        }
        return res;
    }

    public static void quickSort(int [] nums,int left,int right){
        if (left > right)
            return;
        int baseNum = nums[left];
        int i = left;
        int j = right;
        while (i != j){
            while (nums[j] >= baseNum && i < j){
                j--;
            }
            while (nums[i] <= baseNum && i < j){
                i++;
            }
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
        nums[left] = nums[i];

        nums[i] = baseNum;
        quickSort(nums,left,i-1);
        quickSort(nums,j + 1,right);
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
