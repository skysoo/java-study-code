package org.example.codingtest.oneLevel;

import java.util.Arrays;

public class NumberOrdering {
    public static void main(String[] args) {
        long n = 118372;
        long solution = solution(n);
        System.out.println(solution);
    }

    public static long solution(long n) {
        String s = String.valueOf(n);
        String[] split = s.split("");

        Arrays.sort(split);

        StringBuilder sb = new StringBuilder();
        for (int i=split.length-1;i>=0;i--){
            sb.append(split[i]);
        }

        return Long.parseLong(sb.toString());
    }
}
