package com.threadex.controller;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.util.concurrent.*;

/**
 * @program: java-coding
 * @description: 主类
 * @author: Mr.He
 * @create: 2022-04-07 20:21
 **/
public class ThreadTest {

    public static void main(String[] args) {
        //最大工程线程  10    Executors.defaultThreadFactory()
        ExecutorService threadPoolExecutor = new ThreadPoolExecutor(
                2,  //核心线程数为2（corePoolSize）
                2, //最大线程数为2（maxnumPoolSize）
                60,  //最大线程数的空闲时间
                TimeUnit.MINUTES, //最大线程数的空闲时间
                new LinkedBlockingDeque<Runnable>(), //阻塞队列
                new ThreadFactory() {
                    @Override
                    public Thread newThread(Runnable r) {
                        return new Thread(r);
                    }
                }, //线程工厂 （构建Thread对象）
                new ThreadPoolExecutor.AbortPolicy()); //拒绝策略

//        threadPoolExecutor.execute();
    }
}
