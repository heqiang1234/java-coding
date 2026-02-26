package com.leetcode.Algorithm.ListNode;

import com.leetcode.model.ListNode;

public class QuesitonLRC024reverseList {

    // 1-2-3-4-5
    // 5-4-3-2-1
    public static ListNode reverseList(ListNode head) {
        ListNode cur = head,pre = null;
        while (cur != null){
            // 将当前节点的下一个节点的引用地址，保存下来，后续使用
            ListNode nextHead = cur.next;
            // 将当前节点，挂到nexthead节点的next。1，储存《2》
            cur.next = pre;// 和原先的链表断了，此时断开1- 》 2 转而这样形成 了 1 - 》 null,
            pre = cur;   // 将pre节点提上来
            cur = nextHead; // 这个是为了下一次循环。
        }
        return pre;
    }

    public static void main(String[] args) {
        ListNode res = (new ListNode(0, new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, new ListNode(6, new ListNode(7)))))))));
        reverseList(res.next);
    }
}
