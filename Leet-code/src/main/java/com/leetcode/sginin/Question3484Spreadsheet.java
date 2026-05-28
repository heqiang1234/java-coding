package com.leetcode.sginin;

/**
 * @author heqiang
 * @date 2025年09月19日10:11
 */
public class Question3484Spreadsheet {

    /*
    电子表格是一个网格，它有 26 列（从 'A' 到 'Z'）和指定数量的 rows。每个单元格可以存储一个 0 到 105 之间的整数值。

    请你实现一个 Spreadsheet 类：

    Spreadsheet(int rows) 初始化一个具有 26 列（从 'A' 到 'Z'）和指定行数的电子表格。所有单元格最初的值都为 0 。
    void setCell(String cell, int value) 设置指定单元格的值。单元格引用以 "AX" 的格式提供（例如，"A1"，"B10"），
    其中字母表示列（从 'A' 到 'Z'），数字表示从 1 开始的行号。
    void resetCell(String cell) 重置指定单元格的值为 0 。
    int getValue(String formula) 计算一个公式的值，格式为 "=X+Y"，其中 X 和 Y 要么 是单元格引用，要么非负整数，返回计算的和。
    注意： 如果 getValue 引用一个未通过 setCell 明确设置的单元格，则该单元格的值默认为 0 。
     */
    static int[][] nums;
    static String ENG_CHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public Question3484Spreadsheet(int rows) {
        nums = new int[rows][26];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < 26; j++) {
                nums[i][j] = 0;
            }
        }
    }

    public void setCell(String cell, int value) {
        int col = cell.charAt(0) - 'A';
        int rows = changeToNum(cell, 0) - 1;
        nums[rows][col] = value;
    }

    public void resetCell(String cell) {
        int col = cell.charAt(0) - 'A';
        int rows = changeToNum(cell, 0) - 1;
        nums[rows][col] = 0;
    }

    public int getValue(String formula) {
        String[] splt1 = formula.split("=");
        String[] splt2 = splt1[1].split("\\+");
        int[] cr1 = getColRow(splt2[0]);
        int[] cr2 = getColRow(splt2[1]);
        int row1 = cr1[1];
        int col1 = cr1[0];
        int row2 = cr2[1];
        int col2 = cr2[0];

        int nums1 = 0;
        if (cr1[0] >= 27) {
            nums1 = cr1[1];
        } else {
            nums1 = nums[row1 - 1][col1];
        }

        int nums2 = 0;
        if (cr2[0] >= 27) {
            nums2 = cr2[1];
        } else {
            nums2 = nums[row2 - 1][col2];
        }

        return nums1 + nums2;
    }

    public int changeToNum(String srcStr, int action) {
        int srcNum = 0;
        if (action == 0) {
            char[] cg = new char[5];
            int len = srcStr.length();

            srcStr.getChars(1, len, cg, 0);
            for (int i = 0; i < srcStr.length() - 1; i++) {
                srcNum = (srcNum) * 10 + cg[i] - '0';
            }
        } else {
            if (ENG_CHARS.contains(srcStr.charAt(0) + "")) {
                return changeToNum(srcStr, 0);
            } else {
                for (int i = 0; i < srcStr.length(); i++) {
                    srcNum = (srcNum) * 10 + srcStr.charAt(i) - '0';
                }
            }
        }

        return srcNum;
    }

    // A10   20
    public int[] getColRow(String str) {
        int[] res = new int[2];
        if (str.charAt(0) >= 'A' && str.charAt(0) <= 'Z') {
            res[0] = str.charAt(0) - 'A';
            res[1] = changeToNum(str, 0);
        } else {
            res[0] = 27;
            res[1] = changeToNum(str, 1);
        }
        return res;
    }

    public static void main(String[] args) {
        Question3484Spreadsheet spreadsheet = new Question3484Spreadsheet(24); // 初始化一个具有 3 行和 26 列的电子表格
        //spreadsheet.getValue("=5+7"); // 返回 12 (5+7)
        spreadsheet.setCell("B24", 10); // 设置 A1 为 10
        spreadsheet.getValue("=A1+6"); // 返回 16 (10+6)
        spreadsheet.setCell("B2", 15); // 设置 B2 为 15
        spreadsheet.getValue("=A1+B2"); // 返回 25 (10+15)
        spreadsheet.resetCell("A1"); // 重置 A1 为 0
        spreadsheet.getValue("=A1+B2"); // 返回 15 (0+15)
    }
}
