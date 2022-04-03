package com.leetcode.jianzhioffer;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author HQ
 * @create 2021/11/30 19:42
 *
 * @desc 剑指 Offer 46. 把数字翻译成字符串
 * 给定一个数字，我们按照如下规则把它翻译为字符串：0 翻译成 “a” ，1 翻译成 “b”，……，11 翻译成 “l”，……，25 翻译成 “z”。一个数字可能有多个翻译。请编程实现一个函数，用来计算一个数字有多少种不同的翻译方法。
 *
 *
 *
 * 示例 1:
 *
 * 输入: 12258
 * 输出: 5
 * 解释: 12258有5种不同的翻译，分别是"bccfi", "bwfi", "bczi", "mcfi"和"mzi"
 *
 *
 * 提示：
 *
 * 0 <= num < 231
 */
public class Question46TranslateNum {

    // 写法有点C++,没有使用java的库
    public static int translateNum(int num) {
        if (num <= 9) {
            return 1;
        }
        //System.out.println(getNumList(num).toString());
        List<Integer> numList = getNumList(num);
        int[] dp = new int[numList.size()];
        dp[0] = 1;
        if ((numList.get(0) * 10 + numList.get(1) <= 25) && (numList.get(0) * 10 + numList.get(1) >= 10)) {
            dp[1] = 2;
        } else {
            dp[1] = 1;
        }
        for (int i = 2; i < numList.size(); i++) {
            if (((numList.get(i - 1) * 10 + numList.get(i)) <= 25) && ((numList.get(i - 1) * 10 + numList.get(i)) >= 10)) {
                dp[i] = dp[i - 1] + dp[i - 2];
            } else {
                dp[i] = dp[i - 1];
            }
        }
        return dp[numList.size() - 1];
    }

    public static List<Integer> getNumList(int num) {
        Stack<Integer> stack = new Stack<>();
        while (num != 0) {
            stack.push(num % 10);
            num = num / 10;
        }
        List<Integer> res = new ArrayList<>();
        while (!stack.isEmpty()) {
            res.add(stack.pop());
        }
        return res;
    }

    //java + 滚动数组
    public static int maxSplitChar(int num) {
        String stringTemp = String.valueOf(num);
        int num1 = 0,num2 = 0,numRes = 0;
        //for()
        //暂存
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(translateNum(12258));
    }
}
