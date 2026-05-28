package com.leetcode.sginin;

/**
 * @author HQ
 * @program: java-coding
 * @description: 875。爱吃香蕉的珂珂
 * @date 2022-06-07 20:59:03
 * <p>
 * 珂珂喜欢吃香蕉。这里有 n 堆香蕉，第 i 堆中有 piles[i] 根香蕉。警卫已经离开了，将在 h 小时后回来。
 * <p>
 * 珂珂可以决定她吃香蕉的速度 k （单位：根/小时）。每个小时，她将会选择一堆香蕉，从中吃掉 k 根。如果这堆香蕉少于 k 根，她将吃掉这堆的所有香蕉，然后这一小时内不会再吃更多的香蕉。  
 * <p>
 * 珂珂喜欢慢慢吃，但仍然想在警卫回来前吃掉所有的香蕉。
 * <p>
 * 返回她可以在 h 小时内吃掉所有香蕉的最小速度 k（k 为整数）。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：piles = [3,6,7,11], h = 8
 * 输出：4
 * 示例 2：
 * <p>
 * 输入：piles = [30,11,23,4,20], h = 5
 * 输出：30
 * 示例 3：
 * <p>
 * 输入：piles = [30,11,23,4,20], h = 6
 * 输出：23
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/koko-eating-bananas
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Question875MinEatingSpeed {

    public static int minEatingSpeed(int[] piles, int num) {
        int left = 0, right = 0;
        int len = piles.length;
        for (int i = 0; i < len; i++) {
            right = Math.max(right, piles[i]);
        }
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (check(piles,num,mid)){
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return right;
    }

    public static Boolean check(int[] p, int h, int k) {
        int ans = 0;
        for (int x : p) {
            ans += Math.ceil(x * 1.0 / k);
        }
        return ans <= h;
    }

    public static void main(String[] args) {
        System.out.println(minEatingSpeed(new int[]{30,11,23,4,20}, 6));
    }
}
