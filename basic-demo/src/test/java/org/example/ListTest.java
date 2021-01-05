package org.example;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;


public class ListTest {
    @Test
    public void listTest(){
        List<Integer> listA = new ArrayList<>();
        List<Integer> listB = new ArrayList<>();

        listA.add(1);
        listA.add(2);
        listA.add(4);

        listB.add(1);
        listB.add(4);
        listB.add(2);

        boolean equals = listA.equals(listB);
        System.out.println(equals);
    }
}
