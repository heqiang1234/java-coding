package com.leetcode.all;

import java.util.Random;

/**
 * @program: demo
 * @description: 398. 随机数索引
 * @author: Mr.He
 * @create: 2022-01-16 14:02
 **/
public class Question389Solution {

    public int[] res;
    public Random random;

    public Question389Solution(int[] nums) {
        res = nums;
        random = new Random();
    }

    public int pick(int target) {
        int idx = 0;
        int ans = 0;
        for (int i = 0; i < res.length; i++) {
            if (res[i] == target){
                idx++;
                if (random.nextInt(idx) == 0) {
                    ans = i;
                }
            }
        }
        return ans;
    }
}
