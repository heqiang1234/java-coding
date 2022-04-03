package com.leetcode.jianzhioffer;

import java.util.Stack;

/**
 * @author heqiang
 * @date 2021/11/02
 * @desc 剑指 Offer 06. 从尾到头打印链表
 * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
 * 示例
 * 输入：head = [1,3,2]
 * 输出：[2,3,1]
 */
public class Question06FromEndToHeadNode {
    public class ListNode {
     int val;
     ListNode next;
     ListNode(int x) { val = x; }
   }

    //借助栈的机制，先进后出，先存入栈中，然后直接赋值到数组即可，注意数组的定义，长度要等于链表的长度
    public int[] reversePrint(ListNode node) {
        Stack<Integer> stack = new Stack<>();
        while (node != null) {
            stack.add(node.val);
            node = node.next;
        }
        int len = stack.size();
        int[] resultList = new int[len];

        for (int i = 0; i < len; i++) {
            resultList[i] = stack.pop();
        }

        return resultList;
    }

}
