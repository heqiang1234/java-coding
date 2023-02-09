package com.leetcode.year2023.signin;

import org.apache.commons.collections.map.HashedMap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author HQ
 * @program: java-coding
 * @description: 1797. 设计一个验证系统
 * @date 2023-02-09 20:21:11
 */
public class Question1797AuthenticationManager {

    private static int timeToLiveAll = 0;//定义一个全局的时间
    private static List<String> tokenList = null;//储存出现过的token.后续通过这个过滤
    private static Map<String, Integer> tokenMap = null;//储存token,和对应的预计过期时间

    public  Question1797AuthenticationManager(int timeToLive) {
        timeToLiveAll = timeToLive;//赋值给全局的时间戳
        tokenMap = new HashMap<>();
        tokenList = new ArrayList<>();
    }

    public static  void generate(String tokenId, int currentTime) {
        int count = 0;
        for (String str : tokenList) {
            if (str.equals(tokenId)) {//别用==！！！
                int time = tokenMap.get(tokenId);
                tokenMap.replace(tokenId, time, currentTime + timeToLiveAll);
                count++;
            }
        }
        if (count == 0) {
            tokenList.add(tokenId);
            tokenMap.put(tokenId, currentTime + timeToLiveAll);
        }

    }

    public static void renew(String tokenId, int currentTime) {
        int index = Integer.MAX_VALUE;
        for (int i = 0; i < tokenList.size(); i++) {
            String str = tokenList.get(i);
            if (str.equals(tokenId)) {
                int time = tokenMap.get(tokenId);
                if (currentTime >= time) {
                    tokenMap.remove(tokenId);//数据过期，删除
                    index = i;
                } else {
                    tokenMap.replace(tokenId, time, currentTime + timeToLiveAll);
                }
            }
        }

        if (index != Integer.MAX_VALUE) {
            tokenList.remove(index);
        }
    }

    public int countUnexpiredTokens(int currentTime) {
        int count = 0;
        for (String str : tokenList) {
            int time = tokenMap.get(str);
            if (time > currentTime) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Question1797AuthenticationManager authenticationManager = new Question1797AuthenticationManager(13); // 构造 AuthenticationManager ，设置 timeToLive = 5 秒。
//        authenticationManager.renew("aaa", 1); // 时刻 1 时，没有验证码的 tokenId 为 "aaa" ，没有验证码被更新。
//        authenticationManager.generate("aaa", 2); // 时刻 2 时，生成一个 tokenId 为 "aaa" 的新验证码。
//        authenticationManager.countUnexpiredTokens(6); // 时刻 6 时，只有 tokenId 为 "aaa" 的验证码未过期，所以返回 1 。
//        authenticationManager.generate("bbb", 7); // 时刻 7 时，生成一个 tokenId 为 "bbb" 的新验证码。
//        authenticationManager.renew("aaa", 8); // tokenId 为 "aaa" 的验证码在时刻 7 过期，且 8 >= 7 ，所以时刻 8 的renew 操作被忽略，没有验证码被更新。
//        authenticationManager.renew("bbb", 10); // tokenId 为 "bbb" 的验证码在时刻 10 没有过期，所以 renew 操作会执行，该 token 将在时刻 15 过期。
//        authenticationManager.countUnexpiredTokens(15); // tokenId 为 "bbb" 的验证码在时刻 15 过期，tokenId 为 "aaa" 的验证码在时刻 7 过期，所有验证码均已过期，所以返回 0 。
        authenticationManager.renew("ajvy",1);
        authenticationManager.countUnexpiredTokens(3);
        authenticationManager.countUnexpiredTokens(4);
        authenticationManager.generate("fuzxq",5);
        authenticationManager.generate("izmry",7);
        authenticationManager.renew("puv",12);
        authenticationManager.generate("ybiqb",13);
        authenticationManager.generate("gm",14);
        authenticationManager.countUnexpiredTokens(15);
        authenticationManager.countUnexpiredTokens(18);
        authenticationManager.countUnexpiredTokens(19);
        authenticationManager.renew("ybiqb",21);
        System.out.println(authenticationManager.countUnexpiredTokens(23));
        System.out.println(authenticationManager.countUnexpiredTokens(25));
        System.out.println(authenticationManager.countUnexpiredTokens(26));
        authenticationManager.generate("aqdm",28);
        System.out.println(authenticationManager.countUnexpiredTokens(29));
        authenticationManager.renew("puv",30);
    }

}
