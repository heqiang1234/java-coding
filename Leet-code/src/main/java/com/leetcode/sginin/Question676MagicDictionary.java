package com.leetcode.sginin;

import java.util.ArrayList;
import java.util.List;

/**
 * @author HQ
 * @program: java-coding
 * @description: 676.魔法字典
 * @date 2022-07-11 21:36:49
 */
public class Question676MagicDictionary {
    List<String> res;

    public Question676MagicDictionary() {
        res = new ArrayList<>();
    }

    public void buildDict(String[] dictionary) {
        for (String str: dictionary) {
            res.add(str);
        }
    }

    public boolean search(String searchWord) {
        int len = searchWord.length();
        for (int i = 0; i < res.size(); i++) {
            String str = res.get(i);
            if (str.length() == len){
                int cont = 0;
                for (int j = 0; j < len; j++) {
                    if (str.charAt(j) != searchWord.charAt(j)) cont++;
                }
                if (cont == 1) return true;
            }
        }
        return false;
    }
}
