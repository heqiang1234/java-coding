package com.leetcode.sginin;

/**
 * @program: java-coding
 * @description: 796. 旋转字符串
 * @author: Mr.He
 * @create: 2022-04-07 16:33
 **/
public class Question796RotateString {

    public boolean rotateString(String s, String goal) {
        if (s.length() != goal.length()){
            return false;
        }
        s = s + s;
        return (s.contains(goal));
    }
}
