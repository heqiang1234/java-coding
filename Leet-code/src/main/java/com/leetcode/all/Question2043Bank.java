package com.leetcode.all;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: demo
 * @description: 2043. 简易银行系统
 * @author: Mr.He
 * @create: 2022-03-18 20:41
 **/
public class Question2043Bank {

    public List<Long> res;

    public Question2043Bank(long[] balance) {
        res = new ArrayList<>();
        for (int i = 0; i < balance.length; i++) {
            res.add(balance[i]);
        }
    }

    public boolean transfer(int account1, int account2, long money) {
        if (account1 > res.size() || account2 > res.size()){
            return false;
        }
        if (res.get(account1 - 1) >= money) {
            long nowBalance1 = res.get(account1 - 1);
            res.set(account1 - 1, nowBalance1 - money);
            long nowBalance2 = res.get(account2 - 1);
            res.set(account2 - 1, money + nowBalance2);
            return true;
        }
        return false;
    }

    public boolean deposit(int account, long money) {
        if (account > res.size()){
            return false;
        }
        long nowBalance = res.get(account - 1);
        res.set(account - 1, nowBalance + money);
        return true;
    }

    public boolean withdraw(int account, long money) {
        if (account > res.size()){
            return false;
        }
        if (res.get(account - 1) >= money){
            long nowBalance = res.get(account - 1);
            res.set(account - 1, nowBalance - money);
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        long [] res = new long[]{0L};
        Question2043Bank bank = new Question2043Bank(res);
        System.out.println(bank.deposit(1,1000000000000L));
        System.out.println(bank.transfer(1,1,1000000000000L));
        System.out.println(bank.withdraw(1,1000000000000L));
        System.out.println(bank.deposit(1,0));
        System.out.println(bank.transfer(1,1,0));
        System.out.println(bank.withdraw(1, 0));
    }
}
