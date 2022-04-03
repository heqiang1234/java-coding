package com.leetcode.all;

import java.util.*;

/**
 * @program: demo
 * @description: 264. 丑数 ||
 * @author: Mr.He
 * @create: 2022-01-14 19:04
 **/
public class Question264NthUglyNumber {
    //优先队列
    public static int nthUglyNumber(int n) {
        int[] tempNum = {2, 3, 5};
        Queue<Long> queue = new PriorityQueue<>();
        Set<Long> set = new HashSet<>();
        queue.add(1L);
        for (int i = 1; i <= n; i++) {
            Long x = queue.poll();
            if (n == i) {
                return x.intValue();
            }
            for (int j = 0; j < tempNum.length; j++) {
                long t = x * tempNum[j];
                if (!set.contains(t)) {
                    queue.add(t);
                    set.add(t);
                }
            }
        }
        return 0;
    }

    public static int getNum(int n) {
        int[] res = new int[n + 1];
        res[1] = 1;
        for (int i2 = 1,i3 = 1,i5 = 1,idx = 1; idx <= n; idx++) {
            int a= res[i2] * 2,b= res[i3] * 3,c= res[i5] * 5;
            int minNum = Math.min(a,Math.min(b,c));
            if (a == minNum) i2++;
            if (b == minNum) i3++;
            if (c == minNum) i5++;
            res[idx] = minNum;
        }
        return res[n];
    }

    public static void main(String[] args) {
        System.out.println(getNum(10));
    }


}
