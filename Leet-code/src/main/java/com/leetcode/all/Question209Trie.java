package com.leetcode.all;

/**
 * @program: demo
 * @description: 209.实现字典树
 * @author: Mr.He
 * @create: 2022-03-23 09:35
 **/
public class Question209Trie {

    int N = 100005;
    public int [][] trie;
    public int [] count;
    int index;

    public Question209Trie() {
        trie = new int[N][26];
        count = new int[N];
        index = 0;
    }

    public void insert(String word) {
        int p = 0;
        for (int i = 0; i < word.length(); i++) {
            int len = word.charAt(i) - 'a';
            if (trie[p][len] == 0){
                trie[p][len] = ++index;
            }
            p = trie[p][len];
        }
        count[p]++;
    }

    public boolean search(String word) {
        int p = 0;
        for (int i = 0; i < word.length(); i++) {
            int len = word.charAt(i) - 'a';
            if (trie[p][len] == 0) return false;
            p = trie[p][len];
        }
        return count[p] != 0;
    }

    public boolean startsWith(String prefix) {
        int p = 0;
        for (int i = 0; i < prefix.length(); i++) {
            int len = prefix.charAt(i) - 'a';
            if (trie[p][len] == 0) return false;
            p = trie[p][len];
        }
        return true;
    }

    public static void main(String[] args) {
        Question209Trie trie = new Question209Trie();
        trie.insert("apple");
        System.out.println(trie.search("apple"));
        System.out.println(trie.search("app"));
        System.out.println(trie.startsWith("app"));
        trie.insert("app");
        System.out.println(trie.search("app"));

    }
}
