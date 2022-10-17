package com.leetcode.daimasuixianglu;

import java.util.HashSet;
import java.util.Set;

/**
 * @author: Mr.He
 * @create: 2022-10-17 15:59
 * @description: 202.快乐数
 **/
public class Day06_202IsHappy {

    public static boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        set.add(n);
        int tempNum = n;
        while (true) {
            if (tempNum == 1) {
                return true;
            }
            int num = getNum(tempNum);
            if (set.contains(num)) {
                return false;
            } else {
                set.add(num);
                tempNum = num;
            }

        }
    }

    public static int getNum(int num) {
        int sum = 0;
        while (num > 0) {
            int temp = num % 10;
            sum += temp * temp;
            num = num / 10;
        }
        return sum;
    }


    public static void main(String[] args) {
        System.out.println(isHappy(19));
    }

}
