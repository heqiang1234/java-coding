package com.leetcode.hotinterview;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @program: demo
 * @description: 3. 无重复字符的最长子串
 * @author: Mr.He
 * @create: 2022-01-19 15:57
 *
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 *
 * 输入: s = "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 *
 * 输入: s = "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 * 示例 4:
 *
 * 输入: s = ""
 * 输出: 0
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class Question3LengthOfLongestSubstring {

    public static int lengthOfLongestSubstring(String s) {
        if (s.length() <= 1){
            return s.length();
        }
        char[] res = s.toCharArray();
        int i = 0;
        int maxLen = 0;
        while (i < s.length()){
            int temp = i;
            int tempJ = i;
            Map<Character,Integer> map = new HashMap<>();
            for (int j = i; j < res.length; j++) {
                //System.out.println(map.containsKey(res[j]));
                if (map.containsKey(res[j])){
                    i = map.get(res[j]);
                   break;
               } else {
                   map.put(res[j], j);
               }
                tempJ = j;
            }
            maxLen = Math.max(maxLen,tempJ - temp + 1);
            i++;
        }
        return maxLen;
    }

    public static int lengthOfLongestSubstring2(String s) {
        if (s.length() <= 1){
            return s.length();
        }
        char[] res = s.toCharArray();
        int maxLen = 0;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {

        }
        return maxLen;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("bbbbb"));
    }
}
