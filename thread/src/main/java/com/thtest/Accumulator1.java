package com.thtest;

/**
 * @author: Mr.He
 * @create: 2022-04-23 20:26
 * @description: 线程面试题1
 **/
public class Accumulator1 {

    //尽量避免中间状态。
    //使用一个中间值，sum.只有在统计结束后，才进行resulde赋值，减少了中间状态被改变，从而影响结果的值

    private double result = 0.0D;

    public void addAll(double[] values) {
        double sum = 0.0D;
        for (double value : values) {
            sum += value;
        }
        result += sum;
    }
}
