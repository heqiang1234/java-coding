package com.leetcode.jianzhioffer;

/**
 * @author HQ
 * @create 2021/11/28 18:08
 *
 * @desc 剑指 Offer 27. 二叉树的镜像
 *
 *
 * 请完成一个函数，输入一个二叉树，该函数输出它的镜像。
 *
 * 例如输入：
 *
 *      4
 *    /   \
 *   2     7
 *  / \   / \
 * 1   3 6   9
 * 镜像输出：
 *
 *      4
 *    /   \
 *   7     2
 *  / \   / \
 * 9   6 3   1
 *
 *  
 *
 * 示例 1：
 *
 * 输入：root = [4,2,7,1,3,6,9]
 * 输出：[4,7,2,9,6,3,1]
 *  
 *
 * 限制：
 *
 * 0 <= 节点个数 <= 1000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/er-cha-shu-de-jing-xiang-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Question27MirrorTree {

    public static class TreeNode {
       int val;
       TreeNode left;
       TreeNode right;
       TreeNode(int x) { val = x; }
    }

    public static TreeNode res = null;
    public static TreeNode mirrorTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode left = mirrorTree(root.left);
        TreeNode right = mirrorTree(root.right);
        root.left = right;
        root.right = left;
        return  root;
    }



    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        TreeNode rootLeft = new TreeNode(2);
        rootLeft.left = new TreeNode(1);
        rootLeft.right = new TreeNode(3);
        TreeNode rootRight = new TreeNode(7);
        rootRight.left = new TreeNode(6);
        rootRight.right = new TreeNode(9);
        root.left = rootLeft;
        root.right = rootRight;
        mirrorTree(root);
        //TreeNode
    }
}
