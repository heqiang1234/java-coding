package com.leetcode.all;

/**
 * @program: demo
 * @description: 661. 图片平滑器
 * @author: Mr.He
 * @create: 2022-03-24 10:25
 **/
public class Question661ImageSmoother {
    public static int [][] dir = {{-1,-1},{0,-1},{1,-1},{1,0},{1,1},{0,1},{-1,1},{-1,0}};

    public static int[][] imageSmoother(int[][] img) {
        int lenWid = img.length;
        int lenHei = img[0].length;
        int [][] res = new int[lenWid][lenHei];
        for (int i = 0; i < lenWid; i++) {
            for (int j = 0; j < lenHei; j++) {
                int sum = img[i][j];
                int count = 1;
                for (int k = 0; k < dir.length; k++) {
                    int nx = i + dir[k][0];
                    int ny = j + dir[k][1];
                    if(nx >= 0 && ny >= 0 && nx < lenWid && ny < lenHei){
                        sum += img[nx][ny];
                        count++;
                    }
                }
                res[i][j] = (int) Math.floor(sum / count);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int [][] img = new int[][]{{100,200,100},{200,50,200},{100,200,100}};
        System.out.println(imageSmoother(img));
    }
}
