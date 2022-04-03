package com.leetcode.jianzhioffer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author  heqiang
 * @date 2021/11/19 17:39
 * @desc 剑指 Offer 32 - II. 从上到下打印二叉树 II
 *
 * 从上到下按层打印二叉树，同一层的节点按从左到右的顺序打印，每一层打印到一行。
 *
 *  
 *
 * 例如:
 * 给定二叉树: [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回其层次遍历结果：
 *
 * [
 *   [3],
 *   [9,20],
 *   [15,7]
 * ]
 *  
 *
 * 提示：
 *
 * 节点总数 <= 1000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-ii-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class Question32IITreeNodeLevelOrder  {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){
            val = x;
        }
        TreeNode(){}
    }

    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if (root == null) {
            return list;
        }

        Queue<TreeNode> queue = new LinkedList();
        queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> list1 = new ArrayList<>();
            //主要在这里，每次将左右两节点处理完后，再执行后续的子节点，这样可以保证可以输出一层
            for (int i = queue.size(); i > 0 ; i--) {
                TreeNode node = queue.poll();
                list1.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            if (!list1.isEmpty()) {
                list.add(list1);
            }
        }
        return list;
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        //node.left = new TreeNode(9);
        TreeNode node2 = new TreeNode(2);
        node2.left = new TreeNode(4);
        TreeNode node3 = new TreeNode(3);
        node3.right = new TreeNode(5);
        node.left = node2;
        node.right = node3;
        //TreeNode node = new TreeNode();
        levelOrder(node);
    }
}
