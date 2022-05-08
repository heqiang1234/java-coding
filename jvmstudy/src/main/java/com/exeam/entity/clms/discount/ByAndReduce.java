package com.exeam.entity.clms.discount;

/**
 * @author: Mr.He
 * @create: 2022-04-29 16:23
 * @description: 减少
 **/
public class ByAndReduce implements IDiscount{
    @Override
    public double getDiscount(double price) {
        return price * 0.2;
    }
}
