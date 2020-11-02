package org.example.codingtest.one;


import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;

/**
 * 문자열 s에 나타나는 문자를 큰것부터 작은 순으로 정렬해 새로운 문자열을 리턴하는 함수, solution을 완성해주세요.
 * s는 영문 대소문자로만 구성되어 있으며, 대문자는 소문자보다 작은 것으로 간주합니다.
 **/
public class DescendingStr {
    public static void main(String[] args) {
        String s = "Zbcdefg";
        solution(s);
    }

    public static String solution(String s) {
        return Arrays.stream(s.split(""))
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.joining());
    }
}
