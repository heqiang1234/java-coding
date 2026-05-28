package com.leetcode.sginin;

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;

import java.util.ArrayList;
import java.util.List;

/**
 * @author heqiang
 * @date 2025年08月01日14:49
 */
public class Question118Generate {

    public static List<List<Integer>> generate(int numRows) {
        int level = 0;
        List<List<Integer>> res = new ArrayList<>();
        if (numRows == 1){
            List<Integer> tmp = new ArrayList<>();
            tmp.add(1);
            res.add(tmp);
            return res;
        }
        for (int i = 1; i <= 2; i++) {
            List<Integer> tmp = new ArrayList<>();
            for (int j = 0; j < i; j++) {
                tmp.add(1);
            }
            res.add(tmp);
        }

        for (int i = 2; i < numRows; i++) {
            List<Integer> tmp = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    tmp.add(1);
                } else {
                    tmp.add(res.get(i - 1).get(j - 1) + res.get(i - 1).get(j));
                }
            }
            res.add(tmp);
        }

        return res;
    }

    public static void main(String[] args) {
        generate(5);
    }
}
