package com.leetcode.interview;

/**
 * @program: demo
 * @description: 面试题 04.02. 最小高度树
 * @author: Mr.He
 * @create: 2021-12-13 16:26
 **/
public class Question0402SortedArrayToBST {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0) {
            return null;
        }
        return dpTree(nums, 0, nums.length - 1);

    }

    public TreeNode dpTree(int[] nums, int start, int end) {
        if (start > end) {
            return  null;
        }
        int mid = (start + end) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = dpTree(nums, start, mid - 1);
        node.right =dpTree(nums, mid + 1, end);
        return node;
    }
}
