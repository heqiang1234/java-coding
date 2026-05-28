package com.exeam.entity.clms.Travel;

/**
 * @author: Mr.He
 * @create: 2022-04-29 16:43
 * @description: 公交车旅游 by bus
 **/
public class BuyTravel implements TravelUtil {

    @Override
    public void Travel() {
        System.out.println("by bus");
    }

    @Override
    public double cast() {
        //车费
        return 15;
    }
}
