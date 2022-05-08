package com.exeam.entity.clms;

import com.exeam.entity.clms.interfacec.AbstractStrategy;

/**
 * @author: Mr.He
 * @create: 2022-04-28 23:18
 * @description: 汽车策略类
 **/
public class BusStrategy implements AbstractStrategy {
    @Override
    public void printTravelMethod() {
        System.out.println("by bus");
    }
}
