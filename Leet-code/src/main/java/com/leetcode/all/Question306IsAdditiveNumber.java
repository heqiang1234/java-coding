package com.leetcode.all;

/**
 * @program: demo
 * @description: 累加数 斐波那契数列
 * @author: Mr.He
 * @create: 2022-01-10 09:30
 **/
public class Question306IsAdditiveNumber {

    public static boolean isAdditiveNumber(String num) {
        //要求至少为3个数字。

        return dfs(num,0,0,0,0);
    }

    //定义index,储存遍历到的位置，定义一个count，存储现在累计了几个，定义一个prepre存储前面的第一个值，定义 pre，存储第二个值
    public static boolean dfs(String num, int index, int count, long prepre, long pre) {
        if (index >= num.length()) {
            return count > 2;
        }

        long current = 0;//定义一个中间值，存储当次计算的值
        for (int i = index; i < num.length(); i++) {
            int n = num.charAt(i);//获取当前的字符串的值

            //如果第一个为0，就直接返回了，因为前导0，不适合存在，
            if (num.charAt(index) == '0' && i > index) {
                return false;
            }

            current = current * 10 + n - '0';//当前的值

            //如果数量大于2，说明可以进入判断是否等于和了。
            if (count >= 2) {
                long sum = pre + prepre;
                //如果当前的值，大于sum的值，说明已经超过了，这次就不需要继续计算了
                if (current > sum) {
                    return false;
                }
                //如果此时的值小，那么说明还要继续加一个值去计算sum,
                if (current < sum) {
                    continue;
                }
            }
            if (dfs(num, i + 1, count + 1, pre, current)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(isAdditiveNumber("121474836472147483648"));
    }

}
