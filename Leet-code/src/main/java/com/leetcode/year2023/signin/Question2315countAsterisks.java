package com.leetcode.year2023.signin;

/**
 * @author HQ
 * @program: java-coding
 * @description: 2315. 统计星号
 * @date 2023-01-29 20:55:01
 */
public class Question2315countAsterisks {

    public static int countAsterisks(String s)
    {
        int res = 0;
        boolean beginL = false,endL = false;
        int tempCount = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '|')
            {
                if (!beginL){
                    beginL = true;
                } else if (!endL){
                    endL = true;
                }
            }
            if (beginL && endL){
                beginL = false;
                endL = false;
            }
            if (!beginL)
            {
                res += s.charAt(i) == '*' ? 1 : 0;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(countAsterisks("l|*e*et|c**o|*de|"));
    }
}
