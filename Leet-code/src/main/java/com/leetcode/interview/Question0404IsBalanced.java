package com.leetcode.interview;

/**
 * @program: demo
 * @description: 面试题 04.04. 检查平衡性
 * @author: Mr.He
 * @create: 2021-12-31 10:49
 *
 * 实现一个函数，检查二叉树是否平衡。在这个问题中，平衡树的定义如下：任意一个节点，其两棵子树的高度差不超过 1。
 *
 *
 * 示例 1:
 * 给定二叉树 [3,9,20,null,null,15,7]
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回 true 。
 * 示例 2:
 * 给定二叉树 [1,2,2,3,3,null,null,4,4]
 *       1
 *      / \
 *     2   2
 *    / \
 *   3   3
 *  / \
 * 4   4
 * 返回 false 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/check-balance-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class Question0404IsBalanced {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public boolean isBalanced(TreeNode head) {
        if (head == null) {
            return false;
        }
        int leftHeight = checkHeight(head.left);
        int rightHeight = checkHeight(head.right);
        if (Math.abs(leftHeight - rightHeight) > 0) {
            return false;
        }
        return isBalanced(head.left) && isBalanced(head.right);
    }

    public int checkHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = checkHeight(root.left);
        int rightHeight = checkHeight(root.right);
        return Math.max(leftHeight, rightHeight) + 1;
    }
}
