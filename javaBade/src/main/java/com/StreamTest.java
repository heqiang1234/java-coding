package com;

import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Stream;

/**
 * @author HQ
 * @program: java-coding
 * @description: stream
 * @date 2022-07-25 23:31:01
 */
public class StreamTest {

    public static void main(String[] args) {
        Optional<Integer> first = Arrays.asList(1, 2, 3, 4, 5, 6).stream().filter(n -> n % 2 == 0).sorted((a, b) -> b - a).findFirst();
        System.out.println(first.get());

        //基于数组的
        String[] res = new String[]{"aa", "bb", "cc"};
        Stream<String> res1 = Stream.of(res);
        res1.forEach(s -> System.out.println(s));

        Stream<Integer> generate = Stream.generate(() -> new Random().nextInt(1000));
        generate.limit(10).forEach(s -> System.out.println(s));

        Stream<Integer> iterate = Stream.iterate(1, n -> n + 1);
        iterate.limit(100).forEach(s -> System.out.println(s));

        List<String> integers = Arrays.asList("1", "2", "3", "6", "5", "6");
        System.out.println(integers.stream().mapToInt(s -> Integer.parseInt(s)).filter(n -> n % 2 == 0).sum());

    }
}
