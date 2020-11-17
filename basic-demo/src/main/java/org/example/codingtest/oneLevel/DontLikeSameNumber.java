package org.example.codingtest.oneLevel;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class DontLikeSameNumber {
    public static void main(String[] args) {
        int[] arr = {0,0,0,0,0,0,0,0,0};
        int[] solution = solution(arr);
        Arrays.stream(solution).forEach(System.out::println);
    }

    public static int[] solution(int []arr) {
        int before = -1;
        List<Integer> intList = new LinkedList<>();

        for(int num : arr){
            if(num != before) {
                intList.add(num);
            }
            before = num;
        }
        return intList.stream().mapToInt(Integer::intValue).toArray();
    }
}
