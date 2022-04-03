package com.leetcode.interview;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author HQ
 * @program: demo
 * @description: 面试题 05.01. 插入
 * @date 2022-01-04 21:30:36
 *
 * 面试题 05.01. 插入
 * 给定两个整型数字 N 与 M，以及表示比特位置的 i 与 j（i <= j，且从 0 位开始计算）。
 *
 * 编写一种方法，使 M 对应的二进制数字插入 N 对应的二进制数字的第 i ~ j 位区域，不足之处用 0 补齐。具体插入过程如图所示。
 *
 *
 *
 * 题目保证从 i 位到 j 位足以容纳 M， 例如： M = 10011，则 i～j 区域至少可容纳 5 位。
 *
 *
 *
 * 示例1:
 *
 *  输入：N = 1024(10000000000), M = 19(10011), i = 2, j = 6
 *  输出：N = 1100(10001001100)
 * 示例2:
 *
 *  输入： N = 0, M = 31(11111), i = 0, j = 4
 *  输出：N = 31(11111)
 */
public class Question0501InsertBits {

    public static int insertBits(int N, int M, int i, int j) {
//        if (i == 0) {
//            return M + N;
//        }
        int[] numN = getTwoInto(N);
        int[] numM = getTwoInto(M);
        int len = numN.length > numM.length ? numN.length + 1 : numM.length + 1;
        int[] res = new int[len + 10];
        Arrays.fill(res,0);
        int tempM = 0;
        for (int k = 0; k < len + 10; k++) {
            if (numN.length < k +1) {
                res[k] = 0;
            } else {
                res[k] = numN[k];
            }
            if(k >= i && k <= j){
                if (tempM >= numM.length) {
                    res[k] = 0;
                } else {
                    res[k] = numM[tempM];
                    tempM++;
                }
            }
        }
        int sum = 0;
        int temp = 1;
        for (int k = 0; k < len + 10; k++) {
            temp = 1;
            for (int l = 0; l < k; l++) {
                temp *= 2;
            }
            sum +=res[k] * temp;
        }
        return sum;
    }

    public static int[] getTwoInto(int num) {
        StringBuilder stringBuilder = new StringBuilder("");
        int[] arr = new int[1024];
        int count = 0;
        Arrays.fill(arr, 0);
        while (num != 0) {
            int numII = num % 2;
            num = num / 2;
            arr[count] = numII;
            count++;
        }
        int[] res = new int[count + 1];
        Arrays.fill(res, 0);
        for (int i = 0; i < count; i++) {
            res[i] = arr[i];
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //System.out.println(insertBits(1143207437 ,1017033,11,31));
        System.out.println(insertBits(126194517
                ,2982082
                ,9
                ,30));
    }

}
