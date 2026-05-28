package com.leetcode.jianzhioffer;

/**
 * @author HQ
 * @create 2021/11/5 21:38
 * @desc 剑指 Offer 05. 替换空格
 * 请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
 * 示例
 * 输入：s = "We are happy."
 * 输出："We%20are%20happy."
 */
public class Question05ReplaceSpace {

    //直接使用库函数进行修改，
    public String replaceSpace(String s) {
        return s.replace(" ","%20");
    }

    //新建类进行复制
    //并且使用stringbulider非线性安全的，速度快
    public String replaceSpace1(String s) {
        StringBuilder stringBuilder = new StringBuilder();
        for (char c : s.toCharArray()) {
            if( c == ' ') {
                stringBuilder.append("%20");
            } else {
                stringBuilder.append(c);
            }
        }
        return stringBuilder.toString();
    }

}
