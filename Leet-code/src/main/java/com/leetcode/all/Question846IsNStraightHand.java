package com.leetcode.all;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author HQ
 * @program: demo
 * @description: 846. 一手顺子
 * @date 2021-12-30 22:22:14
 *
 * Alice 手中有一把牌，她想要重新排列这些牌，分成若干组，使每一组的牌数都是 groupSize ，并且由 groupSize 张连续的牌组成。
 *
 * 给你一个整数数组 hand 其中 hand[i] 是写在第 i 张牌，和一个整数 groupSize 。如果她可能重新排列这些牌，返回 true ；否则，返回 false 。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：hand = [1,2,3,6,2,3,4,7,8], groupSize = 3
 * 输出：true
 * 解释：Alice 手中的牌可以被重新排列为 [1,2,3]，[2,3,4]，[6,7,8]。
 * 示例 2：
 *
 * 输入：hand = [1,2,3,4,5], groupSize = 4
 * 输出：false
 * 解释：Alice 手中的牌无法被重新排列成几个大小为 4 的组。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/hand-of-straights
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Question846IsNStraightHand {


    //纯暴力，顺次遍历，找到比自己大的，查找过的记录设置为MIN，可以预计到后面的值，直接自己新建出数组。
    //因为题目说了是连续的，所以我们可以通过一位，推算出后面几位。直接拿推算出的后面几位去对比，如果右，就继续匹配，不存在，就报错
    public static boolean isNStraightHand(int[] hand, int groupSize) {

        if (hand.length % groupSize != 0 || hand.length == 0) {
            return false;
        }
        hand = quicksort(hand, 0, hand.length - 1);
        int[] nums = new int[groupSize];
        int MIN_INT = Integer.MIN_VALUE;

        int sumTimes = hand.length / groupSize;
        while (sumTimes > 0) {
            int num = 0;
            int count = 0;
            for (int j = 0; j <= hand.length - 1; j++) {
                if (hand[j] != MIN_INT) {
                    num = hand[j];
                    break;
                }
            }
            for (int i = 0; i < groupSize; i++) {
                nums[i] = num;
                num++;
            }

            for (int j = 0; j <= hand.length - 1; j++) {
                if (hand[j] != MIN_INT && hand[j] == nums[count]) {
                    hand[j] = MIN_INT;
                    count++;
                }
                if (count == groupSize) {
                    break;
                }
            }
            if (count != groupSize) {
                return false;
            }
            sumTimes--;
        }
        return true;
    }

    public static int[] quicksort(int[] hand, int left, int right) {
        int mid = left;
        int i = left, j = right;
        int temp = hand[mid];//取基准值
        while (i < j) {
            //从右开始找到大于标准值的数字。找到就退出
            while (hand[j] > temp && i < j) {
                j--;
            }
            //从左开始找到小于标准值的数字。找到就退出
            while (hand[i] < temp && i < j) {
                i++;
            }

            if (hand[i] == hand[j] && i < j) {
                i++;
            } else {
                int temp_num = hand[i];
                hand[i] = hand[j];
                hand[j] = temp_num;
            }
        }
        if (i - 1 > left) {
            hand = quicksort(hand, left, i - 1);
        }
        if (right > j + 1) {
            hand = quicksort(hand, j + 1, right);
        }
        return hand;
    }

    public static void main(String[] args) {
        int arr[] = new int[]{1,2,3,6,2,3,4,7,8};
        int len = arr.length - 1;
        // arr = quicksort(arr, 0, len);
        for (int i : arr) {
            System.out.print(i + "\t");
        }

        System.out.println(isNStraightHand1(arr, 3));
    }

    //使用HSAHMAP看下
    public static boolean isNStraightHand1(int[] hand, int groupSize) {

        if (hand.length % groupSize != 0 || hand.length == 0) {
            return false;
        }
        Arrays.sort(hand);
        Map<Integer, Integer> map = new HashMap<Integer,Integer>();
        for (int res : hand) {
            map.put(res, map.getOrDefault(res, 0) + 1);
        }
        for (int x : hand) {
            if(!map.containsKey(x)){
                continue;
            }

            for (int i = 0; i < groupSize; i++) {
                int num = x + i;
                if(!map.containsKey(num)){
                    return false;
                }
                map.put(num,map.get(num) - 1);
                if(map.get(num) == 0) {
                    map.remove(num);
                }
            }
        }
        return true;
    }


}
