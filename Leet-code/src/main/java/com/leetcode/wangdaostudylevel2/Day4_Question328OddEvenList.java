package com.leetcode.wangdaostudylevel2;

import com.leetcode.model.ListNode;

/**
 * @author HQ
 * @program: java-coding
 * @description: 328. 奇偶链表
 * @date 2022-08-29 22:17:35
 * 给定单链表的头节点 head ，将所有索引为奇数的节点和索引为偶数的节点分别组合在一起，然后返回重新排序的列表。
 *
 * 第一个节点的索引被认为是 奇数 ， 第二个节点的索引为 偶数 ，以此类推。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/odd-even-linked-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Day4_Question328OddEvenList {

    public ListNode oddEvenList(ListNode head) {
        if (head == null) {
            return head;
        }

        ListNode evenHead = head.next;
        ListNode odd = head, even = evenHead;
        //分成奇数和偶数，分别交替前进
        while (even != null && even.next != null){
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
    }

}
