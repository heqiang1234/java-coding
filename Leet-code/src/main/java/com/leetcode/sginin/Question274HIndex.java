package com.leetcode.sginin;

import java.util.Arrays;

public class Question274HIndex {

    public int hIndex(int[] citations) {
        Arrays.sort(citations);

        int len = citations.length; // 表示总的出了几篇论文
        // 0,1,3,5,6
        // 100
        // 1,1,3
        // 0,0,2
        int res = 0;
        for (int i = 0; i < len; i++) {
            // 当前位置的值 ，小于等于 len - i，表示可以。
            if (citations[i] >= (len - i)) {
                return len - i;
            }
        }
        return res;
    }
}
