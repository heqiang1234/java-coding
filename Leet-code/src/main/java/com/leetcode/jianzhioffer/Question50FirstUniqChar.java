package com.leetcode.jianzhioffer;

import java.util.HashMap;
import java.util.Map;

/**
 * @author heqiang
 * @date 2021/11/19 10:42
 * @desc 剑指 Offer 50. 第一个只出现一次的字符
 *
 * 在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。 s 只包含小写字母。
 *
 * 示例 1:
 *
 * 输入：s = "abaccdeff"
 * 输出：'b'
 * 示例 2:
 *
 * 输入：s = ""
 * 输出：' '
 *  
 *
 * 限制：
 *
 * 0 <= s 的长度 <= 50000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/di-yi-ge-zhi-chu-xian-yi-ci-de-zi-fu-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Question50FirstUniqChar {

    //通过map存储，主要是标记了重复的，后续遍历可以减少很大一部分的工作量
    public static char firstUniqChar(String s) {
        if (s.length() == 0 || s.equals("") || s.isEmpty()) {
            return ' ';
        }
        Map<Character, Integer> mapList = new HashMap<>();
        for (int i = 0; i <s.length() ; i++) {
            char tempChar = s.charAt(i);
            if (mapList.containsKey(tempChar)) {
                mapList.put(tempChar, -1);
            } else {
                mapList.put(tempChar, i);
            }
        }
        int first = s.length();
        for (Map.Entry<Character, Integer> map: mapList.entrySet()) {
            int value = map.getValue();
            if (value != -1 && value < first) {
               first = value;
            }
        }
        
        return first == s.length() ? ' ' : s.charAt(first);
    }

    public static void main(String[] args) {
        String s = "abaccdeff";
        System.out.println(firstUniqChar(s));
    }
}
