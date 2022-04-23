package com.exeam.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * @program: java-coding
 * @description: valatile
 * @author: Mr.He
 * @create: 2022-04-14 20:55
 **/
public class VolitileSerialTest {

    public static int x = 0, y = 0,a = 0, b= 0;

    public static void main(String[] args) throws InterruptedException {
        Set<String> resultSet = new HashSet<>();
        for (int i = 0; i < 10000000; i++) {
            x= 0;
            y = 0;
            a = 0;
            b = 0;
            Thread one = new Thread(() ->{
                a= y;
                x= 1;
            });

            Thread other = new Thread(() ->{
                b= x;
                y= 1;
            });

            one.start();
            other.start();
            one.join();
            other.join();

            resultSet.add("a = " + a + " b = "+ b);
            System.out.println(resultSet);
        }
    }
}
