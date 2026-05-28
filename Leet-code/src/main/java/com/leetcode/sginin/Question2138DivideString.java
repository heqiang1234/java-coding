package com.leetcode.sginin;

/**
 * @author heqiang
 * @date 2025年06月22日19:27
 */
public class Question2138DivideString {

    public static String[] divideString(String s, int k, char fill) {
        int lenStr = s.length();
        int len = (int) Math.ceil((double)(lenStr / (k * 1.0)));
        String[] res = new String[len];
        int index = 0, indexRes = 0;
        StringBuilder resStr = new StringBuilder();
        while (index < len * k) {
            if (index >= lenStr) {
                resStr.append(fill);
            } else {
                resStr.append(s.charAt(index));
            }

            index++;
            if (index % k == 0) {
                res[indexRes] = resStr.toString();
                resStr.setLength(0);
                indexRes++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.printf("", divideString("hjefcvizjkecrioqhywe", 1, 's'));
    }
}