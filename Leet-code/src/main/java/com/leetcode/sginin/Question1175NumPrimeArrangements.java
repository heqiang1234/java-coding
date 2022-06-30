package com.leetcode.sginin;

/**
 * @author: Mr.He
 * @create: 2022-06-30 16:58
 * @description: 1175. 质数排列
 * <p>
 * 请你帮忙给从 1 到 n 的数设计排列方案，使得所有的「质数」都应该被放在「质数索引」（索引从 1 开始）上；你需要返回可能的方案总数。
 * <p>
 * 让我们一起来回顾一下「质数」：质数一定是大于 1 的，并且不能用两个小于它的正整数的乘积来表示。
 * <p>
 * 由于答案可能会很大，所以请你返回答案 模 mod 10^9 + 7 之后的结果即可。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 5
 * 输出：12
 * 解释：举个例子，[1,2,5,4,3] 是一个有效的排列，但 [5,2,3,4,1] 不是，因为在第二种情况里质数 5 被错误地放在索引为 1 的位置上。
 * 示例 2：
 * <p>
 * 输入：n = 100
 * 输出：682289015
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/prime-arrangements
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class Question1175NumPrimeArrangements {


    public int numPrimeArrangements(int n) {
        int tem = getNum(n);

        return getN(tem,);
    }


    public int getNum(int n) {
        Boolean [] isVisit = new Boolean[2000];
        int [] prime = new int[2000];
        int c = 0;
        int count = 0;
        for(int i = 2;i <= n; ++i)//老规矩，遍历区间
        {
            if(isVisit[i] == false) //如果这个数未被访问，则是素数
            {
                prime[++c] = i;
                count++;
            }//将素数保存在素数数组里面，计数+1
            //下面for循环及里面的语句才是这个算法的精髓，我们下面细讲
            for(int j = 1;j <= c && i * prime[j] <= n; ++j)
            {
                isVisit[i * prime[j] ] = true;
                if (i % prime[j] == 0)
                    break;
            }
        }
        return count;
    }

    public long getN(int num1,int num2){
        long res= 1;
        for (int i = 1; i <= num1 ; i++) {
            res *= i;
        }
        long num = 1;
        for (int i = 1; i <= num2 ; i++) {
            num *= i;
        }
        return num * res;
    }

}
