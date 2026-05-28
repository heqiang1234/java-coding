package com.leetcode.Algorithm.ListNode;

import com.leetcode.model.ListNode;
/**
 * @author heqiang
 * @date 2025年11月06日11:24
 */
public class Question2058nodesBetweenCriticalPoints {

    /**
     * 链表中的 临界点 定义为一个 局部极大值点 或 局部极小值点 。
     * <p>
     * 如果当前节点的值 严格大于 前一个节点和后一个节点，那么这个节点就是一个  局部极大值点 。
     * <p>
     * 如果当前节点的值 严格小于 前一个节点和后一个节点，那么这个节点就是一个  局部极小值点 。
     * <p>
     * 注意：节点只有在同时存在前一个节点和后一个节点的情况下，才能成为一个 局部极大值点 / 极小值点 。
     * <p>
     * 给你一个链表 head ，返回一个长度为 2 的数组 [minDistance, maxDistance] ，
     * 其中 minDistance 是任意两个不同临界点之间的最小距离，
     * maxDistance 是任意两个不同临界点之间的最大距离。如果临界点少于两个，则返回 [-1，-1] 。
     *
     * 输入：head = [5,3,1,2,5,1,2]
     * 输出：[1,3]
     * 解释：存在三个临界点：
     * - [5,3,1,2,5,1,2]：第三个节点是一个局部极小值点，因为 1 比 3 和 2 小。
     * - [5,3,1,2,5,1,2]：第五个节点是一个局部极大值点，因为 5 比 2 和 1 大。
     * - [5,3,1,2,5,1,2]：第六个节点是一个局部极小值点，因为 1 比 5 和 2 小。
     * 第五个节点和第六个节点之间距离最小。minDistance = 6 - 5 = 1 。
     * 第三个节点和第六个节点之间距离最大。maxDistance = 6 - 3 = 3 。
     * @param head
     * @return
     */
    public static int[] nodesBetweenCriticalPoints(ListNode head) {
        ListNode pre = head;
        ListNode cur = head.next;
        ListNode next = cur.next;
        int minDis = Integer.MAX_VALUE,maxDis = 0,preIndex = -1,i = 2,count = 0;
        while (cur.next != null){
            if ((cur.val > pre.val && cur.val > next.val)
                    ||(cur.val < pre.val && cur.val < next.val) )
            {
                count++;
                 // 如果处于极值，则记录判断位置
                if (preIndex != -1){
                    minDis = Math.min(minDis,Math.abs(i - preIndex));
                    maxDis += Math.abs(i - preIndex);

                }
                preIndex = i;
            }
            pre = cur;
            cur = cur.next;
            next = cur.next;

            i++;
        }
        if (count < 2){
            return new int[]{-1,-1};
        } else {
         return new int[]{minDis,maxDis};
        }
    }

    public static void main(String[] args) {
        nodesBetweenCriticalPoints(new ListNode(5, new ListNode(3, new ListNode(1, new ListNode(2,new ListNode(5,new ListNode(1,new ListNode(2))))))));

    }

}
