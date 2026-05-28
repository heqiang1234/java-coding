package com.leetcode.year2023.signin;

import java.util.HashMap;

/**
 * @author HQ
 * @program: java-coding
 * @description: 1487. 保证文件名唯一
 * @date 2023-03-03 21:58:52
 */
public class Question1487GetFolderNames {

    public String[] getFolderNames(String[] names) {
        int len = names.length;
        HashMap<String, Integer> map = new HashMap<>();
        String[] res = new String[len];
        for (int i = 0; i < len; i++) {
            String str = names[i];
            if (!map.containsKey(str)) {
                map.put(str, 1);
                res[i] = str;
            } else {
                int index = map.get(str).intValue();//获取我们之前存储的位置
                while (map.containsKey(addSufString(str, index))) {
                    index++;
                }
                res[i] = addSufString(str, index);
                map.put(str, index + 1);
                map.put(addSufString(str,index),1);

            }
        }
        return res;
    }

    public String addSufString(String s, int k) {
        return s + "(" + k + ")";
    }
}
