package com.leetcode.jianzhioffer;

/**
 * @author HQ
 * @create 2021/11/5 22:24
 * @DESC 剑指 Offer 58 - II. 左旋转字符串
 * 字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。请定义一个函数实现字符串左旋转操作的功能。比如，输入字符串"abcdefg"和数字2，该函数将返回左旋转两位得到的结果"cdefgab"。
 *
 * 示例 1：
 * 输入: s = "abcdefg", k = 2
 * 输出: "cdefgab"
 * 示例 2：
 *
 * 输入: s = "lrloseumgh", k = 6
 * 输出: "umghlrlose"
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/zuo-xuan-zhuan-zi-fu-chuan-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Question58ReverseLeftWords {

    //直接拼接
    public String reverseLeftWords(String s, int n) {
        StringBuilder s1 = new StringBuilder();
        StringBuilder s2 = new StringBuilder();
        int m =0;
        for (char c : s.toCharArray()) {
            if (m < n) {
                s1.append(c);
            } else {
                s2.append(c);
            }
            m++;
        }
        s2.append(s1);
        return s2.toString();
    }
}
