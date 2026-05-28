package com.leetcode.daimasuixianglu;

import com.leetcode.model.ListNode;

/**
 * @author HQ
 * @program: java-coding
 * @description: 面试题 02.07. 链表相交
 * @date 2022-10-15 21:28:30
 */
public class Day04_0207GetIntersectionNode {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        //转换为数学问题
        //假设A、B链表的祖成部分都是由私人部分和公有部分，两部分组成
        //A 私有长度 a 、 公有长度 c
        //B 私有长度 b 、 公有长度 c
        //那么只要我们遍历(A) a + c + b  = (B) b + c + a;
        //我们首先遍历完A,B各自的链表，如果为空。则将节点改变 A 变成 B， B 变成 A ，这样可以实现上面的的等式
        ListNode curA = headA;
        ListNode curB = headB;
        while (curA != curB){
            curA = curA != null ? curA.next : headA;
            curB = curB != null ? curB.next : headB;
        }
        return curA;
    }

}
