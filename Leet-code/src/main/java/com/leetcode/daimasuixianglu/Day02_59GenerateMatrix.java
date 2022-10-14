package com.leetcode.daimasuixianglu;

/**
 * @author HQ
 * @program: java-coding
 * @description: 59.螺旋数组II
 * @date 2022-10-13 19:45:01
 */
public class Day02_59GenerateMatrix {

    public int[][] genrateMatrix(int n) {
        int[][] res = new int[n][n];
        //定义边界？上边界，下边界
        int loop = 0;//循环控制次数
        int count = 1;//计数器
        int start = 0;//定义开始点
        int i, j;

        while (loop++ < n / 2) {

            //从左到右
            for (j = start;j < n - loop;j++){
                res[start][j] = count++;
            }

            //从上到下
            for(i = start; i < n - loop;i++){
                res[i][j] = count++;
            }

            //从右到左，起始就是按照前面的规律进行处理。i的位置就是前面处理过后的那个位置，不需要移动，只需要改变y就可以，移动的次数，从现有的j，到循环的圈数。
            for(;j >= loop;j--){
                res[i][j] = count++;
            }

            //从上到下,同上
            for(;i >= loop;i--){
                res[i][j] = count++;
            }
            start++;
        }

        //如果为奇数，则最中心就一个数字，此时，直接特殊处理，赋值。
        if (n % 2 == 1) {
            res[start][start] = count;
        }

        return res;
    }
}
