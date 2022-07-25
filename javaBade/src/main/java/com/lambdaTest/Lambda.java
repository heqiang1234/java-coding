package com.lambdaTest;

/**
 * @author HQ
 * @program: java-coding
 * @description: lambda
 * @date 2022-07-25 22:03:39
 */
public class Lambda {

    public static void main(String[] args) {
        //1.标准使用方式
        MathOperation mathOperation = (Integer a, Integer b) -> {
            System.out.println("加法运算");
            return a + b + 0f;
        };
        System.out.println(mathOperation.operate(1, 2));
    }
}
