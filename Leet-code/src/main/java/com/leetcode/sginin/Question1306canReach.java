package com.leetcode.sginin;

import java.util.ArrayDeque;
import java.util.Queue;

public class Question1306canReach {

    // bfs
    public static boolean canReach(int[] arr, int start) {
        int len = arr.length;
        Queue<Integer> bfs = new ArrayDeque<>();
        Boolean[] visited = new Boolean[len];

        for (int i = 0; i < len; i++) {
            visited[i] = false;
        }
        bfs.offer(start);
        while (!bfs.isEmpty()) {
            int size = bfs.size();
            for (int i = 0; i < size; i++) {
                int num = bfs.poll();
                if (num < 0 || num >= len) continue;
                if (visited[num]) {
                    continue;
                }
                if (arr[num] == 0) {
                    return true;
                }

                visited[num] = true;
                bfs.offer(num - arr[num]);
                bfs.offer(num + arr[num]);
            }
        }
        return false;
    }

    // dfs
    public boolean canReach_dfs(int[] arr, int start) {
        boolean[] visited = new boolean[arr.length];
        for (int i = 0; i < arr.length; i++) {
            visited[i] = false;
        }
        return dp(arr, start, arr.length, visited);
    }

    public boolean dp(int[] arr, int start, int len, boolean[] visited) {
        if (visited[start] || start < 0 || start >= len) {
            return false;
        }

        if (arr[start] == 0) {
            return true;
        }
        visited[start] = true;

        return dp(arr, start + arr[start], len, visited) || dp(arr, start - arr[start], len, visited);
    }

    //

    public static boolean canReach_IIII(String s, int minJump, int maxJump) {
        int end = s.length();
        if (end <= 0) {
            return false;
        }
        if (s.charAt(end - 1) != '0') {
            return false;
        }

        Queue<Integer> index = new ArrayDeque<>();
//        Boolean[] visited = new Boolean[end];
//        for (int i = 0; i < end; i++) {
//            visited[i] = false;
//        }

        int curIndex = 0;
        index.offer(0);
        while (!index.isEmpty()) {
           // int size = index.size();
            //for (int i = 0; i < size; i++) {
                int cur = index.poll();
               // if (visited[cur]) continue;
                if (cur == end - 1) return true;
               // visited[cur] = true;
                int beginIndex = Math.max(cur + minJump, curIndex + 1), endIndex = Math.min(cur + maxJump, end - 1);
                for (int j = beginIndex; j <= endIndex; j++) {
                    if (s.charAt(j) == '0') {
                        if (j == end - 1) return true;
                        if (!index.contains(j)) {
                            index.offer(j);
                        }
                    }
                }
                curIndex = cur + maxJump;
            //}
        }
        return false;
    }


    public static void main(String[] args) {
        //System.out.printf(canReach(new int[]{4, 2, 3, 0, 3, 1, 2}, 5) + " ");
        System.out.println(canReach_IIII("0000000000", 2, 5));
    }
}
