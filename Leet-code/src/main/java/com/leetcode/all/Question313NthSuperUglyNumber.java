package com.leetcode.all;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @program: demo
 * @description: 313. 超级丑数
 * @author: Mr.He
 * @create: 2022-01-14 20:12
 **/
public class Question313NthSuperUglyNumber {

    public static int nthSuperUglyNumber(int n, int[] primes) {

        int[] res = new int[n + 1];
        res[1] = 1;
        int[] tempNum = new int[primes.length];
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < primes.length; i++) {
            map.put(primes[i], 1);
        }
        Arrays.fill(tempNum, 1);
        for (int i = 2; i <= n; i++) {
            int minNum = Integer.MAX_VALUE;
            for (int j = 0; j < primes.length; j++) {
                int temN = res[map.get(primes[j])] * primes[j];
                if (minNum > temN) {
                    minNum = temN;
                }
            }
            map.put(minNum, map.getOrDefault(res, 1) + 1);
            res[i] = minNum;
        }
        return res[n];
    }

    public static void main(String[] args) {
        int [] res = {2,7,13,19};
        System.out.println(nthSuperUglyNumber(10,res));
    }
}
