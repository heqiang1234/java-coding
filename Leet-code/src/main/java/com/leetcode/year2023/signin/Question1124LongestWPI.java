package com.leetcode.year2023.signin;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author HQ
 * @program: java-coding
 * @description: 1124. 表现良好的最长时间段
 * @date 2023-02-15 21:09:09
 */
public class Question1124LongestWPI {

    public static int longestWPI(int[] hours) {
        int ans = 0,len = hours.length;
        Deque<Integer> st = new ArrayDeque<>();
        int[] n = new int[hours.length + 1];
        n[0] = 0;
        st.push(0);
        for (int i = 1; i <= len; i++) {
            n[i] = n[i - 1] + (hours[i - 1] > 8 ? 1 : -1);
            if (n[i] < n[st.peek()]) st.push(i);
        }

        for (int i = len; i >= 0; i--) {
            while (!st.isEmpty() && n[i] > n[st.peek()]) {
                ans = Math.max(ans, i - st.pop());
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        longestWPI(new int[]{9,9,6,0,6,6,9});
    }

}
