package com.leetcode.sginin;

import java.util.*;

/**
 * @program: java-coding
 * @description: 821. 字符的最短距离
 * @author: Mr.He
 * @create: 2022-04-19 20:48
 **/
public class Question821ShortestToChar {

    public static int[] shortestToChar(String s, char c) {
        int len = s.length();
        int[] res = new int[len];
        int index = 0;
        List<Integer> list = new ArrayList<>();
        char[] chars = s.toCharArray();
        for (int i = 0; i < len; i++) {
            if (chars[i] == c) {
                list.add(i);
            }
        }
        int countC = 0;//统计出现的字符的次数；根据这个来选取get的值。
        int lenC = list.size() - 1;
        for (int i = 0; i < len; i++) {
            if (chars[i] == c) {
                countC++;
                res[i] = 0;
                continue;
            }
            if (countC == 0) {
                res[i] = Math.abs(list.get(countC) - i);
            } else {
                if (countC > lenC){
                    countC = lenC;
                }
                int lastCount = countC > 0 ? countC - 1 : countC;
                res[i] = Math.min(Math.abs(list.get(countC) - i), Math.abs(list.get(lastCount) - i));
            }
        }
        return res;
    }

    //普通遍历
    public static int[] shortestToChar1(String s, char c){
        int len = s.length();
        int [] res = new int[len];
        Arrays.fill(res,Integer.MAX_VALUE);
        //从左到右先来一遍，进行判断。
        for (int i = 0,j = -1; i < len; i++) {
            if (s.charAt(i) == c) j = i;
            if (j != -1) res[i] = Math.min(res[i],i - j);
        }
        //从右到左，再来一遍。
        for (int i = len - 1,j = -1; i >=0 ; i--) {
            if (s.charAt(i) == c) j = i;
            if (j != -1) res[i] = Math.min(res[i],j - i);
        }

        return res;
    }

    //栈、BFS遍历
    public static int[] shortestToChar2(String s,char c){
        int n = s.length();
        int[] ans = new int[n];
        Arrays.fill(ans, -1);
        Deque<Integer> d = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == c) {
                d.addLast(i);
                ans[i] = 0;
            }
        }
        int[] dirs = new int[]{-1, 1};
        while (!d.isEmpty()) {
            int t = d.pollFirst();
            for (int di : dirs) {
                int ne = t + di;
                if (ne >= 0 && ne < n && ans[ne] == -1) {
                    ans[ne] = ans[t] + 1;
                    d.addLast(ne);
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(shortestToChar2("loveleetcode", 'e').toString());
    }

}
