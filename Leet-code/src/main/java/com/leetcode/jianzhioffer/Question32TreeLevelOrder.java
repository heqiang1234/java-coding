package com.leetcode.jianzhioffer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author heqiang
 * @date 2021/11/19 13:57
 * @desc 剑指 Offer 32 - I. 从上到下打印二叉树
 *
 * 从上到下打印出二叉树的每个节点，同一层的节点按照从左到右的顺序打印。
 *
 * 例如:
 * 给定二叉树: [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回：
 *
 * [3,9,20,15,7]
 *  
 *
 * 提示：
 *
 * 节点总数 <= 1000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Question32TreeLevelOrder {
    public  static  class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){ val = x;}
    }

    public static int[] levelOrder(TreeNode root) {
        if(root == null) {
            return new int[0];
        }
        Queue<TreeNode> nodeQueue = new LinkedList(){{add(root);}};
        ArrayList<Integer> arrayList = new ArrayList<>();
        while (!nodeQueue.isEmpty()) {
            TreeNode node = nodeQueue.poll();
            arrayList.add(node.val);
            if (node.left != null) {
               nodeQueue.add(node.left);
            }
            if (node.right != null) {
                nodeQueue.add(node.right);
            }
        }
        int[] res = new int[arrayList.size()];
        for (int i = 0; i <arrayList.size() ; i++) {
            res[i] = arrayList.get(i);
        }
        return res;
    }

    public static void main(String[] args) {

    }
}
