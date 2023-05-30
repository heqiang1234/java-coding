package com.leetcode.year2023.dfs;

import com.leetcode.model.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author HQ
 * @program: java-coding
 * @description: 99. 恢复二叉搜索树
 * @date 2023-02-09 21:56:56
 */
public class Question99RecoverTree {

    //使用额外的list储存节点，然后交换对应节点的值
    public void recoverTree(TreeNode root) {
        List<TreeNode> list = new ArrayList<>();
        TreeNode x = null;
        TreeNode y = null;//定义两个的临时节点，储存错误值
        dfsTree(root, list);//将节点储存进list
        int pre = list.get(0).val;
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i).val > list.get(i + 1).val) {
                y = list.get(i + 1);
                if (x == null) {
                    x = list.get(i);//储存前面一个 》 的
                }
            }
        }
        if (x != null && y != null) {
            int temp = x.val;
            x.val = y.val;
            y.val = temp;
        }
    }

    public void dfsTree(TreeNode rt, List<TreeNode> list) {
        if (rt == null) {
            return;
        }
        dfsTree(rt.left, list);
        list.add(rt);
        dfsTree(rt.right, list);
    }

    //
    private TreeNode pre = null;
    private TreeNode x = null;
    private TreeNode y = null;
    public void recoverTreeTwo(TreeNode root) {
        if (root == null) {
            return;
        }
        dfsTreeTwo(root);
    }

    public void dfsTreeTwo(TreeNode tn) {
        if (tn == null){
            return;
        }
        dfsTreeTwo(tn.left);
        if (pre == null){
            pre = tn;
        } else {
            if (pre.val > tn.val){
                y = tn;
                if (x == null){
                    x = pre;
                }
            }
            pre = tn;
        }
        dfsTreeTwo(tn.right);
    }

}
