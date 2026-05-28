package com.leetcode.all;

import java.util.HashMap;
import java.util.Map;

/**
 * @author HQ
 * @program: demo
 * @description: 1189. “气球” 的最大数量
 * @date 2022-02-13 13:05:20
 */
public class Question1189MaxNumberOfBalloons {

    public static int maxNumberOfBalloons(String text) {
        Map<Character,Integer> mapp = new HashMap<>();
        for (int i = 0; i < text.length(); i++) {
            Character ch = text.charAt(i);
            mapp.put(ch,mapp.getOrDefault(ch,0) + 1);
        }
        int minValue = Integer.MAX_VALUE;
        int count = 0;
        for (Map.Entry<Character,Integer> ma: mapp.entrySet()) {
            if (ma.getKey().equals('b')){
                minValue = Math.min(ma.getValue()/1,minValue);
                count++;
            } else if (ma.getKey().equals('a')){
                minValue = Math.min(ma.getValue()/1,minValue);
                count++;
            } else if (ma.getKey().equals('n')){
                minValue = Math.min(ma.getValue()/1,minValue);
                count++;
            } else if (ma.getKey().equals('l')){
                minValue = Math.min(ma.getValue()/2,minValue);
                count++;
            } else if (ma.getKey().equals('o')){
                minValue = Math.min(ma.getValue()/2,minValue);
                count++;
            }
        }
        return minValue == Integer.MAX_VALUE || count != 5 ? 0 : minValue;
    }

    public static void main(String[] args) {
        System.out.println(maxNumberOfBalloons("lloo"));
    }

}
