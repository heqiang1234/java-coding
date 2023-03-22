package com.leetcode.year2023.weekcontest;

import java.util.HashMap;

/**
 * @author HQ
 * @program: java-coding
 * @description: 2564. 子字符串异或查询
 * @date 2023-02-16 21:48:07
 */
public class Question2564SubstringXorQueries {

    public static int[][] substringXorQueries(String s, int[][] queries) {
        int[][] resNum = new int[queries.length][2];
        HashMap<Integer, int[]> hashMap = new HashMap<>();
        int len = s.length();
        int m = s.indexOf('0');
        if (m >= 0) hashMap.put(0, new int[]{m, m});//将0排除
        char[] st = s.toCharArray();
        //普通的运用内置方法
//        for (int i = 0; i < len; i++) {
//            if (s.charAt(i) == '0') {
//                if (!hashMap.containsKey(0)) {
//                    hashMap.put(0, new int[]{i, i});
//                }
//                continue;
//            }
//
//            for (int j = 1; j <= 31 && i + j <= len; j++) {
//                int num = Integer.valueOf(s.substring(i, i + j), 2);
//                if (hashMap.containsKey(num)) {
//                    continue;
//                } else {
//                    hashMap.put(num, new int[]{i, i + j - 1});
//                }
//            }
//        }
        //使用位运算
        for (int i = 0; i < len; i++) {
            if (st[i] == '0') continue;
            for (int j = i, x = 0; j < Math.min(i + 30, len); j++) {
                x = x << 1 | (st[j] & 1);//这个有些精髓   ‘101’  变化过程为  1，10，101
                hashMap.putIfAbsent(x, new int[]{i, j});
            }
        }
        for (int i = 0; i < queries.length; i++) {
            resNum[i] = hashMap.getOrDefault(queries[i][0] ^ queries[i][1], new int[]{-1, -1});
        }
        return resNum;
    }

    public static void main(String[] args) {
        substringXorQueries("101101", new int[][]{{0, 5}, {1, 2}});
    }

}
