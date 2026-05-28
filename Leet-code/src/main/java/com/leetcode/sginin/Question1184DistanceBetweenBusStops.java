package com.leetcode.sginin;

/**
 * @author HQ
 * @program: java-coding
 * @description: 1184。公交站间的距离
 * @date 2022-07-24 15:14:35
 */
public class Question1184DistanceBetweenBusStops {

    //前缀和
    public static int distanceBetweenBusStops(int[] distance, int start, int destination) {
        int len = distance.length;
        int[] run = new int[len + 1];
        run[0] = 0;
        for (int i = 1; i <= distance.length; i++) {
            run[i] = distance[i - 1] + run[i - 1];
        }
        System.out.println(run[destination] - run[start]);
        System.out.println(run[start] - run[0] + run[len] - run[destination]);
        return Math.min(Math.abs(run[destination] - run[start]), Math.min(Math.abs(run[start] - run[0] + run[len] - run[destination]),Math.abs(run[destination] - run[0] + run[len] - run[start])));
    }

    public static void main(String[] args) {
        System.out.println(distanceBetweenBusStops(new int[]{7,10,1,12,11,14,5,0}, 7, 2));
    }

}
