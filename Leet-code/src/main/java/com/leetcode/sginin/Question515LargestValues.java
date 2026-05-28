package com.leetcode.sginin;

import com.leetcode.model.TreeNode;

import java.util.*;

/**
 * @author HQ
 * @program: java-coding
 * @description: 515. 在每个树行中找最大值
 * @date 2022-06-24 22:54:43
 */
public class Question515LargestValues {

    public List<Integer> largestValues(TreeNode root) {
        Queue<TreeNode> queue = new ArrayDeque<>();
        List<Integer> res = new ArrayList<>();
        if (root == null){
            return res;
        }
        queue.add(root);
        while (!queue.isEmpty()){
            int maxNum = Integer.MIN_VALUE;
            for (int i = queue.size(); i >= 0 ; i--) {
                TreeNode temp = queue.poll();
                if (temp.left != null){
                    queue.add(temp.left);
                }
                if (temp.right != null){
                    queue.add(temp.right);
                }
                System.out.println();
                maxNum = Math.max(maxNum,temp.val);
            }
            maxNum = maxNum == Integer.MIN_VALUE ? Integer.MIN_VALUE : maxNum;
            res.add(maxNum);
        }
        return res;
    }

}
