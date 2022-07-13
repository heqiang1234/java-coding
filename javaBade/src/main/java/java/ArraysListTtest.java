package hq.java;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @author HQ
 * @program: java-coding
 * @description: arraysList学习
 * @date 2022-06-30 23:59:51
 */
public class ArraysListTtest {


    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        System.out.println(list.size());
        list.add(1);
        System.out.println(list.size());
        Collections.synchronizedList(list);
        //list.ensureCapacity();
    }
}
