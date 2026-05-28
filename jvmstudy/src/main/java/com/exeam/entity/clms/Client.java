package com.exeam.entity.clms;

import com.exeam.entity.clms.interfacec.AbstractStrategy;

/**
 * @author: Mr.He
 * @create: 2022-04-28 23:19
 * @description: 客户端
 **/
public class Client {
    AbstractStrategy abstractStrategy;

    public void setAbstractStrategy(AbstractStrategy abstractStrategy) {
        this.abstractStrategy = abstractStrategy;
    }

    public void printMethod(){
        abstractStrategy.printTravelMethod();
    }
}
