package com.leetcode.sginin;

import com.leetcode.model.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author: Mr.He
 * @create: 2022-06-22 15:46
 * @description: 513. 找树左下角的值
 **/
public class Question513FindBottomLeftValue {
    int max,ans;

    public int findBottomLeftValue(TreeNode root) {
        max = 1;
        //return bfsTreeNode(root);
        dfsTreeNode(root,0);
        return ans;
    }

    //dfs
    public void dfsTreeNode(TreeNode root,int dep) {
        if (root == null) {
            return;
        }
        if (dep > max){
            max = dep;
            ans = root.val;
        }
        dfsTreeNode(root.left,dep + 1);
        dfsTreeNode(root.right,dep + 1);
    }

    //bfs
    public int bfsTreeNode(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        Boolean firtFlag = false;
        int res = root.val;
        while (queue != null) {
            firtFlag = true;
            for (int i = queue.size(); i > 0; i--) {
                TreeNode node = queue.poll();
                if (firtFlag) {
                    firtFlag = false;
                    res = node.val;
                }
                if (node.left != null) {
                    queue.add(node.left);
                }

                if (node.right != null) {
                    queue.add(node.right);
                }
            }
        }
        return res;
    }

}
