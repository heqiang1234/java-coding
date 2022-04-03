package com.leetcode.all;

import java.util.HashMap;

/**
 * @program: demo
 * @description: 2055. 蜡烛之间的盘子
 * @author: Mr.He
 * @create: 2022-03-08 08:53
 **/
public class Question2055PlatesBetweenCandles {

    //前缀和 + 二分
    public static int[] platesBetweenCandles(String s, int[][] queries) {
        int[] res = new int[queries.length];
        char str[] = s.toCharArray();
        int len = s.length();
        int leftNum[] = new int[len];
        int rightNum[] = new int[len];
        int leftS = -1;
        int rightS = -1;
        int sum[] = new int[len + 1];
        for (int i = 0, j = len - 1; i < len; i++, j--) {
            if (str[i] == '|') {
                leftS = i;
            }
            if (str[j] == '|') {
                rightS = j;
            }
            leftNum[i] = leftS;
            rightNum[j] = rightS;
            sum[i + 1] = sum[i] + (str[i] == '*' ? 1 : 0);
        }

        int left, right;
        for (int i = 0; i < queries.length; i++) {
            left = queries[i][0];
            right = queries[i][1];
            int c = rightNum[left], d = leftNum[right];
            if (c != -1 && c <= d) res[i] = sum[d + 1] - sum[c];
        }
        return res;
    }

    //直接二分
    public static int[] platesBetweenCandles1(String s, int[][] queries) {
        int[] res = new int[queries.length];
        int left = 0, right = 0;
        int count = 0;
        Boolean leftBool, rightBool;
        for (int i = 0; i < queries.length; i++) {
            left = queries[i][0];
            right = queries[i][1];
            leftBool = true;
            rightBool = true;
            while (left <= right) {
                if (s.charAt(left) == '*' && leftBool) {
                    left++;
                } else {
                    leftBool = false;
                }

                if (s.charAt(right) == '*' && rightBool) {
                    right--;
                } else {
                    rightBool = false;
                }

                if (!leftBool && !rightBool) {
                    break;
                }
            }
            res[count] = getCountChar(s, left, right);
            count++;
        }
        return res;
    }

    public static int getCountChar(String s, int left, int right) {
        int count = 0;
        for (int i = left; i < right; i++) {
            if (s.charAt(i) == '*') {
                count++;
            }
        }
        return count;
    }

    //调整自己的想法
    public static int[] platesBetweenCandles2(String s, int[][] queries) {
        HashMap<Integer, Integer> ret = new HashMap<>();
        int[] res = new int[queries.length];
        int index = 0;
        char [] str = s.toCharArray();
        int len = s.length();
        int sumStar = 0; //计算星号
        Boolean startCount = false;//第一次碰到 | 才开始计数
        for (int i = 0; i < len; i++) {
            if (str[i] == '|') {
                ret.put(i, index);
                index = startCount ? index : 0;
                startCount = true;
            } else {
                ret.put(i, 0);
                index += startCount ? 1 : 0;
            }
        }
        int left = 0, right = 0;
        int count = 0;
        Boolean leftBool, rightBool;
        for (int i = 0; i < queries.length; i++) {
            left = queries[i][0];
            right = queries[i][1];
            leftBool = false;
            rightBool = false;
            while (left <= right) {
                if (str[left] == '*' && left < len){
                    left++;
                } else {
                    leftBool = true;
                }

                if (str[right] == '*' && right >= 0){
                    right--;
                } else {
                    rightBool = true;
                }

                if (leftBool && rightBool){
                    break;
                }
            }
            if (left < right){
                res[count] =ret.get(right) - ret.get(left);
            }
            count++;
        }
        return res;
    }

    public static void main(String[] args) {
        String s = "***|**|*****|**||**|*";
        int[][] queries = {{4, 5}, {1, 17}, {14, 17}, {5, 11}, {15, 16}};
        platesBetweenCandles2(s, queries);
    }
}
