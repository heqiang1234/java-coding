package com.leetcode.sginin;

/**
 * @author heqiang
 * @date 2025年07月16日14:03
 */
public class Question3201MaximumLength {

    // 由于是 % 2，则表示所得到的值要么是0，要么是1.
    public int maximumLength(int[] nums) {
        int len = nums.length;
        if (len == 2) {
            return 2;
        }
        // 三种情况，纯奇数，纯偶数，奇偶交替
        //lastNum存上一个数字是奇数还是偶数，
        int js = 0, os = 0, rs = 0, lastNum = -1;
        for (int i = 1; i < len; i++) {
            if (nums[i] % 2 == 0) {
                os++;
                // 如果上一个是偶数，则这次的奇偶交替打乱，则不进行下面的rs增加
                if (lastNum == 0) {
                    continue;
                }
                lastNum = 0;
            } else {
                js++;
                // 同理
                if (lastNum == 1) {
                    continue;
                }
                lastNum = 1;
            }
            rs++;
        }

        return Math.max(rs, Math.max(os,js));
    }

    // 1,2,1,1,2,1,2
    //0,0 % 2 =0
    //0,1 % 2 = 1
    //1,0 % 2 = 1
    //1，1 % 2 = 0

}
