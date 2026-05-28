package com.leetcode.sginin;

import java.util.ArrayList;
import java.util.List;

/**
 * @author HQ
 * @program: java-coding
 * @description: 1408. 数组中的字符串匹配
 * @date 2022-08-06 16:29:51
 */
public class Quesiton1408StringMatching {

    public List<String> stringMatching(String[] words) {
        List<String> res = new ArrayList<>();

        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words.length; j++) {
                if (i == j) continue;
                if (words[j].indexOf(words[i]) >= 0){
                    res.add(words[i]);
                    break;
                }
            }
        }
        return res;
    }
    
}
