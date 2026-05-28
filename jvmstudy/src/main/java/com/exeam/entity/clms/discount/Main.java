package com.exeam.entity.clms.discount;

/**
 * @author: Mr.He
 * @create: 2022-04-29 16:31
 * @description: 测试打折方式的编写
 **/
public class Main {
    public static void main(String[] args) {
        Client client = new Client();
        ByAndReduce byAndReduce = new ByAndReduce();
        client.setiDiscount(byAndReduce);
        System.out.println(client.caclu(20));
        ByCredditDiscount byCredditDiscount = new ByCredditDiscount();
        client.setiDiscount(byCredditDiscount);
        System.out.println(client.caclu(20));
    }
}
