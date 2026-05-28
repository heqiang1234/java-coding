package com.leetcode.sginin;

import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.List;

/**
 * @author HQ
 * @program: java-coding
 * @description: 745.前缀和后缀搜索
 * @date 2022-07-14 20:47:00
 */
public class Question745WordFilter {


    class TrieNode {
        List<Integer> idx = new ArrayList<>();
        TrieNode[] node = new TrieNode[26];
    }

    TrieNode tr1 = new TrieNode(), tr2 = new TrieNode();

    //顺序的存储
    public void insert(TrieNode trieNode, String str, int idx, boolean actionFlag) {
        TrieNode p = trieNode;
        p.idx.add(idx);
        int len = str.length() - 1;
        for (int i = actionFlag ? 0 : len; i >= 0 && i <= len; i += actionFlag ? 1 : -1) {
            int u = str.charAt(i) - 'a';
            if (p.node[u] == null) p.node[u] = new TrieNode();
            p = p.node[u];
            p.idx.add(idx);
        }
    }

    public Question745WordFilter(String[] words) {
        for (int i = 0; i < words.length; i++) {
            insert(tr1, words[i], i, true);
            insert(tr2, words[i], i, false);
        }
    }

    public int query(String pref, String suff) {
        TrieNode p = tr1;
        for (int i = 0; i < pref.length(); i++) {
            int u = pref.charAt(i) - 'a';
            if (p.node[u] == null) return -1;
            p = p.node[u];
        }
        List<Integer> list1 = p.idx;
        p = tr2;
        for (int i = suff.length() - 1; i >= 0; i--) {
            int u = suff.charAt(i) - 'a';
            if (p.node[u] == null) return -1;
            p = p.node[u];
        }
        List<Integer> list2 = p.idx;
        int len1 = list1.size(), len2 = list2.size();
        for (int i = len1 - 1, j = len2 - 1; i >= 0 && j >= 0; ) {
            if (list1.get(i) > list2.get(j)) i--;
            else if (list1.get(i) < list2.get(j)) j--;
            else return list1.get(i);
        }
        return -1;
    }

    public int f(String pref, String suff) {
        return query(pref, suff);
    }


    public static void main(String[] args) {
        //["WordFilter","f"]
        //[[["abbba","abba"]],["ab","ba"]]
        Question745WordFilter wordFilter = new Question745WordFilter(new String[]{"abbba", "abba"});
        System.out.println(wordFilter.f("ab", "ba"));
    }
}
