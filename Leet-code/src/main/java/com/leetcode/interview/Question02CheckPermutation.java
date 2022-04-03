package com.leetcode.interview;

import java.util.Arrays;

/**
 * @program: demo
 * @description: 面试题 01.02. 判定是否互为字符重排
 * @author: Mr.He
 * @create: 2021-12-02 16:10
 *
 * 给定两个字符串 s1 和 s2，请编写一个程序，确定其中一个字符串的字符重新排列后，能否变成另一个字符串。
 *
 * 示例 1：
 *
 * 输入: s1 = "abc", s2 = "bca"
 * 输出: true
 * 示例 2：
 *
 * 输入: s1 = "abc", s2 = "bad"
 * 输出: false
 * 说明：
 *
 * 0 <= len(s1) <= 100
 * 0 <= len(s2) <= 100
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/check-permutation-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class Question02CheckPermutation {

    //使用数组来存储，统计
    public static boolean checkPermutation1(String s1, String s2) {
        //判断长度，如果不相等，直接返回
        if (s1.length() != s2.length()) {
            return false;
        }
        //定义数组，存储数量
        int[] nums = new int[128];
        Arrays.fill(nums,0);
        //将字符存进对应acii码得位置 -64
        for (char c : s1.toCharArray()) {
            nums[c-64]  += 1;
        }
        //直接在该数据上面减去，如果小于0，说明存在不同得字符
        for (char c : s2.toCharArray()) {
            nums[c-64] -= 1;
            if(nums[c-64] < 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(checkPermutation1("asvnpzurz","urzsapzvn"));
    }
}
