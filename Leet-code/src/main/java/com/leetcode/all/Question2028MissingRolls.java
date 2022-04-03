package com.leetcode.all;

/**
 * @program: demo
 * @description: 2028. 找出缺失的观测数据
 * @author: Mr.He
 * @create: 2022-03-27 13:36
 **/
public class Question2028MissingRolls {

    public static int[] missingRolls(int[] rolls, int mean, int n) {
        int rollsLen = rolls.length; //当前已观测数据的长度
        int totalLen = n + rollsLen; //总的数据长度
        int totalNum = mean * totalLen; //总的数据值
        int nowNum = 0; //已观测的数据
        for (int i = 0; i < rollsLen; i++) {
            nowNum += rolls[i];
        }
        int restNum = totalNum - nowNum;
        if (restNum < 0){
            return new int[]{};
        }
        int [] res = new int[n];
        int midNum = restNum / n; //剩下数的平均值
        int restModNum = restNum - midNum * n; //平均值后的值
        for (int i = 0; i < n; i++) {
            int tempNum = restModNum != 0 ? midNum + 1 : midNum;
            if (tempNum > 6){
                return new int[]{};
            }
            if (restModNum != 0){
                restModNum--;
            }
            res[i] = tempNum;
        }
        return res;
    }

    public static void main(String[] args) {
        missingRolls(new int[]{6,1,6,5,2,6,6,2,2,3,4,1,5,2,2,6,6,1,3,3,2,6,3,1,4},1,34);
    }
    /**
     * [6,1,6,5,2,6,6,2,2,3,4,1,5,2,2,6,6,1,3,3,2,6,3,1,4]
     * 1
     * 34
     */
}
