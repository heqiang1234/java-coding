package com.leetcode.Algorithm.TwoOrderSearch;

/**
 * @author HQ
 * @program: java-coding
 * @description: 436.寻找右边界
 * @date 2022-07-02 22:08:51
 * 给你一个区间数组 intervals ，其中 intervals[i] = [starti, endi] ，且每个 starti 都 不同 。
 * <p>
 * 区间 i 的 右侧区间 可以记作区间 j ，并满足 startj >= endi ，且 startj 最小化 。
 * <p>
 * 返回一个由每个区间 i 的 右侧区间 在 intervals 中对应下标组成的数组。如果某个区间 i 不存在对应的 右侧区间 ，则下标 i 处的值设为 -1 。
 * <p>
 *  
 * 示例 1：
 * <p>
 * 输入：intervals = [[1,2]]
 * 输出：[-1]
 * 解释：集合中只有一个区间，所以输出-1。
 * 示例 2：
 * <p>
 * 输入：intervals = [[3,4],[2,3],[1,2]]
 * 输出：[-1,0,1]
 * 解释：对于 [3,4] ，没有满足条件的“右侧”区间。
 * 对于 [2,3] ，区间[3,4]具有最小的“右”起点;
 * 对于 [1,2] ，区间[2,3]具有最小的“右”起点。
 * 示例 3：
 * <p>
 * 输入：intervals = [[1,4],[2,3],[3,4]]
 * 输出：[-1,2,-1]
 * 解释：对于区间 [1,4] 和 [3,4] ，没有满足条件的“右侧”区间。
 * 对于 [2,3] ，区间 [3,4] 有最小的“右”起点。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/find-right-interval
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Question426_FindRightInterval {

    public static int[] findRightInterval(int[][] intervals) {
        int len = intervals.length;
        int [] res = new int[len];
        for (int i = 0; i < len; i++) {
            res[i] = getMaxRight(intervals[i][1],i,intervals);
        }
        return res;
    }

    public static int getMaxRight(int target,int index, int[][] inter) {
        int len = inter.length;
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < len; i++) {
            if (i != index){
                if (target < inter[i][1]){
                    if (target >= inter[i][0] && res >= inter[i][0]){
                        res = inter[i][0];
                    }
                }
            }
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }

    public static void main(String[] args) {
        findRightInterval(new int[][]{{1,4},{2,3},{3,4}});
    }
}
