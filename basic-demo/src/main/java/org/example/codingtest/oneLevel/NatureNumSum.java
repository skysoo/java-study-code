package org.example.codingtest.oneLevel;

import java.util.Arrays;

/**
 * 자연수 N이 주어지면, N의 각 자릿수의 합을 구해서 return 하는 solution 함수를 만들어 주세요.
 * 예를들어 N = 123이면 1 + 2 + 3 = 6을 return 하면 됩니다.
 **/
public class NatureNumSum {
    public static void main(String[] args) {
        int n = 987;
        int solution = solution(n);
        System.out.println(solution);
    }

    public static int solution(int n) {
        String s = String.valueOf(n);
        return Arrays.stream(s.split("")).mapToInt(Integer::parseInt).sum();
    }
}
