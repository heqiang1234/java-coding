package com.leetcode.all;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: demo
 * @description: 590. N 叉树的后序遍历
 * @author: Mr.He
 * @create: 2022-03-12 17:00
 **/
public class Question590Postorder {

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

    public static List<Integer> postorder(Node root) {
        List<Integer> res = new ArrayList<>();
        if (root == null){
            return res;
        }
        dfsNode(res,root);
        return res;
    }

    public static void dfsNode(List<Integer> res,Node root){
       // List<Node> nod = root.children;
        if (root == null){
            return;
        }
        for (Node node: root.children) {
            dfsNode(res,node);
        }
        res.add(root.val);
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
        postorder(root);
    }
}
