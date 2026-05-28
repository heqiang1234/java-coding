package com.leetcode.sginin;

import java.util.Enumeration;

/**
 * @author heqiang
 * @date 2025年07月31日11:48
 */
public class Quesiton2683DoesValidArrayExist {

    public static boolean doesValidArrayExist(int[] derived) {
        int len = derived.length;
        for (int i = 0; i <= len - 1; i++) {
            int nextInt = i + 1;
            if (i == len - 1){
                nextInt = 0;
            }
            if (derived[i] == (derived[i] | derived[nextInt])){

            }  else {
                return false;
            }
        }


        return true;
    }

    public static void main(String[] args) {
        doesValidArrayExist(new int[]{1,1,0});
    }
}
