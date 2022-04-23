package com.exeam.entity;

/**
 * @program: java-coding
 * @description: ss
 * @author: Mr.He
 * @create: 2022-04-14 20:20
 **/
public class volatieVisibilityTest {
    public  static volatile boolean ininFlag = false;

    public static void main(String[] args) throws InterruptedException {
        new Thread(() ->{
            System.out.println("Wating data..");
            while (!ininFlag){

            }
            System.out.println("===========");
        }).start();
        Thread.sleep(2000);
        new Thread(()-> prepareDta()).start();
    }

    public static void prepareDta(){
        System.out.println("prepare data .");
        ininFlag = true;
        System.out.println("prepare data end");
    }

}
