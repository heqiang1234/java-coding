package com.leetcode.sginin;

import org.apache.commons.lang.enums.Enum;

import java.util.Arrays;

/**
 * @program: java-coding
 * @description: 307. 区域和检索 - 数组可修改
 * @author: Mr.He
 * @create: 2022-04-04 12:43
 *
 *
 * 树状数组
 **/
public class Question307NumArray {

    static int[] tr;
    static int lowbit (int val){
        return val & -val;
    }

    static void add(int x,int u){
        for (int i = x; i <= len; i+=lowbit(i))
            tr[i] += u;
    }
    
   static int query(int x){
        int ans = 0;
        for (int i = x; i >0 ; i-=lowbit(i)) {
            ans += tr[i];
        }
        return ans;
    }

    public static int[] res;
    public static int len ;

    public Question307NumArray(int[] nums) {
        res = nums;
        len = nums.length;
        tr = new int[len + 1];
        for (int i = 0; i < len; i++) {
           add(i + 1, nums[i]);
        }
    }

    public static void update(int index, int val) {
        add(index + 1,val - res[index]);
        res[index] = val;
    }

    public static int sumRange(int left, int right) {
        return query(right + 1) - query(left);
    }

    public static void main(String[] args) {

    }
}
