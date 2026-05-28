package com.leetcode.year2023.signin;

import java.util.*;

/**
 * @author: Mr.He
 * @create: 2023-02-08 08:42
 * @description: 1233.删除子文件夹
 **/
public class Question1233RemoveSubfolders {

    static class Trie {
        class TrieNode {
            TrieNode[] son;
            Boolean isEnd;

            public TrieNode() {
                //初始化将son定义为26个字符。局限性
                son = new TrieNode[26];
            }
        }

        TrieNode root;

        //初始化Trie
        public Trie() {
            root = new TrieNode();
        }

        //插入字符
        public void insert(String word) {
            //如果字符为空，则直接返回，不进行任何的处理
            if (word.length() == 0 || word == null)
                return;
            //每次使用一个新的node
            TrieNode node = root;
            for (int i = 0; i < word.length(); i++) {
                int index = word.charAt(i) - 'a';
                //如果此时对应的字符位等于null,说明没有任何字符到过这里
                if (node.son[index] == null) {
                    //将为空的地方复制一个trieNode
                    node.son[index] = new TrieNode();
                }
                //移动node到下一个字符位置
                node = node.son[index];
            }
            //此时遍历完所有的字符，则将该位置的node,置为true
            node.isEnd = true;
        }

        //查找字符
        public boolean search(String word) {
            //如果字符为空，则直接返回，不进行任何的处理
            if (word.length() == 0 || word == null)
                return true;
            TrieNode node = root;
            for (int i = 0; i < word.length(); i++) {
                int index = word.charAt(i) - 'a';
                //如果该字符位置没有东西，则说明该字符没有存在，返回false
                if (node.son[index] == null) {
                    return false;
                }
                //移动到下一个字符位置
                node = node.son[index];
            }
            //遍历完字符串的所有字符，如果位true,则说明该字符串出现过。
            return node.isEnd == true;
        }

        //前缀字符查找
        public boolean prefixSearch(String word) {
            TrieNode node = root;
            for (int i = 0; i < word.length(); i++) {
                int index = word.charAt(i) - 'a';
                //查找字符
                if (node.son[index] == null) {
                    return false;
                }
                //移动node
                node = node.son[index];
            }
            return true;
        }
    }

    static class TrieHash {
        class TrieHashNode {
            Map<Character, TrieHashNode> sonMap;
            boolean isTrue;

            public TrieHashNode() {
                sonMap = new HashMap<>();
            }
        }

        TrieHashNode rt;

        public TrieHash() {
            rt = new TrieHashNode();
        }

        //插入字符到hash表
        public void insertHash(String word) {
            TrieHashNode node = rt;
            for (int i = 0; i < word.length(); i++) {
                Character ch = word.charAt(i);
                if (!node.sonMap.containsKey(ch)) {
                    node.sonMap.put(ch, new TrieHashNode());
                }
                node = node.sonMap.get(ch);
            }
            node.isTrue = true;
        }

        //查找字符
        public Boolean searchHash(String word) {
            TrieHashNode node = rt;
            for (int i = 0; i < word.length(); i++) {
                Character ch = word.charAt(i);
                if (!node.sonMap.containsKey(ch)) {
                    return false;
                }
                node = node.sonMap.get(ch);
            }
            return node.isTrue == true;
        }

        //前缀查找
        public boolean perfixSearchHash(String word) {
            TrieHashNode node = rt;
            for (int i = 0; i < word.length(); i++) {
                Character ch = word.charAt(i);
                if (node.isTrue == true && ch == '/')
                    return true;

                if (!node.sonMap.containsKey(ch)) {
                    return false;
                }

                node = node.sonMap.get(ch);
            }
            return true;
        }
    }

    public static List<String> removeSubfolders(String[] folder) {
        List<String> res = new ArrayList<>();
        sortString(folder, 0, folder.length - 1);
        TrieHash trie = new TrieHash();
        for (int i = 0; i < folder.length; i++) {
            String str = folder[i];
            if (!trie.perfixSearchHash(str)) {
                res.add(str);
                trie.insertHash(str);
            }
        }
        return res;
    }

    //quicksort
    public static void sortString(String[] folders, int left, int right) {
        if (left > right) {
            return;
        }
        int base = folders[left].length();
        String baseStr = folders[left];
        int i = left;
        int j = right;
        while (i != j) {
            while (folders[j].length() >= base && i < j) {
                j--;
            }
            while (folders[i].length() <= base && i < j) {
                i++;
            }
            String temp = folders[i];
            folders[i] = folders[j];
            folders[j] = temp;
        }

        folders[left] = folders[i];

        folders[i] = baseStr;
        sortString(folders, left, i - 1);
        sortString(folders, j + 1, right);
    }

    public static void main(String[] args) {
        List<String> list = removeSubfolders(new String[]{"/ah/al/am","/ah/al"});
        System.out.println(list.stream().toString());
    }

}
