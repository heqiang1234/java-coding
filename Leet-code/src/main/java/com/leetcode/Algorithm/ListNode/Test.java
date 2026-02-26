package com.leetcode.Algorithm.ListNode;

public class Test {

    public static class Box<T>{
        private T tox;

        public Box(T tox){
            this.tox = tox;
        }

        private void setTox(T t){
            this.tox = t;
        }

        private T getTox(){
            return this.tox;
        }

        public <T> T testTT(T t){
            T res = t;
            int arr = 1;

            return res;
        }
    }

    public static void main(String[] args) {
        Box<Integer> intB = new Box<>(1);
        Box<String> stringB = new Box<>("222");
        Box<Double> doubleB = new Box<>(1.0);
        System.out.println(intB.getTox());
        System.out.println(stringB.getTox());
        System.out.println(doubleB.getTox());

        //ConcurrentHashMap<Integer,Integer>
    }
}
