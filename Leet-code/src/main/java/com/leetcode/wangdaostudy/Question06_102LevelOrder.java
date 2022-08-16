package com.leetcode.wangdaostudy;

import com.leetcode.model.TreeNode;
import io.netty.util.concurrent.SingleThreadEventExecutor;
import sun.reflect.generics.tree.Tree;

import java.util.*;

/**
 * @author HQ
 * @program: java-coding
 * @description: 102. 二叉树的层序遍历
 * @date 2022-08-16 23:23:14
 */
public class Question06_102LevelOrder {

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return null;
        }
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            List<Integer> temp = new ArrayList<>();
            for (int i = queue.size(); i > 0 ; i--) {
                TreeNode td = queue.poll();
                if (td.left != null){
                    queue.add(td.left);
                }
                if (td.right != null){
                    queue.add(td.right);
                }
                temp.add(td.val);
            }
            res.add(temp);
        }
        return res;
    }

}
