package com.thtest;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 * @author heqiang
 * @date 2025年09月29日14:05
 */
public class threadTest {

    public void testTr() {
        List<Integer> mit = new ArrayList<>();

        for (int i = 0; i < 100; i++) {
            mit.add(i);
        }
        CountDownLatch downLatch = new CountDownLatch(mit.size());
        int startPos = 0, endPos = 0;
        for (int i = 0; i < mit.size(); i++) {
            startPos = mit.get(i);
            if (i == mit.size() - 1) {
                endPos = 10000;
            } else {
                endPos = mit.get(i + 1);
            }


        }
    }
}
