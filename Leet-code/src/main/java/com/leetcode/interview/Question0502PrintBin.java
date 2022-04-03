package com.leetcode.interview;

/**
 * @program: demo
 * @description: 面试题 05.02. 二进制数转字符串
 * @author: Mr.He
 * @create: 2022-01-05 21:37
 **/
public class Question0502PrintBin {

    public static String printBin(double num) {
        Double temp = 0D;
        StringBuilder stringBuilder = new StringBuilder("0.");
        //因为设定了超过32位直接ERROR
        for (int i = 0; i <= 32; i++) {
            temp = num * 2;
            //乘2法，如果大于一，则取一，否则拼接0.
            if(temp.compareTo(1D) >= 0) {
                stringBuilder.append(1);
                num = temp - 1;
            } else {
                stringBuilder.append(0);
                num = temp;
            }
            if (num == 1 || num == 0){
                return stringBuilder.toString();
            }
        }
        return "ERROR";
    }

    public static void main(String[] args) {
        System.out.println(printBin(0.8125));
    }

}
