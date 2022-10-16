package com.leetcode.programtest3;

/**
 * @author HQ
 * @program: java-coding
 * @description: djstl
 * @date 2022-09-24 06:53:30
 */
public class djstl {


    public static String djstl(int [][] graph,int start,int end){
        int n = graph.length;
        int [] dist = new int[n];//记录起始点到其他节点的距离
        int [] visit = new int[n];//记录是否遍历过该节点

        String[] path = new String[n];
        //初始化距离
        for (int i = 0; i < n; i++) {
            dist[i] = graph[start][i];
        }

        //初始化路径
        for (int i = 0; i < n; i++) {
            path[i] = new String(start + " " + i);
        }

        visit[start] = 1;
        //一直遍历中间节点和其他节点的距离
        for (int i = 0; i < n; i++) {
            int minDist = Integer.MAX_VALUE / 2;
            int middle = 0;

            //遍历出中间节点来
            for (int j = 0; j < n; j++) {
                //获取到未遍历过的，中间节点最近的
                if (visit[j] == 0 && minDist > dist[j]){
                    minDist = dist[j];
                    middle = j;
                }
            }

            for (int j = 0; j < n; j++) {

                if (visit[j] == 0 && dist[j] > dist[middle] + graph[middle][j]){
                    dist[j] = dist[middle] + graph[middle][j];
                    path[j] = path[middle] + " " + j;
                }
            }
            visit[middle] = 1;
        }

        for (int i = 0; i < n; i++) {
            if (end == i){
                System.out.println(path[i]);
            }
        }
        return path[end];
    }

    public static String initGraph(int start,int end) {
        int N = Integer.MAX_VALUE/2;
        int[][] matrix = new int[7][7];
        matrix[0] = new int[]{N, N, N, 5, N, N, N};/*0*/
        matrix[1] = new int[]{N, 0, N, N, 1, N, 1};/*1*/
        matrix[2] = new int[]{N, N, 0, N, 1, N, 1};/*2*/
        matrix[3] = new int[]{N, N, N, 0, N, 1, 1};/*3*/
        matrix[4] = new int[]{N, 1, 1, N, 0, 1, N};/*4*/
        matrix[5] = new int[]{N, N, N, 1, 1, 0, 1};/*5*/
        matrix[6] = new int[]{N, 1, 1, 1, N, 1, 0};/*6*/
        return djstl(matrix,start,end);
    }

    public static void main(String[] args) {
        System.out.println(initGraph(3, 1));
    }
}
