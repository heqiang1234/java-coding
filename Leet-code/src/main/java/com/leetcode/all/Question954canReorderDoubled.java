package com.leetcode.all;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @program: demo
 * @description: 954. 二倍数对数组
 * @author: Mr.He
 * @create: 2022-04-01 21:11
 **/
public class Question954canReorderDoubled {

    public static boolean canReorderDoubled(int[] arr) {
        int len = arr.length;
        if (len < 0 || len % 2 != 0){
            return false;
        }
        Arrays.sort(arr);
        if (len == 2){
            return arr[1] == arr[0] * 2 || arr[0] == arr[1] * 2;
        }
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            map.put(arr[i],map.getOrDefault(arr[i],0) + 1);
        }
        int count = 0;
        for (int i = 0; i < len; i++) {
            if (map.containsKey(2 * arr[i]) && map.get(arr[i]) > 0 && map.get(2 * arr[i]) > 0){
                map.put(arr[i],map.getOrDefault(arr[i],0) - 1);
                map.put(2 *arr[i],map.getOrDefault(2 * arr[i],0) - 1);
                count++;
            }
        }
        return (len / 2) == count;
    }

    public static void main(String[] args) {
        System.out.println(canReorderDoubled(new int[]{-6,-3}));
    }

}
