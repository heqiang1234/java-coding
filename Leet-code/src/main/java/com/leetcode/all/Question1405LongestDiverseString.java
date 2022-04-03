package com.leetcode.all;

import java.util.Arrays;

/**
 * @program: demo
 * @description: 1405. 最长快乐字符串
 * @author: Mr.He
 * @create: 2022-02-07 20:37
 **/
public class Question1405LongestDiverseString {


    public static class Pair {
        char aChar;
        int count;

        public  Pair(int count, char aChar) {
            this.aChar = aChar;
            this.count = count;
        }
    }

    public static String longestDiverseString(int a, int b, int c) {

        Pair[] pair = {new Pair(a, 'a'), new Pair(b, 'b'), new Pair(c, 'c')};
        StringBuilder str = new StringBuilder();
        while (true) {
            Arrays.sort(pair, (p1, p2) -> p2.count - p1.count);
            boolean flag = false;
            for (Pair p : pair) {
                if (p.count <= 0) {
                    break;
                }

                int len = str.length();
                if (len >= 2 && str.charAt(len - 1) == p.aChar && str.charAt(len - 2) == p.aChar) {
                    continue;
                }
                flag = true;
                str.append(p.aChar);
                p.count--;
                break;
            }
            if (!flag) {
                break;
            }
        }
        return str.toString();
    }

    public static void main(String[] args) {
        System.out.println(longestDiverseString(1, 1, 7));
    }
}
