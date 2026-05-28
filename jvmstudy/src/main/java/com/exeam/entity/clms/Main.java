package com.exeam.entity.clms;

/**
 * @author: Mr.He
 * @create: 2022-04-28 23:21
 * @description: 主方法
 **/
public class Main {

    public static void main(String[] args) {
        Client client = new Client();
        BusStrategy busStrategy = new BusStrategy();
        TrainStrtegy trainStrtegy = new TrainStrtegy();
        client.setAbstractStrategy(busStrategy);
        client.printMethod();
        client.setAbstractStrategy(trainStrtegy);
        client.printMethod();


    }
}
