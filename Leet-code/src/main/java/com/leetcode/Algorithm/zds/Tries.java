package com.leetcode.Algorithm.zds;

/**
 * @author HQ
 * @program: java-coding
 * @description: 字典树
 * @date 2022-07-14 22:28:12
 */
public class Tries {

    //--start  数组实现字典树

    int[] count; //储存对应字母结尾的个数
    int index;//节点的个数
    int[][] tries; //储存字符
    int N = 100000;

    public Tries() {
        tries = new int[N][26];
        count = new int[N];
        index = 0;
    }

    public void insert(String str) {
        int p = 0;
        for (int i = 0; i < str.length(); i++) {
            int u = str.charAt(i) - 'a';
            //储存当前字符
            if (tries[p][u] == 0) tries[p][u] = ++index;
            //赋值下一位字符的位置为数组的值
            p = tries[p][u];
        }
        count[p]++;
    }

    public boolean search(String str) {
        int p = 0;
        for (int i = 0; i < str.length(); i++) {
            int u = str.charAt(i) - 'a';
            if (tries[p][u] == 0) return false;
            p = tries[p][u];
        }
        return count[p] != 0;
    }

    public boolean startWith(String str) {
        int p = 0;
        for (int i = 0; i < str.length(); i++) {
            int u = str.charAt(i) - 'a';
            if (tries[p][u] == 0) return false;
            p = tries[p][u];
        }
        return true;
    }

    //--end  数组实现字典树

    public static void main(String[] args) {
        Tries tries = new Tries();
        tries.insert("abcab");
        tries.insert("aa");
        tries.insert("abd");
        System.out.println(tries.toString());
    }
}
