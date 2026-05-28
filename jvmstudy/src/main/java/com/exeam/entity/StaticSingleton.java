package com.exeam.entity;

/**
 * @author: Mr.He
 * @create: 2022-04-28 19:22
 * @description: 静态内部类实现单例
 **/
public class StaticSingleton {
    private static class LAZYHOLDER{
       static StaticSingleton singleton = new StaticSingleton();
    }

    public static StaticSingleton getSingleton(){
        return LAZYHOLDER.singleton;
    }
}
