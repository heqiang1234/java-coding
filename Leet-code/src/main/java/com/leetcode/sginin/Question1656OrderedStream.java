package com.leetcode.sginin;

import java.util.ArrayList;
import java.util.List;

/**
 * @author HQ
 * @program: java-coding
 * @description: 1656. 设计有序流
 * @date 2022-08-16 20:19:01
 */
public class Question1656OrderedStream {

    public static List<String> res;
    public  static int len;
    public  static int index;
    public Question1656OrderedStream(int n) {
        res = new ArrayList<>(n + 2);
        for (int i = 0; i <= n + 1; i++) {
            res.add("false");
        }
        len = n;
        index = 1;
    }

    public static List<String> insert(int idKey, String value) {
        res.remove(idKey);
        res.add(idKey,value);
        List<String> temp = new ArrayList<>();
        if (idKey == index){
            int num = index;
            for (int i = idKey; i <= len; i++) {
                if (res.get(i).equals("false")){
                    break;
                } else {
                    temp.add(res.get(i));
                    num= i;
                }
            }
            index = num + 1;
        }

        return temp;
    }

    public static void main(String[] args) {
        Question1656OrderedStream os= new Question1656OrderedStream(5);
        os.insert(3, "ccccc").stream().toString(); // 插入 (3, "ccccc")，返回 []
        os.insert(1, "aaaaa").stream().toString(); // 插入 (1, "aaaaa")，返回 ["aaaaa"]
        os.insert(2, "bbbbb").stream().toString(); // 插入 (2, "bbbbb")，返回 ["bbbbb", "ccccc"]
        os.insert(5, "eeeee").stream().toString(); // 插入 (5, "eeeee")，返回 []
        os.insert(4, "ddddd").stream().toString(); // 插入 (4, "ddddd")，返回 ["ddddd", "eeeee"]


    }
}
