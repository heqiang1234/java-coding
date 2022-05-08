package com.test;

import java.util.HashMap;

/**
 * @program: java-coding
 * @description: concurrentHashMap
 * @author: Mr.He
 * @create: 2022-04-10 20:35
 **/
public class Test {

    public static void main(String[] args) {
       // ConcurrentHashMap<Integer,Integer> res = new ConcurrentHashMap<Integer, Integer>();
        System.out.println(Runtime.getRuntime().availableProcessors());

        HashMap<Integer,String> map = new HashMap<>(10);
        map.put(1,"2");
        map.put(17,"3");
        map.put(2,"4");
    }
}
