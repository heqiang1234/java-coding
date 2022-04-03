package com.leetcode.all;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: demo
 * @description: 432. 全 O(1) 的数据结构
 * @author: Mr.He
 * @create: 2022-03-16 10:49
 **/
public class Question432AllOne {

        public Map<String,Integer> res;
        public String maxStr = "";
        public String minStr = "";
        public int maxCount = 0;
        public int minCount = 0;

        public Question432AllOne() {
            res = new HashMap<>();
        }

        public void inc(String key) {
            if (res.containsKey(key)){
                res.put(key,res.get(key) + 1);
            } else {
                res.put(key,1);
            }
        }

        public void dec(String key) {
            if (res.containsKey(key)){
                res.put(key,res.get(key) -1);
                if (res.get(key) == 0){
                    res.remove(key);
                }
            }
        }

        public String getMaxKey() {
            return  "";
        }

        public String getMinKey() {
        return "";
        }
}
