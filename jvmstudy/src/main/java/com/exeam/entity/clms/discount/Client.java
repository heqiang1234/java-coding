package com.exeam.entity.clms.discount;

/**
 * @author: Mr.He
 * @create: 2022-04-29 16:24
 * @description: 客户端
 **/
public class Client {

    IDiscount iDiscount;

    public void setiDiscount(IDiscount iDiscount){
        this.iDiscount = iDiscount;
    }

    public double caclu(double price){
       return iDiscount.getDiscount(price);
    }

}
