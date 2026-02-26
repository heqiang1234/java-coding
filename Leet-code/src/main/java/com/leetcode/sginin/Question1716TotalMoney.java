package com.leetcode.sginin;

import java.util.concurrent.CountDownLatch;

public class Question1716TotalMoney {

    //private static int fff = 10;
    static public class totalMoney extends Thread {

        int n;
        CountDownLatch latch;
        int timeMin;

        public totalMoney(int n, int timeMin, CountDownLatch latch) {
            this.n = n;
            this.latch = latch;
            this.timeMin = timeMin;
        }

        public void setN(int n) {
            this.n = n;
        }

        public void run() {
            try {
                Thread.sleep(timeMin);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } finally {
                System.out.println(n + " : " + "时间暂停结束");
            }
            int sumR = 0, countD = 0, currS = 0;
            for (int i = 1; i <= n; i++) {
                countD++;
                int saveN = countD + currS;
                sumR += saveN;
                // 记录天数，等于7，则进1；
                if (countD / 7 == 1) {
                    countD = 0;
                    currS++;
                }
            }
            System.out.println(latch.getCount() + " : " + sumR);

            latch.countDown();

//            try {
//                latch.await();
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
        }
//        fff = 11;
//        int sumR = 0, countD = 0, currS = 0;
//        for (int i = 1; i <= n; i++) {
//            countD++;
//            int saveN = countD + currS;
//            sumR += saveN;
//            // 记录天数，等于7，则进1；
//            if (countD / 7 == 1) {
//                countD = 0;
//                currS++;
//            }
//        }
//        return sumR;
    }

    public static void main(String[] args) throws InterruptedException {

//        CountDownLatch countDownLatch = new CountDownLatch(2);
//        final totalMoney totalMoney1 = new totalMoney(10, 2000, countDownLatch);
//        totalMoney totalMoney2 = new totalMoney(20, 1000, countDownLatch);
//        totalMoney1.run();
//        System.out.println(totalMoney1.toString());
//        totalMoney1.setN(200);
//        //totalMoney1 = new totalMoney(1,3,countDownLatch);
//        totalMoney2.run();
//        countDownLatch.await();
       System.out.println("全部结束");
        String s1 = "1bc";//6105
        String s2 = "2df";//6106
        String s3 = "test";//6109
        String s4 = s1 +  "ggfff";
        String s5 = "1bc" +  "ggfff11";
       // String s4 = new String("1bc4d");
        System.out.println("222");
        //System.out.println(totalMoney(4));
    }
}
