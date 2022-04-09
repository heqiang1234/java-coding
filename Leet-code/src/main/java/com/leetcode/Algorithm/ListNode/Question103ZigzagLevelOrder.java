package com.leetcode.Algorithm.ListNode;

import java.util.*;

/**
 * @program: java-coding
 * @description: 103. 二叉树的锯齿形层序遍历
 * @author: Mr.He
 * @create: 2022-04-09 11:07
 * <p>
 * 给你二叉树的根节点 root ，返回其节点值的 锯齿形层序遍历 。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 * <p>
 * 输入：root = [3,9,20,null,null,15,7]
 * 输出：[[3],[20,9],[15,7]]
 * 示例 2：
 * <p>
 * 输入：root = [1]
 * 输出：[[1]]
 * 示例 3：
 * <p>
 * 输入：root = []
 * 输出：[]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-zigzag-level-order-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class Question103ZigzagLevelOrder {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    //bfs
    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        Deque<TreeNode> deque = new LinkedList<>();
        deque.add(root);
        int num = 0;
        while (!deque.isEmpty()) {
            int n = deque.size();
            Deque<Integer> res = new LinkedList<>();
            for (int i = 0; i < n; i++) {
                TreeNode nd = deque.poll();
                if (num == 1) {
                    res.offerFirst(nd.val);
                } else {
                    res.offerLast(nd.val);
                }
                if (nd.left != null) {
                    deque.add(nd.left);
                }
                if (nd.right != null) {
                    deque.add(nd.right);
                }
            }
            num = num == 0 ? 1 : 0;
            ans.add(new ArrayList<>(res));
        }
        return ans;
    }

    public static List<List<Integer>> ans1 = new ArrayList<>();

    //dfs
    public static List<List<Integer>> zigzagLevelOrder2(TreeNode root) {
        if (root == null) {
            return ans1;
        }
        dfs(root, 0);
        return ans1;
    }

    public static void dfs(TreeNode rn, int depth) {
        if (rn == null) {
            return;
        }
        if (depth == ans1.size()) {
            ans1.add(new ArrayList<>());
        }

        List<Integer> res =  ans1.get(depth);
        if (depth % 2 == 0) {
            res.add(rn.val);
        } else {
            res.add(0,rn.val);
        }
        dfs(rn.left,depth + 1);
        dfs(rn.right,depth + 1);
    }


    public static void main(String[] args) {
        TreeNode right = new TreeNode(20, new TreeNode(15), new TreeNode(7));
        TreeNode root = new TreeNode(1, new TreeNode(2, null, new TreeNode(4)), new TreeNode(3, new TreeNode(5), null));
        zigzagLevelOrder2(root);
    }
}
