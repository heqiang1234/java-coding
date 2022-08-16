package com.leetcode.wangdaostudy;

import com.leetcode.model.NNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author HQ
 * @program: java-coding
 * @description: 589. N 叉树的前序遍历
 * @date 2022-08-16 22:54:13
 */
public class Question06_589Preorder {

    public List<Integer> preorder(NNode root) {
        List<Integer> res = new ArrayList<>();
        dfsNode(root, res);
        return res;
    }

    public void dfsNode(NNode root,List<Integer> res) {
        if (root == null) {
            return;
        }
        res.add(root.val);
        for (NNode nd: root.children) {
            dfsNode(nd,res);
        }
    }
}
