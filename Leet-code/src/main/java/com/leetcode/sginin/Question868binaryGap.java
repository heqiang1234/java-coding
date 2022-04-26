package com.leetcode.sginin;

/**
 * @author: Mr.He
 * @create: 2022-04-24 10:12
 * @description: 868.二进制间距
 **/
public class Question868binaryGap {

    public static int binaryGap(int n) {
        Boolean flag = false;
        int count = 0, maxLen = 0;
        int indexI = 0, indexJ = 0;
        while (n != 0) {
            int temp = n % 2;
            n = n / 2;
            if (temp == 1) {
                count++;
                if (count == 2) {
                    count = 1;
                    maxLen = Math.max(indexJ - indexI + 1, maxLen);

                }
                indexI = indexJ;
            } else {
                indexJ++;
            }
        }
        return maxLen;
    }

    //位运算
    public int binaryGap1(int n) {
        int ans = 0;
        for (int i = 31, j = -1; i >= 0; i--) {
            if (((n >> i) & 1) == 1) {
                if (j != -1) ans = Math.max(ans, j - i);
                j = i;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(binaryGap(5));
    }

}
