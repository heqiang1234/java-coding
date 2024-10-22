package com;

import org.apache.commons.collections.ArrayStack;
import reactor.util.annotation.NonNull;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author HQ
 * @program: java-coding
 * @description: Test
 * @date 2024-02-20 22:14:09
 */
public class TestMain {

     static class A {
        int a;
    }

    public static void testController() {
        A b = new A();
        A a = new A();
        a.a = 1;
        int [] arr = new int[] {1,2,3};
        String s[] = {"1","2"};
        int [] arr1 = new int[5];
        //Arrays.copyOf(arr1,arr);
         arr1 = arr;
        arr1 = Arrays.copyOf(arr,4);
       // arr1[0] = 1;
        
        System.out.println(arr[2]);
        System.out.println(arr1[3]);
        System.out.println(Arrays.asList(arr));
        System.out.println(Arrays.asList(arr1));
        System.out.println(Arrays.asList(s));
    }

    @NonNull
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        ArrayList<String> str = new ArrayList<>();
        str.add("abc");

        ArrayList<Integer> itr = new ArrayList<>();
        itr.add(123);

        System.out.println(str.getClass());
        System.out.println(itr.getClass());
        System.out.println(str.getClass() == itr.getClass());
        System.out.println(args.length);

        ArrayList<Integer> list = new ArrayList<Integer>();

        list.add(1);  //这样调用 add 方法只能存储整形，因为泛型类型的实例为 Integer
        list.size();
        System.out.println("test " + list.getClass().getMethod("size").invoke(list));

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

        ArrayList<String> list1 = new ArrayList();
        list1.add("1"); //编译通过
        //list1.add(1); //编译错误
        String str1 = list1.get(0); //返回类型就是String

        ArrayList list2 = new ArrayList<String>();
        list1.get()
        list2.add("1"); //编译通过
        list2.add(1); //编译通过
        Object object = list2.get(0); //返回类型就是Object

        new ArrayList<String>().add("11"); //编译通过
        //new ArrayList<String>().add(22); //编译错误

        try {

        }catch (Exception e){
            //
        }

        String str2 = new ArrayList<String>().get(0); //返回类型就是String

        testController();
    }
}
