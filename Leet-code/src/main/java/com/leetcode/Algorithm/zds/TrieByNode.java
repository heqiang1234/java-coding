package com.leetcode.Algorithm.zds;

import com.leetcode.model.TreeNode;

/**
 * @author HQ
 * @program: java-coding
 * @description: Node实现字典树
 * @date 2022-07-14 22:53:51
 * Node实现了字典树
 */
public class TrieByNode {

    class TrieNode {
        boolean end;//当前是否是结尾
        TrieNode[] node = new TrieNode[26];
    }

    TrieNode root;

    public TrieByNode() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode p = root;
        for (int i = 0; i < word.length(); i++) {
            int u = word.charAt(i) - 'a';
            if (p.node[u] == null) p.node[u] = new TrieNode();
            p = p.node[u];
        }
        p.end = true;
    }

    public boolean search(String word) {
        TrieNode p = root;
        for (int i = 0; i < word.length(); i++) {
            int u = word.charAt(i) - 'a';
            if (p.node[u] == null) return false;
            p = p.node[u];
        }
        return p.end;
    }

    public boolean startsWith(String prefix) {
        TrieNode p = root;
        for (int i = 0; i < prefix.length(); i++) {
            int u = prefix.charAt(i) - 'a';
            if (p.node[u] == null) return false;
            p = p.node[u];
        }
        return true;
    }
}
