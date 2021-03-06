package com.leetcode.sginin;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Mr.He
 * @create: 2022-05-17 17:23
 * @description: 953. 验证外星语词典
 * <p>
 * 某种外星语也使用英文小写字母，但可能顺序 order 不同。字母表的顺序（order）是一些小写字母的排列。
 * <p>
 * 给定一组用外星语书写的单词 words，以及其字母表的顺序 order，只有当给定的单词在这种外星语中按字典序排列时，返回 true；否则，返回 false。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：words = ["hello","leetcode"], order = "hlabcdefgijkmnopqrstuvwxyz"
 * 输出：true
 * 解释：在该语言的字母表中，'h' 位于 'l' 之前，所以单词序列是按字典序排列的。
 * 示例 2：
 * <p>
 * 输入：words = ["word","world","row"], order = "worldabcefghijkmnpqstuvxyz"
 * 输出：false
 * 解释：在该语言的字母表中，'d' 位于 'l' 之后，那么 words[0] > words[1]，因此单词序列不是按字典序排列的。
 * 示例 3：
 * <p>
 * 输入：words = ["apple","app"], order = "abcdefghijklmnopqrstuvwxyz"
 * 输出：false
 * 解释：当前三个字符 "app" 匹配时，第二个字符串相对短一些，然后根据词典编纂规则 "apple" > "app"，因为 'l' > '∅'，其中 '∅' 是空白字符，定义为比任何其他字符都小（更多信息）
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/verifying-an-alien-dictionary
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class Question953IsAlienSorted {

    public static boolean isAlienSorted(String[] words, String order) {
        List<Character> del = new ArrayList<>();
        for (int i = 0; i < order.length(); i++) {
            del.add(order.charAt(i));
        }
        String temp = words[0];
        for (int i = 1; i < words.length; i++) {
            if (!isSortByDeli(temp, words[i], del)){
                return false;
            }
            temp = words[i];
        }
        return true;
    }

    public static boolean isSortByDeli(String strA, String strB, List<Character> order) {
        int len = strA.length() > strB.length() ? strB.length() : strA.length();
        for (int i = 0; i < len; i++) {
            if (order.indexOf(strA.charAt(i)) < order.indexOf(strB.charAt(i))) {
                return true;
            } else if (order.indexOf(strA.charAt(i)) > order.indexOf(strB.charAt(i))) {
                return false;
            }
        }
        if (strA.length() <= strB.length()) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        String [] words = new String[]{"hello","leetcode"};
        String orders = "hlabcdefgijkmnopqrstuvwxyz";
        System.out.println(isAlienSorted(words, orders));
    }
}
