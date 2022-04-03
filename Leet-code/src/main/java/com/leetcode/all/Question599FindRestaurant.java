package com.leetcode.all;

import java.util.*;

/**
 * @program: demo
 * @description: 599、两个列表的最小索引总和
 * @author: Mr.He
 * @create: 2022-03-14 09:21
 **/
public class Question599FindRestaurant {

    public static String[] findRestaurant(String[] list1, String[] list2) {
        HashMap<String, Integer> map1 = new HashMap<>();
        int count = 0;
        for (String ch : list1) {
            map1.put(ch,count++);
        }
        HashMap<String, Integer> map2 = new HashMap<>();
        count = 0;
        for (String ch : list2) {
            map2.put(ch,count++);
        }
        int minMit = 2000;
        int tempMit = 2000;
        Queue<String> queue = new ArrayDeque<>();
        if (map1.size() > map2.size()){
            Iterator<Map.Entry<String,Integer>> entries = map2.entrySet().iterator();
            while (entries.hasNext()){
                Map.Entry<String,Integer> entry = entries.next();
                tempMit = entry.getValue() + (map1.get(entry.getKey()) == null ? 2002 : map1.get(entry.getKey()));
                if (tempMit < minMit){
                    minMit = tempMit;
                    queue.clear();
                    queue.add(entry.getKey());
                } else if (tempMit== minMit){
                    queue.add(entry.getKey());
                }
            }
        } else {
            Iterator<Map.Entry<String,Integer>> entries = map1.entrySet().iterator();
            while (entries.hasNext()){
                Map.Entry<String,Integer> entry = entries.next();
                tempMit = entry.getValue() + (map2.get(entry.getKey()) == null ? 2002: map2.get(entry.getKey()));
                if (tempMit < minMit){
                    minMit = tempMit;
                    queue.clear();
                    queue.add(entry.getKey());
                } else if (tempMit== minMit){
                    queue.add(entry.getKey());
                }
            }
        }
        int len2 = queue.size();
        String [] res = new String[len2];
        for (int i = 0; i < len2; i++) {
            res[i] = queue.poll();
        }
        return res;
    }

    public static void main(String[] args) {
        String[] list1 = {"Shogun", "Tapioca Express", "Burger King", "KFC"};
        String[] list2 = {"KFC", "Shogun", "Burger King"};
        System.out.println(findRestaurant(list1, list2)[0]);
    }
}
