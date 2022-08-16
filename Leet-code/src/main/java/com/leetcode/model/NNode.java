package com.leetcode.model;

import java.util.List;

/**
 * @author HQ
 * @program: java-coding
 * @description: N叉树
 * @date 2022-08-16 23:09:57
 */
public class NNode {

    public int val;
    public List<NNode> children;

    public NNode() {}

    public NNode(int _val) {
        val = _val;
    }

    public NNode(int _val, List<NNode> _children) {
        val = _val;
        children = _children;
    }
}
