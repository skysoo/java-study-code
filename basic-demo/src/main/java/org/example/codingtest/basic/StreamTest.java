package org.example.codingtest.basic;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class StreamTest {
    public static void main(String[] args) {
        String[] strings = {"1","2","3"};
        List<String> list = Arrays.asList("1","2","3");
        int[] ints = {1,2,3,4,5};

        Arrays.stream(strings).mapToInt(Integer::parseInt).forEach(System.out::println);

        list.stream().mapToInt(Integer::parseInt).forEach(System.out::println);

        Set<Integer> set1 = new HashSet<>();
        for (int num : ints)
            set1.add(num);

        set1.stream().sorted().mapToInt(Integer::intValue);
    }
}
