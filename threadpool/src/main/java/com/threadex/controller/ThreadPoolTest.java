package com.threadex.controller;

import sun.nio.ch.ThreadPool;

import java.util.concurrent.*;

/**
 * @program: java-coding
 * @description: 线程池源码学习
 * @author: Mr.He
 * @create: 2022-04-07 17:20
 **/
public class ThreadPoolTest {

    /**
     * 默认的四种拒绝策略
     */

    /**
     * 创建一个线程池（完整入参）
     * 核心线程数为5（corePoolSize）
     * 最大线程数为10（maxnumPoolSize）
     * 最大线程数的空闲时间（keepAliveTime）
     * 阻塞队列 ListdBlockingQueue(workQueue)
     * 线程工厂 （构建Thread对象） 默认的 DefaultThreadFactory(threadFactory)
     * 拒绝策略 抛出异常（handler）
     */
    private static ExecutorService THRAED_POOL = new ThreadPoolExecutor(
            5,  //心线程数为5（corePoolSize）
            10, //最大线程数为10（maxnumPoolSize）
            60,  //最大线程数的空闲时间
            TimeUnit.MINUTES, //最大线程数的空闲时间
            new LinkedBlockingDeque<Runnable>(), //阻塞队列
            Executors.defaultThreadFactory(), //线程工厂 （构建Thread对象）
            new ThreadPoolExecutor.AbortPolicy()); //拒绝策略



}
