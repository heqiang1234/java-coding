package com.leetcode.sginin;

import java.util.List;

public class Question3349HasIncreasingSubarrays {

    public boolean hasIncreasingSubarrays(List<Integer> nums, int k) {
        int res = 0;
        int cnt = 1, precnt = 0;
        for (int i = 1; i < nums.size(); i++) {
            if (nums.get(i) > nums.get(i - 1)) {
                ++cnt;
            } else {
                precnt = cnt;
                cnt = 1;
            }

            res = Math.max(res, Math.min(cnt, precnt));
            res = Math.max(res, cnt / 2);
        }
        return res >= k;
    }

}
