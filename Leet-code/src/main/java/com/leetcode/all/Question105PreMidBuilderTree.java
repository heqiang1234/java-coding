package com.leetcode.all;

import java.util.HashMap;

/**
 * @author HQ
 * @create 2021/11/15 20:00
 *
 * @desc
 * 给定一棵树的前序遍历 preorder 与中序遍历  inorder。请构造二叉树并返回其根节点。
 *
 * 示例
 * Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
 * Output: [3,9,20,null,null,15,7]
 *
 * 1 <= preorder.length <= 3000
 * inorder.length == preorder.length
 * -3000 <= preorder[i], inorder[i] <= 3000
 * preorder 和 inorder 均无重复元素
 * inorder 均出现在 preorder
 * preorder 保证为二叉树的前序遍历序列
 * inorder 保证为二叉树的中序遍历序列
 *
 * 前序遍历   父 左 右
 * 中序遍历   左 父 右
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Question105PreMidBuilderTree {

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

    private static HashMap<Integer, Integer> indexMap;
    public static TreeNode DpBuildTree(int[] preorder, int[] inorder,int preorder_left, int preorder_right, int inorder_left, int inorder_right) {
        if (preorder_left > preorder_right || inorder_left > inorder_right) {
            return null;
        }
        //前序遍历的最左边的值就是根节点
        int preorder_root = preorder_left;
        //中序遍历中根节点的位置。
        int inorder_root = indexMap.get(preorder[preorder_root]);
        //中序遍历的根节点的位置减去中序遍历的最左边的节点位置，得出了树左边的元素数量
        TreeNode root = new TreeNode(preorder[preorder_root]);
        //中序遍历中，根节点的位置减去中序遍历最左边的索引得到左边的数量
        int size_len = inorder_root - inorder_left;
        //前序遍历中，左边的节点元素为树左边的元素，对位过去为中序遍历中的相同长度的元素
        //左边
        root.left = DpBuildTree(preorder, inorder, preorder_left + 1, preorder_root + size_len, inorder_left, inorder_root - 1);
        //右边，同样操作
        root.right = DpBuildTree(preorder, inorder, preorder_root + size_len + 1, preorder_right,inorder_root + 1, inorder_right);
        return root;
    }

    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        //TreeNode res = new TreeNode();
        int n = inorder.length;
        indexMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < n; i++) {
            indexMap.put(inorder[i], i);
        }
        return DpBuildTree(preorder, inorder, 0, n-1, 0, n-1);
    }

    public static void main(String[] args) {
       int[] preorder = {3,9,20,15,7};
       int[] inorder = {9,3,15,20,7};
       System.out.println(buildTree(preorder, inorder).val);

    }
}
