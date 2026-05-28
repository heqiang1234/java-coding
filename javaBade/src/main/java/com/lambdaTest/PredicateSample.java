package com.lambdaTest;

import java.util.function.Predicate;

/**
 * @author HQ
 * @program: java-coding
 * @description: de
 * @date 2022-07-25 22:37:53
 */
public class PredicateSample {

    public static void main(String[] args) {
        Predicate<Integer> predicate = n -> n > 4;
        System.out.println(predicate.test(3));
    }
}
