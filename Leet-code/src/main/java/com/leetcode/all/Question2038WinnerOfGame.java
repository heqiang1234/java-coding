package com.leetcode.all;

/**
 * @program: demo
 * @description: 2038. 如果相邻两个颜色均相同则删除当前颜色
 * @author: Mr.He
 * @create: 2022-03-22 10:36
 **/
public class Question2038WinnerOfGame {

    public static boolean winnerOfGame(String colors) {
        int len = colors.length();
        if (len <= 2){
            return false;
        }
        char [] res = colors.toCharArray();
        int totleA;
        int totleB;
        int i = 0;
        int resA = 0;
        int resB = 0;
        while (i < (len - 1)){
            totleA = 0;
            totleB = 0;
            while (res[i] == 'A'){
                i++;
                totleA++;
                if (i > (len - 1)){
                    break;
                }
            }
            if (totleA > 2){
                resA += totleA - 2;
            }
            if (i > (len - 1)){
                break;
            }
            while (res[i] == 'B'){
                i++;
                totleB++;
                if (i > (len - 1)){
                    break;
                }
            }
            if (totleB > 2){
                resB += totleB - 2;
            }
        }
        if (resA > resB){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(winnerOfGame("AAAAABBBBBBAAAAA"));
    }
}
