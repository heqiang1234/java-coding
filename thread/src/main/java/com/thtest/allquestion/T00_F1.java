package com.thtest.allquestion;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Mr.He
 * @create: 2022-04-23 20:46
 * @description: 任务
 **/
public class T00_F1 {

    public static void main(String[] args) {

        MyTask t1 = new MyTask("t1", 3, true);
        MyTask t2 = new MyTask("t2", 3, true);
        MyTask t3 = new MyTask("t3", 3, false);

        List<MyTask> tasks = new ArrayList<>();
        tasks.add(t1);
        tasks.add(t2);
        tasks.add(t3);

        tasks.stream().forEach((t) -> t.start());

        for (; ; ) {
            for (MyTask task : tasks) {

            }
        }

    }

    private static enum  Result{
        NOTEND,SUCCESSED,FAILED,CANCELED
    }

    public static class MyTask extends Thread {
        private String name;
        private int timeSeconds;
        private boolean success;

        public MyTask(String name, int timeSeconds, boolean success) {
            this.name = name;
            this.timeSeconds = timeSeconds;
            this.success = success;
        }

        public void run(){
            try {
                sleep(500);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }


    }
}
