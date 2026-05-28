package com.leetcode.year2023.signin;

import com.leetcode.model.TreeNode;

import java.util.*;

/**
 * @author HQ
 * @program: java-coding
 * @description: 1110.删点成林
 * @date 2023-05-30 21:19:11
 */
public class Question1110DelNodes {

    public List<TreeNode> ans;
    public Set<Integer> set;

    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        ans = new ArrayList<>();
        set = new HashSet<>();
        //存入set,后续查找方便
        for (int i = 0; i < to_delete.length; i++) {
            set.add(to_delete[i]);
        }
        return ans;
    }

    public TreeNode dfs(TreeNode rt, boolean isRoot) {
        if (rt == null) {
            return null;
        }
        boolean isTrue = set.contains(rt.val);
        rt.left = dfs(rt.left, isTrue);
        rt.right = dfs(rt.right, isTrue);
        if (isTrue) {
            return null;
        } else {
            if(isRoot){
                ans.add(rt);
            }
            return rt;
        }
    }


}
