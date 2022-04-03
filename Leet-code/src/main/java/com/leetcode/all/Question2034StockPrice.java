package com.leetcode.all;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: demo
 * @description: 2034. 股票价格波动
 * @author: Mr.He
 * @create: 2022-01-23 15:00
 **/
public class Question2034StockPrice {

    public int maxNum;

    public  int minNum;

    public int currentNum;

    public int currentTime;

    public Map<Integer,Integer> map;

    public Question2034StockPrice() {
        map = new HashMap<>();
        minNum = Integer.MIN_VALUE;
        maxNum = 0;
        currentNum = 0;
        currentTime = 0;
    }

    public void update(int timestamp, int price) {
        if (map.containsKey(timestamp)){
            map.replace(timestamp,price);
            if (timestamp == currentTime){
                currentNum = price;
            }
        } else {
            map.put(timestamp,price);
            if (timestamp > currentTime){
                currentTime = timestamp;
                currentNum = price;
            }
        }
        if (price > maxNum){
            maxNum = price;
        }
        if (price < minNum){
            minNum = price;
        }
    }

    public int current() {
        return currentNum;
    }

    public int maximum() {
        return maxNum;
    }

    public int minimum() {
        return minNum;
    }


    public static void main(String[] args) {
        Question2034StockPrice stockPrice = new Question2034StockPrice();
        stockPrice.update(1, 10); // 时间戳为 [1] ，对应的股票价格为 [10] 。
        stockPrice.update(2, 5);  // 时间戳为 [1,2] ，对应的股票价格为 [10,5] 。
        System.out.println(stockPrice.current());
        System.out.println(stockPrice.maximum());
        stockPrice.update(1, 3);  // 之前时间戳为 1 的价格错误，价格更新为 3 。
        // 时间戳为 [1,2] ，对应股票价格为 [3,5] 。
        System.out.println(stockPrice.maximum());
        stockPrice.update(4, 2);  // 时间戳为 [1,2,4] ，对应价格为 [3,5,2] 。
        System.out.println(stockPrice.minimum());
    }
}
