package com.exeam.entity.clms;

import com.exeam.entity.clms.interfacec.AbstractStrategy;

/**
 * @author: Mr.He
 * @create: 2022-04-28 23:24
 * @description: Train策略
 **/
public class TrainStrtegy  implements AbstractStrategy {
    @Override
    public void printTravelMethod() {
        System.out.println("by Train");
    }
}
