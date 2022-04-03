package com.leetcode.all;

/**
 * @program: demo
 * @description: 944. 删列造序
 * @author: Mr.He
 * @create: 2022-03-25 09:56
 **/
public class Question994MinDeletionSize {

    public static int minDeletionSize(String[] strs) {
        int sum = 0;
        int len = strs.length;
        int len2 = strs[0].length();
        Boolean flag;
        for (int i = 0; i < len2; i++) {
            flag = false;
            for (int j = 1; j < len; j++) {
                if ((strs[j - 1].charAt(i)-'a') > (strs[j].charAt(i) - 'a')){
                    flag = true;
                    break;
                }
            }
            if (flag){
                sum++;
            }
        }
        return sum;
    }

    @Deprecated
//    public static boolean dul(String str){
//        char[] res = str.toCharArray();
//        int len = str.length() - 1;
//        for (int i = 1; i < len; i++) {
//            if ((res[i - 1] -'a') >= (res[i] - 'a')){
//                return true;
//            }
//        }
//        return false;
//    }

    public static void main(String[] args) {
        String [] res = new String[]{"rrjk","furt","guzm"};
        System.out.println(minDeletionSize(res));
    }
}
