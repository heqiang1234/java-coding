package com.leetcode.Algorithm.TwoOrderSearch;

import java.util.Arrays;

/**
 * @author HQ
 * @program: java-coding
 * @description: 826.安排工作以达到最大利益
 * @date 2022-07-02 22:51:20
 *
 * 你有 n 个工作和 m 个工人。给定三个数组： difficulty, profit 和 worker ，其中:
 *
 * difficulty[i] 表示第 i 个工作的难度，profit[i] 表示第 i 个工作的收益。
 * worker[i] 是第 i 个工人的能力，即该工人只能完成难度小于等于 worker[i] 的工作。
 * 每个工人 最多 只能安排 一个 工作，但是一个工作可以 完成多次 。
 *
 * 举个例子，如果 3 个工人都尝试完成一份报酬为 $1 的同样工作，那么总收益为 $3 。如果一个工人不能完成任何工作，他的收益为 $0 。
 * 返回 在把工人分配到工作岗位后，我们所能获得的最大利润 。
 *
 *  
 *
 * 示例 1：
 *
 * 输入: difficulty = [2,4,6,8,10], profit = [10,20,30,40,50], worker = [4,5,6,7]
 * 输出: 100
 * 解释: 工人被分配的工作难度是 [4,4,6,6] ，分别获得 [20,20,30,30] 的收益。
 * 示例 2:
 *
 * 输入: difficulty = [85,47,57], profit = [24,66,99], worker = [40,25,25]
 * 输出: 0
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/most-profit-assigning-work
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Question826_1MaxProfitAssignment {

    class job{
       public int x,y;
        public job(int x,int y){
            this.x = x;
            this.y = y;
        }
    }

    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        int len = difficulty.length;
        job[] jb = new job[len];
        //修改下资金数组，保证工资是《=该工时下的最贵的价格
        for(int i = 0; i < len; i++) {
            jb[i] = new job(difficulty[i], profit[i]);
        }
        Arrays.sort(jb, (a, b) -> a.x - b.x);
        Arrays.sort(worker);

        int ans = 0, i = 0, best = 0;
        for (int skill: worker) {
            while (i < len && skill >= jb[i].x)
                best = Math.max(best, jb[i++].y);
            ans += best;
        }
        return ans;
    }
}
