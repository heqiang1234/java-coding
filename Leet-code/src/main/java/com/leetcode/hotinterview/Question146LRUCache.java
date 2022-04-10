package com.leetcode.hotinterview;

import java.util.*;

/**
 * @program: java-coding
 * @description: 146. LRU 缓存
 * @author: Mr.He
 * @create: 2022-04-09 19:49
 **/
public class Question146LRUCache {

    static HashMap<Integer, Integer> map;
    static Deque<Integer> queue;
    static int size;

    public Question146LRUCache(int capacity) {
        map = new HashMap<>();
        size = capacity;
        queue = new LinkedList<>();
    }

    public static int get(int key) {
        if (map.containsKey(key)){
            if (queue.contains(key)){
                queue.remove(key);
            }
            queue.addLast(key);
            return map.get(key);
        } else {
            return -1;
        }

    }

    public static void put(int key, int value) {
        if (map.containsKey(key)) {
            map.replace(key, value);
            if (queue.contains(key)){
                queue.remove(key);
            }
        } else {
            map.put(key,value);
            if (map.size() > size) {
                int temp = queue.pollFirst();
                map.remove(temp);
            }
        }
        queue.addLast(key);
    }

    public static void main(String[] args) {
        Question146LRUCache lRUCache = new Question146LRUCache(2);
        lRUCache.put(1, 1); // 缓存是 {1=1}
        lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
        System.out.println(lRUCache.get(1));
        lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
        System.out.println(lRUCache.get(2));
        lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
        System.out.println(lRUCache.get(1));
        System.out.println(lRUCache.get(3));
        System.out.println(lRUCache.get(4));
    }

}
