package com.leetcode.all;

/**
 * @author HQ
 * @create 2021/11/16 21:09
 *
 * @desc
 * 给定一个单链表，其中的元素按升序排序，将其转换为高度平衡的二叉搜索树。
 *
 * 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
 *
 * 示例:
 *
 * 给定的有序链表： [-10, -3, 0, 5, 9],
 *
 * 一个可能的答案是：[0, -3, 9, -10, null, 5], 它可以表示下面这个高度平衡二叉搜索树：
 *
 *       0
 *      / \
 *    -3   9
 *    /   /
 *  -10  5
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/convert-sorted-list-to-binary-search-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Question109SortedListToBST {

    public static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {}

        TreeNode(int val) {this.val = val;}

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static TreeNode sortedListToBST(ListNode head) {
        return dpListTreeNode(head, null);
    }

    //处理左右边，如果知道中节点
    public static TreeNode dpListTreeNode(ListNode left, ListNode right) {
        if (left == null) {
            return null;
        }

        ListNode node = getMidRoot(left,right);
        TreeNode root = new TreeNode(node.val);

        root.left = dpListTreeNode(left, node);
        root.right = dpListTreeNode(node.next, right);
        return root;
    }

    //快慢指针，通过一个指针next一次和一个指针next两次，实现获取到mid的成效
    public static ListNode getMidRoot(ListNode left, ListNode right) {
        ListNode slow = left;
        ListNode fast = left;
        while (slow != right && fast.next != right) {
                 slow = slow.next;
                 fast = fast.next;
                 fast = fast.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        ListNode root = new ListNode();
        int[] nums = {-10, -3, 0, 5, 9};
        for (int i = 0; i < nums.length - 1; i++) {
            ListNode temp = new ListNode(nums[i]);
            root.val = nums[i];
            root.next = temp;
        }
        sortedListToBST(root);
    }

}
