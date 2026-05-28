package com.leetcode.sginin;

/**
 * @author heqiang
 * @date 2025年06月04日9:51
 */
public class Question3403AnswerString {
    public static String answerString(String word, int numFriends) {
        if (numFriends == 1) {
            return word;
        }

        String res = "";
        int n = word.length();
        for (int i = 0; i < n; i++) {
            String s = word.substring(i, Math.min(i + n - numFriends + 1, n));
            if (res.compareTo(s) <= 0) {
                res = s;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(answerString("dbca", 2));
    }
}
