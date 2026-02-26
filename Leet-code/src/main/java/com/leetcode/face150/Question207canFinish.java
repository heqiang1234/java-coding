package com.leetcode.face150;

import java.util.HashMap;
import java.util.Map;

public class Question207canFinish {

    /**
     * 示例 1：
     *
     * 输入：numCourses = 2, prerequisites = [[1,0]]
     * 输出：true
     * 解释：总共有 2 门课程。学习课程 1 之前，你需要完成课程 0 。这是可能的。
     * 示例 2：
     *
     * 输入：numCourses = 2, prerequisites = [[1,0],[0,1]]
     * 输出：false
     * 解释：总共有 2 门课程。学习课程 1 之前，你需要先完成​课程 0 ；
     * 并且学习课程 0 之前，你还应先完成课程 1 。这是不可能的。
     *
     * @param numCourses
     * @param prerequisites
     * @return
     */
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer,Integer> prep = new HashMap<>();

        // 首先将课程存在map里面
        for (int i = 0; i < prerequisites.length; i++) {
            prep.put(prerequisites[i][0],prerequisites[i][1]);
        }

        // 由于需要判断前序，所以获取到当前课程9，先判断课程是否已经学习

        // 1.如果判断是否存在前序？ 不存在前序的则将自身作为自身的前序，写入表中。
        return false;
    }
}
