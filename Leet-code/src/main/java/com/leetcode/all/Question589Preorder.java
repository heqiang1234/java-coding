package com.leetcode.all;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: demo
 * @description: 589. N 叉树的前序遍历
 * @author: Mr.He
 * @create: 2022-03-10 09:25
 **/
public class Question589Preorder {

    static class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    };

    public static List<Integer> preorder(Node root) {
        List<Integer> res = new ArrayList<>();
        if (root == null){
            return res;
        }
        dfs(res,root);
        return res;
    }

    public static int dfs(List<Integer> res,Node root){
        res.add(root.val);
        if (root.children == null){
            return 0;
        }
        for (int i = 0; i < root.children.size(); i++) {
            dfs(res,root.children.get(i));
        }
        return 0;
    }

    public static void main(String[] args) {
        List<Node> children3  = new ArrayList<>();
        children3.add(new Node(5));
        children3.add(new Node(6));
        Node root3 = new Node(3,children3);

        List<Node> children1 = new ArrayList<>();
        children1.add(root3);
        children1.add(new Node(2));
        children1.add(new Node(4));
        Node root = new Node(1,children1);
        preorder(root);
    }
}
