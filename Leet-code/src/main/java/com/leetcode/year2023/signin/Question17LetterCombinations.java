package com.leetcode.year2023.signin;

import java.util.ArrayList;
import java.util.List;

/**
 * @author HQ
 * @program: java-coding
 * @description: 17.电话号码的数字组合
 * @date 2023-03-21 21:26:57
 */
public class Question17LetterCombinations {

    String[] str = new String[]{"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        for (int i = 0; i < digits.length(); i++) {
            int value = digits.charAt(i) - '0';

        }
    }


}
