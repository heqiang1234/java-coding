package com.leetcode.daimasuixianglu;

import com.leetcode.model.ListNode;

/**
 * @author HQ
 * @program: java-coding
 * @description: 707.设计链表
 * @date 2022-10-14 21:26:39
 */
public class Day03_707MyLinkedList {

    ListNode rt;//定义单链表
    int size;//定义链表长度

    public Day03_707MyLinkedList() {
        rt = new ListNode(0);//虚节点，便于处理第一节点可能被删除的场景
        size = 0;//起始定义0
    }

    //获取任意位置的节点值
    public int get(int index) {
        if (index < 0 || index >= size) {//判断获取的位置是否符合要求
            return -1;
        }
        ListNode cur = rt;
        while (index >= 0) {//移动链表节点
            index--;
            cur = cur.next;
        }
        return cur.val;
    }

    public void addAtHead(int val) {
        addAtIndex(0, val);//新增到头节点
    }

    public void addAtTail(int val) {
        addAtIndex(size, val);//新增到末尾节点
    }

    public void addAtIndex(int index, int val) {
        if (index > size) {//根据题意要求，超过size,则 不做处理
            return;
        }
        if (index < 0) { //根据题意要求，小于0，则插入到第一个节点前
            index = 0;
        }
        size++;//维护size
        ListNode cur = rt;
        while (index > 0) {//移动链表节点
            index--;
            cur = cur.next;
        }
        ListNode newNode = new ListNode(val);
        newNode.next = cur.next;
        cur.next = newNode;//将新增的节点放入链表
    }

    public void deleteAtIndex(int index) {
        if (index >= size || index < 0) {
            return;
        }
        size--;
        if (index == 0) {//如果为0，则直接等同于头节点移动到下一个节点
            rt = rt.next;
            return;
        }
        ListNode pred = rt;
        for (int i = 0; i < index ; i++) {//移动链表
            pred = pred.next;
        }
        pred.next = pred.next.next;//连接前一个节点和下一节点，达到删除的目的
    }
}
