package com.leetcode.weektest.week504;

import java.util.Arrays;

/**
 * @author heqiang
 * @date 2026年05月31日15:37
 */
public class Q2maximumSaleItems {

    public static int maximumSaleItems(int[][] items, int budget) {
        final int bud = budget;
        // 第一轮，先把能买的，加权最大的，买下来来
        // 假设一个加权值，先计算出，买第一个的加权值，
        // 加权的数组
        int n = items.length;
        double[][] jiaq = new double[n][2];
        double[][] pt = new double[n][2];
        Arrays.sort(items, (a, b) -> Integer.compare(a[0], b[0]));
        for (int i = 0; i < items.length; i++) {
            int num = items[i][0], count = 1, price = items[i][1];
            pt[i][0] = items[i][1];
            pt[i][1] = items[i][1];
            for (int j = 0; j < items.length; j++) {
                if (i == j) continue;
                if (items[j][0] % num == 0) {
                    count++;
                }
            }
            jiaq[i][0] = price / (count * 1D);
            jiaq[i][1] = price;
        }
        Arrays.sort(jiaq, (a, b) -> Double.compare(a[1]/a[0] + bud - a[1], a[1]/a[0] + bud - a[1]));
        Arrays.sort(pt, (a, b) -> Double.compare(a[0], b[0]));
        int res = 0;
        for (double[] doubles : jiaq) {
            double price = doubles[1];
            double score = doubles[0];
            if (score > pt[0][1]) break;
            if ((budget + 0.001) > price) {
                res += (int) Math.round(price / score);
                budget -= (int) price;
            } else {
                break;
            }

        }
        while (budget > 0) {
            double price = pt[0][0];
            double socre = pt[0][1];
            if ((budget + 0.001) > price) {
                res += 1;
                budget -= (int) price;
            } else {
                break;
            }

        }

        return res;
    }

    public static void main(String[] args) {
        //System.out.println(maximumSaleItems(new int[][]{{2, 4}, {3, 2}, {4, 1}, {6, 4}, {12, 4}}, 8));
        //System.out.println(maximumSaleItems(new int[][]{{6, 2}, {2, 6}, {3, 4}}, 9));
        //System.out.println(maximumSaleItems(new int[][]{{1, 1}, {1, 2}}, 3));
        //System.out.println(maximumSaleItems(new int[][]{{34, 13}, {62, 28}, {44, 26}}, 44));
//        System.out.println(maximumSaleItems(new int[][]{{979, 37}, {493, 42}, {265, 16}, {1065, 8}, {1410, 13}, {513, 54}, {1354, 1}, {1, 36}, {304, 41},
//                {106, 53}, {1158, 33}, {920, 48}, {1236, 41}, {1055, 65}, {1498, 61}, {716, 59}, {515, 47}, {1494, 51}, {1228, 22}, {365, 19}, {818, 64},
//                {92, 45}, {86, 67}, {403, 18}, {1198, 34},
//                {1358, 18}, {122, 57}, {1390, 40}, {291, 55}, {631, 65}, {921, 5}, {168, 9}, {274, 63}, {309, 59}, {475, 59}, {806, 1}, {400, 64}, {1312, 14},
//                {1428, 40}, {360, 7}, {1354, 51}, {291, 21}, {888, 57}, {651, 28}, {933, 26}, {1124, 64}, {481, 16}, {2, 31}, {706, 50}, {1295, 38}, {509, 28},
//                {30, 54}, {736, 52}, {604, 55}, {630, 8}, {1422, 58}, {1321, 60}, {1261, 50}, {1256, 38}, {960, 20}, {653, 27}, {915, 47}, {62, 4}, {1087, 59},
//                {1410, 67}, {177, 45}, {565, 13}, {1170, 3}, {1272, 63}, {1353, 56}, {444, 8}, {385, 9}, {497, 49}, {176, 1}, {217, 56}, {1039, 60}, {899, 16},
//                {645, 2}, {574, 27}, {609, 11}}, 67));

        System.out.println(maximumSaleItems(new int[][]{{1000, 2}, {1000, 1}}, 2));


        // ],[],[]©leetcode
        //[[6,2],[2,6],[3,4]]©leetcode
    }

}
