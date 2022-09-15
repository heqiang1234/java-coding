package com.leetcode.wangdaostudylevel2;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author: Mr.He
 * @create: 2022-09-02 11:02
 * @description: 2131. 连接两字母单词得到的最长回文串
 * 给你一个字符串数组 words 。words 中每个元素都是一个包含 两个 小写英文字母的单词。
 *
 * 请你从 words 中选择一些元素并按 任意顺序 连接它们，并得到一个 尽可能长的回文串 。每个元素 至多 只能使用一次。
 *
 * 请你返回你能得到的最长回文串的 长度 。如果没办法得到任何一个回文串，请你返回 0 。
 *
 * 回文串 指的是从前往后和从后往前读一样的字符串。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：words = ["lc","cl","gg"]
 * 输出：6
 * 解释：一个最长的回文串为 "lc" + "gg" + "cl" = "lcggcl" ，长度为 6 。
 * "clgglc" 是另一个可以得到的最长回文串。
 * 示例 2：
 *
 * 输入：words = ["ab","ty","yt","lc","cl","ab"]
 * 输出：8
 * 解释：最长回文串是 "ty" + "lc" + "cl" + "yt" = "tylcclyt" ，长度为 8 。
 * "lcyttycl" 是另一个可以得到的最长回文串。
 * 示例 3：
 *
 * 输入：words = ["cc","ll","xx"]
 * 输出：2
 * 解释：最长回文串是 "cc" ，长度为 2 。
 * "ll" 是另一个可以得到的最长回文串。"xx" 也是。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/longest-palindrome-by-concatenating-two-letter-words
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class Day5_Quesion2131LongestPalindrome {

    public static int longestPalindrome(String[] words) {
        Map<String,Integer> map = new HashMap<>();
        int count = 0;
        for (int i = 0; i < words.length; i++) {
            String str = words[i];
            String strT = revertStr(str);
            if (map.containsKey(strT)){
                count++;
                int n = map.getOrDefault(strT,0);
                if (n == 1){
                    map.remove(strT);
                } else {
                    map.replace(strT,--n);
                }
            } else {
                map.put(str,map.getOrDefault(str,0) + 1);
            }
        }
        boolean flag = false;
        Set<String> strings = map.keySet();
        for (String s: strings) {
            if (s.charAt(0) == s.charAt(1)){
                flag = true;
                break;
            }
        }
        return flag ? count * 4 + 2 : count * 4;
    }

    public static String revertStr(String str){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str.charAt(1));
        stringBuilder.append(str.charAt(0));
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome(new String[]{"qo","fo","fq","qf","fo","ff","qq","qf","of","of","oo","of","of","qf","qf","of"}));
    }

}
