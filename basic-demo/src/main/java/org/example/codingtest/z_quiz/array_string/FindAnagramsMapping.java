package org.example.codingtest.z_quiz.array_string;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 주어진 배열 A,B 가 있을 때, A의 인자가 B의 배열에서 어느 위치에 있는지를 리턴하라.
 **/
public class FindAnagramsMapping {
    private static FindAnagramsMapping o = new FindAnagramsMapping();
    public static void main(String[] args) {
        int[] A = {11,27,45,31,50};
        int[] B = {50,11,31,45,27};

        int[] solution = o.solution(A, B);
        Arrays.stream(solution).forEach(System.out::println);
    }

    /**
     * 1. A 배열의 값과 위치 인덱스를 Map 의 k-v 로 매핑한다.
     * 2. B 배열을 읽고 Map 의 v를 output 에 담는다.
     **/
    public int[] solution(int[] a, int[] b) {
        int[] output = new int[a.length];
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < b.length; i++) {
            map.put(b[i], i);
        }

        for (int i = 0; i < a.length; i++) {
            output[i] = map.get(a[i]);
        }
        return output;
    }
}
