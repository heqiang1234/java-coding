package com.leetcode.sginin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author HQ
 * @program: java-coding
 * @description: 03.3. 无重复字符的最长子串
 * @date 2022-07-18 22:06:36
 * <p>
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 * <p>
 * 输入: s = "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 * <p>
 * 输入: s = "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/longest-substring-without-repeating-characters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Question03LengthOfLongestSubstring {

    //暴力破解
    public static int lengthOfLongestSubstring(String s) {
        int len = s.length();
        int count = 0, tempCount = 0;
        if (s.length() == 0) {
            return 0;
        }
        List<Character> res = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            count = Math.max(count, tempCount);
            tempCount = 0;
            res.clear();
            for (int j = i; j < len; j++) {
                Character ch = s.charAt(j);
                if (!res.contains(ch)) {
                    res.add(ch);
                    tempCount++;
                } else {
                    break;
                }
            }
        }
        count = Math.max(count, tempCount);
        return count;
    }

    //滑动窗口
    public static int lengthOfLongestSubstring1(String s) {
        if (s.length() <= 1){
            return s.length();
        }
        //从长度n开始,然后依次减少
        int n = s.length();
        int maxLen = 0;
        int i = 0;
        while (i < s.length()) {
            int temp = i, tempJ = i;
            HashMap<Character, Integer> map = new HashMap<>();
            for (int j = i; j < n; j++) {
                Character ch = s.charAt(j);
                if (map.containsKey(ch)) {
                    i = map.get(ch);
                    break;
                } else {
                    map.put(ch, j);
                }
                tempJ = j;
            }
            maxLen = Math.max(maxLen, tempJ - temp + 1);
            i++;
        }
        return maxLen;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring1("pwwkew"));
    }

}
