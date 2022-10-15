package com.leetcode.daimasuixianglu;

import com.leetcode.model.ListNode;

/**
 * @author HQ
 * @program: java-coding
 * @description: 19. 删除链表的倒数第 N 个结点
 * @date 2022-10-15 20:29:21
 */
public class Day04_19RemoveNthFromEnd {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode vir = new ListNode(-1,head);//设置一个虚节点，方便处理删除头节点的情况

        ListNode slow = vir;//定义快慢指针
        ListNode fast = vir;
        while (n-- > 0){//因为删除的是倒数第n个节点。所以让快指针，先走n步
            fast = fast.next;
        }

        while (fast.next != null){//快指针直到头，跳出
            slow = slow.next;
            fast = fast.next;
        }//此时得到的慢指针为删除指针的前一节点
        slow.next = slow.next.next;//下一个节点和下下节点连接
        return vir.next;
    }
}
