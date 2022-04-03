package com.leetcode.all;

/**
 * @program: demo
 * @description: 744. 寻找比目标字母大的最小字母
 * @author: Mr.He
 * @create: 2022-04-03 14:57
 **/
public class Question744NextGreatestLetter {

    public char nextGreatestLetter(char[] letters, char target) {
        char res;
        for (int i = 0; i < letters.length; i++) {
            if (letters[i] > target){
                return letters[i];
            }
        }
        return target;
    }
}
