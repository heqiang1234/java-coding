package com.leetcode.sginin;

/**
 * @author heqiang
 * @date 2026年03月04日14:18
 */
public class Question1582NumSpecial {

    public int numSpecial(int[][] mat) {
        int res = 0;
        for (int [] ns : mat){
            int rowSum = 0,j = 0;
            for (int i = 0; i < ns.length; i++) {
                if (ns[i] == '1'){
                    rowSum++;
                    j = i;
                }
                if (rowSum > 1) break;
            }
            if (rowSum != 1) continue;

            // 到了这里表示这一行符合需求，下面计算列
            int colSum = 0;
            for (int [] nn : mat){
                colSum += nn[j];
            }
            if (colSum == 1) res++;
        }
        return res;
    }
}
