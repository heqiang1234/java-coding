package com;

import java.util.HashMap;
import java.util.Map;

/**
 * @author heqiang
 * @date 2025年07月24日10:46
 */
public class Test {

    class jszj {
        public int fund_accunt;
        public int note;
    }

    static Map<Integer, Integer> fundaccount = new HashMap<>();

    static Map<Integer, Integer> Nums = new HashMap<>();

    static {
        int[] jszj_num = new int[65215];
        int curr_fund = 1;
        for (int i = 0; i < 65214; i++) {
            for (int j = 1; j <= 17; j++) {
                if (fundaccount.get(j) >= i) {
                    curr_fund = j;
                    break;
                }
            }
            Nums.put(i, curr_fund);
        }
    }

    static {
        fundaccount.put(0, 0);
        fundaccount.put(1, 1063);
        fundaccount.put(2, 2321 + fundaccount.get(1));
        fundaccount.put(3, 1312 + fundaccount.get(2));
        fundaccount.put(4, 3494 + fundaccount.get(3));
        fundaccount.put(5, 20803 + fundaccount.get(4));
        fundaccount.put(6, 12600 + fundaccount.get(5));
        fundaccount.put(7, 4603 + fundaccount.get(6));
        fundaccount.put(8, 2009 + fundaccount.get(7));
        fundaccount.put(9, 2438 + fundaccount.get(8));
        fundaccount.put(10, 1147 + fundaccount.get(9));
        fundaccount.put(11, 1169 + fundaccount.get(10));
        fundaccount.put(12, 1109 + fundaccount.get(11));
        fundaccount.put(13, 2638 + fundaccount.get(12));
        fundaccount.put(14, 3437 + fundaccount.get(13));
        fundaccount.put(15, 1233 + fundaccount.get(14));
        fundaccount.put(16, 2009 + fundaccount.get(15));
        fundaccount.put(17, 1829 + fundaccount.get(16));


    }

    //int countRQMC = 0, countWCDBB = 0;
    static int[][] countRQMC = new int[18][1];
    static int[][] countWCDBB = new int[18][1];
    static int[][] countJSZJ = new int[18][1];

    public static void main(String[] args) {
        int beginIndex = 0, count = 0, maxcount = 4000;
        int curretnNote = -1;
        int ct = 1;
        do {
            int[] ress = countTimes(ct, ct + 1, curretnNote);
            count = ress[0];
            curretnNote = ress[1];
            ct++;
        } while (count >= maxcount);
        System.out.println(1);
    }

    public static int[] countTimes(int begin, int end, int curretnNote) {

        int[] res = new int[]{0, 0};
        int countJszj1 = 0;
        int next_currtent_node = 0;
        for (int i = begin; i <= end; i++) {

            // 计算融券卖出所得
            countRQMC[i][0] += 1;

            // 计算维持担保比，调用日间接口
            countWCDBB[i][0] += 1;

            // 结算资金处理
            //int maxCount1 = fundaccount.get(i);
            for (int j = 0; j <= 65214; j++) {
                if (j <= curretnNote) {
                    continue;
                }
                countJSZJ[i][0] += 1;
                countJszj1++;
                if (countJszj1 == 4000) {
                    next_currtent_node = j;
                    break;
                }
            }
        }
        res[0] = countJszj1;
        res[1] = next_currtent_node;
        return res;
    }

}
