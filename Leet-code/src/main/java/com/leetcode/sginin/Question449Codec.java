package com.leetcode.sginin;

import com.leetcode.model.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Mr.He
 * @create: 2022-05-11 09:57
 * @description: 449.序列化和反序列化二叉搜索树
 **/
public class Question449Codec {
    public static String nodeStr;//储存每次的数据

    // Encodes a tree to a single string.
    public static String serialize(TreeNode root) {
        if (root == null){
            return null;
        }
        List<String> list = new ArrayList<>();
        dfs(root, list);
        int n = list.size();
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < n; i++) {
            str.append(list.get(i));
            if (i != n - 1) str.append(",");
        }
        return str.toString();
    }

    public static void dfs(TreeNode root, List<String> loist) {
        if (root == null)
            return;
        loist.add(root.val + ",");
        dfs(root.left, loist);
        dfs(root.right, loist);
    }

    // Decodes your encoded data to tree.
    public static TreeNode deserialize(String data) {
        if (data == null){
            return null;
        }
        List<Integer> list = new ArrayList<>();
        String[] split = data.split(",");
        return dfs2(0, split.length - 1, split);

    }

    public static TreeNode dfs2(int l, int r, String[] ss) {
        if (l > r) return null;
        int j = l + 1, t = Integer.parseInt(ss[l]);
        TreeNode node = new TreeNode(t);
        while (j <= r && Integer.parseInt(ss[j]) <= t) {
            j++;
        }
        node.left = dfs2(l + 1,j -1,ss);
        node.right = dfs2(j,r,ss);
        return node;
    }

    public static void main(String[] args) {
        Question449Codec ser = new Question449Codec();
        Question449Codec deser = new Question449Codec();
        String tree = ser.serialize(new TreeNode(2, new TreeNode(1), new TreeNode(3)));
        TreeNode ans = deser.deserialize(tree);
    }
}
