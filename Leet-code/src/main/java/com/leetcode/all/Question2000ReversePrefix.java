package com.leetcode.all;

/**
 * @author HQ
 * @program: demo
 * @description: 2000. 反转单词前缀
 * @date 2022-02-02 13:37:56
 */
public class Question2000ReversePrefix {

    public static String reversePrefix(String word, char ch) {
        StringBuilder resStr = new StringBuilder();
        int temp = 0;
        int strLen = word.length();
        for (int i = 0; i < strLen; i++) {
            if (word.charAt(i) == ch) {
                temp = i;
                break;
            }
        }
        if (temp == 0) {
            return word;
        } else {
            resStr.append(revert(word.substring(0, temp + 1)));
            resStr.append(word.substring(temp + 1, strLen));
        }
        return resStr.toString();
    }

    public static String revert(String str) {
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = str.length() - 1; i >= 0; i--) {
            stringBuilder.append(str.charAt(i));
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        String word = "abcd";
        char ch = 'z';
        System.out.println(reversePrefix(word, ch));
    }
}
