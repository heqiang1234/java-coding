package com.leetcode.year2023.signin;

/**
 * @author HQ
 * @program: java-coding
 * @description: 2696.删除子串后的字符串最小长度
 * @date 2024-01-10 08:40:58
 */
public class Qustion2696MinLength {
    public int minLength(String s) {
        int count = s.length() - 1;//记录长度
        int beginIndex = 0;//左指针初始位置
        int endIndex = s.length() - 1;//右指针初始位置
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == 'A' && s.charAt(i + 1) == 'B' ||
                    (s.charAt(i) == 'C' && s.charAt(i + 1) == 'D')) {
                endIndex = i;
            }
            count = Math.min(endIndex - beginIndex,count);
        }

        return count;
    }
}
