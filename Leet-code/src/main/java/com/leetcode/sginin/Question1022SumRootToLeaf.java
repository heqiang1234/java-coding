package com.leetcode.sginin;

import com.leetcode.model.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Mr.He
 * @create: 2022-05-30 15:16
 * @description: 1022. 从根到叶的二进制数之和
 **/
public class Question1022SumRootToLeaf {

    public static int sumRootToLeaf(TreeNode root) {
        List<String> res = new ArrayList<>();
        //dfs(root, new StringBuilder());
        for (String st: res) {
            System.out.println(st);
        }
        return 0;
    }

    public static void dfs(TreeNode root, int num) {
        //int num = index + root.val;
        if (root == null){
            return;
        }

    }

    // public int getRealNum(int num, int size) {
    //
    //     for (int i = 0; i < size; i++) {
    //         num =
    //     }
    // }

    public static int transforTwoBit(int num) {
        int res = 0;
        int index = 0;
        int sum = 0;
        while (num > 0) {
            int bit = (num % 10);
            sum = 1;
            if (bit != 0) {
                for (int i = index; i > 0; i--) {
                    sum = sum * 2;
                }
            }
            index++;
            res += bit * sum;
            num = num / 10;
        }
        return res;
    }

    public static void main(String[] args) {
        //System.out.println(transforTwoBit(111));
       //sumRootToLeaf(new TreeNode(1, new TreeNode(0,new TreeNode(0),new TreeNode(1)), new TreeNode(1,new TreeNode(0),new TreeNode(1))));
        tests();
    }


    public static void tests(){
        Boolean stas = false;
        boolean stas2 = false;
        int num = 2;
        if (stas = num == 3){
            System.out.println("1");
        }
        System.out.println(stas);
    }

}
