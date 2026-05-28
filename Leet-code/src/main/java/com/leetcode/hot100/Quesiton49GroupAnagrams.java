package com.leetcode.hot100;

import java.util.*;

/**
 * @author heqiang
 * @date 2025年07月31日16:31
 */
public class Quesiton49GroupAnagrams {

    /**
     * 给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。
     * <p>
     * <p>
     * <p>
     * 示例 1:
     * <p>
     * 输入: strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
     * <p>
     * 输出: [["bat"],["nat","tan"],["ate","eat","tea"]]
     * <p>
     * 解释：
     * <p>
     * 在 strs 中没有字符串可以通过重新排列来形成 "bat"。
     * 字符串 "nat" 和 "tan" 是字母异位词，因为它们可以重新排列以形成彼此。
     * 字符串 "ate" ，"eat" 和 "tea" 是字母异位词，因为它们可以重新排列以形成彼此。
     *
     * @param strs
     * @return
     */
    public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        List<String> list1 = new ArrayList<>();
        if (strs.length == 0) {
            return res;
        }

        String tmpStr = strs[0];
        list1.add(tmpStr);
        res.add(list1);
        for (int i = 1; i < strs.length; i++) {
            if (Judge(tmpStr, strs[i])) {
                for (int j = 0; j < res.size(); j++) {
                    if (Judge(tmpStr, res.get(j).get(0))) {
                        res.get(j).add(tmpStr);
                    }
                }
            } else {
                tmpStr = strs[i];
                int a = 0;
                for (int j = 0; j < res.size(); j++) {
                    if (Judge(tmpStr, res.get(j).get(0))) {
                        res.get(j).add(tmpStr);
                        a= 1;
                        break;
                    }
                }
                if (a == 0){
                    List<String> str1 = new ArrayList<>();
                    str1.add(tmpStr);
                    res.add(str1);
                }

            }
        }
        Collections.sort(res,(list3,list4) -> list3.size() - list4.size());
        return res;
    }


    public static boolean Judge(String str1, String str2) {
        for (int i = 0; i < str1.length(); i++) {
            if (str2.indexOf(str1.charAt(i)) == -1) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"});
    }
}
