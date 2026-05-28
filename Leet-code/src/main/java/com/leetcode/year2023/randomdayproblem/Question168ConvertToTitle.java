package com.leetcode.year2023.randomdayproblem;

/**
 * @author HQ
 * @program: java-coding
 * @description: 168.Excel表列名称
 * @date 2023-01-11 21:39:29
 */
public class Question168ConvertToTitle {

    /**
     * A - 1      Z - 26
     * AA - 27     AZ - 52
     * BA - 53      BZ - 78
     *
     *
     * @param columnNumber
     * @return
     */
    public static String converTotile(int columnNumber)
    {
        StringBuilder res = new StringBuilder();
        while (columnNumber != 0){
            int lastNum = 0;
            for (int i = 1; i <= 26; i++) {
                int temp = (columnNumber - i) / 26;
                if (temp * 26 == columnNumber - i){
                    lastNum = i;
                    break;
                }
            }
            char ch = (char) (lastNum + 64);
            columnNumber = (columnNumber - lastNum) / 26;
            res.append(ch);
        }
        StringBuilder str = new StringBuilder();
        for (int i = res.length() - 1; i >= 0; i--) {
            str.append(res.charAt(i));
        }
        return str.toString();
    }

    //宫水三叶大佬的题解，提前 - 1
    //求新位的时候，对当前数 −1,再进制转换，即为所求。
    /**
     *
     * @param columnNumber
     * @return
     */
    public String converTotile_1 (int columnNumber)
    {
        //输入 1 即证明 - 1
        StringBuilder str = new StringBuilder();
        while (columnNumber > 0){
            columnNumber--;
            str.append((char) columnNumber % 26 + 'A');
            columnNumber /=26;
        }
        return str.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(converTotile(2147483647));
    }
}
