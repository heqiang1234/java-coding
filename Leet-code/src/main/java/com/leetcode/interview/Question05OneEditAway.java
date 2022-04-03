package com.leetcode.interview;

/**
 * @program: demo
 * @description: 面试题 01.05. 一次编辑
 * @author: Mr.He
 * @create: 2021-12-03 15:51
 * <p>
 * 字符串有三种编辑操作:插入一个字符、删除一个字符或者替换一个字符。 给定两个字符串，编写一个函数判定它们是否只需要一次(或者零次)编辑。
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入:
 * first = "pale"
 * second = "ple"
 * 输出: True
 *  
 * <p>
 * 示例 2:
 * <p>
 * 输入:
 * first = "pales"
 * second = "pal"
 * 输出: False
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/one-away-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class Question05OneEditAway {

    //考虑片面
    @Deprecated
    public static boolean oneEditAway(String first, String second) {
        //如果两个字符串都为空，则进行false处理
        if (first == null || second == null) {
            return false;
        }
        //记录第一个，第二个字符串长度，后续使用
        int firstLen = first.length();
        int secondLen = second.length();
        //因为这边只能处理一次，所以这边直接判断长度
        if (Math.abs(firstLen - secondLen) >= 2) {
            return false;
        }
        //如果两个字符串，equal那就直接true,
        if (first.equals(second)) {
            return true;
        }
        //这里主要考虑ascII码的所有情况 128个字符
        long high64 = 0;
        long low64 = 0;
        int count = 0;
        for (char c : first.toCharArray()) {
            if (c > 64) {
                long bitIndex = 1 << (c - 64);
                if ((bitIndex & high64) != 0) {
                    count++;
                }
                high64 ^= bitIndex;
            } else {
                long bitIndex = 1 << c;
                if ((bitIndex & low64) != 0) {
                    count++;
                }
                low64 ^= bitIndex;
            }
        }

        for (char c : second.toCharArray()) {
            if (c > 64) {
                long bitIndex = 1 << (c - 64);
                if ((bitIndex & high64) != 0) {
                    count++;
                }
                high64 ^= bitIndex;
            } else {
                long bitIndex = 1 << c;
                if ((bitIndex & low64) != 0) {
                    count++;
                }
                low64 ^= bitIndex;
            }
        }
        if (firstLen == secondLen) {
            if ((count * 2 + 2) == (firstLen + secondLen)) {
                return true;
            }
        } else {
            if ((count * 2 + 1) == (firstLen + secondLen)) {
                return true;
            }
        }
        return false;//未考虑到顺序的影响，这个方法不行，舍弃
    }

    public static boolean oneEditAwayAnother(String first, String second) {
        //如果两个字符串都为空，则进行false处理
        if (first == null || second == null) {
            return false;
        }
        //记录第一个，第二个字符串长度，后续使用
        int firstLen = first.length();
        int secondLen = second.length();
        //因为这边只能处理一次，所以这边直接判断长度，如果大于2，就直接false
        if (Math.abs(firstLen - secondLen) >= 2) {
            return false;
        }
        //如果两个字符串，equal那就直接true,
        if (first.equals(second)) {
            return true;
        }
        //始终保证first为短的字符串
        if (firstLen > secondLen) {
            return oneEditAwayAnother(second, first);
        }
        //定义一个记录值
        int count = 0;
        //长度相同时候
        if (firstLen == secondLen) {
            for (int i = 0; i < firstLen; i++) {
                if (first.charAt(i) != second.charAt(i)) {
                    count++;
                }
            }
            //如果不同点只有一处，返回true,大于1处，返回false
            return count <= 1;
        }

        //长度不同时
        int i = 0,diffChar = 0;
        while (i < firstLen) {
            //这里留一个diffCahr，留给不同的那一处
            //相等于修改短字符串，碰到不同的，跳过一次，
            if(first.charAt(i) != second.charAt(i + diffChar)) {
                //碰到不同处，记录一个不同点，如果出现第二次，直接false退出
                if(++diffChar > 1) {
                    return false;
                }
            } else {
                i++;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(oneEditAwayAnother("islander","slander"));
    }
}
