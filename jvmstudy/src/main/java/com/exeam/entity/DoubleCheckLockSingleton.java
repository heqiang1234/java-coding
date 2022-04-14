package com.exeam.entity;

/**
 * @program: java-coding
 * @description: 双重检测锁实现 单例模式
 * @author: Mr.He
 * @create: 2022-04-14 21:12
 **/
public class DoubleCheckLockSingleton {

    private static DoubleCheckLockSingleton instance = null;

    //DCL
    public static DoubleCheckLockSingleton getInstance(){
        if (instance == null){
            synchronized (DoubleCheckLockSingleton.class){
                if (instance == null){
                    instance = new DoubleCheckLockSingleton();
                }
            }
        }
        return instance;
    }


    public static void main(String[] args) {
        DoubleCheckLockSingleton instance = DoubleCheckLockSingleton.getInstance();
    }
}
