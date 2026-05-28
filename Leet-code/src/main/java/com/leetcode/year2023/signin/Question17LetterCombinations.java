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

    static String[] str = new String[]{"","","abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    static List<String> res = new ArrayList<>();

    public static  List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0){
            return res;
        }
        dfsCom(digits,0,"");
        return res;
    }

    public static void dfsCom(String digits,Integer index,String s){
        if (index == digits.length()){
            res.add(s);
            return;
        }

        int value = digits.charAt(index) - '0';
        String tmp = str[value];
        for (int i = 0; i < tmp.length(); i++) {
            dfsCom(digits,index + 1,s + tmp.charAt(i));
        }
    }

    public static void main(String[] args) {
        System.out.println(letterCombinations("23"));
    }

}
