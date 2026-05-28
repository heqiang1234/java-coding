package com.leetcode.year2026;

/**
 * @author heqiang
 * @date 2026年05月21日10:08
 */
public class Q2657_2_findThePrefixCommonArray {

    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        long p = 0,q = 0;

        for (int i = 0; i < A.length; i++) {
            p |= 1L << A[i]; // 将A存入对应的p的二进制位
            q |= 1L << B[i]; // 将B存入对应的q的二进制位

            A[i] = Long.bitCount(q & q); // 统计 p,q二进制位，相同的个数，表示相同的前缀。
        }
        return  A;
    }
}
