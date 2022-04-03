package com.leetcode.hotinterview;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: demo
 * @description: 17. 电话号码的字母组合
 * @author: Mr.He
 * @create: 2022-03-05 16:18
 **/
public class Question17LetterCombinations {

    public static Map<Integer,String> res;
    static
    {
        res = new HashMap<Integer, String>();
        res.put(2, "abc");
        res.put(3, "def");
        res.put(4, "ghi");
        res.put(5, "jkl");
        res.put(6, "mno");
        res.put(7, "pqrs");
        res.put(8, "tuv");
        res.put(9, "wxyz");
    }
    public static List<String> letterCombinations(String digits) {
        for (int i = 0; i < digits.length(); i++) {
            int re = Character.getNumericValue(digits.charAt(i));
            System.out.println(re);
            String tesTemp = res.get(re);
            System.out.println(tesTemp);

        }
        return null;
    }

    public void dfs(){}

    public static void main(String[] args) {
     letterCombinations("23");
    }
}
