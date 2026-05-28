package com.leetcode.test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author: Mr.He
 * @create: 2023-03-13 09:18
 * @description: sd
 **/
public class main {
    public static void main(String[] args) {
        List<User> allUser = new ArrayList<>();

        allUser.add(new User("hq","123",12));
        allUser.add(new User("hw","124",22));
        allUser.add(new User("h3","213",15));
        allUser.add(new User("h2","1254",19));
        allUser.add(new User("h1","12256",30));
        allUser.add(new User("he","125",20));
        for (User user : allUser){
            System.out.println(user.toString());
        }
        System.out.println("---------");
        allUser.stream().sorted(Comparator.comparing(User::getAge)).collect(Collectors.toList());

        System.out.println(allUser.toString());
        int temp = 2;
        for (User user : allUser){
            System.out.println(user.toString());
            int age1 = user.getAge();
            if (temp > 0){
                age1 += 1;
                temp--;
            }
            user.setAge(age1);
        }
        System.out.println("---------");
        for (User user : allUser){
            System.out.println(user.toString());
        }
        System.out.println("/////////");
    }
}
