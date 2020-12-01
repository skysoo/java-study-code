package org.example.codingtest.oneLevel;

import java.util.Arrays;

public class Descending {
    public static void main(String[] args) {
        long n = 118372;
        long solution = solution(n);
        System.out.println(solution);
    }

    public static long solution(long n) {
        String s = String.valueOf(n);
        int[] val = new int[s.length()];
        for (int i = 0;i<s.length();i++){
            val[i] = s.charAt(i);
        }
        Arrays.sort(val);

        StringBuilder sb = new StringBuilder();
        for (int i=0;i<s.length();i++){
            sb.append(val[i]);
        }
        return Long.parseLong(sb.toString());
    }
}
