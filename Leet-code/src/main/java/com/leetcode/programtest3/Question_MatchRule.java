package com.leetcode.programtest3;

/**
 * @author: Mr.He
 * @create: 2022-09-21 13:55
 * @description: 匹配规则
 **/
public class Question_MatchRule {

    public static boolean matchStrRule(String funcStr,String ruleStr){
        //首先判断是否存在 *，如果不存在，则判断字符长度，不相等，则false
        boolean starFlag = false;
        int lenFunc = funcStr.length();
        int lenRule = ruleStr.length();
        for (int i = 0; i < ruleStr.length(); i++) {
            if (ruleStr.charAt(i) == '*'){
                starFlag = true;
                break;
            }
        }
        //不存在 * 星号
        if (!starFlag){
            //如果长度不相等，则返回false
            if (lenFunc != lenRule){
                return false;
            }
            int i = 0;
            while (i < lenRule){
                if (ruleStr.charAt(i) == '?' || ruleStr.charAt(i) == funcStr.charAt(i)){
                    i++;
                } else {
                    return false;
                }
            }
        } else {//存在  * 号
            int i = 0 ;
            while (i < lenRule){
                if (i >= lenFunc){
                    break;
                }
                if (ruleStr.charAt(i) == '?' || ruleStr.charAt(i) == funcStr.charAt(i)){
                    i++;
                } else if (ruleStr.charAt(i) == '*'){
                    return true;
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(matchStrRule("600570", "600*"));//true
        System.out.println(matchStrRule("600570", "600???"));//tue
        System.out.println(matchStrRule("600570", "600*??"));//true
        System.out.println(matchStrRule("600570", "600??*"));//true
        System.out.println(matchStrRule("600570", "600?*"));//true
        System.out.println(matchStrRule("600570", "600?"));//false
        System.out.println(matchStrRule("600570", "605?*"));//false
        System.out.println(matchStrRule("600570", "700???"));//false
        System.out.println(matchStrRule("600570", "600***"));//true
        System.out.println(matchStrRule("600570", "6?0???"));//true
        System.out.println(matchStrRule("600570", "*"));//true
        //System.out.println(matchStrRule("600570", "*9"));//true
    }
}
