package com.leetcode.all;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: demo
 * @description: 539. 最小时间差
 * @author: Mr.He
 * @create: 2022-01-18 09:53
 **/
public class Question539FindMinDifference {

    //个人思路是全部和0，进行对比，然后排序，找到前两个大小的;
    public static int findMinDifference(List<String> timePoints){
        int [] res = new int[timePoints.size()];
        for (String s: timePoints) {
           int intHour = Integer.parseInt(s.split(":")[0]);
           int intMint = Integer.parseInt(s.split(":")[1]);
           //和00：00比较
            //(intHour - 0) * 60 + intMint - 0);
           //和24:00比较
            //(intHour - 23) * 60 + ( 60 - intMint);
            int minInt = Math.min(Math.abs((intHour - 0) * 60 + intMint - 0),Math.abs(Math.abs(intHour - 23) * 60 + ( 60 - intMint)));
            System.out.println(minInt);
        }
        return 0;
    }

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("23:59");
        list.add("12:31");
        list.add("01:01");
        list.add("12:32");
        findMinDifference(list);
    }
}
