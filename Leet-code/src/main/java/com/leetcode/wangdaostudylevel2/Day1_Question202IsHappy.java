package com.leetcode.wangdaostudylevel2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author: Mr.He
 * @create: 2022-08-26 14:06
 * @description: 202.快乐数
 **/
public class Day1_Question202IsHappy {

    //笨比办法
    static HashMap<Integer, Integer> map = new HashMap<>();

    public static boolean isHappy(int n) {
        if (n <= 0) {
            return false;
        }
        if (map.containsKey(n)) {
            return false;
        } else {
            map.put(n, 1);
        }
        List<Integer> res = new ArrayList<>();
        while (n != 0) {
            res.add(n % 10);
            n /= 10;
        }
        int sum = 0;
        for (int i = res.size() - 1; i >= 0; i--) {
            sum += Math.pow(res.get(i), 2);
        }
        if (sum == 1) {
            return true;
        }
        return isHappy(sum);
    }

    //快慢指针
    public boolean isHappy1(int n) {
        if (n <= 0){
            return false;
        }
        int slow = n,fast = n;
        do {
            slow = getSecondNum(slow);
            fast = getSecondNum(fast);
            fast = getSecondNum(fast);
        } while (slow != fast);
        return fast == 1;
    }

    public int getSecondNum(int n) {
        int sum =0;
        while (n > 0) {
            int bit = n % 10;
            sum += bit * bit;
            n /= 10;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(isHappy(2));
    }

}
