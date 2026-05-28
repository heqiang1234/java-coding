package com.thtest;

import javax.annotation.security.RunAs;
import java.util.concurrent.CountDownLatch;

/**
 * @author heqiang
 * @date 2025年09月29日14:43
 */
public class CountDownLatchDemo {

    public static void main(String[] args) {
        int threadCount = 5; // 定义线程数量
        CountDownLatch latch = new CountDownLatch(3);

        for (int i = 0; i < threadCount; i++) {
            new Thread(new Task(latch)).start();
        }
        try {
            latch.await();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("结束");
    }

    static class Task implements Runnable {
        private final CountDownLatch latch;

        public Task(CountDownLatch latch) {
            this.latch = latch;
        }

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + " 正常执行任务");
            long time = (long)(Math.random() * 1000);
            try {
                Thread.sleep(time);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } finally {
                latch.countDown();
                System.out.println(Thread.currentThread().getName() +"时间：" + time +"：完成任务，计数器" + latch.getCount());
            }
        }

    }
}
