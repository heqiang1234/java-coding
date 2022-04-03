package com.leetcode.all;

/**
 * @program: demo
 * @description: 209.字典树-使用树来实现
 * @author: Mr.He
 * @create: 2022-03-23 10:24
 **/
public class Question209TrieTreeNode {
    class TrieNode{
        boolean end;
        TrieNode [] trie = new TrieNode[26];
    };
    TrieNode root;
    public Question209TrieTreeNode(){
        root = new TrieNode();
    }

    public void insert(String word){
        TrieNode p = root;
        for (int i = 0; i < word.length(); i++) {
            int len = word.charAt(i) - 'a';
            if (p.trie[len] == null) p.trie[len] = new TrieNode();
            p = p.trie[len];
        }
        p.end = true;
    }

    public Boolean search(String word){
        TrieNode p = root;
        for (int i = 0; i < word.length(); i++) {
            int len = word.charAt(i) - 'a';
            if (p.trie[len] == null) return false;
            p = p.trie[len];
        }
        return p.end;
    }

    public Boolean startsWith(String prefix){
        TrieNode p = root;
        for (int i = 0; i < prefix.length(); i++) {
            int len = prefix.charAt(i) - 'a';
            if (p.trie[len] == null) return false;
            p = p.trie[len];
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
