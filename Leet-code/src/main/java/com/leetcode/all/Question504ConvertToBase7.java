package com.leetcode.all;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: demo
 * @description: 504. 七进制数
 * @author: Mr.He
 * @create: 2022-03-07 08:44
 **/
public class Question504ConvertToBase7 {

    public static String convertToBase7(int num) {
        String res  = "";
        List<Integer> nums = new ArrayList<>();
        if (num >= 0){
            while (num >= 7){
                nums.add(num % 7);
                num = num / 7;
            }
            nums.add(num);
            res = changeNum(nums);
        } else {
            num = -1* num;
            while (num >= 7){
                nums.add(num % 7);
                num = num / 7;
            }
            nums.add(num);
            res = "-" + changeNum(nums);
        }
        return res;
    }

    public static String changeNum(List<Integer> ret){
        StringBuilder str = new StringBuilder();
        for (int i = ret.size() - 1; i >= 0; i--) {
            str.append(ret.get(i));
        }
        return str.toString();
    }

    public static String convertToBase777(int num){
        int temp = num ^ 7;
        int temp2 = num | 7;
        return "";
    }

    public static void main(String[] args) {
        System.out.println(convertToBase777(100));

    }
}
