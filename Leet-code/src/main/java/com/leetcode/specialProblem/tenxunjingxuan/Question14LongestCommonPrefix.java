package com.leetcode.specialProblem.tenxunjingxuan;

/**
 * @author HQ
 * @program: java-coding
 * @description: 14.最大公共前缀
 * @date 2022-06-09 20:48:38
 *
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 *
 * 如果不存在公共前缀，返回空字符串 ""。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：strs = ["flower","flow","flight"]
 * 输出："fl"
 * 示例 2：
 *
 * 输入：strs = ["dog","racecar","car"]
 * 输出：""
 * 解释：输入不存在公共前缀。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/longest-common-prefix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Question14LongestCommonPrefix {

    public static String longestCommonPrefix(String[] strs) {
        if (strs.length <= 0){
            return null;
        }
        if (strs.length == 1){
            return strs[0];
        }
        String res = strs[0];
        for (int i = 0; i < strs.length; i++) {
            res = getPublicStr(res,strs[i]);
        }
        return res;
    }

    public static String getPublicStr(String str1,String str2){
        int len = Math.min(str1.length(),str2.length());
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < len; i++) {
            if (str1.charAt(i) == str2.charAt(i)){
                str.append(str1.charAt(i));
            } else {
                break;
            }
        }
        return str.toString();
    }

    public static void main(String[] args) {
        System.out.println(longestCommonPrefix(new String[]{"cir","car"}));
    }
}
