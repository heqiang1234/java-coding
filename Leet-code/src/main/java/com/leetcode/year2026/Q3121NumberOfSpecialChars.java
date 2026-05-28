package com.leetcode.year2026;

/**
 * @author heqiang
 * @date 2026年05月28日8:55
 */
public class Q3121NumberOfSpecialChars {

    // 状态设置，  -1 表示有问题的  ，2- 表示完结， 1表示 就绪 ， 0表示初始状态

    public static int numberOfSpecialChars(String word) {
        int [] stat = new int[27];
        int res = 0;
        for ( char ch : word.toCharArray()){
            int x = ch & 31; // 取出来得到的是1——26；
            if ((ch & 32) <= 0){ // 大写
                if (stat[x] == 1 ){ // 先出现小写，后出现大写，则表示正常。
                    res++;
                    stat[x] = 2;
                } else if (stat[x] == 0){ // 先出现大写，未出现小写，则直接置为 -1
                    stat[x] = -1;
                }
            } else { // 小写
                if (stat[x] == 0){ // 先出现小写，则置为就绪状态
                    stat[x] = 1;
                } else if (stat[x] == 2){ // 当出现完结状态，还是出现一个小写，则表示存在问题，需要立马置为 -1-error 且个数-1
                    stat[x] = -1;
                    res --;
                }
            }
        }
        return res;
    }

    public static int numberOfSpecialChars1(String word) {
        int res = 0;
        int small = 0, big = 0, error = 0;
        for (char ch : word.toCharArray()){
            int bit = ch & 31; // 得到具体的值，a = 1

            if ((ch & 32) > 0){ // 小写
                small |= bit;
                if ((big & bit ) > 0){ // 判断这个位数，有没有在大写的那里出现，出现了，则放进error的里面
                    error |= bit; // 第几位为1.则表示那个字母是失效的
                }
            } else {
                big |= bit;
            }
        }
        return Integer.bitCount(small & big & ~error);
    }

    public static void main(String[] args) {
        System.out.println(numberOfSpecialChars("aaAbcBC"));
         // 计算字母的二进制
         //
        char ch = 'A';
        char chh = 'a';
        int n = 0;
        while (n < 26)
        {
            char ch1 = (char)((int) ch  + n);
            char chh1 = (char)((int) chh  + n);
            System.out.println(ch + " " + ch1 + " " + (ch1 & 31) + " " + (ch1 & 32) + " / " + chh + " " + chh1 + " " + (chh1 & 31) + " " + (chh1 & 32) );
            n++;
        }
    }
}
