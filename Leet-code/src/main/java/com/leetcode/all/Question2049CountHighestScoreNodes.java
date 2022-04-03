package com.leetcode.all;

import java.util.Arrays;

/**
 * @program: demo
 * @description: 2049. 统计最高分的节点数目
 * @author: Mr.He
 * @create: 2022-03-11 20:55
 **/
public class Question2049CountHighestScoreNodes {
    public static int countHighestScoreNodes(int[] parents) {
        int ans = 0;
        int len = parents.length;
        int []num = new int[len];
        Arrays.fill(num,0);
        for (int i = 0; i < len; i++) {
            if (parents[i] != -1) {
                num[parents[i]]++;
                if (num[parents[i]] == 2) {
                    ans++;
                }
            }
        }
        return len - ans;
    }

    public static void main(String[] args) {
        System.out.println(countHighestScoreNodes(new int[]{-1, 2, 0}));
    }
}
