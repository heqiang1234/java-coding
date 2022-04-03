package com.leetcode.all;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @program: demo
 * @description: 382. 链表随机节点
 * @author: Mr.He
 * @create: 2022-01-16 12:23
 **/
public class Question382Solution {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static List<Integer> list;
    public static Random random;

    public Question382Solution(ListNode head) {
        list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        random  = new Random();
    }

    public static int getRandom() {
        return list.get(random.nextInt(list.size()));
    }


    //蓄水池算法
    public static ListNode head;
    public static int getRandom2(){
        int ans = 0;
        int idx = 0;
        int count = 0;
        ListNode listNode = head;
        while (listNode != null){
            if (random.nextInt(idx) == 0){
                ans = listNode.val;
            }
            listNode = listNode.next;
            idx++;
        }
        return ans;
    }

    public static void main(String[] args) {
        Random random1 = new Random();
        for (int i = 0; i < 10; i++) {
            System.out.println(random1.nextInt(1));
        }

    }
}
