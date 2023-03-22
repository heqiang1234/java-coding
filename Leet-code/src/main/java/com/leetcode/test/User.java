package com.leetcode.test;

/**
 * @author: Mr.He
 * @create: 2023-03-13 09:16
 * @description: yonghu
 **/
public class User{

    private String  Name;

    private String ID;

    private int Age;

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public int getAge() {
        return Age;
    }

    public void setAge(int age) {
        Age = age;
    }

    public User(String name, String ID, int age) {
        Name = name;
        this.ID = ID;
        Age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "Name='" + Name + '\'' +
                ", ID='" + ID + '\'' +
                ", Age=" + Age +
                '}';
    }
}
