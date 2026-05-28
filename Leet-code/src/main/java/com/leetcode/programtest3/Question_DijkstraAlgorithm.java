package com.leetcode.programtest3;

/**
 * @author: Mr.He
 * @create: 2022-09-21 15:32
 * @description: 迪杰斯特拉最短路径算法
 **/
public class Question_DijkstraAlgorithm {

    public static int DijkstraAlgorithm(int[][] graph,int start,int end) {
        int n = graph.length;//存储图中的顶点个数
        int [] visit = new int[n];//标记已作为中间节点完成放问的顶点
        int [] dist = new int[n];//存储从起点start到其他顶点的最短路径
        //存储输出路径
        String[] path = new String[n];
        for (int i = 0; i < n; i++) {
            dist[i] = graph[start][i];//初始化dist数组，记录从start到其他顶点的路径长度
        }
        //初始化输出路径
        for (int i = 0; i < n; i++) {
            path[i] = new String(start + "->" + i);
        }

        visit[start] = 1;
        for (int i = 1; i < n; i++) { // 更新最短路径的循环，循环进行n次
            int minDist = Integer.MAX_VALUE/2;//存储从起点到其他未被访问节点中的最短距离
            int middle = 0;//存储最短距离节点的编号
            //遍历n个顶点，寻找当前未被访问的顶点中的距离起始顶点最短距离的节点编号
            for (int j = 0; j < n; j++) {
                //如果visit[j] == 0，说明顶点j未被访问，且min_dist > dist[j]时
                if (visit[j] == 0 && minDist > dist[j]){
                    minDist = dist[j];//更新最短距离min_dist为dist[j]
                    middle = j;//更新顶点编号middle为j
                }
            }
            //以middle为中间节点，再循环遍历其他所有节点
            for (int j = 0; j < n; j++) {
                //如果当前遍历的节点j未曾作为过中间节点，并且从起始节点到j的距离dist[j]大于
                // 从起始节点到middle与从middle到j的距离和
                if (visit[j] == 0 && dist[j] > dist[middle] + graph[middle][j]){
                    //更新起始节点到j的距离dist[j]，更新为起始到middle与middle到j的距离和
                    dist[j] = dist[middle] + graph[middle][j];
                    path[j] = path[middle] + "->" + j;
                }
            }
            visit[middle] = 1;//将middle顶点设置为已访问
        }
        //打印最短路径
        for (int i = 0; i < n; i++) {
            if (i != start && i == end) {
                if (dist[i] == Integer.MAX_VALUE/2) {
                    System.out.println(start + "到" + i + "不可达");
                } else {
                    System.out.println(start + "到" + i + "的最短路径为：" + path[i] + "，最短距离是：" + dist[i]);
                }
            }
        }
        return dist[end];
    }

    public static int initGraph(int start,int end) {
        int N = Integer.MAX_VALUE/2;
        int[][] matrix = new int[7][7];
        matrix[0] = new int[]{N, N, N, 5, N, N, N};/*0*/
        matrix[1] = new int[]{N, 0, N, N, 1, N, 1};/*1*/
        matrix[2] = new int[]{N, N, 0, N, 1, N, 1};/*2*/
        matrix[3] = new int[]{N, N, N, 0, N, 1, 1};/*3*/
        matrix[4] = new int[]{N, 1, 1, N, 0, 1, N};/*4*/
        matrix[5] = new int[]{N, N, N, 1, 1, 0, 1};/*5*/
        matrix[6] = new int[]{N, 1, 1, 1, N, 1, 0};/*6*/
       return DijkstraAlgorithm(matrix,start,end);
    }

    public static void main(String[] args) {
        System.out.println(initGraph(3, 1));
    }
}
