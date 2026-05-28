package com.leetcode.year2023.signin;

/**
 * @author HQ
 * @program: java-coding
 * @description: 1247. 交换字符使得字符串相同
 * @date 2023-02-25 19:40:51
 */
public class Quesiton1247MinimumSwap {

    public int minimumSwap(String s1, String s2) {
        int xy = 0;//统计xy的次数
        int yx = 0;//统计yx的次数
        char ch1;
        char ch2;
        for (int i = 0; i < s1.length(); i++) {
            ch1 = s1.charAt(i);
            ch2 = s2.charAt(i);
            if (ch1 == 'x' && ch2 == 'y') {
                xy++;
            }
            if (ch1 == 'y' && ch2 == 'x') {
                yx++;
            }
        }

        if ((xy + yx) % 2 == 1) {
            //奇数
            return -1;
        }

        //先让两个 xy,xy  或者 yx,yx 内部配对，这样只需要一次
        //如果是xy 和yx则需要换两次
        return xy / 2 + yx / 2 + (xy % 2 + yx % 2);
    }

}
