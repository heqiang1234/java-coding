package com.leetcode.sginin;

import java.util.Random;

/**
 * @author: Mr.He
 * @create: 2022-04-25 19:58
 * @description: 398.随机数索引
 **/
public class Question398SolutionPick {

    public int[] res;
    public Random random;

    public Question398SolutionPick(int[] nums) {
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
