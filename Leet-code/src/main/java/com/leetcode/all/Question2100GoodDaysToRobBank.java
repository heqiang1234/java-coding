package com.leetcode.all;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @program: demo
 * @description: 2100. 适合打劫银行的日子
 * @author: Mr.He
 * @create: 2022-03-06 11:20
 **/
public class Question2100GoodDaysToRobBank {

    public static List<Integer> goodDaysToRobBank(int[] security, int time) {
        List<Integer> res = new ArrayList<>();
        if (time == 0){
            for (int i = 0; i < security.length; i++) {
                res.add(i);
            }
            return res;
        }
        int len = security.length - 1;
        for (int i = 0; i < len; i++) {
            if (checkTime(i,len,time)){
                if (checkPreSecu(security,i,time)){
                    if (checkAfterSecu(security,i,time)){
                        res.add(i);
                    }
                }
            }
        }
        return res;
    }

    //依次判断会超时。
    public static Boolean checkTime(int index,int length,int time){
        if (index >= time && length - index >= time) {
            return true;
        }
        return false;
    }

    //递增
    public static Boolean checkPreSecu(int [] secu, int index,int time){
        for (int i = index - time; i < index; i++) {
            if (secu[i] < secu[ i + 1]){
                return false;
            }
        }
        return true;
    }

    //递减
    public static Boolean checkAfterSecu(int [] secu, int index,int time){

        for (int i = index; i <= index + time - 1; i++) {
            if (i + 1 >= secu.length){
                break;
            }
            if (secu[i] > secu[ i + 1]){
                return false;
            }
        }
        return true;
    }

    public static List<Integer> goodDaysToRobBank2(int[] security, int time) {
        List<Integer> res = new ArrayList<>();
        int len = security.length;
       int [] left = new int[len];
       int [] right = new int[len];
        Arrays.fill(left,0);
        Arrays.fill(right,0);
        for (int i = 1; i < len; i++) {
            if (security[i] <= security[i - 1]){
                left[i] = left[i - 1] + 1;
            }

            if (security[len -i - 1] <= security[len - i]){
                right[len - i - 1] = right[len - i] + 1;
            }
        }

        for (int i = time; i < len - time; i++) {
            if (left[i] >= time && right[i] >= time) {
                res.add(i);
            }
        }
        return res;
    }


    public static void main(String[] args) {
        int [] secu = {5,3,3,3,5,6,2};
        goodDaysToRobBank2(secu,2);
    }

}
