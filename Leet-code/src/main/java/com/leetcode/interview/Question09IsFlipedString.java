package com.leetcode.interview;

/**
 * @program: demo
 * @description: 面试题 01.09. 字符串轮转
 * @author: Mr.He
 * @create: 2021-12-06 14:43
 * <p>
 * 字符串轮转。给定两个字符串s1和s2，请编写代码检查s2是否为s1旋转而成（比如，waterbottle是erbottlewat旋转后的字符串）。
 * <p>
 * 示例1:
 * <p>
 * 输入：s1 = "waterbottle", s2 = "erbottlewat"
 * 输出：True
 * 示例2:
 * <p>
 * 输入：s1 = "aa", s2 = "aba"
 * 输出：False
 * 提示：
 * <p>
 * 字符串长度在[0, 100000]范围内。
 * 说明:
 * <p>
 * 你能只调用一次检查子串的方法吗？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/string-rotation-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class Question09IsFlipedString {

    public static Boolean isFlipedString(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(s2);
        stringBuilder.append(s2);
        String resStr = stringBuilder.toString();
        //直接使用内置函数
        //return resStr.contains(s1);
        return isExist(resStr.toString(), s1);
    }

    //不使用内置函数，进行字符的匹配
    //字符暴力匹配
    public static Boolean isExist(String s1, String s2) {
        int j = 0;
        int i = 0;
        while (i < s1.length() && j < s2.length()) {
            if (s1.charAt(i) == s2.charAt(j)) {
                j++;
                i++;
            } else {
                j = 0;
                i = i - j + 1;
            }
        }
        if (j == s2.length()) {
            return true;
        } else {
            return false;
        }
    }

    //尝试  子串匹配KMP算法
    public static Boolean isExistKmp(String s1, String s2) {
        int j = 0;
        int i = 0;
        int[] next = initNext(s2);
        while (i < s1.length() && j < s2.length()) {
            if (s1.charAt(i) == s2.charAt(j)) {
                j++;
                i++;
            } else {
                if(j == 0) {
                    i++;
                } else {
                    j = next[i -1] + 1;
                }
            }
        }
        if (j == s2.length()) {
            return true;
        } else {
            return false;
        }
    }

    public static int[] initNext(String str) {
        int[] next = new int[str.length()];
        next[0] = -1;
        int j = 0;
        for (int i = 1; i < str.length(); i++) {
            j = next[i - 1];
            while (str.charAt(j + 1) != str.charAt(i) && j >= 0) {
                j = next[j];
            }
            if (str.charAt(i) == str.charAt(j + 1)) {
                next[i] = j + 1;
            } else {
                next[i] = -1;
            }
        }
        for (int i = 0; i < next.length; i++) {
            System.out.print(next[i] + " ");
        }
        return next;
    }


    public static void main(String[] args) {
        System.out.println(isFlipedString("waterbottle", "erbottlewat"));
    }
}
