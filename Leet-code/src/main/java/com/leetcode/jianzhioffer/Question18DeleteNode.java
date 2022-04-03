package com.leetcode.jianzhioffer;

/**
 * @program: demo
 * @description: 剑指 Offer 18. 删除链表的节点
 * @author: Mr.He
 * @create: 2021-12-01 14:08
 * <p>
 * 给定单向链表的头指针和一个要删除的节点的值，定义一个函数删除该节点。
 * <p>
 * 返回删除后的链表的头节点。
 * <p>
 * 注意：此题对比原题有改动
 * <p>
 * 示例 1:
 * <p>
 * 输入: head = [4,5,1,9], val = 5
 * 输出: [4,1,9]
 * 解释: 给定你链表中值为 5 的第二个节点，那么在调用了你的函数之后，该链表应变为 4 -> 1 -> 9.
 * 示例 2:
 * <p>
 * 输入: head = [4,5,1,9], val = 1
 * 输出: [4,5,9]
 * 解释: 给定你链表中值为 1 的第三个节点，那么在调用了你的函数之后，该链表应变为 4 -> 5 -> 9.
 *  
 * <p>
 * 说明：
 * <p>
 * 题目保证链表中节点的值互不相同
 * 若使用 C 或 C++ 语言，你不需要 free 或 delete 被删除的节点
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shan-chu-lian-biao-de-jie-dian-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class Question18DeleteNode {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            val = val;
        }
    }
    //两个指针，一个在后面先遍历，如果相等，则将这个指针之前直接相连接，跳过该节点
    public static ListNode deleteNode(ListNode head, int val) {
        if (head == null) {
            return null;
        }
        if (head.val == val) {
            return head.next;
        }
        ListNode pre = head, curr = head.next;

        while (curr != null && curr.val != val) {
            pre = curr;
            curr = curr.next;
        }
        if (curr != null) {
            pre.next = curr.next;
        }
        return pre;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode();
        int[] nums = {4, 5, 1, 9};
        for (int i = 0; i < nums.length; i++) {
            ListNode temp = new ListNode(nums[i]);
            node.val = nums[i];
            node.next = temp;
        }
        deleteNode(node, 5);
    }
}
