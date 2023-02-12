package com.leetcode.year2023.signin;

import org.apache.el.lang.ELArithmetic;

/**
 * @author HQ
 * @program: java-coding
 * @description: 1138. 字母板上的路径
 * @date 2023-02-12 14:42:59
 */
public class Question1138AlphabetBoardPath {

    private static char nowCh;
    private static int nowX ;
    private static int nowY;
    public static String alphabetBoardPath(String target) {
        String[] board = new String[]{"abcde", "fghij", "klmno", "pqrst", "uvwxy", "z"};
        nowCh = board[0].charAt(0);
        nowX = 0;
        nowY = 0;
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < target.length(); i++) {
            char ch = target.charAt(i);
            int y = (ch - 'a') / 5;
            int x = (ch - 'a') % 5;
            res.append(getRoud(x,y,ch));
        }
        return res.toString();
    }

    public static String getRoud(int x, int y, char ch) {
        StringBuilder tmpStr = new StringBuilder();
        if (x == nowX && y == nowY && nowCh == ch) {
            return "!";
        } else {
            int tempX = nowX - x;
            int tempY = nowY - y;
            if (tempX == 0 && tempY != 0){
                if (tempY > 0){
                    while (tempY != 0){
                        tmpStr.append("U");
                        tempY--;
                    }
                } else {
                    while (tempY != 0){
                        tmpStr.append("D");
                        tempY++;
                    }
                }
            } else if (tempX != 0 && tempY == 0){
                if (tempX > 0){
                    while (tempX != 0){
                        tmpStr.append("L");
                        tempX--;
                    }
                } else {
                    while (tempX != 0){
                        tmpStr.append("R");
                        tempX++;
                    }
                }
            } else {
                if (tempX > 0 && tempY > 0){
                    while (tempX != 0){
                        tmpStr.append("L");
                        tempX--;
                    }
                    while (tempY != 0){
                        tmpStr.append("U");
                        tempY--;
                    }
                } else if (tempX < 0 && tempY < 0){

                    while (tempX != 0){
                        tmpStr.append("R");
                        tempX++;
                    }

                    while (tempY != 0){
                        tmpStr.append("D");
                        tempY++;
                    }
                } else if (tempX > 0 && tempY < 0){
                    while (tempX != 0){
                        tmpStr.append("L");
                        tempX--;
                    }
                    while (tempY != 0){
                        tmpStr.append("D");
                        tempY++;
                    }
                } else if (tempX < 0 && tempY > 0){
                    while (tempY != 0){
                        tmpStr.append("U");
                        tempY--;
                    }

                    while (tempX != 0){
                        tmpStr.append("R");
                        tempX++;
                    }
                }
            }
        }
        tmpStr.append("!");
        nowX = x;
        nowY = y;
        nowCh = ch;
        return tmpStr.toString();
    }

    public static void main(String[] args) {
        System.out.println(alphabetBoardPath("code"));
    }

}
