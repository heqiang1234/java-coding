package com.leetcode.sginin;

/**
 * @author: Mr.He
 * @create: 2022-04-29 14:02
 * @description: 427. 建立四叉树
 **/
public class Question427Construct {

    class Node {
        public boolean val;
        public boolean isLeaf;
        public Node topLeft;
        public Node topRight;
        public Node bottomLeft;
        public Node bottomRight;


        public Node() {
            this.val = false;
            this.isLeaf = false;
            this.topLeft = null;
            this.topRight = null;
            this.bottomLeft = null;
            this.bottomRight = null;
        }

        public Node(boolean val, boolean isLeaf) {
            this.val = val;
            this.isLeaf = isLeaf;
            this.topLeft = null;
            this.topRight = null;
            this.bottomLeft = null;
            this.bottomRight = null;
        }

        public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
            this.val = val;
            this.isLeaf = isLeaf;
            this.topLeft = topLeft;
            this.topRight = topRight;
            this.bottomLeft = bottomLeft;
            this.bottomRight = bottomRight;
        }
    };

    public Node res = new Node();

    public Node construct(int[][] grid) {
        return res;
    }

    public void dfsNode(int [][] grid){
        int width = grid.length;
        int heigh = grid[0].length;
        if (width <= 1){

        }

        for (int i = 0; i < 4; i++) {
            dfsNode(grid);
        }

    }
}
