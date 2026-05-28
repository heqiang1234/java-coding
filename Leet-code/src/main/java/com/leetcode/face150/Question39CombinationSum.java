package com.leetcode.face150;

import java.util.ArrayList;
import java.util.List;

/**
 * @author heqiang
 * @date 2025年07月20日15:51
 */
public class Question39CombinationSum {

    public  static List<List<Integer>> res = new ArrayList<>();;
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        //List<List<Integer>> res = new ArrayList<>();
        int count = 0;
        for (int i = 0; i < candidates.length; i++) {
            dp(candidates, target - candidates[i]);
        }

        return res;
    }

    // 使用dp .
    // candidates = [2,3,6,7], target = 7
    // 查找， dp(7 - 2).dp(7 -3 ),dp (7 -6).dp(7-7);
    //
    public static void dp(int[] cand, int target) {
        List<Integer> ress = new ArrayList<>();
        ress.add(target);
        if (target == 0) {
            res.add(ress);
            return ;
        }
        if (target < 0){
            ress.clear();
            return;
        }
        for (int i = 0; i < cand.length; i++) {
            dp(cand, target - cand[i]);
        }
        return ;
    }

    public static void main(String[] args) {
        System.out.println(combinationSum(new int[]{2, 3, 6, 7}, 7));
    }
}
