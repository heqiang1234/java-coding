package com.leetcode.sginin;

import com.sun.java.swing.plaf.windows.WindowsTextAreaUI;

import javax.jnlp.ClipboardService;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @program: java-coding
 * @description: s
 * @author: Mr.He
 * @create: 2022-04-13 18:34
 **/
public class tss {

    public static void main(String[] args) {
        int i=0;
        int count = i++;
        System.out.println(count);
        System.out.println(i);
        i = 0;
        System.out.println(i--);
        System.out.println(i);
        i = 0;
        System.out.println(--i);
        System.out.println(i);
        i = 0;
        System.out.println(++i);
        System.out.println(i);

        Scanner scanner = new Scanner(System.in);

        List<Integer> res  = new ArrayList<>();
        for (int j = 0; j < 3; j++) {
            int num = scanner.nextInt();
            res.add(num);
        }
        System.out.println(res.size());
    }
}
