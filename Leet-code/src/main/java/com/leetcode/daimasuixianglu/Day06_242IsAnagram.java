package com.leetcode.daimasuixianglu;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: Mr.He
 * @create: 2022-10-17 15:11
 * @description: 242. 有效的字母异位词
 **/
public class Day06_242IsAnagram {

    //直接遍历模拟
    public static boolean isAnagram(String s, String t) {
        if (s.length() != s.length()) return false;//判断长度，减少处理步骤
        StringBuilder str = new StringBuilder(t);
        for (char ch : s.toCharArray()){//遍历第一个字符串，
            int index = str.indexOf(ch + "");//查看第一个字符串中字符在第二个字符的位置
            if (index >= 0){//如果存在，则删除该位置的字符
                str.deleteCharAt(index);
            } else {
                return false;//如果字符不存在，则直接false
            }
        }
        return true;
    }

    //哈希表
    public static boolean isAnagramTwo(String s,String t){
        if (s.length() != t.length()) return false;
        Map<Character,Integer> res = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {//建立hash基地，将第一个字符串的字符放入hash表
            char ch = s.charAt(i);
            res.put(ch,res.getOrDefault(ch,0) + 1);
        }

        for (int i = 0; i < t.length(); i++) {//遍历第二个字符串，存在，则该字符-1，不存在或者个数被减到0以下，则false
            char ch = t.charAt(i);
            if (res.containsKey(ch)){
                res.replace(ch,res.getOrDefault(ch,0) - 1);
                if (res.get(ch) < 0){
                    return false;
                }
            } else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isAnagram("rat", "car"));
    }

}
