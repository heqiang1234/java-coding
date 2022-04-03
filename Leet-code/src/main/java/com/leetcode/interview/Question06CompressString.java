package com.leetcode.interview;/**
 * @author HQ
 * @create 2021/12/3 20:05
 */

import java.util.Arrays;

/**
 * @author HQ
 * @program: demo
 * @description: 面试题 01.06. 字符串压缩
 * @date 2021-12-03 20:05:47
 * <p>
 * 字符串压缩。利用字符重复出现的次数，编写一种方法，实现基本的字符串压缩功能。比如，字符串aabcccccaaa会变为a2b1c5a3。若“压缩”后的字符串没有变短，则返回原先的字符串。你可以假设字符串中只包含大小写英文字母（a至z）。
 * <p>
 * 示例1:
 * <p>
 * 输入："aabcccccaaa"
 * 输出："a2b1c5a3"
 * 示例2:
 * <p>
 * 输入："abbccd"
 * 输出："abbccd"
 * 解释："abbccd"压缩后为"a1b2c2d1"，比原字符串长度更长。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/compress-string-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Question06CompressString {

    //这个是统计字符串所有字母的地方
    @Deprecated
    public static String compressString(String str) {
        if (str == null || str.length() == 0) {
            return null;
        }
        int[] ch = new int[129];
        Arrays.fill(ch, 0);
        int count = 0;
        int len = 0;
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < ch.length; i++) {
            if(ch[i] != 0) {
                stringBuffer.append((char)i);
                stringBuffer.append(ch[i]);
                len = len + 2;
            }
        }
        if(len > str.length()) {
            return str;
        }
        return stringBuffer.toString();
    }


    public static String compressStringOne(String str) {
        if (str == null || str.length() == 0) {
            return str;
        }

        StringBuffer stringBuffer = new StringBuffer();
        int count=1;
        //将第一个字符存进去，和后续的字符进行对比
        char ch = str.charAt(0);
        //aabccdddaa
        for (int i = 1; i < str.length(); i++) {
            //如果相同，那就数量+1
            if (ch == str.charAt(i) ) {
                count++;
            } else {
                //当前序字符和后面的不同时，说明前面相同的字符串计算完毕，直接存进去，该字符，数量
                stringBuffer.append(ch);
                stringBuffer.append(count);
                //将ch字符修改，重置为 当前不同的那个字符，
                ch = str.charAt(i);
                //数量重置
                count = 1;
            }
        }
        stringBuffer.append(ch);
        stringBuffer.append(count);
        //如果压缩后的长度没有减少，那么就将原字符串返回
        if(stringBuffer.length() >= str.length()) {
            return str;
        }
        return stringBuffer.toString();
    }

    public static void main(String[] args) {
        System.out.println(compressStringOne("abbccd"));
    }
}
