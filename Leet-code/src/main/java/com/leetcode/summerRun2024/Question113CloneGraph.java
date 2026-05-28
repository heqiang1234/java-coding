package com.leetcode.summerRun2024;

import java.util.*;

/**
 * @author heqiang
 * @date 2025年08月13日13:27
 */
public class Question113CloneGraph {

    class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }


//    public Node cloneGraph(Node node) {
//        Queue<Node> clone = new ArrayDeque<>();
//        clone(node.val);
//    }

}
