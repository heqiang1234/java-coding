package com.leetcode.year2023.signin;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author HQ
 * @program: java-coding
 * @description: 733. 图像渲染
 * @date 2023-01-29 21:08:30
 */
public class Quetion733FloodFill {
    static int dx[] = {1, 0, 0, -1};
    static int dy[] = {0, 1, -1, 0};
    //bfs
    public static int[][] floodFill(int[][] image, int sr, int sc, int color) {


        int currColor = image[sr][sc];
        if (currColor == color) {
            return image;
        }
        int n = image.length, m = image[0].length;
        Queue<int[]> queue = new LinkedList<int[]>();
        queue.offer(new int[]{sr,sc});
        image[sr][sc] = color;
        while (!queue.isEmpty()){
          int[] cel = queue.poll();
          int x = cel[0],y = cel[1];
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i],ny = y + dy[i];
                if (nx < n && nx >= 0 && ny < m && ny >= 0 && image[nx][ny] == currColor){
                    queue.offer(new int[]{nx,ny});
                    image[nx][ny] = color;
                }
            }
        }
        return image;
    }

    //dfs
    public static int[][] floodFill2(int[][] image, int sr, int sc, int color) {
        int currColor = image[sr][sc];
        if (currColor != color){
            dfs(image,sr,sc,currColor,color,image.length,image[0].length);
        }
        return image;
    }

    public static void dfs(int[][] image, int x, int y, int currColor,int color,int n,int m){
        if (image[x][y] == currColor){
            image[x][y] = color;
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i],ny = y + dy[i];
                if (nx < n && nx >= 0 && ny < m && ny >= 0 && image[nx][ny] == currColor){
                    dfs(image,nx,ny,currColor,color,n,m);
                }
            }
        }
    }


    public static void main(String[] args) {
        int [][]res = floodFill2(new int[][]{{1,1,1},{1,1,0},{1,0,1}},1,1,2);
        System.out.println(res);
    }
}
