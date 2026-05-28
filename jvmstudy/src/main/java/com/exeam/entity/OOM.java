package com.exeam.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * @author heqiang
 * @date 2025年09月12日12:43
 */
public class OOM {

    public static class OomObject {
    }

    ;

    public static void HeapOOM() {
        List<OomObject> OOMList = new ArrayList<>();

        for (; ; ) {
            OOMList.add(new OomObject());
        }
    }

    public static void main(String[] args) {
//        String s = "111";
//        s.length()
      //  HeapOOM();
        maxFreqSum("successes");
    }

    public static int maxFreqSum(String s) {
        String FreS = ",a,e,i,o,u,";
        int[] ChCount = new int[32];
        for (int i = 0; i < s.length(); i++) {
            System.out.println(s.charAt(i) - 'a');
            ChCount[s.charAt(i) - 'a']++;
        }
        int maxF = 0, maxY = 0;
        for (int i = 0; i < 32; i++) {
            if (i == 0 || i == 4 || i == 8
                    || i == 14 || i == 20) {
                maxY = Math.max(maxY, ChCount[i]);
            } else {
                maxF = Math.max(maxF, ChCount[i]);
            }
        }
        return maxY + maxF;
    }
}
