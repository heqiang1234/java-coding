package com.leetcode.Algorithm.zds;

import java.util.List;

/**
 * @author HQ
 * @program: java-coding
 * @description: 139.单词拆分
 * @date 2022-07-16 16:17:23
 */
public class Question139WordBreak {

    class TrieNode{
        boolean end;
        TrieNode [] node = new TrieNode[26];
    }

    TrieNode trie;

    public void insert(String val){
        TrieNode p = trie;
        for (int i = 0; i < val.length(); i++) {
            int u = val.charAt(i) - 'a';
            if (p.node[u] == null) p.node[u] = new TrieNode();
            p = p.node[u];
        }
        p.end = true;
    }

    public boolean search(String val){
        TrieNode p = trie;
        for (int i = 0; i < val.length(); i++) {
            int u = val.charAt(i) - 'a';
            if (p.node[u] == null) return false;
            p = p.node[u];
        }
        return p.end;
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        int len = s.length();
        insert(s);



        return false;
    }

}
