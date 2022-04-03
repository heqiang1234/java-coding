package com.leetcode.all;

import java.util.HashSet;
import java.util.Set;

/**
 * @program: demo
 * @description: 720. 词典中最长的单词
 * @author: Mr.He
 * @create: 2022-03-17 15:42
 **/
public class Question720LongestWord {

    public static String Question720LongestWord(String[] words) {
//        Arrays.sort(words, (a,b) ->{
//            if (a.length() != b.length()){
//                return a.length() - b.length();
//            } else {
//                return b.compareTo(a);
//            }
//        });
//        (o1, o2) -> o2 - o1)

        // Arrays.sort(words,(o1, o2) -> o2.length() - o1.length() );
        // sort(words,0,words.length - 1);
        String res = "";
        Set<String> set = new HashSet<>();
        for (int i = 0; i < words.length; i++) {
            set.add(words[i]);
        }
        for (String str : words) {
            int len1 = str.length();
            int len2 = res.length();
            if (len1 < len2) {
                continue;
            }
            if (len1 == len2 && str.compareTo(res) > 0) {
                continue;
            }
            Boolean flag = true;
            for (int i = 0; i < str.length(); i++) {
                if (!set.contains(str.substring(0, str.length() - i))) {
                    flag = false;
                }
            }
            if (flag) {
                res = str;
            }
        }
        return res;
    }


    static class TrieNode {
        boolean end;
        TrieNode[] ans = new TrieNode[26];
    }

    static TrieNode root;

    public static String Question720LongestWord2(String[] words) {
        root = new TrieNode();
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            TrieNode p = root;
            for (int j = 0; j < word.length(); j++) {
                int len = word.charAt(j) - 'a';
                if (p.ans[len] == null) p.ans[len] = new TrieNode();
                p = p.ans[len];
            }
            p.end = true;
        }
        String res = "";
        Boolean flag;
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            TrieNode p = root;
            flag = true;
            for (int j = 0; j < word.length(); j++) {
                int len = word.charAt(j) - 'a';
                if (p.ans[len] != null) {
                    p = p.ans[len];
                    if (!p.end) {
                        flag = false;
                        break;
                    }
                } else {
                    flag = false;
                }
            }
            if (flag ) {
                if (res.length() == word.length()){
                    if (res.compareTo(word) > 0){
                        res = word;
                    }
                } else if (res.length() < word.length()){
                    res = word;
                }
            }

        }
        return res;
    }


    public static void main(String[] args) {
        String[] res = {"b","br","bre","brea","break","breakf","breakfa","breakfas","breakfast","l","lu","lun","lunc","lunch","d","di","din","dinn","dinne","dinner"};
        System.out.println(Question720LongestWord2(res));
    }
}
