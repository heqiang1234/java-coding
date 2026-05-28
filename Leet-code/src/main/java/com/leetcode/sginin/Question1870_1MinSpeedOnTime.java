package com.leetcode.sginin;

/**
 * @author HQ
 * @program: java-coding
 * @description: 1870.准时到达的列车的最小时速
 * @date 2022-07-04 23:01:03
 * <p>
 * 给你一个浮点数 hour ，表示你到达办公室可用的总通勤时间。要到达办公室，你必须按给定次序乘坐 n 趟列车。另给你一个长度为 n 的整数数组 dist ，其中 dist[i] 表示第 i 趟列车的行驶距离（单位是千米）。
 * <p>
 * 每趟列车均只能在整点发车，所以你可能需要在两趟列车之间等待一段时间。
 * <p>
 * 例如，第 1 趟列车需要 1.5 小时，那你必须再等待 0.5 小时，搭乘在第 2 小时发车的第 2 趟列车。
 * 返回能满足你准时到达办公室所要求全部列车的 最小正整数 时速（单位：千米每小时），如果无法准时到达，则返回 -1 。
 * <p>
 * 生成的测试用例保证答案不超过 107 ，且 hour 的 小数点后最多存在两位数字 。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：dist = [1,3,2], hour = 6
 * 输出：1
 * 解释：速度为 1 时：
 * - 第 1 趟列车运行需要 1/1 = 1 小时。
 * - 由于是在整数时间到达，可以立即换乘在第 1 小时发车的列车。第 2 趟列车运行需要 3/1 = 3 小时。
 * - 由于是在整数时间到达，可以立即换乘在第 4 小时发车的列车。第 3 趟列车运行需要 2/1 = 2 小时。
 * - 你将会恰好在第 6 小时到达。
 * 示例 2：
 * <p>
 * 输入：dist = [1,3,2], hour = 2.7
 * 输出：3
 * 解释：速度为 3 时：
 * - 第 1 趟列车运行需要 1/3 = 0.33333 小时。
 * - 由于不是在整数时间到达，故需要等待至第 1 小时才能搭乘列车。第 2 趟列车运行需要 3/3 = 1 小时。
 * - 由于是在整数时间到达，可以立即换乘在第 2 小时发车的列车。第 3 趟列车运行需要 2/3 = 0.66667 小时。
 * - 你将会在第 2.66667 小时到达。
 * 示例 3：
 * <p>
 * 输入：dist = [1,3,2], hour = 1.9
 * 输出：-1
 * 解释：不可能准时到达，因为第 3 趟列车最早是在第 2 小时发车。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/minimum-speed-to-arrive-on-time
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Question1870_1MinSpeedOnTime {

    //直接遍历速度，最下为0，最大为1e7,然后直接遍历
    public static int minSpeedOnTime(int[] dist, double hour) {
        int sumRoad = 0;
        int len = dist.length - 1;
        for (int i = 0; i < dist.length; i++) {
            sumRoad += dist[i];
        }
        int left = 1, right = 10000000;
        int ans = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            double count = 0;
            for (int i = 0; i <= len; i++) {
                double rd = i == len ? dist[i] * 1.0  / mid * 1.0 : Math.ceil(dist[i] * 1.0  / mid * 1.0 );
                count += rd;
            }
            if (count <= hour) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(minSpeedOnTime(new int[]{1, 3, 2}, 2.7));
    }
}
