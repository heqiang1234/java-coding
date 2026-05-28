package com.exeam.entity;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @author: Mr.He
 * @create: 2022-04-28 19:32
 * @description: 反射获取单例对象
 **/
public class ReflectSingleton {

    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        // Constructor sing = StaticSingleton.class.getDeclaredConstructor();
        // System.out.println(sing.isAccessible());
        // sing.setAccessible(true);
        // System.out.println(sing.isAccessible());
        // StaticSingleton staticSingleton1 = (StaticSingleton) sing.newInstance();
        // StaticSingleton staticSingleton2 = (StaticSingleton) sing.newInstance();
        //获得构造器
        Constructor con = SingletonEnum.class.getDeclaredConstructor();
//设置为可访问
        con.setAccessible(true);
//构造两个不同的对象
        SingletonEnum singleton1 = (SingletonEnum)con.newInstance();
        SingletonEnum singleton2 = (SingletonEnum)con.newInstance();
//验证是否是不同对象
        System.out.println(singleton1.equals(singleton2));

        System.out.println(singleton1);
        System.out.println(singleton2);

        System.out.println(singleton1.equals(singleton2));




    }
}
