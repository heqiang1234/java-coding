package com.leetcode.all;

import java.util.Iterator;
import java.util.List;

/**
 * @program: demo
 * @description: 842. 将数组拆分成斐波那契序列
 * @author: Mr.He
 * @create: 2022-01-10 21:06
 **/
public class Question842SplitIntoFibonacci {

    public static List<Integer> resList;

    public static List<Integer> splitIntoFibonacci(String num) {
        dfsFib(num, 0,0,0,0);
        return resList;
    }

    public static boolean dfsFib(String num, int index, int count, long prepre, long pre) {
        if (index >= num.length()) {
            return count > 2;
        }

        long current = 0;
        for (int i = index; i < num.length(); i++) {
            int n = num.charAt(i);
            if (num.charAt(index) == '0' && i > index) {
                return false;
            }

            current = current * 10 + n - '0';

            if (count >= 2) {
                long sum = prepre + pre;
                if (current > sum) {
                    return false;
                }
                if (current < sum) {
                    continue;
                }
            }
            if (dfsFib(num, i + 1, count + 1, pre, current)){
                resList.add((int)pre);
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println();
            // 获取迭代器
            Iterator<Integer> it = splitIntoFibonacci("11235813").iterator();

        // 输出集合中的所有元素
        while(it.hasNext()) {
            System.out.println(it.next());
        }
    }
}
