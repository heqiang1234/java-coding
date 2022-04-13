package com.leetcode.sginin;

/**
 * @program: java-coding
 * @description: 806. 写字符串需要的行数
 * @author: Mr.He
 * @create: 2022-04-12 15:22
 **/
public class Question806NumberOfLines {

    public static int[] numberOfLines(int[] widths, String s) {
        int [] res = new int[2];
        int len = s.length();
        if (len == 0){
            return new int[]{0,0};
        }

        int maxLen = 0;//记录每一行的数据长度；
        int count = 0;//记录层数
        for (char ch: s.toCharArray()) {
            int index = ch - 'a';
            if (maxLen + widths[index] <= 100){
                maxLen += widths[index];
            } else {
                count++;
                maxLen = widths[index];
            }
        }
        res[0] = count + 1;
        res[1] = maxLen;
        return res;
    }

    public static void main(String[] args) {
        int[] wirtds = {10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10};
        String s = "abcdefghijklmnopqrstuvwxyz";
        numberOfLines(wirtds,s);
    }

}
