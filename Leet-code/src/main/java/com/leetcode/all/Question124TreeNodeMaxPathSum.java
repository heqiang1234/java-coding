package com.leetcode.all;

/**
 * @author HQ
 * @create 2021/11/15 19:52
 *
 * @desc
 * 路径 被定义为一条从树中任意节点出发，沿父节点-子节点连接，达到任意节点的序列。同一个节点在一条路径序列中 至多出现一次 。该路径 至少包含一个 节点，且不一定经过根节点。
 *
 * 路径和 是路径中各节点值的总和。
 *
 * 给你一个二叉树的根节点 root ，返回其 最大路径和 。
 *
 *
 * 示例
 *
 * 输入：root = [1,2,3]
 * 输出：6
 * 解释：最优路径是 2 -> 1 -> 3 ，路径和为 2 + 1 + 3 = 6
 *
 * 输入：root = [-10,9,20,null,null,15,7]
 * 输出：42
 * 解释：最优路径是 15 -> 20 -> 7 ，路径和为 15 + 20 + 7 = 42
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-maximum-path-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Question124TreeNodeMaxPathSum {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    private static  int res = Integer.MIN_VALUE;
    public  static  int maxPathSum(TreeNode root) {
        dpNum(root);
        return res;
    }

    public static  int dpNum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        //遍历左节点
        int left = Math.max(0, dpNum(root.left));
        //遍历右节点
        int right = Math.max(0, dpNum(root.right));
        //储存暂时的最大值
        res = Math.max(res, left + right + root.val);
        //返回最大的那一条路径
        return Math.max(left, right) + root.val;
    }

    public static void main(String[] args) {
        //[1,2,3]
        TreeNode left = new TreeNode(1);
        TreeNode right = new TreeNode(3);
        TreeNode root = new TreeNode(2, left, right);
        System.out.println(maxPathSum(root));
    }
}
