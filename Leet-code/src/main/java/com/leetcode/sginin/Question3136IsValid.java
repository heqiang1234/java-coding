package com.leetcode.sginin;

public class Question3136IsValid {

    public boolean isValid(String word) {
        // 检查长度，小于3，则退出
        if (word.length() < 3) {
            return false;
        }
        String str1 = "aeiouAEIOU";
        boolean str1_bool = false;
        boolean str2_bool = false;
        // 只包含0-9，a-z
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if ((ch >= '0' && ch <= '9')) {

            } else if ((ch >= 'a' && ch <= 'z')
                    || (ch >= 'A' && ch <= 'Z')) {
                if (str1.contains(ch + "")) {
                    str1_bool = true;
                } else {
                    str2_bool = true;
                }
            } else {
                return false;
            }
        }

        return str1_bool && str2_bool;
    }
}
