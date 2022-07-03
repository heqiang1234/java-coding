package com.leetcode.sginin;

import java.util.*;

/**
 * @author HQ
 * @program: java-coding
 * @description: 556.下一个元素更大III
 * @date 2022-07-03 09:36:45
 * <p>
 * 给你一个正整数 n ，请你找出符合条件的最小整数，其由重新排列 n 中存在的每位数字组成，并且其值大于 n 。如果不存在这样的正整数，则返回 -1 。
 * <p>
 * 注意 ，返回的整数应当是一个 32 位整数 ，如果存在满足题意的答案，但不是 32 位整数 ，同样返回 -1 。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 12
 * 输出：21
 * 示例 2：
 * <p>
 * 输入：n = 21
 * 输出：-1
 *  
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/next-greater-element-iii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。+
 */
public class Question556NextGreaterElement {

    public static List<Integer> res = new ArrayList<>();

    public static int nextGreaterElement(int n) {
        getThos(n);
        //获取第一个可以换位置的index;
        int index = -1;
        int len = res.size();
        for (int i = 0; i < len - 1 && index == -1; i++) {
            if (res.get(i + 1) < res.get(i)) {
                index = i + 1;
            }
        }
        //此时的index就是换位置的后几位的位置i
        if (index == -1) {
            return -1;
        }

        //然后将这位和我们之前的前一位进行变化位置，此时只改变一位
        //这里很重要，因为要把末尾的小于index位置的数字换过去，所以需要一个遍历。保证换过去的是大于的数字
        //241   如果直接和最后一位换就是  124，这样就小于那个数字了
        for (int i = 0; i < index; i++) {
            if (res.get(i) > res.get(index)){
                swap(res,i,index);
                break;
            }
        }
        // swap(res,0,index);
        for (int i = 0,r = index - 1; i <r ; i++,r--) {
            swap(res,i,r);
        }
        long ans = 0;
        for (int i = len - 1; i >=0 ; i--) {
            ans = res.get(i) + ans * 10;
        }

        return ans > Integer.MAX_VALUE ? -1 : (int)ans;
    }

    //得到后续处理的数字的数组序列
    public static void getThos(int n) {
        while (n != 0) {
            int temp = n % 10;
            res.add(temp);
            n = n / 10;
        }
    }

    public static void swap(List<Integer> nums, int left, int right) {
        int temp = nums.get(left);
        nums.set(left, nums.get(right));
        nums.set(right, temp);
    }

    public static void main(String[] args) {
        System.out.println(nextGreaterElement(12));
    }

}
