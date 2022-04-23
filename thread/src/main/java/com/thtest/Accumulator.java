package com.thtest;

/**
 * @author: Mr.He
 * @create: 2022-04-23 20:26
 * @description: 线程面试题1
 **/
public class Accumulator {

    private double result = 0.0D;

    public void addAll(double[] values) {
        for (double value : values) {
            result +=value;
        }
    }
}
