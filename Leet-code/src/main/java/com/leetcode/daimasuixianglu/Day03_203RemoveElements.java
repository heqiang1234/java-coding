package com.leetcode.daimasuixianglu;

import com.leetcode.model.ListNode;

/**
 * @author HQ
 * @program: java-coding
 * @description: 203.移除链表元素
 * @date 2022-10-14 21:07:09
 */
public class Day03_203RemoveElements {

    public ListNode removeElements(ListNode head, int val) {
        ListNode temp = new ListNode(-1,head);//定义一个前置节点，这样可以控制第一节点的删除
        ListNode pre = temp;
        ListNode cur = head;

        while (cur != null){
            if (cur.val == val){
                pre.next = cur.next;//如果相等，则相当于当前节点的上一节点和下一节点直接相链接
            } else {
                pre = cur;//不相等，则移动上一节点至当前节点
            }
            cur = cur.next;//移动当前节点
        }
        return temp.next;
    }

}
