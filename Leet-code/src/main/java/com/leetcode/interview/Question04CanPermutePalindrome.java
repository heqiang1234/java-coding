package com.leetcode.interview;

/**
 * @program: demo
 * @description: 面试题 01.04. 回文排列
 * @author: Mr.He
 * @create: 2021-12-03 09:47
 **/
public class Question04CanPermutePalindrome {

    //1) 如果都出现偶数次数，那么一定是回文。
    //这个好判断，可以直接用位运算，因为偶数次，所以会导致得到得结果全为0，&运算
    //2) 还有一种场景， 只有一个出现了一次，其他的都是偶数次，那么也可以是回文。
    public static boolean canPremutePalindrome(String str) {

        //如果为空，直接返回
        if (str == null || str.length() <= 0) {
            return false;
        }
        //字符串长度
        int strLen = str.length();
        //这里设定了高位64和低位64，可以针对所有的ascii码，
        long high64 = 0;
        long low64 = 0;
        //计算偶数出现次数
        int count = 0;
        for (char c : str.toCharArray()) {
            if (c > 64) {
                long bitIndex = 1L << (c - 64);
                if ((bitIndex & high64) != 0) {
                    count++;
                }
                high64 ^= bitIndex;
            } else {
                long bitIndex = 1L << c;
                //&运算，如果同时为1，才为1，否则为0，这里如果出现之前出现过的字符，对应位上会为1，这里和新出现的字符对比，
                // 如果两者 &运算的结果不为0，说明有同时为1，那就说明出现过。
                if ((bitIndex & low64) != 0) {
                    count++;
                }
                //这里使用 | 或运算，一个为1，就为1，这样可以将之前出现过的保存下来。
                low64 ^= bitIndex;
            }
        }
        //针对上面两种场景分别判断结果
        if (strLen % 2 == 0) {
            if (count * 2 == strLen) {
                return true;
            }
        } else {
            if (count * 2 + 1 == strLen) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(canPremutePalindrome("AaBb//a"));
    }
}
