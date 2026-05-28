package com.leetcode.all;

import java.util.HashMap;

/**
 * @author HQ
 * @create 2021/11/15 21:12
 *
 * @desc
 * 根据一棵树的中序遍历与后序遍历构造二叉树。
 *
 * 注意:
 * 你可以假设树中没有重复的元素。
 *
 * 例如，给出
 *
 * 中序遍历 inorder = [9,3,15,20,7]
 * 后序遍历 postorder = [9,15,7,20,3]
 * 返回如下的二叉树：
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Question106MidAfterBuilderTree {

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

    public static TreeNode buildTree(int[] inorder , int[] postorder ) {
        //TreeNode res = new TreeNode();
        int n = inorder.length;
        HashMap<Integer,Integer> indexMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < n; i++) {
            indexMap.put(inorder[i], i);
        }
        return buildTree(inorder, postorder, 0, n-1, 0, n-1, indexMap);
    }

    private static TreeNode buildTree(int[] inorder, int[] postorder, int inorder_left, int inorder_right, int postorder_left, int postorder_right, HashMap<Integer,Integer> indexMap) {

        if (inorder_left > inorder_right || postorder_left > postorder_right) {
            return null;
        }

        //后序遍历的最后一位是父节点
        int postorder_root = postorder_right;
        //通过哈希表快速的获取到父节点在中序遍历中的索引位置，这样可以区分到了左边的树和右边的树
        int tree_root = indexMap.get(postorder[postorder_root]);
        //树左边的长度
        int tree_size = tree_root - inorder_left;
        //创建树，因为父节点通过后序遍历是已知的，所以直接初始化
        TreeNode root = new TreeNode(postorder[postorder_root]);
        //
        //对于边界值的部分还存在模糊的地方
        //中序遍历是  左 中 右
        //后序遍历是  左 右 中
        // 所以我们的边界值处理
        //左边
        //树左边的处理    首先中序数组的处理，左inorder_left  右 使用中节点的位置处理，是 中节点位置 - 1 tree_root - 1    后序数组的处理 左 postorder_left 右，使用 （树左边的长度），postorder_left + tree_size - 1，减一是因为size为长度，从一开始，我们要使用的是数组，从0开始
        root.left = buildTree(inorder, postorder, inorder_left, tree_root -1, postorder_left, postorder_left + tree_size - 1 , indexMap);
        //右边
        //树右边的处理   首先中序数组的处理。左 中节点的后一位 tree_root + 1， 右 数组最右值 inorder_right  后序数组的处理 左 使用 （树左边长度）postorder_left + tree_size  右 后序数组最右值减一 ，因为最后一位是中节点，所以需要减一

        root.right = buildTree(inorder, postorder, tree_root + 1, inorder_right, postorder_left + tree_size, postorder_right - 1, indexMap);
        return root;
    }

    public static void main(String[] args) {
        //int[] preorder = {3,9,20,15,7};
        int[] inorder = {9,3,15,20,7};
        int[] postorder = {9,15,7,20,3};
        buildTree(inorder, postorder);
    }
}
