package com.leetcode.hotinterview;

/**
 * @program: demo
 * @description: 19. 删除链表的倒数第 N 个结点
 * @author: Mr.He
 * @create: 2022-03-05 15:17
 **/
public class Question19RemoveNthFromEnd {
    public class ListNode{
        int val;
        ListNode next;
        ListNode(){}
        ListNode(int val){
            this.val = val;
        }
        ListNode(int val, ListNode next){
            this.val = val;
            this.next = next;
        }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode res = new ListNode(0,head);
        ListNode fast = head,slow = res;
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        while (fast != null){
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        ListNode ress = res.next;
        return ress;
    }
}
