package com.leetcode.sginin;

/**
 * @author HQ
 * @program: java-coding
 * @description: 1417. 重新格式化字符串
 * @date 2022-08-11 22:21:19
 * 给你一个混合了数字和字母的字符串 s，其中的字母均为小写英文字母。
 * <p>
 * 请你将该字符串重新格式化，使得任意两个相邻字符的类型都不同。也就是说，字母后面应该跟着数字，而数字后面应该跟着字母。
 * <p>
 * 请你返回 重新格式化后 的字符串；如果无法按要求重新格式化，则返回一个 空字符串 。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "a0b1c2"
 * 输出："0a1b2c"
 * 解释："0a1b2c" 中任意两个相邻字符的类型都不同。 "a0b1c2", "0a1b2c", "0c2a1b" 也是满足题目要求的答案。
 * 示例 2：
 * <p>
 * 输入：s = "leetcode"
 * 输出：""
 * 解释："leetcode" 中只有字母，所以无法满足重新格式化的条件。
 * 示例 3：
 * <p>
 * 输入：s = "1229857369"
 * 输出：""
 * 解释："1229857369" 中只有数字，所以无法满足重新格式化的条件。
 * 示例 4：
 * <p>
 * 输入：s = "covid2019"
 * 输出："c2o0v1i9d"
 * 示例 5：
 * <p>
 * 输入：s = "ab123"
 * 输出："1a2b3"
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/reformat-the-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Question1417Reformat {

    public static String reformat(String s) {
        int len = s.length();

        StringBuilder num = new StringBuilder();//统计数字

        StringBuilder chars = new StringBuilder();//统计字母
        for (int i = 0; i < len; i++) {
            char ch = s.charAt(i);
            if (ch <= 'z' && ch >= 'a') {
                chars.append(ch);
            }
            if (ch >= '0' && ch <= '9') {
                num.append(ch);
            }
        }
        int countNum = num.length();
        int countCh = chars.length();
        if (Math.abs(countCh - countNum) > 1) {
            return "";
        }
        int total = countCh + countNum;
        StringBuilder res = new StringBuilder();
        while (res.length() != total){
            if (countCh > countNum){
                res.append(chars.charAt(--countCh));
            } else if (countCh < countNum){
                res.append(num.charAt(--countNum));
            } else {
                if (res.length() != 0 && res.charAt(res.length() - 1) >= 'a')  res.append(num.charAt(--countNum));
                else res.append(chars.charAt(--countCh));
            }
        }
        return res.toString();
    }

    public String reformat2(String s) {
        int len = s.length();
        int countNum = 0;
        char[] num = new char[len];//统计数字
        int countCh = 0;
        char[] chars = new char[len];//统计字母
        for (int i = 0; i < len; i++) {
            char ch = s.charAt(i);
            if (ch <= 'z' && ch >= 'a') {
                chars[countCh] = ch;
                countCh++;
            }
            if (ch >= '0' && ch <= '9') {
                num[countNum] = ch;
                countNum++;
            }
        }
        if (Math.abs(countCh - countNum) > 1) {
            return "";
        }
        StringBuilder res = new StringBuilder();
        if (countCh > countNum) {
            while (countNum >= 0) {
                res.append(chars[countCh--]);
                res.append(num[countNum--]);
            }
            res.append(chars[countCh]);
        } else if (countCh < countNum) {
            while (countCh >= 0) {
                res.append(chars[countNum--]);
                res.append(num[countCh--]);
            }
            res.append(chars[countNum]);
        } else {
            while (countCh >= 0) {
                res.append(chars[countCh--]);
                res.append(num[countNum--]);
            }
        }
        return res.toString();
    }

    public static void main(String[] args) {
        System.out.println(reformat("a0b1c2"));
    }

}
