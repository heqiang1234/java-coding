package com.leetcode.programtest3;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Mr.He
 * @create: 2022-09-19 11:09
 * @description: 数据压缩算法实现
 **/
public class Question_DataFolder {

    static class pair {
        int offset;//偏移量
        int len;//匹配到的字符长度
        char nextChar;//下一个字符

        public pair(int index, int maxLen, char charAt) {
            this.offset = index;
            this.len = maxLen;
            this.nextChar = charAt;
        }

    }

    public static List<pair> DataFolder(String str) {
        List<pair> res = new ArrayList<>();
        int index = 0;//指针的位置
        int maxLen = 0;
        int len = str.length() - 1;
        while (index < len) {
            int[] nowNum = compareString(str, index);
            if (nowNum[1] > maxLen) {
                maxLen = nowNum[1];
                System.out.println("(" + (index - nowNum[0]) + " " + maxLen + " " + str.charAt(index) + ")");
                res.add(new pair((index - nowNum[0]), maxLen, str.charAt(index)));
                index = 2 * index;
            } else {
                res.add(new pair(0, 0, str.charAt(index)));
                System.out.println("(" + 0 + " " + 0 + " " + str.charAt(index) + ")");
                index++;
            }
        }
        return res;
    }

    //最大公共长度
    //比较字典缓冲区和预读区的字符串,输出最大的相同长度
    public static int[] compareString(String str, int index) {
        int i = 0, j = 0,origI = 0;
        int count = 0, maxLen = 0, resIndex = 0;
        while (i < index) {
            j = index;
            origI = i;
            //如果相等，则一直往后推移遍历
            while (str.charAt(i) == str.charAt(j)) {
                i++;
                j++;
                count++;
                if (i >= index || j >= str.length()) {
                    break;
                }
            }
            if (count > maxLen) {
                resIndex = origI;
                maxLen = Math.max(maxLen, count);
            }
            i++;
        }
        return new int[]{resIndex, maxLen};
    }

    public static void main(String[] args) {
        List<pair> now = DataFolder("ABBC");
        System.out.println(now);
    }

}
