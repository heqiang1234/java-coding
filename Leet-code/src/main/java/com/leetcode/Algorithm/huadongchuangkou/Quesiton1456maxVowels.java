package com.leetcode.Algorithm.huadongchuangkou;

/**
 * @author heqiang
 * @date 2025年07月31日12:37
 */
public class Quesiton1456maxVowels {

    public int maxVowels(String s, int k) {
        char[] str = s.toCharArray();
        int res = 0, vmode = 0;
        for (int i = 0; i < s.length(); i++) {
            // 入窗口
            if (str[i] == 'a' ||
                    str[i] == 'e' ||
                    str[i] == 'i' ||
                    str[i] == 'o' ||
                    str[i] == 'u') {
                vmode++;
            }

            // 更新答案
            res = Math.max(res, vmode);

            // 没有达到窗口大小，则不出来
            if (i < k - 1) {
                continue;
            }

            // 有一个字母需要移动出窗口，需要判断是否是元音，如果是，则原因计数 - 1
            char ss = str[i - k + 1];
            if (ss == 'a' ||
                    ss == 'e' ||
                    ss == 'i' ||
                    ss == 'o' ||
                    ss == 'u') {
                vmode--;
            }
        }
        return res;
    }
}
