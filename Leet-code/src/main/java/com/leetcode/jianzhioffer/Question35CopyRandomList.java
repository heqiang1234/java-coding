package com.leetcode.jianzhioffer;

import java.util.HashMap;
import java.util.Map;

/**
 * @author HQ
 * @create 2021/11/3 22:44
 * @desc 剑指 Offer 35. 复杂链表的复制
 *
 * 请实现 copyRandomList 函数，复制一个复杂链表。在复杂链表中，每个节点除了有一个 next 指针指向下一个节点，还有一个 random 指针指向链表中的任意节点或者 null。
 *
 *  输入：head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
 *  输出：[[7,null],[13,0],[11,4],[10,2],[1,0]]
 *
 *  输入：head = [[1,1],[2,1]]
 *  输出：[[1,1],[2,1]]
 *
 *  输入：head = [[3,null],[3,0],[3,null]]
 *  输出：[[3,null],[3,0],[3,null]]
 *
 *  输入：head = []
 *  输出：[]
 *  解释：给定的链表为空（空指针），因此返回 null。
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/fu-za-lian-biao-de-fu-zhi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Question35CopyRandomList {

    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
    //哈希表进行复制
    //使用map来进行存储
    public Node copyRandomList(Node head) {
        //创建一个键值对
        Map<Node,Node> map = new HashMap<>();
        //新建一个链表保存原始链表
        Node cur = head;
        while (cur != null) {
            map.put(cur, new Node(cur.val));
            cur = cur.next;
        }
        cur = head;
        //将对应的next和random进行赋值操作
        while (cur != null) {
            map.get(cur).next = map.get(cur.next);
            map.get(cur).random = map.get(cur.random);
            cur = cur.next;
        }
        return map.get(head);
    }

    //原地复制节点+拆分
    public Node CopyRandomList2(Node head) {
        if(head == null) {
            return head;
        }
        //1->2->3->null
        //1->1(new)->2->2(new)->3->3(new)->null->null(new)
        //达到这个效果
        Node cur = head;
        while (cur != null) {
            Node tmp = new Node(cur.val);
             tmp.next = cur.next;
             cur.next = tmp;
             cur = tmp.next;
        }
        //将存在random节点都进行复制
        cur = head;
        while (cur != null) {
            if (cur.random != null) {
                cur.next.random = cur.random.next;
            }
            cur = cur.next.next;
        }
        // 1->2->3->null
        //1->1(new)->2->2(new)->3->3(new)->null->null(new)
        //将 new 出来的节点全部取出来。
        cur = head.next;
        Node pre = head;
        Node now = head.next;
        while (cur.next != null) {
            pre.next = pre.next.next;
            cur.next = cur.next.next;
            pre = pre.next;
            cur = cur.next;
        }
        //精髓，while循环后此时的 pre.next -->  null->null（复制的null）, 和原本的 null 不相同，相当于改变了原链表，所以需要赋值null,
        pre.next = null;
        return now;
    }


}
