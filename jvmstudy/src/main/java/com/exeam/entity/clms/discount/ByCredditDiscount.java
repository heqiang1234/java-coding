package com.exeam.entity.clms.discount;

/**
 * @author: Mr.He
 * @create: 2022-04-29 16:22
 * @description: 信用卡打折
 **/
public class ByCredditDiscount implements IDiscount{

    @Override
    public double getDiscount(double price) {
        return price * 0.1;
    }
}
