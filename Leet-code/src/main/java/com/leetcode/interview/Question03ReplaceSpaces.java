package com.leetcode.interview;

/**
 * @program: demo
 * @description: 面试题 01.03. URL化
 * @author: Mr.He
 * @create: 2021-12-02 17:38
 * <p>
 * URL化。编写一种方法，将字符串中的空格全部替换为%20。假定该字符串尾部有足够的空间存放新增字符，并且知道字符串的“真实”长度。（注：用Java实现的话，请使用字符数组实现，以便直接在数组上操作。）
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入："Mr John Smith    ", 13
 * 输出："Mr%20John%20Smith"
 * 示例 2：
 * <p>
 * 输入："               ", 5
 * 输出："%20%20%20%20%20"
 *  
 * <p>
 * 提示：
 * <p>
 * 字符串长度在 [0, 500000] 范围内。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/string-to-url-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class Question03ReplaceSpaces {

    public static String replaceSpaces(String S, int length) {
        //如果为空，返回null
        if (S == null) {
            return null;
        }
        char[] charRes = new char[length * 3 + 1];
        //遍历字符串，获取空格
        //定义结果得长度
        int j = 0;
        for (int i = 0; i < length; i++, j++) {
            if (S.charAt(i) == ' ') {
                charRes[j] = '%';
                charRes[++j] = '2';
                charRes[++j] = '0';
            } else {
                charRes[j] = S.charAt(i);
            }
        }
        //定义一个返回结果得数组
        char[] chars = new char[j];
        //去除多余得部分
        for (int i = 0; i < j; i++) {
            chars[i] = charRes[i];
        }
        return String.valueOf(chars);
    }

    public static void main(String[] args) {
        System.out.println(replaceSpaces("Mr John Smith    ", 13));
    }
}
