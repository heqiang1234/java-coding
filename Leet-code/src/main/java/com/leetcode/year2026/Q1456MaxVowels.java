package com.leetcode.year2026;

/**
 * @author heqiang
 * @date 2026年05月19日15:23
 */
public class Q1456MaxVowels {

    /**
     * 请返回字符串 s 中长度为 k 的单个子字符串中可能包含的最大元音字母数。
     *
     * 英文中的 元音字母 为（a, e, i, o, u）。
     *
     *
     *
     * 示例 1：
     *
     * 输入：s = "abciiidef", k = 3
     * 输出：3
     * 解释：子字符串 "iii" 包含 3 个元音字母。
     * */
    public int maxVowels(String s, int k) {
        int res = 0,mode = 0;
        for (int i = 0; i < s.length(); i++) {

            // 新字段进入窗口
            if (s.charAt(i) == 'a' ||
                    s.charAt(i) == 'e' ||
                    s.charAt(i) == 'i' ||
                    s.charAt(i) == 'o' ||
                    s.charAt(i) == 'u'
            ){
                mode++;
            }

            // 统计现有的大小
            res = Math.max(res,mode);

            if (res == k) return k;

            if (i - k + 1 < 0) continue;

            // 需要出窗口，
            // 需要确定现有窗口的第一个字母的位置， 当前位置 i， 窗口长度 K，则窗口第一个字母的位序是。
            // 0，1，2，3，4 假设i = 3 窗口  2， 则第一个是 2 则 3- 2 + 1 = i- K+1
            if (s.charAt(i- k + 1) == 'a' ||
                    s.charAt(i- k + 1) == 'e' ||
                    s.charAt(i- k + 1) == 'i' ||
                    s.charAt(i- k + 1) == 'o' ||
                    s.charAt(i- k + 1) == 'u'
            ){
                mode--;
            }
        }
        return res;
    }
}
